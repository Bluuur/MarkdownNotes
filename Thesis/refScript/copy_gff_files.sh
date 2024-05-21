#!/bin/bash

# 目标目录，如果没有则创建
TARGET_DIR="./data_gff"
if [ ! -d "$TARGET_DIR" ]; then
  mkdir "$TARGET_DIR"
fi

# 要遍历的目录，此处假设为脚本所在目录的上一级目录
PARENT_DIR="/beegfs/home/dhyao/prokka_output"

# 遍历PARENT_DIR下的所有文件夹
for DIR in "$PARENT_DIR"/*; do
  if [ -d "$DIR" ]; then
    # 检查目录中是否存在.gff文件
    if ls "$DIR"/*.gff 1> /dev/null 2>&1; then
      # 复制.gff文件到目标目录
      cp "$DIR"/*.gff "$TARGET_DIR/"
      echo "Copied .gff files from $DIR to $TARGET_DIR"
    else
      echo "No .gff files found in $DIR"
    fi
  fi
done
