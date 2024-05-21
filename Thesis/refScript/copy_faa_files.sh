
#!/bin/bash

# 创建一个新的目录来存放.faa文件，如果它不存在的话
mkdir -p faa_data

# 遍历当前目录下每个子目录
for dir in */; do
    # 检查目录是否为空
    if [ -d "$dir" ]; then
        # 找到当前目录下所有.faa文件
        for file in "$dir"*.faa; do
            # 检查文件是否存在
            if [ -f "$file" ]; then
                # 复制文件到faa_data目录下
                cp "$file" faa_data/
                echo "Copied $file to faa_data/"
            fi
        done
    fi
done

echo "All .faa files have been copied to faa_data/"
