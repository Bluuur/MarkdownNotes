> 

[TOC]

# 培养组学分析流程

作者：刘永鑫 (yxliu@genetics.ac.cn)等 (遗传发育所白洋组)

版本： v2.0   日期：2022-04-11

使用此流程，请引用: Jingying Zhang, Yong-Xin Liu, Xiaoxuan Guo, Yuan Qin, Ruben Garrido-Oter, Paul Schulze-Lefert & Yang Bai. 2021. High-throughput cultivation and identification of bacteria from the plant root microbiota. **Nature Protocols** 16: 988-1012. https://doi.org/10.1038/s41596-020-00444-7

使用方法：参考附录或 `0install_win/mac.sh` 安装培养组流程。然后在 R Studio 中逐行运行本脚本，缩进的行为代码，可在 Terminal 中运行。

## 分析步骤

设置工作目录 ( work directory，`wd`)；修改 `db` 为 `Culturome`的安装目录

```shell
# 启动 culturome 的 conda 环境
conda activate culturome
# 设置工作目录，Mac设置为 `~/Documents/microbiome/culture`
wd=/mnt/c/culture
# 创建工作目录并进入，`-p` 允许建立多级目录
mkdir -p $wd && cd $wd
# 设置 Culturome 位置(让程序找到引物、绘图方案等信息)，Mac设置为 `~/Documents/microbiome/Culturome`
db=/mnt/c/microbiome/Culturome
# 建议项目所需文件夹
mkdir -p seq temp result
```

(可选)下载测试数据并解压。或准备测序数据于seq目录中

```shell
# 下载示例数据，-c 支持断点续传。下载中断可再次运行此命令尝试
wget -c ftp://download.big.ac.cn/gsa3/CRA002517/CRR127980/CRR127980_f1.fq.gz -O seq/L1_1.fq.gz
wget -c ftp://download.big.ac.cn/gsa3/CRA002517/CRR127980/CRR127980_r2.fq.gz -O seq/L1_2.fq.gz
wget -c ftp://download.big.ac.cn/gsa3/CRA002517/CRR127982/CRR127982_f1.fq.gz -O seq/L2_1.fq.gz
wget -c ftp://download.big.ac.cn/gsa3/CRA002517/CRR127982/CRR127982_r2.fq.gz -O seq/L2_2.fq.gz
gunzip seq/*.gz
```

### 编写样本信息(mapping files)

一个分菌样本通常对应一个测序文库。为每个测序文库编写 mapping files（将菌位置与标签信息对应）。每个孔为双端标签的 16S 扩增子测序。

```shell
# 生成文库列表，1 个或多个文库都可循环处理
ls seq/*.fq | cut -f 2 -d '/' | cut -f 1 -d '_' | uniq > result/library.txt
        
# 利用 for 循环为每个文库生成包含 48(板) \times 96(孔)的 mapping file
    for l in `cat result/library.txt`; do
      write_mapping_file.pl -i ${db}/script/barcodeF96.txt -b ${db}/script/barcodeR48.txt \
        -F AACMGGATTAGATACCCKG -R ACGTCATCCCCACCTTCC \
        -L ${l} -p 48 -v Nippobare -c Root -m TSB -B 1 -s Rice -d WildType \
        -o seq/${l}.txt; done

# 合并两个 mapping file(s) 为单个 metadtata (单个项目要有唯一的 metadata，可以包含多个 mapping file 信息)
    l=`head -n1 result/library.txt|cut -f1`
    cat <(head -n1 seq/${l}.txt | sed 's/#//g') \
        <(cat seq/*.txt |grep -v '#'|grep -v -P '^SampleID\t') \
        > result/metadata.txt
```

### 校验 mapping file 格式是否正确

手动编写或修改的文章必须校验，确保下游分析顺利完成。

```shell
    for l in `cat result/library.txt`; do
      validate_mapping_file.py -m seq/${l}.txt -o temp/;done
```

### 双端序列合并

```shell
# time 统计计算时间，rush 指定并行任务数量，3s - 3m
# 并行报错修改为 -j 1 单个文件运行
time cat result/library.txt|rush -j 3 \
	'vsearch -fastq_mergepairs \
	seq/{1}_1.fq -reverse seq/{1}_2.fq \
	-fastqout temp/{1}.fq'
```

### 样本拆分

```shell
# 从数据中提取 barcodes，用于序列孔来源识别 1 - 15m
# 注意根据实验设计修改 barcode 长度
time cat result/library.txt|rush -j 3 \
	'extract_barcodes.py \
		-f temp/{1}.fq -m seq/{1}.txt \
		-c barcode_paired_stitched \
		--bc1_len 10 --bc2_len 6 \
		-a --rev_comp_bc2 \
		-o temp/{1}'

# 利用 barcode 与 mapping file，将每条序列重命名为板和孔位置 2m
# 从数据中提取 barcodes，用于序列孔来源识别 1 - 15m
# 注意根据实验设计修改 barcode 长度
time cat result/library.txt|rush -j 3 \
	'extract_barcodes.py \
		-f temp/{1}.fq -m seq/{1}.txt \
		-c barcode_paired_stitched \
		--bc1_len 10 --bc2_len 6 \
		-a --rev_comp_bc2 \
		-o temp/{1}'

# 利用barcode与mapping file，将每条序列重命名为板和孔位置, 2m
time cat result/library.txt|rush -j 3 \
	'split_libraries_fastq.py \
		-i temp/{1}/reads.fastq \
		-b temp/{1}/barcodes.fastq \
		-m seq/{1}.txt \
		-q 19 --max_barcode_errors 0 \
		--barcode_type 16 --phred_offset 33 \
		-o temp/{1}'

# 将序列ID修改为vsearch要求格式
rm -rf temp/qc.fa
for l in `cat result/library.txt`; do
	cut -f 1 -d ' ' temp/${l}/seqs.fna | sed 's/_/./' \
	>> temp/qc.fa; done
```
### 统计每个板和孔中的测序深度

```shell
# 建立此步分析结果目录
mkdir -p result/split
# 绘图柱状图
for l in `cat result/library.txt`; do
	tail -n+16 temp/${l}/split_library_log.txt| \
	head -n-4 > result/split/${l}.txt
	stat_split_bar.R \
    	-i result/metadata.txt \
    	-d result/split/${l}.txt \
    	-o result/split/
done
```
+ 每个孔的测序数量 `result/split/L1.txt.well.pdf/png`
+ 每个孔的测序数量直方图 `result/split/L1.txt.histogram.pdf/png`
+ 每个板的测序数量柱状图 `result/split/L1.txt.plate.pdf/png`
+ 每个图都包括 pdf/png 两个版本，`L1.txt` 和 `L1.txt.plate.txt` 是图的原始数据

### 切除引物

```shell
# 根据实验设置引物长度 1s - 2m
time vsearch --fastx_filter temp/qc.fa \
	--fastq_stripleft 19 --fastq_stripright 18 \
	--fastaout temp/filtered.fa
```
### 挑选代表序列

```shell
# 7.1 去冗余：计算每个序列出现的频率，去除小于 10 的读长， 4s - 3m
time vsearch --derep_fulllength temp/filtered.fa \
	--relabel Uni --minuniquesize 10 --sizeout \
	--output temp/uniques.fa
# 查看非冗余序列大小。MB级别较正常，GB级别可能上游出错
ls -hs temp/uniques.fa

# 7.2 采用unoise3算法去噪，鉴定ASV
vsearch --cluster_unoise temp/uniques.fa --minsize 10 \
	--centroids temp/Zotus.fa

# 7.3 从头去除嵌合体
vsearch --uchime3_denovo temp/Zotus.fa --relabel ASV_ \
	--nonchimeras result/ASV.fa
```
### 构建 ASV 表

```shell
# 比对读长到ASV进行定量, 2m-30m
time vsearch --usearch_global temp/filtered.fa \
	--db result/ASV.fa \
	--otutabout temp/ASV_table.txt \
	--id 0.97
```

### 假阳性率控制
扩增子测序容易受低丰度 DNA 污染，采用阴性对照控制假阳性结果。

```shell
# 计算样阴、阳性对照的数据量，确定过滤假阳性的阈值
negative_threshold.R \
	--input temp/ASV_table.txt --metadata result/metadata.txt \
	--threshold 1 \
	--negative A12 --positive B12 \
	--output result/fdr.txt
cat result/fdr.txt
```
结果图：`result/fdr.txt.control.pdf`

```shell
# 过滤潜在假阳性孔
# e.g. Deleted 705，Keep 4990
otutab_trim.R \
	--input temp/ASV_table.txt \
	--min_sample_size `cat result/fdr.txt` \
	--output result/ASV_table.txt
sed -i '1 s/#OTU ID/OTUID/' result/ASV_table.txt

# 统计每个板中阳性孔数量
head -n1 result/ASV_table.txt | cut -f2- | \
	sed 's/\t/\n/g' | cut -c1-5 | sort | \
	uniq -c | sort -k1,1n > result/plate_positive.count
cat result/plate_positive.count
```
### 物种注释

```shell
# 基于RDP训练集16，置信度阈值0.6.
vsearch --sintax result/ASV.fa --db ${db}/db/rdp_16s_v16_sp.fa --tabbedout temp/ASV.fa.tax --sintax_cutoff 0.6
# 制作2列，8列的物种注释表
cut -f 1,4 temp/ASV.fa.tax | sed 's/\td/\tk/;s/:/__/g;s/,/;/g;s/"//g;s/\/Chloroplast//' > result/taxonomy_2.txt
awk 'BEGIN{OFS=FS="\t"} {delete a; a["k"]="Unassigned";a["p"]="Unassigned";a["c"]="Unassigned";a["o"]="Unassigned";a["f"]="Unassigned";a["g"]="Unassigned";a["s"]="Unassigned"; split($2,x,";");for(i in x){split(x[i],b,"__");a[b[1]]=b[2];} print $1,a["k"],a["p"],a["c"],a["o"],a["f"],a["g"],a["s"];}' result/taxonomy_2.txt | sed '1 i #OTU ID\tKingdom\tPhylum\tClass\tOrder\tFamily\tGenus\tSpecies' |sed 's/#//g;s/ //g' > result/taxonomy_8.txt
    
# ASV表按属合并
awk 'BEGIN{FS=OFS="\t"} NR==FNR{a[$1]=$7} NR>FNR{print $0,a[$1]}' result/taxonomy_8.txt result/ASV_table.txt | sed '/\t$/d' | sed '1 s/Genus/KO/' > result/ASV_table7.txt
mat_gene2ko.R -i result/ASV_table7.txt -n 100 \
	-o result/genus
```

### 鉴定 ASV 的高纯度菌孔

```shell
time identify_isolate.R \
	--input result/ASV_table.txt \
	--genus result/genus.count \
	--taxonomy result/taxonomy_8.txt \
	--output result/isolate
```
- ASV/G属纯度分布 `result/isolate.Distribution.pdf/png`
- 稀释曲线 `result/isolate_rare_curve.pdf/png`
- 孔列表 `result/isolate_well.txt`
- ASV 列表 `result/isolate_ASV.txt`

(可选) 每个每个库第一板的纯度热图，删除'|head -n3'绘制所有板

```shell
mkdir -p result/purity
for l in `cat result/library.txt`; do
	# Prepare input file
	awk 'NR==FNR{a[$1]=$3}NR>FNR{print $1"\t"a[$1]}' result/isolate_well.txt seq/${l}.txt | \
		tail -n+2 | sed 's/\t$/\t0/' \
		> result/purity/${l}.txt
	# Format list into plate format
	format_list2plate.pl -i result/purity/${l}.txt \
		-o result/purity/${l}/
	# Batch plot top 1 plate, deleted '|head -n1' to plot all
	list=`ls result/purity/${l}/|cut -f 1 -d '.'|cut -f 2 -d 'P'|sort|uniq|head -n1`
	for plate in $(echo $list);do 
		plot_pheatmap.sh -i result/purity/${l}/${l}P${plate}.plate \
			-o result/purity/${l}/${l}P${plate}.png
	done;
done
```
+ 每个板中每个孔纯度热图 `result/purity/L*/*.png`

### 培养菌进化分支树

```shell
# 准备graphlan输入文件
graphlan_prepare.R --input result/ASV_table.txt \
	--taxonomy result/taxonomy_8.txt \
	--abundance 0 --number 150 \
	--output result/graphlan/ 
# 绘图
graphlan_plot.sh -i $db -o result/graphlan
```
+ 结果树图 `result/graphlan/graphlan.pdf`

### (可选)项目清理

项目结束后，删除临时文件，节省空间

```shell
# 统计目录空间
du -sh *
# 压缩原始数据
gzip seq/*.fq
# 删除临时文件
rm -r temp
# 结果打包
zip result.zip -r result/
```

## 附录1. Windows 的 WSL 或 Linux 下安装代码

所有需要的文件在 QQ 群中均可下载。建议先下载 Windows + Culturome 目录

简明教程：QQ 群中 Culturome/培养组学分析流程.pptx - 培养组分析流程安装

详细教程及常见问题：QQ 群中：Culturome/培养组学软件安装.docx

第 1 步：安装编程环境 R 和 RStudio

第 2 步：Windows 安装 WSL

第 3 步：安装 Conda，完成后关闭终端再打开
```shell
# linux下修改为~/microbiome
wd=/mnt/c/microbiome 
mkdir -p $wd && cd $wd
wget -c https://repo.anaconda.com/miniconda/Miniconda3-latest-Linux-x86_64.sh
bash Miniconda3-latest-Linux-x86_64.sh -b -f
~/miniconda3/condabin/conda init
```

第 4 步：安装培养组流程依赖的软件

```shell
# 确定安装目录：Windows用户在C盘新建文件夹并进入
# Linux下修改为~/microbiome
wd=/mnt/c/microbiome 
mkdir -p $wd && cd $wd
# 下载培养组流程依赖的软件
wget -c http://210.75.224.110/db/conda/culturome.tar.gz
# 解压到conda环境目录
mkdir -p ~/miniconda3/envs/culturome
tar -xvzf culturome.tar.gz -C ~/miniconda3/envs/culturome
# 进入conda的culturome环境并初始化(3s-30s, 左侧(base)变为(culturome))
conda activate culturome
conda unpack
# 删除安装包(必须删除，否则与后面软件冲突)
rm culturome.tar.gz
```

第5步：安装培养组流程
```shell
# Install culturome pipeline
# For windows usea change to c:
# Linux下修改为~/microbiome
wd=/mnt/c/microbiome 
mkdir -p $wd && cd $wd
wget -c http://210.75.224.110/db/Culturome.tar.gz
tar xvzf Culturome.tar.gz
chmod +x Culturome/script/*
echo export PATH=`pwd`/Culturome/script:\$PATH >>  ~/.bashrc
source ~/.bashrc
```

安装结束后，可以用RStudio从头运行脚本开展程序分析

将来不需要删除 conda 环境的方法：`# conda env remove -n culturome`