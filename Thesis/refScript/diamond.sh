#!/bin/bash

# 设置目录变量
DATA_GENE_DIR="/beegfs/home/dhyao/data_gene2"
DATA_DMND_DIR="/beegfs/home/dhyao/data_dmnd"

# 遍历data_gene目录下的所有文件
for GENE_FILE in "$DATA_GENE_DIR"/*; do
    # 获取基因文件的基名（无路径和后缀）
    GENE_BASENAME=$(basename "$GENE_FILE" .fasta)

    # 遍历data_dmnd目录下的所有.dmnd文件
    for DMND_FILE in "$DATA_DMND_DIR"/*.dmnd; do
        # 获取数据库文件的基名（无路径和后缀）
        DMND_BASENAME=$(basename "$DMND_FILE" .dmnd)

        # 定义输出文件名
        OUT_FILE="${DMND_BASENAME}_${GENE_BASENAME}.txt"

        # 运行diamond比对，并将结果输出到定义的文件中
        # 这里假设diamond的命令格式为 diamond view -a <alignments-file> -o <output-file>
        # 请根据你的实际需求调整diamond命令和参数
        ~/diamond blastp --db "$DMND_FILE" -q "$GENE_FILE" -o "$OUT_FILE"
    done
done

echo "Diamond比对完成。"
