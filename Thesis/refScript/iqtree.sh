#!/bin/bash
#SBATCH -p normal1#运行模式，可不更改。
#SBATCH -n 16#用的节点数目，
#SBATCH -o download.out#输出文件的名字
#SBATCH -e download.err#若报错，报错文件的名字，
iqtree -s core_gene_alignment.fasta -nt 16
