# RNA-seq 流程模块

## 数据预处理和质量控制

### `gff`

1. 基因类型、出图
   1. **mRNA:** If the feature type is `mRNA`, it is considered a protein-coding gene.
   2. **miRNA:** If the feature type is `miRNA`, it is considered a microRNA gene.
   3. **mRNA_TE_gene:** If the feature type is `mRNA_TE_gene`, it is considered a transposable element-derived protein-coding gene.
   4. **ncRNA:** If the feature type is `ncRNA`, it is considered a non-coding RNA gene.
   5. **pseudogenic_transcript:** If the feature type is `pseudogenic_transcript`, it is considered a pseudogene.
   6. **rRNA:** If the feature type is `rRNA`, it is considered a ribosomal RNA gene.
   7. **snoRNA:** If the feature type is `snoRNA`, it is considered a small nucleolar RNA gene.
   8. **snRNA:** If the feature type is `snRNA`, it is considered a small nuclear RNA gene.
   9. **tRNA:** If the feature type is `tRNA`, it is considered a transfer RNA gene.
2. 计算不同基因组区域的长度分布，出图
   1. **Region_Type:** 此列指定基因组区域的类型。此示例中存在以下类型：
      - **CDS (编码序列):** CDS 指的是编码蛋白质的 DNA 序列。这部分基因组包含了实际用于生产蛋白质的遗传信息。
      - **noncoding:** 非编码区域指的是基因组中不编码蛋白质的 DNA 序列。这些区域可能包含调控元件，如启动子、增强子等，对基因表达有重要影响。
      - **intron:** 内含子是真核生物基因中不包含在成熟 mRNA 中的序列，它们在前体 mRNA 中存在，但在成熟过程中被剪接掉。内含子的长度通常比外显子（exons）长，并且占据了基因组的很大一部分。
      - **intergenic:** 基因间区域是指两个相邻基因之间的 DNA 序列。这些区域通常不编码蛋白质，但可能包含调控元件或其他功能元件。
      - **three_prime_UTR (3' UTR):** 3' 非翻译区（3' UTR）是 mRNA 分子的尾部非编码序列，位于编码蛋白质的序列之后。3' UTR 在调控 mRNA 的稳定性和翻译效率中起着重要作用。
      - **five_prime_UTR (5' UTR):** 5' 非翻译区（5' UTR）是 mRNA 分子的头部非编码序列，位于编码蛋白质的序列之前。5' UTR 同样在调控 mRNA 的翻译和稳定性中发挥作用。
   2. **length:** 此列代表所有染色体上对应区域类型的总长度，单位是 bp。

### `fastqc`

FastQC 是一个质量控制分析工具，用于检测高通量测序数据中的潜在问题。它提供了一系列的分析模块，可以帮助快速了解数据是否有任何需要注意的问题，以便进行进一步的分析。FastQC 可以处理 `fastq` 或 `bam` 格式的原始序列文件，并生成一个报告，总结分析结果。

FastQC 的报告是一个 HTML 文件，包含了各种分析模块的结果和图表。FastQC 的报告中，每个分析模块都有一个结果图和一个状态图标。状态图标表示该模块的结果是否正常（绿色）、需要注意（黄色）或有问题（红色）。

FastQC 有以下几个分析模块：

+ 基本统计：显示输入文件的名称、编码类型、总读数、读长和 GC 含量等信息。
+ 每碱基质量分布：显示每个位置的平均质量得分，以及上下四分位数的范围。
+ 每序列质量分布：显示每个序列的平均质量得分的频率分布，以及对应的合格率。
+ 每碱基序列内容：显示每个位置的 A、T、G 和 C 的比例，以及与理论值的偏差。
+ 每序列 GC 含量：显示每个序列的 GC 含量的频率分布，以及与整体 GC 含量的比较。
+ 每碱基 N 含量：显示每个位置包含 N（未知）碱基的比例。
+ 序列长度分布：显示不同长度序列出现的频率，以及平均长度和最大长度。
+ 序列重复度：显示不同重复次数序列出现的频率，以及总重复度和最大重复度。
+ 过表示 kmer 内容：显示在所有序列中过表达（出现次数超过预期）或者欠表达（出现次数低于预期）的 kmer（一般为 7 或 8 bp），以及它们在序列中出现的位置和比例。
+ 适配器内容：检测输入文件中是否包含常见 adapter 序列，并显示它们在不同位置出现的比例。

#### Quality Score

$$
\huge Q=-10\log_{10}P
$$

> $Q$: Phred 质量分数
>
> $P$: 测序错误率
>
> 如果一个碱基的 Phred 质量分数是 30，那么这个碱基的错误概率是 $10^{−30}$ 或 0.001，即在 1000 个这样的碱基中，平均会有 1 个碱基识别错误。

#### GC Content

对测序 reads 中四种碱基的分布比例进行评估，检查是否存在 AT、CG 分离现象，理论上 A 与 T、C 与 G 的含量在整个测序反应中分别相同，且维持在稳定水平。

上图中横坐标表示碱基在 reads 上的位置，纵轴为碱基含量百分比。对于一个随机的文库，四种碱基的出现频率应该是非常接近的，而且没有位置差异，因此代表碱基的四条线应该平行且接近。每种碱基的相对比例反应的是基因组中碱基整体的比例分布，在任意情况下它们都不会出现明显偏差。当部分位置上碱基的比例表现出较强的偏好性时，往往提示文库中存在超出比例的序列的污染。当所有位置上的碱基比例一致的表现出偏好性时，往往表示文库有序列偏好性 (建库过程或本身特点)，或者是测序过程中存在系统误差。

测序中，由于随机引物扩增偏差等原因，会导致测序得到的 reads 前 6~7 个碱基有较大的波动，属正常情况。碱基的含量分布线平行且略有分离，主要由于建库或测序中的碱基偏好性所导致。

#### Length distribution

横坐标表示序列长度，纵坐标为 reads 数目，reads 的长度为原始测序长度去掉低质量碱基之后的长度，通常绝大多数 reads 长度略短于测序平台的读长，图中的峰在末尾碱基处出现。

#### Duplication Level

在 cDNA 文库构建的过程中对捕获的 mRNA/ncRNA 进行随机片段化，随后加接头并进行 RT-PCR。一个多样性的文库中大多数序列应该只出现一次，低水平的序列冗余度往往表明高水平的靶标序列覆盖度，而高水平的序列冗余度则意味着一定程度上的偏好富集性，如文库构建过程中 PCR 过度扩增。通常测序深度越高，越容易产生一定程度的重复 reads，属于正常的现象。实际操作中，由于数据量较大，为了降低计算中对内存的要求，仅选取了每个文件的前 200 000 条 reads 进行分析，认为其可以代表全部序列的冗余度。

PCR duplication level 计算方法为：从测序数据中随机挑选 20 万 reads 作为 Total Reads，按照如下公式进行计算：
$$
\text{PCR duplication Level} = \frac{\text{Duplication Reads}}{\text{Total Reads}}
$$
统计序列完全一样的 reads 出现的频率。上图中横坐标表示重复次数，纵坐标为 reads 比例，跟踪每条序列在其所在的文件中整体的重复度，重复次数大于等于 10 的 reads 被合并统计，所以图的最右侧通常表现出轻微上扬，如果最右侧明显上扬，则表明有相当多的序列高度重复。但由于 reads 越长越不容易完全相同（由测序错误导致碱基差异），所以其重复程度仍有可能被低估。

相对于基因组测序，RNA-seq 数据较高的序列重复水平主要由 PCR 扩增导致，reads 重复率可达到 70% (Mamanova, Andrews et al. 2010)。去除这部分重复的 reads 并不会提高定量的准确性，所以现有基因表达水平的分析中保留了这部分数据，而在 SNP 分析中这部分数据需要剔除 (Chepelev, Wei et al. 2009)。

## 比对和基因表达

### `mapping`

Reads 比对到参考基因组。根据不同的基因组的特征，选取相对合适的软件，动植物用 HISAT2 (Kim D, Langmead B et al. 2015)、真菌或者基因密度较高的物种用 Bowtie 2 (Langmead and Salzberg 2012)，根据需要会设定一定的容错率，将有效测序数据（clean reads）比对到参考基因组上。

1. Total reads：clean reads 中成对的 reads 数目，用于后续分析；
2. Total mapped：能定位到参考基因组上的 reads 的数目及比例；转录组测序中，如果不存在污染并且参考基因组选择合适的情况下，通常这部分数据的比例高于 70%；
3. Total Uniquely mapped：在参考基因组上仅有唯一定位的 reads 数及其占 total mapped reads 的比例，单位置比对的 reads 绝大多数来自成熟的 mRNA；
4. Total Multiple mapped：在参考基因组上有多个定位的 reads 数及其占 total mapped reads 的比例，多位置比对的 reads 以 rRNA 和 tRNA 为主；
5. Total Pairs：前面 Total reads 中成对的序列对的数目；
6. Total Uniquely Concordant Pairs：在参考基因组上仅有唯一定位的 reads 中一致的序列对（concordant Pair）的数目及比例；成对的两条 reads 的在基因组上的距离在插入片段长度范围内，且朝向都未改变，即为一致的序列对；
7. Splice reads：分段比对到两个外显子上的测序序列，在 AS 分析中称为 Junction reads；
8. Nonsplice reads：整段比对到外显子上的测序序列。

正常情况下，转录组数据中定位到 CDS 区域的序列比例最高，其次是 3’UTR，定位到 Intron 区域的序列可能是由未成熟的 mRNA 或者基因组注释不完全导致，而定位到基因间区域的测序序列可能是由基因组注释不完全以及背景噪音所致。

### `basic_mapregin`

` expression_quantity_calculation.py`：`gffutils` 和 `HTSeq` 来处理基因组注释文件（GFF）和测序数据（如 BAM 或 BED 文件）统计计算基因表达量

### `newtrans__stringtie`

StringTie 是一款专门用于 RNA-Seq 数据的转录本组装和定量的生物信息学软件。它结合了基因组指导的组装方法和从头组装的策略，以提高转录组组装的准确性和发现新型转录本的能力。

根据指定的基因注释文件和输入的 BAM 文件来组装和量化转录本，并输出基因丰度和转录本组装的结果。

使用 `stringtie --merge` 合并多个转录本文件，并与参考注释进行比较，接着通过文本处理命令筛选和转换注释信息，最终生成一个GFF3格式的转录本注释文件。

### `sogenas`

作图参数

### `basic__diistance2xxx`

计算给定 GFF/gffdb 文件和 BAM/bed 文件中 reads 或 peaks 相对于特定基因组特征（例如 TSS、TTS、起始密码子、终止密码子）的分布。

### `plotgenome`

计算和可视化人类基因组（GRCh38 参考）上 BAM 文件（可能包含来自 DNA 测序的对齐读取）的覆盖深度。覆盖深度代表参考基因组中每个碱基被 BAM 文件中读取覆盖的次数。此信息对于评估测序数据的质量和均匀性很有价值，可用于各种下游分析，例如识别覆盖率高或低的区域或检测转录起始位点等基因组特征。

### `lncrna__filter`

识别、过滤和表征长链非编码 RNA（lncRNA）候选物。lncRNA 是长度超过 200 个碱基的非编码 RNA 分子，可能在细胞调控中发挥重要作用。此分析管道使用来自 RNA-seq 测序实验的比对结果（BAM 文件）作为输入，并输出最终过滤的 lncRNA 列表和一些统计数据。

### `basic__exp`

分析 RNA-seq 数据，计算基因表达水平（FPKM）并生成累积分布图。

### `newtrans__newtrans`

分析了 RNA-seq 数据，分别使用标准参考基因组注释和 StringTie 组装的新转录本注释计算了基因表达量 (FPKM)。生成了两个累积分布图。

### `lncrna__blast2noncode`

根据 lncRNA 序列与已知非编码 RNA 的相似性对其进行分类，并将它们分为已知和潜在新类别。

### `lncrna__stat`

分析 RNA-Seq 数据以识别、过滤、注释和统计分析 lncRNA 转录本。

+  生成 lncRNA 表达和类型统计数据

+ 生成 lncRNA 表达和类型的条形图

## 差异和功能通路分析

### `deg`

1. **加载数据：** 从 RNA-Seq 数据文件中加载 Reads 和 FPKM 数据，并从注释文件中加载基因信息。
2. **预处理数据：** 过滤 Reads 数据以删除低质量读取，并对 Reads 和 FPKM 数据进行归一化。
3. **差异表达分析：** 使用 `edgeR` 或 `DESeq` 等统计方法进行差异表达分析，并根据 p 值和倍数变化阈值识别 DEGs。`DEG_calculate` 子程序是脚本的核心部分，它根据配置文件中的参数和样本数据进行差异表达基因分析。支持两种分析方法：`edgeR` 和 `DESeq`，并生成相应的脚本和命令来执行分析。
4. **结果输出：** 将 DEGs 的结果输出到文件中，并生成火山图等可视化图形。

### `lncrna__exp`

这个脚本是一个生物信息学分析流程，主要功能是计算基因表达量并进行相关分析。具体来说，它执行以下步骤：

1. 创建目录结构：脚本首先创建了一系列目录，用于存放不同类型的分析结果，如新发现的 lncRNA（长非编码 RNA）和已知的 lncRNA。
2. 计算表达量：使用 `expression_quantity_calculation_v2.4.1.py` 脚本计算基因表达量。这个脚本通过读取过滤后的 lncRNA 数据库文件和比对结果文件（BAM 文件），计算每个基因的表达量，并输出表达量文件。
3. 结果整合：将新发现的 lncRNA 和已知 lncRNA 的表达量文件合并，创建一个包含所有 lncRNA 表达量的文件。
4. 过滤表达量数据：使用 `lines_filter.pl` 脚本过滤合并后的表达量文件，根据注释信息保留有效的 lncRNA 基因，并输出一个新的过滤后的表达量文件。
5. 基因与 lncRNA 关联分析：使用 `lncRNA_gene_association_Strand.pl` 脚本分析 lncRNA 与其邻近蛋白编码基因的关联性，输出关联信息文件。
6. 数据可视化：使用 R 脚本 `Cor_line.r` 对关联信息文件进行处理，生成 lncRNA 与蛋白编码基因相互作用的图形表示。

`expression_quantity_calculation_v2.4.1.py` 脚本的主要功能是计算基因表达量，它通过以下步骤实现：

- 读取 GFF 文件或数据库，创建或使用 GFF 数据库。
- 读取 BAM 文件，这是比对后的测序数据。
- 计算每个基因的表达量，包括 mRNA 的不同部分（如 5'UTR、CDS、3'UTR）。
- 计算基因表达量的 FPKM（每千个碱基数的片段数目

### `deg__gokegg`

进行基因表达差异分析后的 GO 和 KEGG 富集分析。具体来说，它执行以下步骤：

1. 创建目录：脚本首先创建一个目录，用于存放 GO 和 KEGG 分析的结果。
2. 运行 GO 和 KEGG 分析：脚本使用 `kegg_go_pipe_one.pl` 这个 Perl 脚本来处理两个输入文件 `LADA_vs_healthy_Up_DEG.txt` 和 `LADA_vs_healthy_Down_DEG.txt`，这两个文件包含上调和下调差异表达基因（DEGs）的列表。脚本分别对这两个列表进行 GO 和 KEGG 富集分析。
3. 分析参数设置：`kegg_go_pipe_one.pl` 脚本通过命令行参数接收输入文件、物种代码、基因本体描述文件、KEGG 注释文件等信息，并根据这些信息执行相应的分析。
4. GO 分析：脚本调用 `GO_pipe` 子程序，该子程序将执行 GO 富集分析，包括提取显著富集的 GO 术语，并将结果保存到文件中。此外，它还会生成 GO 术语的条形图，用于可视化分析结果。
5. KEGG 分析：脚本调用 `KEGG_pipe` 子程序，该子程序将执行 KEGG 路径富集分析，提取显著富集的 KEGG 路径，并将结果保存到文件中。它还会生成 KEGG 路径的图像，用于可视化分析结果。
6. PPI 分析（可选）：如果启用了蛋白质 - 蛋白质相互作用（PPI）分析，脚本将调用 `PPI_pipe` 子程序，执行 PPI 网络分析。

`kegg_go_pipe_one.pl` 脚本的主要功能是自动化 GO 和 KEGG 富集分析的流程，它通过以下步骤实现：

- 解析命令行参数，获取必要的输入信息。
- 根据物种代码和注释文件，执行 GO 和 KEGG 富集分析。
- 生成富集分析的结果文件，包括 GO 术语和 KEGG 路径的注释、富集结果以及可视化图像。
- 可选地，执行 PPI 网络分析。

### `lncrna__deg`

长非编码 RNA（lncRNA）的差异表达分析（DEG）。具体来说，它执行以下步骤：

1. 清理并创建目录：首先删除已存在的 `lncrna/deg` 目录（如果存在），然后重新创建这个目录。
2. 准备输入文件：脚本通过 `grep` 和 `cat` 命令合并 FPKM 和 reads 计数数据，创建两个临时文件 `all_fpkm.txt.tmp` 和 `all_reads.txt.tmp`。这些文件包含了所有表达的基因和 lncRNA 的信息。
3. 执行差异表达分析：使用 `DEG_for_lncRNA_repetition_v4.pl` 这个 Perl 脚本来计算 lncRNA 的差异表达。该脚本接受多个参数，包括配置文件、FPKM 文件、reads 计数文件、注释文件以及输出目录等。
4. 记录日志：将 `DEG_for_lncRNA_repetition_v4.pl` 脚本的输出重定向到 `log.deg.txt` 文件中，以便记录分析过程。
5. 完成标志：最后，脚本输出一条消息表示工作已完成。

`DEG_for_lncRNA_repetition_v4.pl` 脚本的主要功能是自动化差异表达分析的流程，它通过以下步骤实现：

- 读取配置文件来获取分析所需的参数和选项。
- 检查输入文件是否存在，并准备输出目录。
- 加载 RNA 测序数据，包括 FPKM 和 reads 计数。
- 根据配置文件中的分组信息，对不同的样本组进行差异表达分析。
- 使用 edgeR 或 DESeq 等统计方法进行分析，并生成相应的图表和报告。
- 对于共同差异表达基因（co-DEG）和差异表达基因（di-DEG），生成 Venn 图和统计表格。

### `saturarion__saturation`

主要用于差异表达基因（Differential Expression Genes, DEG）分析。识别在不同条件下表达差异显著的基因。

脚本的主要功能如下：

1. **环境设置**：脚本首先切换工作目录到指定的文件夹，这是存放分析结果的位置。
2. **参数读取**：通过命令行参数读取输入文件的路径和其他必要的参数，如基因注释文件的路径。
3. **错误检查**：脚本检查配置文件、RNA 测序文件和 FPKM（Fragments Per Kilobase of transcript per Million mapped reads）文件是否存在。
4. **样本和组信息加载**：脚本加载 RNA 测序文件和 FPKM 文件，以获取样本信息和表达量数据。
5. **差异表达基因分析**：根据配置文件中的参数，脚本执行差异表达基因分析。它支持两种方法：edgeR 和 DESeq。这两种方法都是流行的 RNA-seq 数据分析工具，用于检测在不同条件下表达量发生变化的基因。
6. **结果输出**：分析完成后，脚本将结果输出到指定的目录，并生成一些附加文件，如差异表达基因列表和火山图。
7. **注释添加**：脚本还包括步骤来添加基因注释信息到结果文件中，这有助于理解差异表达基因的功能和生物学意义。
8. **时间记录**：脚本记录分析的开始和结束时间，以便于跟踪分析过程的耗时。
9. **辅助功能**：脚本包含一些辅助函数，如获取配置选项、处理文件路径、格式化日期时间等。

### `report`

1. **参考基因组信息同步**：使用 `rsync` 命令同步 `gff` 目录中的文件到参考基因组信息目录，同时排除了一些不需要的文件和目录。
2. **样本信息复制**：将 `Sample_description.xls` 文件从样本信息目录复制到图书馆信息目录。
3. **质量控制文件同步**：使用 `rsync` 命令同步 `fastqc` 目录中的文件到质量控制信息目录，并创建了一些子目录，然后将特定的图像文件从 `fastqc` 目录复制到相应的子目录中。
4. **映射结果同步**：将基本分析结果目录中的文件同步到映射补充目录，包括排除了一些不需要的文件和目录，并将特定的图像文件和文本文件从绘图基因组目录复制到映射补充目录。
5. **差异表达基因分析结果同步**：将差异表达基因分析结果目录中的特定文件同步到 DEG 结果目录，同时排除了一些不需要的文件。
6. **基因本体（GO）和 KEGG 路径分析结果同步**：将 GO 和 KEGG 分析结果目录中的特定文件同步到 GO 和 KEGG 补充目录，包括排除了一些不需要的文件和目录。

### `lncrna__report`

组织和处理长非编码 RNA (lncRNA) RNA 测序分析结果的 shell 脚本。

**部分 1：压制 “Supplements” 文件夹中的特定文件 / 目录**

此部分循环遍历“Supplements”文件夹中的几个名为 `Sup[0-7]` 的子目录。对于每个子目录，它执行以下操作：

1. **清除现有内容:** 它使用 `rm -rf` 删除子目录中的所有文件和目录。
2. **复制特定文件 / 目录:** 它根据名称或模式复制特定文件或目录，使用 `cp -rf`。

**部分 2：过滤和组织已知 lncRNA 统计数据**

此部分处理与已知 lncRNA 相关的统计信息并将它们保存到 `Sup0_Annotated_lncRNA` 子目录中。它执行以下操作：

1. **删除现有文件:** 它删除目录中任何现有的文件。

2. **移动到目录:** 它将工作目录更改为 `Sup0_Annotated_lncRNA`。

3. **提取标题行:** 它使用 `head -n 3` 从 `anno_lncRNA_statics.txt` 文件中提取标题行。

4. 从统计数据创建文件:

    

   它创建三个文件：

   - `Annotated_lncRNA_in_reference_genome.xls`: 此文件可能是通过复制具有相同名称的另一个文件的內容创建的。
   - `Annotated_lncRNA_type_classification.txt`: 此文件是通过使用 Perl 处理 `anno_lncRNA_type_statics.txt` 文件创建的。脚本计算每个 lncRNA 类型的比率并创建包含类型、数量和比率的表。

5. **复制 PNG 图像:** 它从另一个位置复制名为 `Annotated_lncRNA_type_classification_Bar.png` 的图像文件。

**部分 3：处理新 lncRNA 预测结果**

此部分处理与新 lncRNA 的预测相关的结果并将它们保存到 `Sup1_lncRNA_prediction` 子目录中。以下是细分：

1. **清除现有内容:** 它删除子目录中的所有文件和目录。
2. **创建子目录:** 它创建两个名为 `known` 和 `novel` 的子目录，以可能组织不同类别的预测 lncRNA。
3. **从另一个目录复制文件:** 它将所有文件从 `stat` 目录复制到 `known` 子目录。这表明 `stat` 目录包含已知 lncRNA 的参考数据。
4. **移动到 `known` 子目录:** 它将工作目录更改为 `known`。
5. **删除特定文件:** 它删除几个可能与中间处理步骤相关的文件。
6. **处理已知 lncRNA 统计数据:** 它使用 Perl 可能处理名为 `anno_lncRNA_statics.txt` 的文件并创建名为 `Expressed_annotated_lncRNA.txt` 的新文件。此新文件可能包含已表达的注释 lncRNA 的统计数据。
7. **移动到 `novel` 子目录:** 它将工作目录更改为 `novel`。
8. **提取统计数据头:** 它从名为 `novel_lncRNA_filter_statics.txt` 的文件中提取标题行并将其保存到不同的文件中以进行进一步分析。
9. **删除临时文件:** 它删除几个可能包含中间结果的目录和文件。

**部分 4：针对非编码数据库的 Blast 结果**

此部分处理将新 lncRNA 与非编码数据库进行 BLAST 的结果并将它们保存到 `Sup2_blast2noncode` 子目录中。它执行以下操作：

1. **清除现有内容:** 它删除子目录中的所有文件和目录。
2. **移动到目录:** 它将工作目录更改为 `Sup2_blast2noncode`。
3. **复制相关文件:** 它复制几个与新 lncRNA 过滤统计和 BLAST 结果相关的文件。
4. **运行 Perl 脚本:** 它运行名为 `count_gene_from_gtf_or_gff.pl` 的 Perl 脚本，该脚本可能从 GTF/GFF 文件 (novel_lncRNA.known.gtf) 中量化基因并创建名为 `noncode_lncRNA_statics.txt` 的新文件。
5. **使用 Perl 处理结果:** 它使用另一个 Perl 脚本可能处理 `noncode_lncRNA_statics.txt` 文件和 `novel_lncRNA_filter_statics.txt` 文件以创建名为 `Novel_lncRNA_blast2noncode.txt` 的新文件。此新文件可能包含有关新 lncRNA 与已知非编码序列相似性的信息。

**部分 5：lncRNA 和 mRNA 的共表达分析**

此部分对 lncRNA 和 mRNA 进行共表达分析并将结果保存到 `Sup3_coexp` 子目录中。它执行以下操作：

1. **清除现有内容:** 它删除子目录中的所有文件和目录。
2. **移动到目录:** 它将工作目录更改为 `Sup3_coexp`。
3. **复制相关文件:** 它复制几个与共表达分析相关的文件，包括 lncRNA 和 mRNA 的表达矩阵。
4. **运行共表达分析:** 它运行名为 `coexp.pl` 的 Perl 脚本以执行 lncRNA 和 mRNA 之间的共表达分析。脚本可能计算相关系数或其他共表达度量。
5. **使用 Perl 处理结果:** 它使用另一个 Perl 脚本可能处理共表达分析的输出并创建包含共表达网络或其他可视化的新文件。

**部分 6：lncRNA 的功能注释**

此部分对 lncRNA 进行功能注释并将结果保存到 `Sup4_function` 子目录中。它执行以下操作：

1. **清除现有内容:** 它删除子目录中的所有文件和目录。
2. **移动到目录:** 它将工作目录更改为 `Sup4_function`。
3. **复制相关文件:** 它复制几个与功能注释相关的文件，包括 lncRNA 序列和基因本体论 (GO) 注释。
4. **运行功能注释:** 它运行名为 `GO_annotation.pl` 的 Perl 脚本以执行 lncRNA 的功能注释。该脚本可能根据 lncRNA 相关基因或其他特征为 lncRNA 分配 GO 术语。
5. **使用 Perl 处理结果:** 它使用另一个 Perl 脚本可能处理功能注释的输出并创建包含富集的 GO 术语或其他功能信息的

**部分 7：构建 lncRNA-mRNA 调控网络**

此部分构建 lncRNA-mRNA 调控网络并将结果保存到 `Sup5_lncRNA_mRNA_network` 子目录中。它执行以下操作：

1. **清除现有内容:** 它删除子目录中的所有文件和目录。
2. **移动到目录:** 它将工作目录更改为 `Sup5_lncRNA_mRNA_network`。
3. **复制相关文件:** 它复制几个与网络构建相关的文件，包括共表达数据和功能注释结果。
4. **构建调控网络:** 它运行名为 `lncRNA_mRNA_network.pl` 的 Perl 脚本以构建 lncRNA 和 mRNA 的调控网络。该脚本可能使用共表达数据和功能信息来推断 lncRNA 和 mRNA 之间的相互作用。
5. **可视化网络:** 它使用网络可视化工具，例如 Cytoscape 或 Gephi，以可视化构建的调控网络。

**部分 8：构建 lncRNA-miRNA 调控网络**

此部分构建 lncRNA-miRNA 调控网络并将结果保存到 `Sup6_lncRNA_miRNA_network` 子目录中。步骤类似于第 7 节，但它们侧重于 lncRNA 和 miRNA 之间的相互作用，而不是 lncRNA 和 mRNA。

**部分 9：构建 lncRNA-circRNA 调控网络**

此部分构建 lncRNA-circRNA 调控网络并将结果保存到 `Sup7_lncRNA_circRNA_network` 子目录中。步骤类似于第 7 节，但它们侧重于 lncRNA 和 circRNA 之间的相互作用，而不是 lncRNA 和 mRNA 或 miRNA。

### `as_suva`

分析 RNA-Seq 数据中的可变剪接。以下是脚本功能的细分：

**1. 配置和输入参数：**

- 脚本首先读取命令行参数和配置文件（`suva.config`）。
- 配置文件定义了分析的各种参数，包括：
  - 样本名称及其 BAM 文件的路径。
  - 参考基因组注释文件的地址。
  - 所需的分析选项，例如 p 值和差异剪接阈值。
  - 是否使用 SGE 进行并行执行。

**2. 预处理和 SJ 准备：Splice Junction analysis**

- 脚本通过以下方式准备分析数据：
  - 将连接文件（通常来自 STAR 或 TopHat2）转换为与 SUVA 兼容的格式。
  - 如果分析环状 RNA（circRNA），它可能会纳入 circRNA 连接信息。
  - 根据最小支持读取过滤连接。
  - 生成包含拼接位点周围边界的文件。
  - 可选地，使用提供的 BAM 文件计算支持每个拼接位点的读取数（如果仅分析连接文件，可以跳过此步骤）。

**3. AS 事件检测：**Alternative Splicing analysis

- 脚本利用工具（`detectASevents.sh`）从提供的基因注释和处理过的拼接位点数据中识别替代剪接（AS）事件。

**4. NIR 分析（非保留内含子）：**Non-Intron Retained analysis

- 此部分侧重于分析非保留内含子（NIR）事件，这些剪接事件不涉及内含子。
- 它包括：
  - 对类似的拼接连接进行聚类。
  - 计算每个样本支持每个连接簇的读取数比率。
  - 可选地，如果提供比较配置，则在样本组之间执行差异剪接分析。

**5. ALL 分析（组合）：**

- 此部分可能会组合来自 AS 事件检测和 NIR 分析的结果（如果两者都已执行）。

**6. 脚本执行和输出：**

- 脚本生成各种输出文件，包含以下结果：
  - 检测到的 AS 事件。
  - NIR 分析的连接簇信息和读取计数。
  - 差异剪接分析结果（如果执行）。
- 最后，脚本创建 shell 命令以按指定顺序运行分析步骤。可以使用 `sh` 执行这些命令以执行整个分析管道。

**分析 RNA-Seq 数据中的替代剪接事件和非保留内含子剪接的综合工具。**
