1. # miRNA 抑制靶基因表达的机制：动物与植物比较

   ## 哺乳动物（人类）miRNA 抑制机制

   在哺乳动物中，miRNA 通常通过与靶 mRNA 3′UTR 的部分互补结合，招募 RNA 诱导沉默复合体（RISC），从而抑制基因表达。主要的两种效应是：① **靶 mRNA 降解**，即通过诱导 mRNA 去腺苷酸化（deadenylation）和脱帽（decapping）加速 mRNA 降解 [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=poly(A), Challenging this view are results)；② **翻译抑制**，即阻断 mRNA 的翻译起始或延伸过程，使蛋白产量降低 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/14744438/#:~:text=MicroRNAs ,coding genes)。Bartel 等指出，当 miRNA 与靶 mRNA 高度互补时，会发生 Argonaute 介导的 mRNA 切割（这在植物中占优势）[pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=patterns1 %2C 23,pairing required for cleavage 23) [frontiersin.org](https://www.frontiersin.org/journals/plant-science/articles/10.3389/fpls.2022.824240/full#:~:text=highly complementary to its target,2008)；而在人类等脊椎动物中，大多数 miRNA 与靶 mRNA 仅部分配对，因此主要通过 mRNA 去腺苷酸化/降解来实现抑制 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/14744438/#:~:text=MicroRNAs ,coding genes) [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=poly(A), Challenging this view are results)。总的来说，动物 miRNA 沉默往往是不可逆的 mRNA 稳定性下降为主，翻译抑制则作为可逆的调节手段。

   + **高通量定量分析结果**：Guo 等（2010）利用 HeLa 细胞和小鼠细胞的翻译组测序（Ribo-seq）和转录组测序分析发现，miRNA 导致的蛋白产量降低中 ≥84%归因于靶 mRNA 水平的降低 [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=contributions of these two outcomes,reason for reduced protein output)。Eichhorn 等（2014）在人源 U2OS 细胞中也通过 Ribo-seq 测定，发现不同 miRNA 作用下约 66%–90%的抑制可归因于 mRNA 降解 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/25263593/#:~:text=MicroRNAs ,ensues%2C the effect of mRNA)。这些研究均使用 RNA 测序和核糖体足迹测序等高通量手段对比 miRNA 处理前后的 mRNA 和多肽水平，从而量化两种机制的贡献 [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=contributions of these two outcomes,reason for reduced protein output) [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/25263593/#:~:text=MicroRNAs ,ensues%2C the effect of mRNA)。
   + **翻译抑制的作用**：尽管 mRNA 降解占主导，但翻译抑制仍不可忽视。Freimer 等（2018）通过敲除小鼠胚胎干细胞中的翻译抑制因子 DDX6 发现，失去 DDX6 可使 miRNA 靶标的 **翻译水平显著上升** 而 mRNA 稳定性基本不变，表明 miRNA 对翻译的抑制可独立于 mRNA 降解发生 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/30044225/#:~:text=upregulated translation of microRNA targets%2C,downstream consequences of microRNA loss)。另有研究通过单分子和功能分析发现，miRNA 可以 **暂时减慢核糖体延伸速率** 以促进蛋白折叠，但对蛋白最终产量影响甚微 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/37492926/#:~:text=their low suppressive efficiency%2C it,and miRNA binding sites to)，这意味着 miRNA 的翻译调控作用主要用于精细调节而非大量抑制蛋白生成。
   + **研究方法**：以上结论依赖于多种实验技术。**核糖体足迹测序（Ribo-seq）** 可以直接测量翻译中 mRNA 的核糖体占用量，为翻译效率提供定量数据 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/25263593/#:~:text=MicroRNAs ,ensues%2C the effect of mRNA) [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=Ribosome profiling%2C a method that,molecular consequences of miRNA repression)；**RNA 测序**（总 RNA 或 mRNA 测序）用于评估 miRNA 对 mRNA 丰度的影响；**蛋白质组学**（如 SILAC）可测定 miRNA 对蛋白产量的终端效应。**CLIP 技术**（如 Ago HITS-CLIP/PAR-CLIP）可鉴定 miRNA 与靶 mRNA 的结合位点，但不直接区分降解和翻译抑制。综合这些方法的结果一致表明，在人类和其他哺乳动物细胞中，miRNA 抑制主要表现为 mRNA 降解 [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=contributions of these two outcomes,reason for reduced protein output) [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/25263593/#:~:text=MicroRNAs ,ensues%2C the effect of mRNA)。

   ## 植物 miRNA 抑制机制

   植物 miRNA 与靶 mRNA 往往具有高互补度，因此 **靶 mRNA 切割** 是一条主要的抑制途径。AGO 蛋白可以在配对完美或接近完美的靶位点处直接切割 mRNA，从而迅速降解靶 RNA [frontiersin.org](https://www.frontiersin.org/journals/plant-science/articles/10.3389/fpls.2022.824240/full#:~:text=highly complementary to its target,2008)。例如，一般认为植物 miRNA 的“主效应”是通过这种切割来消除靶 RNA [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=patterns1 %2C 23,pairing required for cleavage 23) [frontiersin.org](https://www.frontiersin.org/journals/plant-science/articles/10.3389/fpls.2022.824240/full#:~:text=highly complementary to its target,2008)。然而，研究发现植物 miRNA 也经常介导 **翻译抑制**。Brodersen 等（2008）在拟南芥中通过突变体分析发现，miRNA 介导的沉默存在广泛的翻译抑制成分，其机制与脱帽降解可分离 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/18483398/#:~:text=High complementarity between plant microRNAs,as recently suggested from animal)。最近的全基因组分析进一步揭示了植物 miRNA 调控的复杂性：在玉米中，Wang 等的研究表明 miRNA 靶标 mRNA 在细胞中的轻多核糖体（低翻译活性）区相对富集，表明 **miRNA 抑制主要通过抑制翻译**（减少 mRNA 参与重多核糖体）[pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/38132362/#:~:text=miRNAs moderately inhibit the translation,tend to target mRNAs with)。Yang 等（2024）在玉米 DCL1 突变株中进行的 Ribo-seq 和 RNA-seq 分析发现，翻译抑制对大部分 miRNA 靶基因都有显著贡献，约 1/3 的靶基因主要通过翻译抑制下调 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/38963711/#:~:text=insight into the repression mechanism,independent mechanisms)。Ma 等（2021）的研究也指出，许多植物 miRNA 靶标的表达调控更多地依赖于翻译抑制以缓冲表达噪声，而不仅仅依赖于切割 [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC8092011/#:~:text=Instead%2C the data suggest that,those targets directing cell fate) [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC8092011/#:~:text=with earlier proposals that few,2008)。这些结果表明，**植物 miRNA 抑制机制是切割与抑制并用**：靶 mRNA 切割提供了基础性的降解途径 [frontiersin.org](https://www.frontiersin.org/journals/plant-science/articles/10.3389/fpls.2022.824240/full#:~:text=highly complementary to its target,2008)，而翻译抑制则在复杂表达环境下提供了灵活的调控手段 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/18483398/#:~:text=High complementarity between plant microRNAs,as recently suggested from animal) [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/38963711/#:~:text=insight into the repression mechanism,independent mechanisms)。

   ## 动物与植物机制比较

   + **共同点**：动物和植物 miRNA 都借助 Argonaute/RISC 复合体作用于靶 RNA，并可招募 mRNA 去腺苷酸化及去帽复合体加速 mRNA 降解 [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=poly(A), Challenging this view are results)[pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/18483398/#:~:text=mediated by small interfering RNA,miRNAs%2C which suggests that the)。两者中，CCR4-NOT 和 DCP1/2 等去腺苷酸化/去帽组分普遍参与 miRNA 作用，表明基本的沉默机制具有进化保守性 [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=poly(A), Challenging this view are results)[pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/18483398/#:~:text=mediated by small interfering RNA,miRNAs%2C which suggests that the)。
   + **不同点**：植物 miRNA 与靶 RNA 往往配对几乎完全，因此 **靶 mRNA 切割**（滑脱性剪切）较多见，而动物 miRNA 多数在 3′UTR 与靶位点仅种子区配对，导致靶 mRNA 先去腺苷酸化后降解 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/14744438/#:~:text=MicroRNAs ,coding genes) [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=poly(A), Challenging this view are results)。在量化效果上，哺乳动物中大多数 miRNA 效应最终来自 mRNA 水平的降低 [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=contributions of these two outcomes,reason for reduced protein output) [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/25263593/#:~:text=MicroRNAs ,ensues%2C the effect of mRNA)；而植物中除切割降解外，翻译抑制对基因表达的贡献也相对较大 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/18483398/#:~:text=High complementarity between plant microRNAs,as recently suggested from animal) [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/38963711/#:~:text=insight into the repression mechanism,independent mechanisms)。此外，翻译抑制在动物中常被认为是 miRNA 作用的早期可逆效应 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/25263593/#:~:text=determine the relative dynamics of,mediated)，而在植物中则更多作为切割机制的补充来细调基因表达。[pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=poly(A), Challenging this view are results)[pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/37492926/#:~:text=their low suppressive efficiency%2C it,and miRNA binding sites to)
   + **案例**：如前所述，Sako 等人通过在哺乳动物细胞中研究 miRNA 靶在 CDS 结合位点的效应，发现 miRNA 可以短暂减慢核糖体速度以辅助蛋白折叠，但蛋白产量基本不变 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/37492926/#:~:text=their low suppressive efficiency%2C it,and miRNA binding sites to)；Brodersen 等则在植物中用突变体证明，miRNA 的翻译抑制与切割是并存的机制 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/18483398/#:~:text=High complementarity between plant microRNAs,as recently suggested from animal)。这些研究表明，尽管细节不同，两种生物类群利用 miRNA 进行基因抑制时，共享核心的 RISC 介导沉默策略，但在互补度和抑制方式的权重上存在差异。

   ## 结论

   综上所述，哺乳动物（尤其人类）miRNA 主要通过促进靶 mRNA 降解来实现基因表达抑制，多项大规模研究表明在稳态下约 70%–90%以上的 miRNA 抑制效应归因于 mRNA 水平下降 [pmc.ncbi.nlm.nih.gov](https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/#:~:text=contributions of these two outcomes,reason for reduced protein output) [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/25263593/#:~:text=MicroRNAs ,ensues%2C the effect of mRNA)；翻译抑制则通常仅起次要调节作用，但在特定情境下（如快速反应或蛋白质折叠）也发挥重要作用 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/30044225/#:~:text=upregulated translation of microRNA targets%2C,downstream consequences of microRNA loss) [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/37492926/#:~:text=their low suppressive efficiency%2C it,and miRNA binding sites to)。植物 miRNA 由于高互补度，大量依赖直接切割机制 [frontiersin.org](https://www.frontiersin.org/journals/plant-science/articles/10.3389/fpls.2022.824240/full#:~:text=highly complementary to its target,2008)，但翻译抑制在调控网络中也占有显著地位，尤其用于微调表达和缓冲噪声 [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/18483398/#:~:text=High complementarity between plant microRNAs,as recently suggested from animal) [pubmed.ncbi.nlm.nih.gov](https://pubmed.ncbi.nlm.nih.gov/38963711/#:~:text=insight into the repression mechanism,independent mechanisms)。现代高通量技术（如 Ribo-seq、degradome 测序等）的应用，使我们能够定量区分这两种机制的贡献，并揭示不同生物体系中的差异，为深入理解 miRNA 功能提供了重要参考。

    

   **参考文献：**

   1. Bartel DP. *MicroRNAs: genomics, biogenesis, mechanism, and function.* Cell. 2004; 116(2): 281–297.
   2. Guo H, Ingolia NT, Weissman JS, Bartel DP. *Mammalian microRNAs predominantly act to decrease target mRNA levels.* Nature. 2010; 466(7308): 835–840.
   3. Eichhorn SW, Guo H, McGeary SE, Rodriguez-Mias RA, Shin C, Bartel DP. *mRNA destabilization is the dominant effect of mammalian microRNAs by the time substantial repression ensues.* Mol. Cell. 2014; 56(1): 104–115.
   4. Freimer JW, Hu TJ, Blelloch R. *Decoupling the impact of microRNAs on translational repression versus RNA degradation in embryonic stem cells.* eLife. 2018; 7: e38014.
   5. Wang T, Tian S, Tikhonova EB, Karamyshev AL, Wang JJ, Zhang F, Wang DG. *The Enrichment of miRNA-Targeted mRNAs in Translationally Less Active over More Active Polysomes.* Biology (Basel). 2023; 12(12): 1536.
   6. Sako H, Youssef M, Elisseeva O, et al. *microRNAs slow translating ribosomes to prevent protein misfolding in eukaryotes.* EMBO J. 2023; 42(18): e112469.
   7. Brodersen P, Sakvarelidze-Achard L, Bruun-Rasmussen M, et al. *Widespread translational inhibition by plant miRNAs and siRNAs.* Science. 2008; 320(5880): 1185–1190.
   8. Yang H, Thompson B. *Widespread changes to the translational landscape in a maize microRNA biogenesis mutant.* Plant J. 2024; 119(4): 1986–2000.
   9. Ma X, Denyer T, Javelle M, et al. *Genome-wide analysis of plant miRNA action clarifies levels of regulatory dynamics across developmental contexts.* Genome Res. 2021; 31(5): 811–822.

   引用

   

   Mammalian microRNAs predominantly act to decrease target mRNA levels - PMC

   https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/

   

   MicroRNAs: genomics, biogenesis, mechanism, and function - PubMed

   https://pubmed.ncbi.nlm.nih.gov/14744438/

   

   Mammalian microRNAs predominantly act to decrease target mRNA levels - PMC

   https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/

   

   Frontiers | microRNAs and Their Roles in Plant Development

   https://www.frontiersin.org/journals/plant-science/articles/10.3389/fpls.2022.824240/full

   

   Mammalian microRNAs predominantly act to decrease target mRNA levels - PMC

   https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/

   

   mRNA destabilization is the dominant effect of mammalian microRNAs by the time substantial repression ensues - PubMed

   https://pubmed.ncbi.nlm.nih.gov/25263593/

   

   Decoupling the impact of microRNAs on translational repression versus RNA degradation in embryonic stem cells - PubMed

   https://pubmed.ncbi.nlm.nih.gov/30044225/

   

   microRNAs slow translating ribosomes to prevent protein misfolding in eukaryotes - PubMed

   https://pubmed.ncbi.nlm.nih.gov/37492926/

   

   Mammalian microRNAs predominantly act to decrease target mRNA levels - PMC

   https://pmc.ncbi.nlm.nih.gov/articles/PMC2990499/

   

   Widespread translational inhibition by plant miRNAs and siRNAs - PubMed

   https://pubmed.ncbi.nlm.nih.gov/18483398/

   

   The Enrichment of miRNA-Targeted mRNAs in Translationally Less Active over More Active Polysomes - PubMed

   https://pubmed.ncbi.nlm.nih.gov/38132362/

   

   Widespread changes to the translational landscape in a maize microRNA biogenesis mutant - PubMed

   https://pubmed.ncbi.nlm.nih.gov/38963711/

   

   Genome-wide analysis of plant miRNA action clarifies levels of regulatory dynamics across developmental contexts - PMC

   https://pmc.ncbi.nlm.nih.gov/articles/PMC8092011/

   

   Genome-wide analysis of plant miRNA action clarifies levels of regulatory dynamics across developmental contexts - PMC

   https://pmc.ncbi.nlm.nih.gov/articles/PMC8092011/

   

   Widespread translational inhibition by plant miRNAs and siRNAs - PubMed

   https://pubmed.ncbi.nlm.nih.gov/18483398/

   

   mRNA destabilization is the dominant effect of mammalian microRNAs by the time substantial repression ensues - PubMed

   https://pubmed.ncbi.nlm.nih.gov/25263593/

   全部来源

   pmc.ncbi.nlm.nih

   

   