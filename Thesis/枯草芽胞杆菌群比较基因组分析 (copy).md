# 枯草芽胞杆菌群比较基因组分析

[toc]



## 材料与方法

### 材料

#### 枯草芽孢杆菌基因组

*Bacillus subtilis*

##### Miniconda 安装

```bash
# 安装 conda 环境
# 下载 Miniconda 安装脚本
wget -c https://repo.anaconda.com/miniconda/Miniconda3-latest-Linux-x86_64.sh

 
# 运行安装脚本
chmod a+x 
bash Miniconda3-latest-Linux-x86_64.sh

export PATH=<condaPath>/bin:$PATH
# 刷新环境变量
source .bashrc
```

##### ncbi-genome-download 安装

该软件用于批量下载 NCBI 基因组数据。

```bash
conda install -c bioconda ncbi-genome-download
ncbi-genome-download --genera "Bacillus subtilis" --output-folder ~/genomes --formats genbank bacteria
```

1. 基因家族聚类分析
2. 查找直系同源基因
3. 系统进化分析
4. 物种分歧时间的估算分析
5. 鉴定基因融合与基因簇
6. 信号通路基因簇重构
7. 基因家族收缩与扩张
8. 全基因组复制事件分析
9. 全基因组共线性比较

### 方法

#### 基因组组分分析

##### [Glimmer](http://ccb.jhu.edu/software/glimmer/index.shtml)	预测基因组编码基因

+ Glimmer 安装

```bash
wget http://www.cbcb.umd.edu/software/glimmer/glimmer302.tar.gz

tar -zxvf glimmer302.tar.gz  # 解压缩命令
# tar -zcvf 压缩文件名.tar.gz 被压缩文件名
cd glimmer3.02/src
make # 编译
# 将 glimmer 的 bin 目录添加环境变量
echo export PATH=~/soft/glimmer3.02/bin:\$PATH >>  ~/.bashrc 
```

+ 预测基因组编码基因

```bash
# 选用自身作为训练集来作为模型
# 运行 long-orfs 产生无重叠的 orfs
long-orfs -n -t 1.15 ~/bt.fna ~/result/glimmer_out/bt.longorfs  1>/dev/null 2>/dev/null
# 运行 extract 提取训练集
extract -t ~/bt.fna ~/result/glimmer_out/bt.longorfs  > ~/result/glimmer_out/bt.train  2>/dev/null
# 运行 bulid-icm 通过训练集，生产预测的模型，用于基因预测
build-icm  -r ~/result/glimmer_out/bt.icm < ~/result/glimmer_out/bt.train 1>/dev/null 2>/dev/null
# 运行 glimmer3 完成基因预测
glimmer3 -o50 -g110 -t30 ~/bt.fna ~/result/glimmer_out/bt.icm bt
# 参数含义：
# -o50 指定 ORF 被视为基因预测的最小长度
# -g110 指定 ORF 被视为基因预测的最大长度
# -t30 指定基因预测的最小分数阈值，该分数基于 ORF 的各种特征（如起始密码子上下文、编码潜力等）计算而来
```

##### Prodigal

```bash
~/Prodigal-2.60/prodigal -a ~/result/prodigal_out/bt.pep -d bt.cds -f gff -g 11 -o ~/result/prodigal_out/bt.gff -p meta -s ~/result/prodigal_out/bt.stat -i ~/bt.fna > ~/result/prodigal_out/prodigal.log
---

#!/bin/bash
#SBATCH -J prodigal
#SBATCH -p normal1
#SBATCH -n 5
#SBATCH -o prodigal.out
#SBATCH -e prodigal.err

~/Prodigal-2.60/prodigal -a ~/result/prodigal_out/bt.pep -d bt.cds -f gff -g 11 -o ~/result/prodigal_out/bt.gff -p meta -s ~/result/prodigal_out/bt.stat -i ~/bt.fna > ~/result/prodigal_out/prodigal.log
```



##### [tRNAscan-SE](http://topaz.gatech.edu/GeneMark)	预测 tRNA



```bash
wget -c http://eddylab.org/infernal/infernal-1.1.2-linux-intel-gcc.tar.gz
tar xzvf infernal-1.1.2-linux-intel-gcc.tar.gz
cd infernal-1.1.2-linux-intel-gcc/
./configure --prefix=/home/zidongzh/infernal-1.1.2-linux-intel-gcc
make && make install
cp binaries/*  bin

wget -c http://lowelab.ucsc.edu/software/tRNAscan-SE.tar.gz
tar -xvf tRNAscan-SE.tar.gz
mkdir tRNAscan-SE-2.0_installed # 跳过此操作安装在解压目录下也可以
./configure --prefix=/home/zidongzh/tRNAscan-SE-2.0_installed
make && make install
# 添加bashrc【建议】或者terminal运行
export PATH=/home/zidongzh/tRNAscan-SE-2.0_installed/bin:$PATH
# >----- server ----->
echo export PATH=/beegfs/home/zdzhang/tRNAscan-SE-2.0_installed/bin:$PATH >> ~/.bashrc
# <----- server -----<

export PERL5LIB=/home/zidongzh/tRNAscan-SE-2.0_installed/lib:$PERL5LIB
# >----- server ----->
echo export PERL5LIB=/beegfs/home/zdzhang/tRNAscan-SE-2.0_installed/lib:$PERL5LIB >> ~/.bashrc
# <----- server -----<

# 需要编辑/user/software/tRNAscan-SE-2.0_installed/bin/tRNAscan-SE.conf文件，每个项目单独拷贝到相应目录下编辑保存
bin_dir:/user/software/tRNAscan-SE-2.0_installed/bin
lib_dir: /user/software/tRNAscan-SE-2.0_installed/lib/tRNAscan-SE
infernal_dir: /user/software/infernal-1.1.2-linux-intel-gcc/bin


tRNAscan-SE -B -o ~/result/trnascan_out/tRNA.out -f ~/result/trnascan_out/tRNA.ss -m ~/result/trnascan_out/tRNA.stats -b ~/result/trnascan_out/tRNA.bed  ~/bt.fna

# 该命令产生的结果与Demo文件夹中的结果文件类型一致，其中参数
  -o 结果文件
  -f 二级结构（tRNA）文件
  -s （Isotype specific）结果
  -m 统计文件（statistics）
  -b 输出bed格式结果，也可不设置

```



\>>>>>>>>>>>>>>>>>> dumped \>>>>>>>>>>>>>>>>>>

使用 conda 安装

```bash
# 安装 tRNAscan-SE
conda install trnascan-se -c bioconda
# 使用前需要将依赖程序链接到指定的目录
# 修改前备份软件的配置文件
cp tRNAscan-SE.conf ./tRNA scan-SE.conf.bak
# 查找以下文件的路径，并配置到软件的配置文件中
which cmsearch
/home/zidongzh/miniconda3/envs/comparative/bin/cmsearch
which cmscan
/home/zidongzh/miniconda3/envs/comparative/bin/cmscan
```

软件配置文件如下：

```bash
# tRNAscan-SE 2.0
# Configuration File

# default paths
bin_dir: ~/miniconda3/pkgs/trnascan-se-2.0.9-pl5321hec16e2b_3/bin
lib_dir: ~/miniconda3/pkgs/trnascan-se-2.0.9-pl5321hec16e2b_3/lib/tRNAscan-SE
infernal_dir: ~/miniconda3/bin

# temporary files
temp_dir: /usr/tmp # 如果序列长度超过 1 MB 需要将 tmp 文件夹改为 /usr/tmp
```

```bash
tRNAscan-SE -B -o ~/result/trnascan_out/tRNA.out -f ~/result/trnascan_out/tRNA.ss -m ~/result/trnascan_out/tRNA.stats -b ~/result/trnascan_out/tRNA.bed  ~/bt.fna

tRNAscan-SE \
	-B \
	-o ~/result/trnascan_out/tRNA.out \
	-f ~/result/trnascan_out/tRNA.ss \
	-m ~/result/trnascan_out/tRNA.stats \
	-b ~/result/trnascan_out/tRNA.bed \
	-c ~/miniconda3/pkgs/trnascan-se-2.0.9-pl5321hec16e2b_3/bin/tRNAscan-SE.conf \
	~/bt.fna
```

参数含义：

1. `-B`: 指定了 tRNA 的搜索模型为细菌。
2. `-o <file>`: 指定输出文件的名称。
3. `-f <file>`: 保存 tRNA 二级结构到文件。
4. `-m <file>`: 将统计结果保存到文件。
5. `-c <path_to_tRNAscan-SE.conf>`: 指定配置文件的路径。
6. `-b <file>`: 保存 tRNA 序列到文件（.bed 格式）。

\<<<<<<<<<<<<<<<<<<< dumped <<<<<<<<<<<<<<<<<

##### [RNAmmer](http://trna.ucsc.edu/software/)	分析 rRNA

本地版的 RNAmmer 依赖于低版本的 hmmer

```bash
wget http://eddylab.org/software/hmmer/hmmer-2.3.2.tar.gz
tar -zxf hmmer-2.3.2.tar.gz

./configure --prefix=/beegfs/home/zdzhang/hmmer-2.3.2_install
mkdir -p /beegfs/home/zdzhang/hmmer-2.3.2_install/man/man1 /beegfs/home/zdzhang/hmmer-2.3.2_install/bin
make && make install

```

RNAmmer 安装配置

```bash
tar zxf rnammer-2.3.2.src.tar.Z -C ~/rnammer

# >>>>>>>>>> local >>>>>>>>>>
perl -p -i -e 's/(my \$INSTALL_PATH).*/$1 = \"\/home\/zidongzh\/rnammer";/' /home/zidongzh/rnammer/rnammer

perl -p -i -e 's/^(\s+\$HMMSEARCH_BINARY).*/$1 = \"\/home\/zidongzh\/hmmer-2.3.2\/src\/hmmsearch";/' /home/zidongzh/rnammer/rnammer

perl -p -i -e's/--cpu 1//g' /home/zidongzh/rnammer/core-rnammer

/home/zidongzh/hmmer-2.3.2/src/hmmsearch
# <<<<<<<<<<< local <<<<<<<<<<
---------------
# >>>>>>>>>>>> server >>>>>>>>>>>>
perl -p -i -e 's/(my \$INSTALL_PATH).*/$1 = \"\/beegfs\/home\/zdzhang\/rnammer";/' /beegfs/home/zdzhang/rnammer/rnammer

perl -p -i -e 's/^(\s+\$HMMSEARCH_BINARY).*/$1 = \"\/beegfs\/home\/zdzhang\/hmmer-2.3.2_install\/bin\/hmmsearch";/' /beegfs/home/zdzhang/hmmer-2.3.2/src/hmmsearch

perl -p -i -e's/--cpu 1//g' /beegfs/home/zdzhang/rnammer/core-rnammer
# <<<<<<<<<<<< server <<<<<<<<<<<<
```

运行

```bash
~/rnammer/rnammer -S bac -multi\
	-f ~/result/rnammer_out/bt_rRNA.fasta\
     -h ~/result/rnammer_out/bt_rRNA.hmmreport\
     -xml ~/result/rnammer_out/bt_rRNA.xml\
     -gff ~/result/rnammer_out/bt_rRNA.gff2\
     ~/bt.fna
     
```

---

服务器运行脚本：

```bash
#!/bin/bash
#SBATCH -J rnammer
#SBATCH -p normal1
#SBATCH -n 5
#SBATCH -o rnammer.out
#SBATCH -e rnammer.err

~/rnammer/rnammer -S bac -multi\
	-f ~/result/rnammer_out/bt_rRNA.fasta\
     -h ~/result/rnammer_out/bt_rRNA.hmmreport\
     -xml ~/result/rnammer_out/bt_rRNA.xml\
     -gff ~/result/rnammer_out/bt_rRNA.gff2\
     ~/bt.fna
```

rnammer 参数：

```
-S  指定输入序列的物种所属的界： arc bac 或 euk

-gff  生成的gff文件结果

-m  所需要预测的moleculers： 'tsu' for 5/8s rRNA, 'ssu' for 16/18s rRNA, 'lsu' for 23/28s rRNA。如果全部进行预测，则该参数后为 'tsu,ssu,lsu'。

-multi  并行运算，预测正反两条链上所有的moleculers。最多并行运行6个计算。使用该参数，则不需要上一个参数。

-f  生成的rRNA的fasta结果文件

-h  生成的hmm报告结果

-gff  生成的rRNA的gff2文件

-x  生成的xml结果文件
```

+ [BLAST+](ftp://ftp.ncbi.nlm.nih.gov/blast/executables/blast+/2.3.0/)	预测 SnRNA
+ [Minced](https://github.com/ctSkennerton/minced)	预测 CRISPR-Cas 数量
+ [PHAST](https://sourceforge.net/projects/phage-finder/files/)	预测前噬菌体个数
+ [IslandViewer](https://www.pathogenomics.sfu.ca/islandviewer/resources/)	预测基因岛数量

#### 基因功能分析

+ [Blast2go](https://www.blast2go.com/)	GO 数据库注释
+ [eggNOG](http://eggnogdb.embl.de/#/app/home)	COG 数据库注释
+ [KEGG 在线数据库](http://www.genome.jp/kegg/)	KEGG 注释
+ [CAZy](http://www.cazy.org/)	CAZy 注释
+ [antiSMASH](https://dl.secondarymetabolites.org/releases/4.0.2/)	次级代谢产物注释

#### 比较基因组分析

+ [IQ-TREE](http://www.iqtree.org/release/v1.6.12)	构建同源单拷贝基因系统发育树，建树方法为 maximum likelihood
+ [Mummer](https://mummer4.github.io/)	共线性分析，默认软件参数

---

```shell
conda activate pgcgap
mamba install  -c bioconda -y eggnog-mapper
#数据库目录~/00_database/
download_eggnog_data.py -P -M -y -f --data_dir /data1/develop/16s/pgcgap/eggnogDB/

create_dbs.py -m diamond --dbname bacteria --taxa Bacteria --data_dir /data1/develop/16s/pgcgap/eggnogDB/

#功能注释
cat >function.sh
#!/bin/bash
#SBATCH -J function
#SBATCH -p normal
#SBATCH -n 12
#SBATCH -o function.out
#SBATCH -e function.err


emapper.py -i $faa --output funAnno/$prefix --data_dir eggnogDB -m diamond --usemem --cpu 64

for faa in $(ls data/Annotations/AAs/*.faa); do
    # 执行emapper.py命令
    echo "Processing $faa"
    date
    prefix=`basename $faa`
    emapper.py -i $faa --output funAnno/$prefix --data_dir eggnogDB -m diamond --usemem --cpu 64
done
```

```shell
http://eggnogdb.embl.de/download/emapperdb-5.0.2/eggnog.db.gz
http://eggnogdb.embl.de/download/emapperdb-5.0.2/eggnog.taxa.tar.gz
http://eggnogdb.embl.de/download/emapperdb-5.0.2/eggnog_proteins.dmnd.gz
http://eggnogdb.embl.de/download/emapperdb-5.0.2/pfam.tar.gz
http://eggnogdb.embl.de/download/emapperdb-5.0.2/mmseqs.tar.gz
```



Pan：Roary，OrthoMCL，Gene Ontology，PAML

```shell
wget http://orthomcl.org/common/downloads/software/v2.0/orthomclSoftware-v2.0.9.tar.gz
```





1. 菌株基因组序列数据下载与注释
2. 核心基因组的构建
   首先推导直系同源基因家族，在众多直系同源基因家族中，将每个菌株基因组都出现的直系同源基因家族定义为核心基因家族，将仅出现于单个菌株基因组的直系同源基因定义为株特有基因，其余的为辅助基因家族。
3. 泛基因组分析
4. 系统发育树的构建及比较

/public/pipeline/besalttools/latest/public/gokegg_heatmap_clusterprofile.sh



## 表面素合成 $srfA$ 操纵子基因

srfA-A srfA-B srfA-C srfA-D

调控基因：ComA DegU AbrB CodY SinR

## ClusterProfiler 功能富集

```R
library(clusterProfiler)
library(enrichplot)
library(ggplot2)
library(stringr)
geneGO <- read.table(file.choose(),sep="\t",header=T, stringsAsFactors = FALSE)
symbol <- geneGO$symbol
goID <- geneGO$GO
term2gene <- geneGO[,c(2,1)]
#term2gene <- buildGOmap(term2gene)
go2term <- go2term(term2gene$GO)
# go2term <- as.data.frame(goID) %>% left_join(go2term, by = c("goID"="go_id"))

soft <- panGene[304:2283]
shell <- panGene[2588:4877]
cloud <- panGene[4878:31561]

df <- enricher(symbol, TERM2GENE = term2gene, TERM2NAME = go2term,pvalueCutoff = 0.5,qvalueCutoff = 0.5)
barplot(df, showCategory=20, title="EnrichmentGO")
```

```
/data1/develop/16s/pgcgap/comparative/result/OrthoFinder
/data1/develop/16s/pgcgap/comparative/result/roary

/data1/develop/16s/pgcgap
├── comparative
│   ├── data
│   │   ├── genes
│   │   └── genomes
│   ├── db
│   │   ├── diamondDB
│   │   └── eggnogDB
│   ├── result
│   │   ├── clusterProfilerInput
│   │   ├── dmndMap
│   │   ├── egngmpOut
│   │   ├── emapperAnno
│   │   ├── iden0.7GeneFre
│   │   ├── iden0.9GeneFre
│   │   ├── OrthoFinder
│   │   ├── prokka
│   │   ├── roary
│   │   └── test
│   └── sgeScript
│       └── plot
├── dumped
│   ├── GCA
│   │   ├── AAs
│   │   ├── annotation
│   │   ├── CDs
│   │   └── GFF
│   ├── Results
│   │   ├── Annotations
│   │   ├── COG
│   │   ├── CoreTrees
│   │   ├── PanGenome
│   │   └── PanGenome_1714460030
│   └── sgeOut
│       └── script
└── soft
    └── orthomclSoftware-v2.0.9
        ├── bin
        ├── config
        ├── doc
        └── lib
```

对核心基因进行富集
