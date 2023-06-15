









<center><font face = "黑体" size = 7><b>ChIP-Seq 数据分析</b></font></center>





<center>生信 2001 张子栋 2020317210101</center>

















<div STYLE="page-break-after: always;"></div>

[toc]

<div STYLE="page-break-after: always;"></div>

## 数据来源

### PubMed 数据库中搜索数据文献

#### 选定研究物种

​	选定研究物种为线虫（$nematode,\ Caenorhabditis\ Elegans$）。

#### 在 PubMed 中检索文献

​	在 [PubMed (nih.gov)](https://pubmed.ncbi.nlm.nih.gov/) 中搜索关键字 `Caenorhabditis Elegans ChIP seq`. 并选定文献为 [The hypoxia response pathway promotes PEP carboxykinase and gluconeogenesis in C. elegans - PubMed (nih.gov)](https://pubmed.ncbi.nlm.nih.gov/36257965/)（Nat Commun. 2022 Oct 18;13(1):6168. DOI: [10.1038/s41467-022-33849-x](https://doi.org/10.1038/s41467-022-33849-x)）. 

​	这篇文章研究的内容是在线虫中，缺氧应答通路如何通过激活 HIF-1 转录因子来调节 PEP 羧激酶和糖异生的基因表达和代谢流动，从而提高对氧化应激和缺氧应激的抵抗力。PEP 羧激酶是糖异生过程中的限速酶，可以将草酰乙酸转化为磷酸烯醇式丙酮酸。

​	作者利用基因组编辑、转录组分析、代谢组分析和行为实验等方法来揭示 HIF-1 直接或间接调控的上百个基因的功能。这篇文章使用 ChIP-Seq 的目的是为了发现 HIF-1 直接调控的基因，并分析它们在缺氧应答通路中的功能。



### 数据获取

​	文章中的 ChIP-seq 数据上传至 NIH/NCBI 数据库，登录号为 [GSE173333](https://www.ncbi.nlm.nih.gov/geo/query/acc.cgi?acc=GSE173333)。SRA 数据库对应登录号为 [SRP316378 - SRA - NCBI (nih.gov)](https://www.ncbi.nlm.nih.gov/sra?term=SRP316378)，最终选择数据集 `SRR14325856` 和 `SRR14325854` 作为研究数据。

## 实验过程

```R

```

