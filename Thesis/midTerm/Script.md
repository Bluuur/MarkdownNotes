## 前言

研究方向是枯草芽孢杆菌群比较基因组分析，通过分析枯草芽孢杆菌的功能特征、进化谱系，比较菌株之间的基因功能差异。

关于枯草芽孢杆菌的核心基因的相关文献较少

## 材料

从 NCBI 基因组数据库下载 384 个枯草芽孢杆菌的全基因组。

## 方法

### 基因组组分分析

使用 Glimmer / Prodigal 对所有基因组进行基因预测、基因组注释。

### 基因功能分析

使用各个数据库对基因功能进行注，得到各个基因、蛋白质功能

+ GO 
  + 细胞组成
  + 分子功能
  + 生物过程
+ COG
  + 生物分子的转运与代谢
+ KEGG
  + 合成代谢通路
+ CAZy
  + 活性酶

### 泛基因组分析

得到核心基因和非核心基因在不同菌株中的含量，可以了解菌株对不同环境的适应性或者功能的多样性。也可以发现新的基因和功能。

+ 核心基因
  + 这些基因在所有样本中都存在，是物种共有的基因。
+ 软核基因
  + 是在**至少 95%** 的个体中存在的基因。它们不是核心基因，但在大多数样本中仍然普遍存在。
  + 软核基因可能在不同个体之间发生变异，但仍保持较高的共现率。
+ 壳层基因
  + 核心基因和云基因之间，占据 15% 到 95% 的范围。它们不是核心基因，但在一部分个体中存在。
+ 云层基因
  + 云基因不足15%。这些基因仅在某个特定个体中存在，不在其他样本中出现。

###  比较基因组分析

#### 构建系统发育树

比较所有菌株之间的进化关系

#### 共线性分析

根据菌株基因组的相似性，通过共线性分析识别基因组之间的一致性与变异性
