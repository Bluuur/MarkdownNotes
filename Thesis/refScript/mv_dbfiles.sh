#!/bin/bash

# 定义原始目录，包含.dmnd文件
SOURCE_DIR="/beegfs/home/dhyao/data_faa"

# 定义目标目录，父目录下的data_dmnd文件夹
TARGET_DIR="/beegfs/home/dhyao/data_dmnd"

# 检查目标目录是否存在，如果不存在则创建
if [[ ! -d "$TARGET_DIR" ]]; then
    mkdir -p "$TARGET_DIR"
fi

# 进入原始目录
cd "$SOURCE_DIR"

# 找到所有.dmnd文件并移动到目标目录
mv *.dmnd "$TARGET_DIR"

# 输出移动操作的信息
echo "All .dmnd files have been moved to $TARGET_DIR"
