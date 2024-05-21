#!/bin/bash

# 设置源文件夹路径
SOURCE_DIR="/beegfs/home/dhyao/data"

# 检查源文件夹是否存在
if [ ! -d "$SOURCE_DIR" ]; then
    echo "Error: Source directory does not exist."
    exit 1
fi

# 切换到源文件夹
cd "$SOURCE_DIR"

# 查找并重命名所有 .fna 文件
for fna_file in *.fna; do
    if [ -f "$fna_file" ]; then
        # 构建新的文件名
        fasta_file="${fna_file%.fna}.fasta"
        
        # 重命名文件
        mv "$fna_file" "$fasta_file"
        echo "Renamed $fna_file to $fasta_file"
    fi
done

echo "All .fna files have been renamed to .fasta."
