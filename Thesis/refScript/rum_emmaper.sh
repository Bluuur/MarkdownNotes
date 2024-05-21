#!/bin/bash

# 设置包含FAA文件的目录路径
FASTA_DIR="/beegfs/home/dhyao/data_faa"

# 设置emapper的输出目录
PROKKA_OUTDIR="/beegfs/home/dhyao/empper_output"

# 定义CPU核心数
cpu_cores=12

# 创建emapper输出目录，如果它还不存在
mkdir -p "$PROKKA_OUTDIR"
cd "$PROKKA_OUTDIR"
# 遍历FASTA目录中的所有FASTA文件
for fasta_file in "$FASTA_DIR"/*.faa; do
    # 获取不带路径的文件名
    base_name=$(basename "$fasta_file" .faa)

    # 运行emapper程序
    emapper.py -i "$fasta_file" --output "$base_name" -m diamond --cpu "$cpu_cores" &

    # 检查emapper是否成功执行
    if [ $? -eq 0 ]; then
        echo "Annotation of $fasta_file completed successfully."
    else
        echo "Error annotating $fasta_file. Check $output_prefix.err for details."
    fi
done

echo "All FASTA files have been annotated with emapper."
