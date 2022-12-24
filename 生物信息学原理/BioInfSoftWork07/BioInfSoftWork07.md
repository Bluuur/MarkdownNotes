# 表达谱基本分析及查询

> 日期：2022-12-7
>
> 实验者：生信 2001 张子栋
>
> [MarkdownNotes/软件第7次作业.md at main · Bluuur/MarkdownNotes (github.com)](https://github.com/Bluuur/MarkdownNotes/blob/main/生物信息学原理/BioInfSoftWork07)
> [生物信息学原理/软件第7次作业.md · blur/MarkdownNotes - 码云 - 开源中国 (gitee.com)](https://gitee.com/bluur/MarkdownNotes/blob/main/生物信息学原理/BioInfSoftWork07)

## 实验目的

1. 熟悉表达谱数据库的查询和数据下载
2. 熟悉芯片表达谱数据分析的一般流程
3. 掌握表达差异分析和基因富集分析的方法
4. 了解常用的数据可视化方法

## 实验内容

1. GEO 数据库查询和数据下载
2. 使用 R 包 `limma` 进行差异表达分析
3. 使用 R 包 `clusterProfiler` 进行基因富集分析
4. 使用 `gplots`, `ggpubr`, `pheatmap` 等 R 包对差异表达和富集分析进行结果可视化

## 实验步骤

以 `GSE46456` 为例，该实验使用的芯片平台为 GPL198，拟南芥样本基因型包括：野生型、BRI1 单突变型、GUL2 单突变型、BRI 和 GUL 双突变型，每种基因型设置**三种重复**。研究三种突变型样本与 WT 野生型样本哪些基因存在显著的差异表达。根据所提供的演示代码和相关文件，请完成以下任务：

1. 对获得的芯片数据进行数据标准化、探针过滤、limma 差异分析，写明每一步骤的代码、目的以及中间结果。

加载 R 包


```R
library(cluster)
library(kohonen)
library(gplots)
library(RankProd)
library(affy)
library(affyPLM)
library(RColorBrewer)
library(limma)
library(pheatmap)
library(Mfuzz)
library(clusterProfiler)
library(enrichplot)
library(ggplot2)
library("org.At.tair.db", character.only = TRUE)
```

> 删除了导包的输出


读取数据并标准化


```R
# 生成文件列表以便批量导入文件
cels <- list.files("C:\\Users\\ZidongZh\\Documents\\BioInf\\GSE46456_RAW", pattern = "*.gz", full.names = TRUE)
# 使用 Affy 包中 ReadAffy 函数，读取 CEL 文件，将其处理成 AffyBatch 对象
celfiles <- ReadAffy(filenames = cels)
# 将 AffyBatch 对象转换为 ExpressionSet 对象，对数据进行标准化
celfiles.rma <- rma(celfiles)
cols <- brewer.pal(8, "Set1")
```

    Warning message:
    "replacing previous import 'AnnotationDbi::tail' by 'utils::tail' when loading 'ath1121501cdf'"
    Warning message:
    "replacing previous import 'AnnotationDbi::head' by 'utils::head' when loading 'ath1121501cdf'"

    Background correcting
    Normalizing
    Calculating Expression



```R
setwd("C:\\Users\\ZidongZh\\Documents\\BioInf\\GSE46456_RAW")
# 未标准化的数据
boxplot(celfiles, col=cols)
# 标准化的数据
boxplot(celfiles.rma, col=cols)
```

密度和对数强度直方图


```R
# 未标准化的数据
hist(celfiles, col = cols)
# 标准化的数据
hist(celfiles.rma, col = cols)
```


​    
![png](output_8_0.png)
​    


![png](output_8_1.png)
    


探针过滤


```R
# list 中的 eset 为过滤后的 ExpressionSet, filter.log 为每一步过滤到多少探针的记录。
library(genefilter)
celfiles.filtered <- nsFilter(celfiles.rma, require.entrez=FALSE, remove.dupEntrez=FALSE)
```


```R
celfiles.filtered$filter.log
celfiles.filtered$eset
```


<dl>
	<dt>$numLowVar</dt>
		<dd>11373</dd>
	<dt>$feature.exclude</dt>
		<dd>64</dd>
</dl>




    ExpressionSet (storageMode: lockedEnvironment)
    assayData: 11373 features, 12 samples 
      element names: exprs 
    protocolData
      sampleNames: GSM1130596_Ws-2-1.CEL.gz GSM1130597_Ws-2-2.CEL.gz ...
        GSM1130607_gul2-1bri1-5-3.CEL.gz (12 total)
      varLabels: ScanDate
      varMetadata: labelDescription
    phenoData
      sampleNames: GSM1130596_Ws-2-1.CEL.gz GSM1130597_Ws-2-2.CEL.gz ...
        GSM1130607_gul2-1bri1-5-3.CEL.gz (12 total)
      varLabels: sample
      varMetadata: labelDescription
    featureData: none
    experimentData: use 'experimentData(object)'
    Annotation: ath1121501 


获得表达量矩阵


```R
eset <- exprs(celfiles.filtered$eset)
head(eset)
```


<table class="dataframe">
<caption>A matrix: 6 × 12 of type dbl</caption>
<thead>
	<tr><th></th><th scope=col>GSM1130596_Ws-2-1.CEL.gz</th><th scope=col>GSM1130597_Ws-2-2.CEL.gz</th><th scope=col>GSM1130598_Ws-2-3.CEL.gz</th><th scope=col>GSM1130599_bri1-5-1.CEL.gz</th><th scope=col>GSM1130600_bri1-5-2.CEL.gz</th><th scope=col>GSM1130601_bri1-5-3.CEL.gz</th><th scope=col>GSM1130602_gul2-1-1.CEL.gz</th><th scope=col>GSM1130603_gul2-1-2.CEL.gz</th><th scope=col>GSM1130604_gul2-1-3.CEL.gz</th><th scope=col>GSM1130605_gul2-1bri1-5-1.CEL.gz</th><th scope=col>GSM1130606_gul2-1bri1-5-2.CEL.gz</th><th scope=col>GSM1130607_gul2-1bri1-5-3.CEL.gz</th></tr>
</thead>
<tbody>
	<tr><th scope=row>244901_at</th><td>5.224648</td><td>5.428151</td><td>5.546510</td><td>4.683135</td><td>4.753393</td><td>4.463033</td><td>6.087000</td><td>5.868863</td><td>5.386404</td><td>5.490967</td><td>5.671008</td><td>5.305481</td></tr>
	<tr><th scope=row>244902_at</th><td>5.149407</td><td>5.187442</td><td>4.886097</td><td>4.672779</td><td>4.805556</td><td>4.794880</td><td>5.527636</td><td>5.592619</td><td>5.927320</td><td>5.302640</td><td>5.524203</td><td>5.494279</td></tr>
	<tr><th scope=row>244903_at</th><td>5.592680</td><td>5.436074</td><td>5.638751</td><td>5.562216</td><td>5.622267</td><td>5.224591</td><td>6.605356</td><td>6.062327</td><td>5.597098</td><td>6.694592</td><td>6.661931</td><td>6.565135</td></tr>
	<tr><th scope=row>244904_at</th><td>4.985820</td><td>5.072172</td><td>5.262937</td><td>5.016912</td><td>5.446725</td><td>5.482161</td><td>5.366306</td><td>5.495490</td><td>5.026725</td><td>5.257816</td><td>5.356717</td><td>5.228070</td></tr>
	<tr><th scope=row>244906_at</th><td>5.727308</td><td>5.889640</td><td>5.323069</td><td>5.381804</td><td>5.609199</td><td>5.514687</td><td>6.348055</td><td>6.080350</td><td>6.218219</td><td>6.613726</td><td>6.537190</td><td>6.425924</td></tr>
	<tr><th scope=row>244912_at</th><td>6.465566</td><td>6.586064</td><td>6.814510</td><td>7.653073</td><td>7.871753</td><td>8.260488</td><td>8.052288</td><td>7.970124</td><td>7.871955</td><td>7.620157</td><td>7.387385</td><td>7.555005</td></tr>
</tbody>
</table>



增加探针对应的基因信息


```R
araAnno <- read.delim("C:\\Users\\ZidongZh\\Documents\\BioInf\\affy_ATH1_array_elements-2010-12-20.txt")
head(araAnno)
head(eset)
ids <- match(rownames(eset), araAnno$array_element_name)
length(araAnno$array_element_name)
length(ids)
# ids
head(eset)
rownames(eset) <- araAnno$locus[ids]
colnames(eset) <- sub(".CEL.gz", "", colnames(eset))
head(eset)
```


<table class="dataframe">
<caption>A data.frame: 6 × 9</caption>
<thead>
	<tr><th></th><th scope=col>array_element_name</th><th scope=col>array_element_type</th><th scope=col>organism</th><th scope=col>is_control</th><th scope=col>locus</th><th scope=col>description</th><th scope=col>chromosome</th><th scope=col>start</th><th scope=col>stop</th></tr>
	<tr><th></th><th scope=col>&lt;chr&gt;</th><th scope=col>&lt;chr&gt;</th><th scope=col>&lt;chr&gt;</th><th scope=col>&lt;chr&gt;</th><th scope=col>&lt;chr&gt;</th><th scope=col>&lt;chr&gt;</th><th scope=col>&lt;chr&gt;</th><th scope=col>&lt;chr&gt;</th><th scope=col>&lt;chr&gt;</th></tr>
</thead>
<tbody>
	<tr><th scope=row>1</th><td>244901_at</td><td>oligonucleotide</td><td>Arabidopsis thaliana</td><td>no</td><td>ATMG00640</td><td>hydrogen ion transporting ATP synthases, rotational mechanism;zinc ion binding</td><td>M</td><td>188160</td><td>188619</td></tr>
	<tr><th scope=row>2</th><td>244902_at</td><td>oligonucleotide</td><td>Arabidopsis thaliana</td><td>no</td><td>ATMG00650</td><td>NADH dehydrogenase subunit 4L                                                 </td><td>M</td><td>188954</td><td>189182</td></tr>
	<tr><th scope=row>3</th><td>244903_at</td><td>oligonucleotide</td><td>Arabidopsis thaliana</td><td>no</td><td>ATMG00660</td><td>hypothetical protein                                                          </td><td>M</td><td>190106</td><td>190540</td></tr>
	<tr><th scope=row>4</th><td>244904_at</td><td>oligonucleotide</td><td>Arabidopsis thaliana</td><td>no</td><td>ATMG00670</td><td>hypothetical protein                                                          </td><td>M</td><td>191055</td><td>191627</td></tr>
	<tr><th scope=row>5</th><td>244905_at</td><td>oligonucleotide</td><td>Arabidopsis thaliana</td><td>no</td><td>ATMG00680</td><td>hypothetical protein                                                          </td><td>M</td><td>201768</td><td>202096</td></tr>
	<tr><th scope=row>6</th><td>244906_at</td><td>oligonucleotide</td><td>Arabidopsis thaliana</td><td>no</td><td>ATMG00690</td><td>hypothetical protein                                                          </td><td>M</td><td>203634</td><td>204043</td></tr>
</tbody>
</table>




<table class="dataframe">
<caption>A matrix: 6 × 12 of type dbl</caption>
<thead>
	<tr><th></th><th scope=col>GSM1130596_Ws-2-1.CEL.gz</th><th scope=col>GSM1130597_Ws-2-2.CEL.gz</th><th scope=col>GSM1130598_Ws-2-3.CEL.gz</th><th scope=col>GSM1130599_bri1-5-1.CEL.gz</th><th scope=col>GSM1130600_bri1-5-2.CEL.gz</th><th scope=col>GSM1130601_bri1-5-3.CEL.gz</th><th scope=col>GSM1130602_gul2-1-1.CEL.gz</th><th scope=col>GSM1130603_gul2-1-2.CEL.gz</th><th scope=col>GSM1130604_gul2-1-3.CEL.gz</th><th scope=col>GSM1130605_gul2-1bri1-5-1.CEL.gz</th><th scope=col>GSM1130606_gul2-1bri1-5-2.CEL.gz</th><th scope=col>GSM1130607_gul2-1bri1-5-3.CEL.gz</th></tr>
</thead>
<tbody>
	<tr><th scope=row>244901_at</th><td>5.224648</td><td>5.428151</td><td>5.546510</td><td>4.683135</td><td>4.753393</td><td>4.463033</td><td>6.087000</td><td>5.868863</td><td>5.386404</td><td>5.490967</td><td>5.671008</td><td>5.305481</td></tr>
	<tr><th scope=row>244902_at</th><td>5.149407</td><td>5.187442</td><td>4.886097</td><td>4.672779</td><td>4.805556</td><td>4.794880</td><td>5.527636</td><td>5.592619</td><td>5.927320</td><td>5.302640</td><td>5.524203</td><td>5.494279</td></tr>
	<tr><th scope=row>244903_at</th><td>5.592680</td><td>5.436074</td><td>5.638751</td><td>5.562216</td><td>5.622267</td><td>5.224591</td><td>6.605356</td><td>6.062327</td><td>5.597098</td><td>6.694592</td><td>6.661931</td><td>6.565135</td></tr>
	<tr><th scope=row>244904_at</th><td>4.985820</td><td>5.072172</td><td>5.262937</td><td>5.016912</td><td>5.446725</td><td>5.482161</td><td>5.366306</td><td>5.495490</td><td>5.026725</td><td>5.257816</td><td>5.356717</td><td>5.228070</td></tr>
	<tr><th scope=row>244906_at</th><td>5.727308</td><td>5.889640</td><td>5.323069</td><td>5.381804</td><td>5.609199</td><td>5.514687</td><td>6.348055</td><td>6.080350</td><td>6.218219</td><td>6.613726</td><td>6.537190</td><td>6.425924</td></tr>
	<tr><th scope=row>244912_at</th><td>6.465566</td><td>6.586064</td><td>6.814510</td><td>7.653073</td><td>7.871753</td><td>8.260488</td><td>8.052288</td><td>7.970124</td><td>7.871955</td><td>7.620157</td><td>7.387385</td><td>7.555005</td></tr>
</tbody>
</table>




22810



11373



<table class="dataframe">
<caption>A matrix: 6 × 12 of type dbl</caption>
<thead>
	<tr><th></th><th scope=col>GSM1130596_Ws-2-1.CEL.gz</th><th scope=col>GSM1130597_Ws-2-2.CEL.gz</th><th scope=col>GSM1130598_Ws-2-3.CEL.gz</th><th scope=col>GSM1130599_bri1-5-1.CEL.gz</th><th scope=col>GSM1130600_bri1-5-2.CEL.gz</th><th scope=col>GSM1130601_bri1-5-3.CEL.gz</th><th scope=col>GSM1130602_gul2-1-1.CEL.gz</th><th scope=col>GSM1130603_gul2-1-2.CEL.gz</th><th scope=col>GSM1130604_gul2-1-3.CEL.gz</th><th scope=col>GSM1130605_gul2-1bri1-5-1.CEL.gz</th><th scope=col>GSM1130606_gul2-1bri1-5-2.CEL.gz</th><th scope=col>GSM1130607_gul2-1bri1-5-3.CEL.gz</th></tr>
</thead>
<tbody>
	<tr><th scope=row>244901_at</th><td>5.224648</td><td>5.428151</td><td>5.546510</td><td>4.683135</td><td>4.753393</td><td>4.463033</td><td>6.087000</td><td>5.868863</td><td>5.386404</td><td>5.490967</td><td>5.671008</td><td>5.305481</td></tr>
	<tr><th scope=row>244902_at</th><td>5.149407</td><td>5.187442</td><td>4.886097</td><td>4.672779</td><td>4.805556</td><td>4.794880</td><td>5.527636</td><td>5.592619</td><td>5.927320</td><td>5.302640</td><td>5.524203</td><td>5.494279</td></tr>
	<tr><th scope=row>244903_at</th><td>5.592680</td><td>5.436074</td><td>5.638751</td><td>5.562216</td><td>5.622267</td><td>5.224591</td><td>6.605356</td><td>6.062327</td><td>5.597098</td><td>6.694592</td><td>6.661931</td><td>6.565135</td></tr>
	<tr><th scope=row>244904_at</th><td>4.985820</td><td>5.072172</td><td>5.262937</td><td>5.016912</td><td>5.446725</td><td>5.482161</td><td>5.366306</td><td>5.495490</td><td>5.026725</td><td>5.257816</td><td>5.356717</td><td>5.228070</td></tr>
	<tr><th scope=row>244906_at</th><td>5.727308</td><td>5.889640</td><td>5.323069</td><td>5.381804</td><td>5.609199</td><td>5.514687</td><td>6.348055</td><td>6.080350</td><td>6.218219</td><td>6.613726</td><td>6.537190</td><td>6.425924</td></tr>
	<tr><th scope=row>244912_at</th><td>6.465566</td><td>6.586064</td><td>6.814510</td><td>7.653073</td><td>7.871753</td><td>8.260488</td><td>8.052288</td><td>7.970124</td><td>7.871955</td><td>7.620157</td><td>7.387385</td><td>7.555005</td></tr>
</tbody>
</table>




<table class="dataframe">
<caption>A matrix: 6 × 12 of type dbl</caption>
<thead>
	<tr><th></th><th scope=col>GSM1130596_Ws-2-1</th><th scope=col>GSM1130597_Ws-2-2</th><th scope=col>GSM1130598_Ws-2-3</th><th scope=col>GSM1130599_bri1-5-1</th><th scope=col>GSM1130600_bri1-5-2</th><th scope=col>GSM1130601_bri1-5-3</th><th scope=col>GSM1130602_gul2-1-1</th><th scope=col>GSM1130603_gul2-1-2</th><th scope=col>GSM1130604_gul2-1-3</th><th scope=col>GSM1130605_gul2-1bri1-5-1</th><th scope=col>GSM1130606_gul2-1bri1-5-2</th><th scope=col>GSM1130607_gul2-1bri1-5-3</th></tr>
</thead>
<tbody>
	<tr><th scope=row>ATMG00640</th><td>5.224648</td><td>5.428151</td><td>5.546510</td><td>4.683135</td><td>4.753393</td><td>4.463033</td><td>6.087000</td><td>5.868863</td><td>5.386404</td><td>5.490967</td><td>5.671008</td><td>5.305481</td></tr>
	<tr><th scope=row>ATMG00650</th><td>5.149407</td><td>5.187442</td><td>4.886097</td><td>4.672779</td><td>4.805556</td><td>4.794880</td><td>5.527636</td><td>5.592619</td><td>5.927320</td><td>5.302640</td><td>5.524203</td><td>5.494279</td></tr>
	<tr><th scope=row>ATMG00660</th><td>5.592680</td><td>5.436074</td><td>5.638751</td><td>5.562216</td><td>5.622267</td><td>5.224591</td><td>6.605356</td><td>6.062327</td><td>5.597098</td><td>6.694592</td><td>6.661931</td><td>6.565135</td></tr>
	<tr><th scope=row>ATMG00670</th><td>4.985820</td><td>5.072172</td><td>5.262937</td><td>5.016912</td><td>5.446725</td><td>5.482161</td><td>5.366306</td><td>5.495490</td><td>5.026725</td><td>5.257816</td><td>5.356717</td><td>5.228070</td></tr>
	<tr><th scope=row>ATMG00690</th><td>5.727308</td><td>5.889640</td><td>5.323069</td><td>5.381804</td><td>5.609199</td><td>5.514687</td><td>6.348055</td><td>6.080350</td><td>6.218219</td><td>6.613726</td><td>6.537190</td><td>6.425924</td></tr>
	<tr><th scope=row>AT2G07783;ATMG00830</th><td>6.465566</td><td>6.586064</td><td>6.814510</td><td>7.653073</td><td>7.871753</td><td>8.260488</td><td>8.052288</td><td>7.970124</td><td>7.871955</td><td>7.620157</td><td>7.387385</td><td>7.555005</td></tr>
</tbody>
</table>



3. 运用 `limma` 获得突变体和野生型的差异表达基因集，并阐述差异分析结果的各列含义。

分组矩阵


```R
group_list <- c(rep('Wild_type', 3),
                rep('bri1.5_mutant', 3),
                rep('gul2.1_mutant', 3),
                rep('gul2.1_bri1.5_mutant',3))
design <- model.matrix(~0+factor(group_list))
colnames(design) <- levels(factor(group_list))
rownames(design) <- colnames(eset)
design
```


<table class="dataframe">
<caption>A matrix: 12 × 4 of type dbl</caption>
<thead>
	<tr><th></th><th scope=col>bri1.5_mutant</th><th scope=col>gul2.1_bri1.5_mutant</th><th scope=col>gul2.1_mutant</th><th scope=col>Wild_type</th></tr>
</thead>
<tbody>
	<tr><th scope=row>GSM1130596_Ws-2-1</th><td>0</td><td>0</td><td>0</td><td>1</td></tr>
	<tr><th scope=row>GSM1130597_Ws-2-2</th><td>0</td><td>0</td><td>0</td><td>1</td></tr>
	<tr><th scope=row>GSM1130598_Ws-2-3</th><td>0</td><td>0</td><td>0</td><td>1</td></tr>
	<tr><th scope=row>GSM1130599_bri1-5-1</th><td>1</td><td>0</td><td>0</td><td>0</td></tr>
	<tr><th scope=row>GSM1130600_bri1-5-2</th><td>1</td><td>0</td><td>0</td><td>0</td></tr>
	<tr><th scope=row>GSM1130601_bri1-5-3</th><td>1</td><td>0</td><td>0</td><td>0</td></tr>
	<tr><th scope=row>GSM1130602_gul2-1-1</th><td>0</td><td>0</td><td>1</td><td>0</td></tr>
	<tr><th scope=row>GSM1130603_gul2-1-2</th><td>0</td><td>0</td><td>1</td><td>0</td></tr>
	<tr><th scope=row>GSM1130604_gul2-1-3</th><td>0</td><td>0</td><td>1</td><td>0</td></tr>
	<tr><th scope=row>GSM1130605_gul2-1bri1-5-1</th><td>0</td><td>1</td><td>0</td><td>0</td></tr>
	<tr><th scope=row>GSM1130606_gul2-1bri1-5-2</th><td>0</td><td>1</td><td>0</td><td>0</td></tr>
	<tr><th scope=row>GSM1130607_gul2-1bri1-5-3</th><td>0</td><td>1</td><td>0</td><td>0</td></tr>
</tbody>
</table>



构建对照矩阵


```R
contrast.matrix <- makeContrasts(bri1.5_mutant-Wild_type,
                                 gul2.1_mutant-Wild_type,
                                 gul2.1_bri1.5_mutant-Wild_type,
                                 levels = design)
contrast.matrix
```


<table class="dataframe">
<caption>A matrix: 4 × 3 of type dbl</caption>
<thead>
	<tr><th></th><th scope=col>bri1.5_mutant - Wild_type</th><th scope=col>gul2.1_mutant - Wild_type</th><th scope=col>gul2.1_bri1.5_mutant - Wild_type</th></tr>
</thead>
<tbody>
	<tr><th scope=row>bri1.5_mutant</th><td> 1</td><td> 0</td><td> 0</td></tr>
	<tr><th scope=row>gul2.1_bri1.5_mutant</th><td> 0</td><td> 0</td><td> 1</td></tr>
	<tr><th scope=row>gul2.1_mutant</th><td> 0</td><td> 1</td><td> 0</td></tr>
	<tr><th scope=row>Wild_type</th><td>-1</td><td>-1</td><td>-1</td></tr>
</tbody>
</table>



拟合 差值计算 检验


```R
# limma
# 线性模型拟合
fit1 <- lmFit(eset, design)
# 根据对比模型进行差值计算
fit2 <- contrasts.fit(fit1, contrast.matrix)
# 贝叶斯检验
fit2 <- eBayes(fit2)
```

输出差异表达基因


```R
# 利用 toptable 导出 DEG 结果
limma_results <- lapply(colnames(contrast.matrix),
                        function(x) {
                          topTable(fit2,
                                   coef     = x,
                                   adjust   = "fdr",
                                   sort.by  = "logFC",
                                   number   = Inf)
                        })
length(limma_results)
# 对导出的结果标记 title 信息
names(limma_results) <- colnames(contrast.matrix)
head(limma_results[[1]])
save(limma_results, file = "limma_compare_res.RData")
# 对每对比较的样本对 DEG 结果单独导出 DEG 信息 6
for (n in names(limma_results)) {
    write.table(limma_results[[n]],
                file        = sprintf("%s.tsv", gsub(' ', '', n)),
                row.names   = FALSE,
                sep         = "\t")
}
save(eset, file = "eset.RData")
head(eset)
```


3



<table class="dataframe">
<caption>A data.frame: 6 × 7</caption>
<thead>
	<tr><th></th><th scope=col>ID</th><th scope=col>logFC</th><th scope=col>AveExpr</th><th scope=col>t</th><th scope=col>P.Value</th><th scope=col>adj.P.Val</th><th scope=col>B</th></tr>
	<tr><th></th><th scope=col>&lt;chr&gt;</th><th scope=col>&lt;dbl&gt;</th><th scope=col>&lt;dbl&gt;</th><th scope=col>&lt;dbl&gt;</th><th scope=col>&lt;dbl&gt;</th><th scope=col>&lt;dbl&gt;</th><th scope=col>&lt;dbl&gt;</th></tr>
</thead>
<tbody>
	<tr><th scope=row>311</th><td>AT4G15620</td><td> 4.414308</td><td> 5.380715</td><td> 35.58470</td><td>2.706107e-19</td><td>1.538828e-15</td><td>33.49616</td></tr>
	<tr><th scope=row>46</th><td>ATCG00790</td><td> 4.022998</td><td>10.302096</td><td> 35.58878</td><td>2.700114e-19</td><td>1.538828e-15</td><td>33.49803</td></tr>
	<tr><th scope=row>1693</th><td>AT5G53870</td><td>-3.405975</td><td> 6.478671</td><td>-20.55259</td><td>9.726000e-15</td><td>7.374253e-12</td><td>23.92538</td></tr>
	<tr><th scope=row>742</th><td>AT1G57750</td><td>-3.346731</td><td> 5.462349</td><td>-29.17670</td><td>1.241947e-17</td><td>3.531167e-14</td><td>30.16103</td></tr>
	<tr><th scope=row>45</th><td>ATCG00780</td><td> 3.195997</td><td> 8.690368</td><td> 21.39171</td><td>4.579686e-15</td><td>4.539751e-12</td><td>24.65109</td></tr>
	<tr><th scope=row>21</th><td>ATCG00065</td><td> 3.039406</td><td> 7.137484</td><td> 22.37312</td><td>1.963188e-15</td><td>2.480816e-12</td><td>25.46182</td></tr>
</tbody>
</table>




<table class="dataframe">
<caption>A matrix: 6 × 12 of type dbl</caption>
<thead>
	<tr><th></th><th scope=col>GSM1130596_Ws-2-1</th><th scope=col>GSM1130597_Ws-2-2</th><th scope=col>GSM1130598_Ws-2-3</th><th scope=col>GSM1130599_bri1-5-1</th><th scope=col>GSM1130600_bri1-5-2</th><th scope=col>GSM1130601_bri1-5-3</th><th scope=col>GSM1130602_gul2-1-1</th><th scope=col>GSM1130603_gul2-1-2</th><th scope=col>GSM1130604_gul2-1-3</th><th scope=col>GSM1130605_gul2-1bri1-5-1</th><th scope=col>GSM1130606_gul2-1bri1-5-2</th><th scope=col>GSM1130607_gul2-1bri1-5-3</th></tr>
</thead>
<tbody>
	<tr><th scope=row>ATMG00640</th><td>5.224648</td><td>5.428151</td><td>5.546510</td><td>4.683135</td><td>4.753393</td><td>4.463033</td><td>6.087000</td><td>5.868863</td><td>5.386404</td><td>5.490967</td><td>5.671008</td><td>5.305481</td></tr>
	<tr><th scope=row>ATMG00650</th><td>5.149407</td><td>5.187442</td><td>4.886097</td><td>4.672779</td><td>4.805556</td><td>4.794880</td><td>5.527636</td><td>5.592619</td><td>5.927320</td><td>5.302640</td><td>5.524203</td><td>5.494279</td></tr>
	<tr><th scope=row>ATMG00660</th><td>5.592680</td><td>5.436074</td><td>5.638751</td><td>5.562216</td><td>5.622267</td><td>5.224591</td><td>6.605356</td><td>6.062327</td><td>5.597098</td><td>6.694592</td><td>6.661931</td><td>6.565135</td></tr>
	<tr><th scope=row>ATMG00670</th><td>4.985820</td><td>5.072172</td><td>5.262937</td><td>5.016912</td><td>5.446725</td><td>5.482161</td><td>5.366306</td><td>5.495490</td><td>5.026725</td><td>5.257816</td><td>5.356717</td><td>5.228070</td></tr>
	<tr><th scope=row>ATMG00690</th><td>5.727308</td><td>5.889640</td><td>5.323069</td><td>5.381804</td><td>5.609199</td><td>5.514687</td><td>6.348055</td><td>6.080350</td><td>6.218219</td><td>6.613726</td><td>6.537190</td><td>6.425924</td></tr>
	<tr><th scope=row>AT2G07783;ATMG00830</th><td>6.465566</td><td>6.586064</td><td>6.814510</td><td>7.653073</td><td>7.871753</td><td>8.260488</td><td>8.052288</td><td>7.970124</td><td>7.871955</td><td>7.620157</td><td>7.387385</td><td>7.555005</td></tr>
</tbody>
</table>



+ `ID`: Gene ID
+ `logFC`: 两组表达值之间以2为底对数化的变化倍数（Fold change, FC），由于基因表达矩阵本身已经取了对数，这里实际上只是两组基因表达值均值之差。
+ `AveExpr`: 该探针组所在所有样品中的平均表达值。
+ `t`：贝叶斯调整后的两组表达值间 $T$ 检验中的 $t$ 统计量。
+ `P.Value`: 检验 $P$ 值。
+ `adj.P.Val`: 调整后的 $P$ 值。（多重检验 BH 等方法）
+ `B`: 是经验贝叶斯得到的标准差的对数化值。

差异表达分析结果可视化

DEG plot


```R
pheatmap(eset,
         col                = c(colorRampPalette(brewer.pal(9, "Blues")[7:2])(100),
                                colorRampPalette(brewer.pal(9, "Reds")[2:7])(100)),
         border_color       = NA,
         cluster_rows       = T,
         cluster_cols       = T,
         show_rownames      = F,
         show_colnames      = T,
         angle_col          = 315,
         fontsize           = 13,
         main               = "expression",
         display_numbers    = F)
```


​    
![png](output_26_0.png)
​    


DEG 火山图


```R
library(ggpubr)
library(ggthemes)
deg.data <- read.table("C:\\Users\\ZidongZh\\Documents\\BioInf\\GSE46456_RAW\\bri1.5_mutant-Wild_type.tsv", header = T, sep = "\t")
# - log10 值转换
deg.data$logP <- -log10(deg.data$adj.P.Val)
# 定义 Group 列
deg.data$Group <- "not-significant"
# 定义 DEG 标准
deg.data$Group[which ((deg.data$adj.P.Val < 0.05) & (deg.data$logFC > 2))] <- "up-regulated"
# 定义 DEG 标准
deg.data$Group[which ((deg.data$adj.P.Val < 0.05) & (deg.data$logFC < -2))] <- "down-regulated"
# 统计 DEG 数量
table(deg.data$Group)
ggscatter(deg.data, x = "logFC", y = "logP", color = "Group") + theme_base()
```

    Warning message:
    "程辑包'ggpubr'是用R版本4.1.3 来建造的"
    
    载入程辑包：'ggpubr'


​    
​    The following object is masked from 'package:enrichplot':
​    
        color_palette


​    
​    Warning message:
​    "程辑包'ggthemes'是用R版本4.1.3 来建造的"




     down-regulated not-significant    up-regulated 
                 13           11338              22 




![png](output_28_2.png)
    



```R
# 新加一列 lable
deg.data$Lable <- ""
# 对差异表达基因 P 值从小到大排序
deg.data <- deg.data[order(deg.data$adj.P.Val), ]
# 从高表达基因中选取 adj.P.Val 最显著的 10 个基因
up.genes <- head(deg.data$ID[which(deg.data$Group == "up-regulated")], 10)
# 从低表达基因中选取 adj.P.Val 最显著的 10 个基因
down.genes <- head(deg.data$ID[which(deg.data$Group == "down-regulated")], 10)
# 讲上两步选取的显著基因合并并加入到 lable 中
deg.top10.genes <- c(as.character(up.genes), as.character(down.genes))
deg.data$Lable[match(deg.top10.genes, deg.data$ID)] <- deg.top10.genes
```


```R
ggscatter(deg.data,
          x             = "logFC",
          y             = "logP",
          color         = "Group",
          palette       = c("#2f5688", "#BBBBBB", "#CC0000"),
          size          = 1,
          label         = deg.data$Lable,
          font.label    = 8,
          repel         = T,
          xlab          = "Log2FoldChange",
          ylab          = "-Log10(Adjust P-value)",) +
  theme_base() +
  geom_hline(yintercept = 1.30, linetype="dashed") +
  geom_vline(xintercept = c(-2,2),linetype="dashed")
```

    Warning message:
    "ggrepel: 8 unlabeled data points (too many overlaps). Consider increasing max.overlaps"




![png](output_30_1.png)
    


输出 DEG 结果


```R
write.table(deg.data, ".\\DEG_Plot_bri1.5mutant-Wild_type.tsv", sep = "\t")
```

3. 对所有基因做 GSEA 富集分析；并对三组上调的差异表达基因(`bri1-WT`, `gul2-WT`, `bri1_gul2-WT`)做 GO 富集分析，并解释富集结果，如有图片请注明图注信息。

富集分析 GSEA


```R
# 导入 DEG 信息
data <- read.table(".\\DEG_Plot_bri1.5mutant-Wild_type.tsv", sep = "\t", header = TRUE)
GSEA_data <- data
# 提取表达量变化值
GSEA_gene_lists <- GSEA_data$logFC
# 给提取出来的值赋予 ID
names(GSEA_gene_lists) <- GSEA_data$ID
# 降序排列
GSEA_gene_lists <- sort(GSEA_gene_lists, decreasing = TRUE)
head(GSEA_gene_lists)
```


<style>
.dl-inline {width: auto; margin:0; padding: 0}
.dl-inline>dt, .dl-inline>dd {float: none; width: auto; display: inline-block}
.dl-inline>dt::after {content: ":\0020"; padding-right: .5ex}
.dl-inline>dt:not(:first-of-type) {padding-left: .5ex}
</style><dl class=dl-inline><dt>AT4G15620</dt><dd>4.41430828002192</dd><dt>ATCG00790</dt><dd>4.02299842465399</dd><dt>ATCG00780</dt><dd>3.19599709685614</dd><dt>ATCG00065</dt><dd>3.03940635696951</dd><dt>ATMG01360</dt><dd>3.02028076719578</dd><dt>ATCG01230;ATCG00905</dt><dd>2.96904529537879</dd></dl>




```R
# 获取拟南芥数据库信息
organisms <- get("org.At.tair.db")
gse <- gseGO(geneList       = GSEA_gene_lists,
             ont            = "ALL",
             keyType        = "TAIR",
             nPerm          = 10000,
             minGSSize      = 3,
             maxGSSize      = 800,
             pvalueCutoff   = 0.05,
             verbose        = TRUE,
             OrgDb          = organisms,
             pAdjustMethod  = "none")
gseaplot(gse, by = "all", title = gse$Description[1], geneSetID = 1)
```

    preparing geneSet collections...
    
    GSEA analysis...
    
    Warning message in .GSEA(geneList = geneList, exponent = exponent, minGSSize = minGSSize, :
    "We do not recommend using nPerm parameter incurrent and future releases"
    Warning message in fgsea(pathways = geneSets, stats = geneList, nperm = nPerm, minSize = minGSSize, :
    "You are trying to run fgseaSimple. It is recommended to use fgseaMultilevel. To run fgseaMultilevel, you need to remove the nperm argument in the fgsea function call."
    Warning message in preparePathwaysAndStats(pathways, stats, minSize, maxSize, gseaParam, :
    "There are duplicate gene names, fgsea may produce unexpected results."
    leading edge analysis...
    
    done...


​    


​    
![png](output_35_1.png)
​    


从总体上看，该基因集是上调趋势。

GO 富集分析


```R
data<- data[data$Group == "up-regulated", ]
ego <- enrichGO(gene            = data$ID,
                keyType         = "TAIR",
                OrgDb           = organisms,
                ont             = "ALL",
                pAdjustMethod   = "BH",
                qvalueCutoff    = 0.05)
dotplot(ego, showCategory = 10)
```


​    
![png](output_38_0.png)
​    


## 讨论

在这次上机实验中，熟悉并掌握了分析芯片表达数据的流程，表达差异分析和基因辅基分析的方法，了解了常用的数据可视化方式。
