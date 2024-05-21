#!/bin/bash

# 目录路径，包含所有的.faa文件
DATA_DIR="/beegfs/home/dhyao/data_faa"

# 进入数据目录
cd "$DATA_DIR"

# 遍历目录中的每个.faa文件
for faa_file in *.faa; do
    # 检查文件是否确实存在，避免空目录问题
    if [[ -f "$faa_file" ]]; then
        # 获取文件名（不包含扩展名）作为数据库的名称
        db_name=$(basename "$faa_file" .faa)
        
        # 使用diamond makedb命令创建数据库
        # 这里假设你已经安装了Diamond，并且其可执行文件在系统的PATH中
       ../diamond makedb --in "$faa_file" --db db
        
        echo "Database for $faa_file has been created."
    else
        echo "No .faa files found in $DATA_DIR"
        break
    fi
done
