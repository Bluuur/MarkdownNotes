# 数据预处理

## 测序数据分析流程

+ 原始数据 FastQ 文件
	+ 数据预处理
+ 数据文件 FastQ 文件
	+ 序列比对
+ mapping file
	+ 数据分析
		+ ChIP-Seq
		+ RNA-Seq
		+ ChIA-PET
		+ ……
+ 初步结果
	+ GO analysis
+ 进一步的结果

### 测序过程
#### Sanger Sequencing 

#### Illumina Flowcell

```R
library(ChIPseeker) # 加载ChIPseeker包
library(TxDb.Celegans.UCSC.ce6.ensGene) # 加载TxDb.Celegans.UCSC.ce6.ensGene包
library(EnsDb.Celegans.v32) # 加载EnsDb.Celegans.v32包
library(org.Ce.eg.db) # 加载org.Ce.eg.db包

peak <- readPeakFile("path/to/peak/file") # 读取peak文件

txdb <- TxDb.Celegans.UCSC.ce6.ensGene # 定义TxDb对象
ebdb <- EnsDb.Celegans.v32 # 定义EnsDb对象
orgdb <- org.Ce.eg.db # 定义orgdb对象

anno <- annotatePeak(peak, tssRegion=c(-3000, 3000), TxDb=txdb, annoDb=ebdb, annotation="WormBase", output="annotation") # 注释peak文件

--------------------------

library(clusterProfiler)
library(ChIPseeker)
library(GenomicFeatures)
txdb <- makeTxDbFromGFF("F:/university/3down/生物信息学进展/chip/Saccharomyces_cerevisiae.R64-1-1.109.gff3",
                        format="gff3")    #也可以使用gtf
keytypes(txdb)    #感兴趣的话，可以用以下方法探索txdb都包含了什么内容
keys(txdb)
#读入单个summits文件
peaks <- readPeakFile("F:/university/3down/生物信息学进展/chip/test_summits.bed")
#结构注释
peakAnno <- annotatePeak(peaks,
                         TxDb=txdb,
                         tssRegion=c(-1000, 1000))
#注释完，进行可视化，多种图可供选择
plotAnnoBar(peakAnno)
plotDistToTSS(peakAnno)
vennpie(peakAnno)
plotAnnoPie(peakAnno)
#install.packages("ggupset")
library(ggupset)
upsetplot(peakAnno)
#install.packages("ggimage")
library(ggimage)
upsetplot(peakAnno, vennpie=TRUE)

#最后将我们的注释结果转为数据框，便于查看
df <- as.data.frame(peakAnno)
#将注释到的基因提取出来（第14列），用于后续功能分析
gene <- df[,14]
```



```R
####GO富集分析
library('devtools')
library(DOSE) #其中自带的genelist数据为人类背景基因集
library(org.Sc.sgd.db) #酵母的参考基因富集数据库
library(topGO)
library(clusterProfiler)
library(pathview)
MyGeneSet <- unique(gene)
#去除版本号
#columns(org.Sc.sgd.db)

ego_ALL <- enrichGO(gene =unique(gene_last$ENTREZID), 
                    OrgDb = "org.Sc.sgd.db" ,
                    keyType = "ENTREZID",
                    ont = "ALL", # Other options: CC or BP or MF
                    pAdjustMethod = "BH", # adjust method,  "holm“, “hochberg”, “hommel”, “bonferroni”, “BH”, “BY”, “fdr”, “none”中的一种
                    pvalueCutoff = 0.01, 
                    qvalueCutoff = 0.05,)

barplot(ego_ALL , x = "GeneRatio", color = "p.adjust", #默认参数（x和color可以根据eG里面的内容更改）
        showCategory =10, #只显示前10
        split="ONTOLOGY", font.size =6) + #以ONTOLOGY类型分开
  facet_grid(ONTOLOGY~., scale='free') #以ONTOLOGY类型分开绘图
dotplot(eG,x = "GeneRatio", color = "p.adjust", size = "Count", #默认参数
        showCategory =10,#只显示前5
        split="ONTOLOGY", font.size =6) + #以ONTOLOGY类型分开
  facet_grid(ONTOLOGY~., scale='free') #以ONTOLOGY类型分屏绘图
```



