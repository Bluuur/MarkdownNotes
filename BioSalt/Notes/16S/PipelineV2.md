# 16s 扩增子分析流程

[toc]

## 环境安装

### 目录结构

```
amplicon/
├── reads	# 存放序列文件
├── result	# 存放结果文件
└── tmp		# 存放中间文件
```

### R package

```R
install.packages("devtools")

if (!requireNamespace("BiocManager", quitely = TRUE))
    install.packages("BiocManager")
BiocManager::install("edgeR")

library(devtools)
devtools::install_github("microbiota/amplicon")
```

### 其他软件

存放路径：

```
/users/zhangzd/soft/
├── conda
├── csvtk
├── fastp
├── rush
├── seqkit
├── taxonkit
├── usearch
└── vsearch
```

### qiime2-amplicon conda 环境

解压  至 conda/envs/ 目录下

### STAMP

http://kiwi.cs.dal.ca/Software/STAMP

```shell
pip install STAMP
```

## 数据预处理

### 双端序列合并

```shell
vsearch 
	-fastq_mergepairs reads/WT1_1.fq.gz \
    -reverse reads/WT1_2.fq.gz \
	-fastqout temp/WT1.merged.fq 
	-relabel WT1.
	

cd reads
for file in *1.fq.gz; do
    sample_name=$(basename -s _1.fq.gz "$file")
    forward_reads="${file}"
	reverse_reads="${sample_name}_2.fq.gz"
	output_file="../temp/${sample_name}.merged.fq"
    vsearch 
    	-fastq_mergepairs "$forward_reads" \
        -reverse "$reverse_reads" \
        -fastqout "$output_file" \
        -relabel "${sample_name}."
done
cd ..

```



### 质控

### 切除引物和 Barcode

## 去噪 ASV

### 数据去冗余 去噪

### 去除嵌合体