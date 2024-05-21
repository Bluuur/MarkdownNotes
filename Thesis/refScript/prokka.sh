#!/bin/bash

# 设置包含FASTA文件的目录路径
FASTA_DIR="/beegfs/home/dhyao/data"

# 设置Prokka的输出目录
PROKKA_OUTDIR="/beegfs/home/dhyao/prokka_output"

# 创建Prokka输出目录，如果它还不存在
mkdir -p "$PROKKA_OUTDIR"

# 遍历FASTA目录中的所有FASTA文件
for fasta_file in "$FASTA_DIR"/*.fasta; do
    # 获取不带路径的文件名
    base_name=$(basename "$fasta_file" .fasta)
    
    # 设置Prokka输出目录中的文件前缀
    output_prefix="$PROKKA_OUTDIR/$base_name"
    
    # 运行Prokka注释
    prokka \
        --cpus 8 \
        --outdir "$output_prefix" \
        --prefix "$base_name" \
        --kingdom Bacteria \
        "$fasta_file"
    
    # 检查Prokka是否成功执行
    if [ $? -eq 0 ]; then
        echo "Annotation of $fasta_file completed successfully."
    else
        echo "Error annotating $fasta_file. Check $output_prefix.err for details."
    fi
done

echo "All FASTA files have been annotated with Prokka."
