## 

论文中对从NCBI上下载的331个枯草芽孢杆菌基因组进行了比较基因组分析

以筛选出生物被膜形成潜力较高的菌株

并探讨了比较基因组联合多组学分析的可能性

## 

1. 研究中的比较基因组分析通过流程图中的步骤展开
2. 首先对所有菌株进行结构和功能注释
   1. 通过结构注释的结果构建泛基因组
      1. 泛基因组由核心基因和辅助基因构成
         1. 核心基因包括 roary 软件结果中的核心基因和辅助基因
         2. 辅助基因包括壳层基因和云层基因
         3. 这些基因的定义在后面的结果中会给出
      2. 构建过程中会得到泛基因组中所有基因在每个基因组中的存在/缺失信息
      3. 通过存在缺失信息构建进化树
   2. 从功能注释的结果中提取 基因和 GO ID 用于功能富集分析
      1. 分别对核心基因和辅助基因进行功能富集

## 

生物被膜的作用有以下几个方面

1. 保护作用

   1. 物理屏障 组织抗菌剂渗透到细菌细胞
      提高对抗生素和其他抗菌剂的耐受性

2. 基因交换

   1. 被膜内的细菌可以发生水平基因转移
      通过质粒、转座子或噬菌体等方式
      促进抗性基因传播 提高基因多样性 提高了群体适应能力

3. 定殖与生存

   1. 微生物通过生物被膜附着在生长表面
   2. 生物被膜也为细菌提供了一个相对稳定的微环境，具有一定的缓冲作用
   3. 保护细菌免受机械损伤 对于在流动性较强的环境中生存的细菌尤为重要，对微生物资源的运输也有重要作用

4. 资源获取

   1. 生物被膜能捕获和集中环境中的营养物质
      提高微生物对资源的利用效率
   2. 被膜基质中的多糖和蛋白质可以吸附和储存营养物种

   

## 

生物被膜的形成包括三个过程

1. 黏附

   1. 通过细胞表面的黏附素附着在生长表面
      \*\* MSCRAMM 一种黏附蛋白 可识别并结合细胞外基质 EMC 有助于生物被膜的形成

2. 成熟

   1. 形成细胞外基质包裹细菌，细胞外基质包括多糖和蛋白质

   2. 由于细菌自溶死亡或通过外膜囊泡运输，DNA 被释放到生物被膜中，这是水平基因转移的关键

      \* mitomycinC 和 clsplatin 是两种抗癌药物，会选择出抗性菌株

3. 分散

   1. 随生物被膜中细菌生长到一定阶段
      细菌会离开生物被膜，扩散到新的生长表面，开始循环
   2. 这个过程中会产生一些酶，分解细胞外基质

## 

1. srfA 
   1. 合成表面素，降低表面张力，促进细菌在固体表面的扩散和聚集，有助于生物被膜的形成
   2. 具有抗菌活性，抑制其他微生物生长，让细菌在竞争环境中更具优势
   3. 受 comA 基因调控
2. abrB
   1. 抑制生物被膜形成基因的表达（多糖和蛋白质）
3. codY
   1. 感应细胞内代谢物浓度 抑制生物被膜形成基因的表达
4. comA
   1. 与双组分系统中感受器蛋白 comP 共同作用 是生物被膜形成的正调控因子，能激活与生物被膜形成相关的基因（多糖和蛋白质）
   2. comP 感应细胞密度增加等环境信号 自磷酸化，然后将磷酸基团传递给 comA 并激活
5. degU
   1. 高磷酸化水平正调控，低磷酸化水平负调控 （degS）
6. sinR
   1. 负转录调控 抑制生物被膜形成相关基因的表达

## 

12

1. 将核酸序列转换为蛋白质序列 聚类 得到同源基因家族
2. 对每个样本确定基因存在/缺失
3. 计算核心基因、软核基因、壳层基因和云层基因数量

## 

13

一致性 70%

## 

15

对基因组碱基、编码序列、tRNA 和 rRNA 数量作箱线图

eggNOG-mapper 共注释到 2503 个 GO term

## 

16

1. 泛基因组的构建过程
   1. 随参与构建泛基因组的菌株增多，泛基因组基因数量变化
      基因数量增加放缓 但总体是增加的趋势，说明枯草芽孢杆菌具有开放的泛基因组 反应菌株基因组的的多样性
   2. 构建过程中保守基因的数量 保守基因是核心基因的一部分
      总体减少 有一个峰的原因是对应的基因组之间相似性高 在后面的泛基因组矩阵中也可以看出
      会导致保守基因数量暂时增加
   3. 每个基因组为泛基因组贡献的新基因数量，累积起来就是泛基因组中基因数量
   4. 特有基因的数量（仅存在于一个菌株中的基因）是云层基因的一部分
   5. 在 95 - 100% 相似性下比对的命中数 总体呈增加的趋势，原因是分析中的基因组都来自枯草芽孢杆菌，相似性较高
      在更高的相似性水平下会有更多的比对

## 

17 

roary 构建的泛基因组矩阵 左侧是通过基因存在/缺失信息构建的进化树（fasttree 最大似然）矩阵 x 轴是泛基因组中的基因 每一列是一个基因家族，y 是参与分析的菌株

可以看到有一个分支的软核基因较少，而辅助基因较多 可以对这个分支做进一步的功能富集分析

这个分支也是出现保守基因峰的原因

## 

18

泛基因组的组成和核心基因。。。的定义

因为构建泛基因组的菌株数量多，核心基因的定义比较严格，所以将这里的核心基因和软核基因定义为核心基因，壳层基因和云层基因定义为辅助基因

## 

对泛基因组进行功能富集 这里展示的是富集结果前 30 的功能和对应的基因

## 

20

分别对roary定义的核心基因 软核基因 壳层基因和云层基因进行功能富集

从结果上看，核心基因和软核基因功能重叠较多，主要负责基础的生物过程 也反映前面将软核基因也归为核心基因是合理的

辅助基因也就是这里的壳层基因和云层基因的功能与核心基因存在差异，主要与细胞应对环境变化和生存压力相关

## 

21

对辅助基因较多的分支进行进一步的功能分析 该分支在进化数上的位置为黄色高亮区域

## 

22 

可以看到该分支的功能与核心基因基本重合 可能是因为

1. 功能冗余与替代
   1. 这些菌株通过水平基因转移获得了与核心基因功能相似的辅助基因，能够替代核心基因的功能 反映这个分支下菌株的适应性
2. 环境适应
   1. 在特定环境中某些核心基因不再是必须的，这些菌株更倾向保留哪些能够提供生存优势的辅助基因
3. 进化压力与选择
   1. 特定的辅助基因提供了选择优势，原本的核心基因失去作用或被淘汰（基因流失-获取平衡观点）
4. 基因组重组与重塑
   1. 这些菌株的基因组可能经历了较大规模的重组和重塑
      （马赛克基因组）
5. 保护机制
   1. 确保核心基因缺失，依然能位置正常功能（冗余保障）

## 

23

通过 diamond 比对和进一步统计生物质膜合成相关基因的频率 筛选出了 10 个菌株

24

肥料 生物质膜可以帮助细菌附着在作物根部 代谢产物为作物提供营养 生物质膜促进土壤形成团聚体 促进土壤通气性和保水性