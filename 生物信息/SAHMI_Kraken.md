# 工具输入要求

Kraken2 是基于 k-mer 的序列分类器，设计用于对 DNA 序列进行分类[github.com](https://github.com/DerrickWood/kraken2/wiki/Manual#:~:text=Kraken is a taxonomic sequence,mer)。它可以接受常规的 FASTA/FASTQ 数据（包括二代测序产生的 cDNA 序列）作为输入，并自动识别压缩格式（可用`--fastq-input`选项）[github.com](https://github.com/DerrickWood/kraken2/wiki/Manual#:~:text=Kraken is a taxonomic sequence,mer)[github.com](https://github.com/DerrickWood/kraken2/blob/master/docs/MANUAL.markdown#:~:text=URL%3A https%3A%2F%2Fgithub)。因此，来自 Illumina 平台的 bulk RNA-seq 或 10x scRNA-seq 的 cDNA FASTQ 文件都可以直接作为 Kraken2 的输入（前提是测序库已逆转录为 DNA，序列中含 T 而非 U）。SAHMI（Single-cell Analysis of Host-Microbiome Interactions）是基于 R 的分析管线，专门用于处理 scRNA-seq 数据中的宿主-微生物信号。它以 Kraken2/Kraken2Uniq 的分类结果为输入，利用每条 read 的条形码和 UMI 信息进行分析[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=)。SAHMI 要求提供：Kraken2 输出报告文件（标准报告、MPA 风格报告和包含每条 reads 分类结果的输出文件）以及对应的分类后 FASTQ/FASTA 文件[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)。简言之，任何含有 DNA 序列的 FASTQ 文件（如转录组得到的 cDNA 序列）都可用于 Kraken2；若要使用 SAHMI，则需先用 Kraken2/KrakenUniq 对原始或去宿主后的 FASTQ 进行分类，生成 SAHMI 所需的报告和带分类标签的 reads 文件[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)。

## 推荐分析流程

一般推荐的分析流程包括以下主要步骤：

1. **数据质控**：使用 FastQC、Trimmomatic/fastp 等对 FASTQ 进行质量控制和接头去除。

2. **宿主序列处理**（可选）：为了减少宿主污染，可将 reads 比对到人基因组（如 GRCh38）并去除匹配的 reads；或者直接在后续分类中使用包含人基因组的参考库[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)（见下文“宿主去除策略”）。

3. **Kraken2 分类**：构建 Kraken2 数据库。可选择使用含微生物（细菌、真菌、病毒等）和/或宿主（人）基因组的混合数据库。如果宿主已在前步骤去除，则可只包含微生物序列，否则需要把人基因组也放入库中[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)。然后用 Kraken2（或 Kraken2Uniq）对 FASTQ 进行分类，生成分类输出（`.kraken` 和报告）。例如：

   ```
   kraken2 --db PATH_TO_DB --paired reads_1.fastq reads_2.fastq --output sample.out --report sample.report
   ```

   这里输出包括标准报告、MPA 样式报告以及每条 read 的分类标签等，SAHMI 需要这些结果作为输入[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)。

4. **提取微生物 reads**（仅 SAHMI 单细胞分析）：使用 SAHMI 中的 `extract_microbiome_reads.r` 脚本，从 Kraken2 分类后的 FASTQ 和报告中提取标记为微生物的 reads，生成仅含微生物 reads 的 FASTA/FASTQ 文件[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=)。

5. **单细胞 k-mer 分析**（仅 scRNA-seq）：使用 SAHMI 的 `sckmer.r` 脚本统计每个细胞（barcode）中每个分类单元（如种属）的 k-mer 计数[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=species,mers%2C and number of unique)。该步骤要求输入：微生物 reads FASTA 文件、Kraken 报告等参数（包括每个 barcode 的长度 `cb_len`、UMI 长度 `umi_len`）[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=)。此时 SAHMI 会过滤掉含宿主 k-mer 的 reads[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=species,mers%2C and number of unique)。

6. **宿主-微生物共表达分析**：得到每个细胞/样本的微生物计数矩阵后，可与宿主转录组表达数据结合分析。常见做法包括计算微生物丰度与宿主基因模块的相关性，或进行联合聚类等。从而识别与特定微生物存在相关的宿主基因表达模式（即共表达网络）。例如，可通过 WGCNA 或相关分析将微生物定量结果与宿主细胞类型或通路活动联系起来。

在实际操作中，上述步骤可用流程脚本简化（SAHMI 提供 `run_kraken.r`、`extract_microbiome_reads.r`、`sckmer.r` 等脚本[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=)）。整体流程可以概括如下表：

| 步骤                 | 工具/脚本                  | 说明与关键参数                                               |
| -------------------- | -------------------------- | ------------------------------------------------------------ |
| 1. 质量控制          | FastQC/Trimmomatic         | 去接头、低质量序列；保证下游分析准确性                       |
| 2. 宿主序列处理      | Bowtie2/Kraken2            | 使用 Bowtie2 将 reads 比对到人基因组并去除；或后续 Kraken2 数据库同时含人基因组[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and) |
| 3. Kraken2 分类      | Kraken2/Kraken2Uniq        | 对处理后 FASTQ 分类；数据库可含微生物及（可选）宿主序列；输出分类报告及标记好的 reads |
| 4. 提取微生物 reads  | extract_microbiome_reads.r | 从 Kraken2 输出中提取微生物 reads，生成纯微生物序列文件      |
| 5. 单细胞 k-mer 分析 | sckmer.r                   | 统计每个细胞 barcode 的微生物 k-mer 计数；过滤含宿主 k-mer 的 reads[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=species,mers%2C and number of unique) |
| 6. 相关性分析        | R/python 分析              | 将微生物丰度与宿主基因表达关联分析，构建共表达网络           |



## 人源序列去除策略

在处理含有丰富宿主序列的样本时，推荐先去除人源序列以减少误判和计算量。常用做法是使用 Bowtie2（或 BWA/KneadData 等）将 reads 比对到人参考基因组（如 GRCh38）并丢弃匹配的部分[pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC11255660/#:~:text=,The remaining)。若不先行去除，则至少应在 Kraken2 的参考库中加入人类基因组作为可能目标[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)。SAHMI 文档明确指出：“必须包含所有可能的参考基因组（如宿主、人、常见载体等），否则应将宿主可比对的 reads 排除”[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)。这样做既可避免宿主 reads 被错误分类为微生物，也能让分类器将同源片段正确归到人类类别。实际上，如果参考库同时包含人基因组和细菌基因组，则那些在人和细菌间存在高同源性的序列往往会被 Kraken2 判定为人类而不计入细菌类[phys.org](https://phys.org/news/2023-10-analytical-tool-genetic-analysis-accuracy.html#:~:text=Methods for definitions of the,2 × 10−16)。相反，如果数据库中**不**包含人类序列，这类 reads 很可能被错误地标记为细菌，造成细菌读数虚增[phys.org](https://phys.org/news/2023-10-analytical-tool-genetic-analysis-accuracy.html#:~:text=Methods for definitions of the,2 × 10−16)[biostars.org](https://www.biostars.org/p/380889/#:~:text=custom database built by kraken2,06 million reads on bacteria)。SAHMI 的设计也沿用了这一思路：在分类后，任何包含宿主 k-mer 的 reads 都会被直接丢弃[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=species,mers%2C and number of unique)，避免后续分析中的交叉污染。因此，实际应用中应根据研究需求决定去宿主步骤：要么预先用比对工具去除，要么包含人基因组并依赖 Kraken2/SAHMI 本身的策略过滤宿主序列。

## 同源序列注释行为

Kraken2 对每条序列的 k-mer 进行查库，并将其与包含该 k-mer 的所有基因组的最低公共祖先（LCA）关联[genomebiology.biomedcentral.com](https://genomebiology.biomedcentral.com/articles/10.1186/s13059-019-1891-0#:~:text=,accurate in independent tool comparisons)。若一条 reads 的 k-mer 同时匹配到人类和某种细菌，Kraken2 将会返回它们的 LCA 分类。例如，人和细菌的最小共同祖先可能是“根”或“细胞生物”，这通常导致该 reads 被标记为未分类或被归为人类。实践中发现：**包含人类参考库时，这类同源 reads 往往会被归到人类，细菌读数减少**[phys.org](https://phys.org/news/2023-10-analytical-tool-genetic-analysis-accuracy.html#:~:text=Methods for definitions of the,2 × 10−16)；**不含人类时，原本属于宿主的 reads 则多误归为细菌**[phys.org](https://phys.org/news/2023-10-analytical-tool-genetic-analysis-accuracy.html#:~:text=Methods for definitions of the,2 × 10−16)。为提高注释准确性，建议采取以下预处理或过滤手段：

+ **去除宿主序列**：如前所述，尽量通过比对剔除人源 reads，减少 Kraken2 将宿主序列错误分类为微生物的风险。
+ **使用 Kraken2Uniq 或设定置信度阈值**：这些工具/参数可以过滤掉 k-mer 匹配不唯一或置信度低的分类结果。
+ **SAHMI 过滤策略**：SAHMI 在单细胞 k-mer 分析中，明确丢弃任何含宿主 k-mer 的 reads[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=species,mers%2C and number of unique)，并要求每条 reads 至少有一半以上的 k-mer 与同一分类单元一致，否则也将其抛弃[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=species,mers%2C and number of unique)。此外，SAHMI 引入了基于条形码的 k-mer 相关性检验（见下节“应用案例”），进一步剔除散落在极少数细胞、且总／独特 k-mer 数不成比例的假阳性信号。通过上述措施，可以显著提高微生物分类的准确性，减少由于序列同源性带来的混淆。

## 应用案例

Kraken2+SAHMI 已在多篇高水平文章中用于宿主-微生物互作分析。**胰腺癌单细胞**研究是代表性案例：Ghaddar 等人在 *Cancer Cell* (2022) 中介绍了 SAHMI 管线，利用 10x scRNA-seq 数据识别胰腺导管腺癌组织中的肿瘤细胞相关细菌，并发现这些细菌的存在与肿瘤细胞特定的基因表达通路（如细胞运动和免疫信号）密切相关[pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/36220074/#:~:text=tumor responses in humans remain,infiltrating)。该研究中，SAHMI 首先用 Kraken2Uniq 对单细胞 RNA 序列进行分类，然后通过 k-mer 条形码相关性检验筛选出可靠的菌属信号，最后关联宿主细胞的转录特征[pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/36220074/#:~:text=tumor responses in humans remain,infiltrating)[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=species,mers%2C and number of unique)。结果显示，某些细菌主要聚集在肿瘤细胞内，它们的“存在”与宿主转移和免疫信号通路的活性显著相关[pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/36220074/#:~:text=recover and denoise microbial signals,infiltrating)。此外，SAHMI 的原始方法论文（*Nat. Comput. Sci.*, 2023）在多个真实数据集（包括已知感染模型）中验证了这种去噪策略的有效性，证明它能识别真正存在的微生物并剔除污染和假阳性[nature.com](https://www.nature.com/natcomputsci/articles?type=brief-communication&year=2023#:~:text=SAHMI performs in silico denoising,positive misclassifications)[phys.org](https://phys.org/news/2023-10-analytical-tool-genetic-analysis-accuracy.html#:~:text=Image%3A New analytical tool improves,showing the total number of)。图示中明确看到：如果不将人类参考包含在分类数据库中，Kraken2 注释到细菌的 reads 显著增加；这验证了“有无宿主序列”对结果的影响[phys.org](https://phys.org/news/2023-10-analytical-tool-genetic-analysis-accuracy.html#:~:text=Methods for definitions of the,2 × 10−16)。综上所述，使用 Kraken2 + SAHMI 分析宿主微生物组时，遵循官方推荐流程并结合上述案例中的经验，可有效展开宿主-微生物共表达网络研究。例如，可以在各细胞类型或样本组中计算微生物丰度与宿主基因模块的相关性，从而探讨肿瘤内细菌对宿主转录网络的潜在调控作用[pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/36220074/#:~:text=recover and denoise microbial signals,infiltrating)[phys.org](https://phys.org/news/2023-10-analytical-tool-genetic-analysis-accuracy.html#:~:text=Image%3A New analytical tool improves,showing the total number of)。

**参考文献**：关于 Kraken2 和 SAHMI 的技术细节，请参见相关原始文献和官方资料[github.com](https://github.com/DerrickWood/kraken2/wiki/Manual#:~:text=Kraken is a taxonomic sequence,mer)[genomebiology.biomedcentral.com](https://genomebiology.biomedcentral.com/articles/10.1186/s13059-019-1891-0#:~:text=,accurate in independent tool comparisons)[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=Metagenomic classification of paired,output file with read and)[github.com](https://github.com/sjdlabgroup/SAHMI#:~:text=species,mers%2C and number of unique)[pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/36220074/#:~:text=tumor responses in humans remain,infiltrating)[nature.com](https://www.nature.com/natcomputsci/articles?type=brief-communication&year=2023#:~:text=SAHMI performs in silico denoising,positive misclassifications)。上述流程亦参考了多个案例研究和性能评估结果[phys.org](https://phys.org/news/2023-10-analytical-tool-genetic-analysis-accuracy.html#:~:text=Image%3A New analytical tool improves,showing the total number of)[phys.org](https://phys.org/news/2023-10-analytical-tool-genetic-analysis-accuracy.html#:~:text=Methods for definitions of the,2 × 10−16)。