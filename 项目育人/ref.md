``` shell
###1 安装conda等进行实验预准备
##1.1 安装conda
mkdir miniconda
wget https://repo.anaconda.com/miniconda/Miniconda3-py37_4.10.3-Linux-x86_64.sh
bash Miniconda3-latest-Linux-x86_64.sh
#一直按enter，然后按照指引即可安装
##1.2 添加镜像
conda config --add channels conda-forge
conda config --add channels bioconda
site=https://mirrors.tuna.tsinghua.edu.cn/anaconda
conda config --add channels ${site}/cloud/conda-forge/
conda config --add channels ${site}/cloud/bioconda/
##1.3 创建所需环境并安装需要的包
conda create -n culturome python=2.7 -c bioconda -y #注意不要更改环境，此环境运行qiime1和其他包正好
conda activate culturome
conda install qiime=1.9.1 -c bioconda #
conda install graphlan=1.1.3 -c bioconda #
conda install r-base r-dplyr r-optparse r-stringr r-ggplot2 r-pheatmap r-reshape2 -c bioconda 
conda install -c bioconda vsearch #
conda install -c conda-forge r-base=4.0 #
#注意usearch需要自己到官网下载并解压上传到linux中，推荐等级>=10.0且<=11.0
#登录后安装miniconda环境#
##1.4 下载Culturome管道，里面包含所需的脚本在路径Culturome/script下
wget -c https://github.com/YongxinLiu/Culturome/archive/master.zip﻿
unzip master.zip
mv Culturome-master Culturome
##1.5 添加到环境变量。以便直接调用脚本 
chmod +x Culturome/script/*
echo export PATH=`pwd`/Culturome/script:\$PATH >>  ~/.bashrc
#上述路径为自己的script的路径，运行完这一步后重启
##1.6 设置工作目录 ( work directory，`wd`)；修改 `db` 为 `Culturome`的安装目录
# 启动culturome的conda环境
source activate culturome 
conda activate culturome #这两条命令效果是一样的
# 设置工作目录，Mac设置为~/Documents/microbiome/culture
wd=/mnt/c/culture
# 创建工作目录并进入，-p允许建立多级目录
mkdir -p $wd && cd $wd
#设置Culturome位置
db=/mnt/c/microbiome/Culturome
#建议项目所需文件夹
mkdir -p seq temp result
#上述这几步也可省略直接通过调用绝对路径


###2 导入文件到qiime，并制作mappin文件
##2.1 手动制作mainfest文件和mapping文件
#引物信息和mainfest文件及mapping文件格式见附件“毕设\分析\qiime导入数据”
write_mapping_file.pl -i ${db}/script/barcodeF96.txt -b ${db}/script/barcodeR48.txt \
        -F AACMGGATTAGATACCCKG -R ACGTCATCCCCACCTTCC \
        -L ${l} -p 48 -v Rhizosphere -c Root -m TSB -B 1 -s Bean -d WildType \
        -o seq/${l}.txt; done
#也可使用此代码生成mapping文件，但是在导入barcode信息是经常报错，可先试用此代码生成在使用附件中“毕设\软件及包\mapping_get.py”进行修改
#此脚本是自编写，用于在手动贴好引物信息后对其进行修正
#在进行此过程时建议先在excel中做好，再将结果黏贴到txt文件中导入，这样不会报错
##2.2 检查mapping文件
cd ~/miniconda3/pkgs/qiime-1.9.1-np110py27_1/bin/
validate_mapping_file.py -m /beegfs/home/zjxie/bishe/data/en/en_mapping.txt -o /beegfs/home/zjxie/bishe/mapping_check/
#注意这一步生成的结果中虽有会有mapping_correct文件，但并不会帮助修改mapping文件，只是改了一个名字，还得自己手动对mapping文件进行修改
 
###3 质量检测并合并双端序列
##3.1使用qiime进行质量检测
qiime tools import --type ‘SampleData[PairedEndSequencesWithQuality]’ --input-path /public/home/yjpeng/hamo/data/mainfest.tsv --output -path /public/home/yjpeng/hamo/data/manifest_output.qza --input-format PairedEndFastqManifestPhred33V2
##3.2 合并双端测序的结果
qiime demux summarize --i-data ~/hamo/data/manifest_output.qza  --o-visualization ~/hamo/output_all/paired-end_seq_visualized.qzv   
#导出的qzv文件可使用qiime view观看
 
 
###4 样本拆分
### 从这一步开始都需要将根际根内分开制做，但此处只展示根内，将en改成rhi即为根际代码
##4.1 从数据中提取barcodes，用于序列孔来源识别
extract_barcodes.py -f /beegfs/home/zjxie/bishe/data/xzjbean.fq -m /beegfs/home/zjxie/bishe/data/en/en_mapping.txt -c barcode_paired_stitched --bc1_len 7 --bc2_len 7 -a --rev_comp_bc2 -o /beegfs/home/zjxie/bishe/data/en/bean.fq
 #这一步需要根据自己的引物长度进行修改
##4.2 利用barcode与mapping file，将每条序列重命名为板和孔位置
split_libraries_fastq.py -i /beegfs/home/zjxie/bishe/data/en/data_processed/reads.fastq -b /beegfs/home/zjxie/bishe/data/en/data_processed/barcodes.fastq -m /beegfs/home/zjxie/bishe/data/en/en_mapping.txt -q 19 --max_barcode_errors 0 --barcode_type 16 -o /beegfs/home/zjxie/bishe/data/en/reads_exact --phred_offset 33
##4.3 将序列的ID修改为vsearch可识别的格式
cut -f 1 -d '' /beegfs/home/zjxie/bishe/data/en/reads_exact/seqs.fna  | sed 's/ _/./' > /beegfs/home/zjxie/bishe/data/en/reads_exact/qa.fa
 
###5 统计每个板中孔的测序深度
cd /beegfs/home/zjxie/bishe/data/en/
mkdir split
tail -n+16 /beegfs/home/zjxie/bishe/data/en/reads_exact/split_library_log.txt | head -n-4 > /beegfs/home/zjxie/bishe/data/en/split/en_exact.txt
 
#每个孔的测序数量 `result/split/L1.txt.well.pdf/png`
#每个孔的测序数量直方图 `result/split/L1.txt.histogram.pdf/png`
#每个板的测序数量柱状图 `result/split/L1.txt.plate.pdf/png`
#每个图都包括pdf/png两个版本，L1.txt和L1.txt.plate.txt是图的原始数据
 
###6 切除引物序列
vsearch --fastx_filter /beegfs/home/zjxie/bishe/data/en/reads_exact/qa.fa --fastq_stripleft 19 --fastq_stripright 20 -fastaout /beegfs/home/zjxie/bishe/data/en/reads_exact/en_filtered.fa
#这一步的参数需要根据引物长度调整
 
###7 挑选代表序列
##7.1 去冗余：计算每个序列的出现频率，过滤低丰度reads
 vsearch --derep_fulllength /beegfs/home/zjxie/bishe/data/en/reads_exact/en_filtered.fa -relabel Uni --minuniquesize 8 --sizeout --output /beegfs/home/zjxie/bishe/data/en/reads_exact/en_uniques_1.fa
# 查看非冗余序列大小。MB级别较正常，GB级别可能上游出错
##7.2 采用unoise3算法去噪，鉴定ASV
vsearch --cluster_unoise /beegfs/home/zjxie/bishe/data/en/reads_exact/en_uniques.fa --minsize 10 --centroids /beegfs/home/zjxie/bishe/data/en/reads_exact/en_Zotus.fa
##7.3 从头去除嵌合体
vsearch --uchime3_denovo /beegfs/home/zjxie/bishe/data/en/reads_exact/en_Zotus.fa --relabel ASV_ --nonchimeras /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV.fa
 
###8 构建ASV表格
vsearch --usearch_global /beegfs/home/zjxie/bishe/data/en/reads_exact/en_filtered.fa --db /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV.fa --otutabout /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV_table.txt --id 0.97
 
###9 假阳性率控制
##9.1计算阴性和阳性对照的数据量，确定过滤假阳性的阈值
negative_threshold.R --input /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV_table.txt --metadata /beegfs/home/zjxie/bishe/data/en/en_mapping.txt --threshold 1 --output /beegfs/home/zjxie/bishe/data/en/en_fdr.txt
##9.2过滤潜在假阳性孔
otutab_trim.R --input /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV_table.txt  --min_sample_size /beegfs/home/zjxie/bishe/data/en/reads_exact/en_fdr.txt --output /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV_table_fltered.txt
 
###10 物种注释
##10.1 基于RDP训练集16，置信度阈值0.6
vsearch --sintax /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV.fa --db /beegfs/home/zjxie/miniconda3/envs/Culturome/db/rdp_16s_v16_sp.fa -tabbedout /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV.fa.tax -sintax_cutoff 0.6 -strand both
##10.2 制作2列，8列的物种注释表
tax_sum.sh -i /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV.fa.tax -d /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV_table.txt -o /beegfs/home/zjxie/bishe/data/en/reads_exact/
#注意这一步需要安装usearch且为10.0版本，前面使用usearch的步骤都可以用vsearch替代
##10.3 ASV表按属合并
awk 'BEGIN{FS=OFS="\t"} NR==FNR{a[$1]=$7} NR>FNR{print $0,a[$1]}' /beegfs/home/zjxie/bishe/data/en/reads_exact/taxonomy_8.txt /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV_table.txt  | sed '/\t$/d' | sed '1 s/Genus/KO/' > /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV_table7.txt
mat_gene2ko.R -i /beegfs/home/zjxie/bishe/data/rhi/reads_exact/rhi_ASV_table7.txt -n 100 -o /beegfs/home/zjxie/bishe/output_all/rhi/genus/
 
###11 
identify_isolate.R \
        --input result/ASV_table.txt \
        --genus result/genus.count \
        --taxonomy result/taxonomy_8.txt \
        --output result/isolate
 
###12 构建进化分支树
##12.1 准备graphlan的输入文件
 
/beegfs/home/zjxie/miniconda3/envs/Culturome/script/graphlan_prepare.R --input /beegfs/home/zjxie/bishe/data/en/reads_exact/en_ASV_table.txt --taxonomy /beegfs/home/zjxie/bishe/data/en/reads_exact/taxonomy_8.txt --abundance 0 --number 150 --output /beegfs/home/zjxie/bishe/output_all/en/graphlan/
##12.2 构建进化树
graphlan_plot.sh -i ~/miniconda3/envs/Culturome/ -o /beegfs/home/zjxie/bishe/output_all/en/graphlan/
#注意-i参数后面是Culturome-master文件夹的路径
 
```
