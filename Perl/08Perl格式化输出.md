# 格式化输出

[toc]

## 语法

```perl
format <formatName> = # 定义格式名
<fieldline> # 格式行 规定了输出格式 并有 @ ^ < > | 等字符占位
<values> # 数据行，会被放到占位符的地方
<fieldline>
<values>
. # 结束符号
```

|    格式    |   值域含义   |
| :--------: | :----------: |
|   `@<<<`   |  左对齐输出  |
|   `@>>>`   |  右对齐输出  |
|   `@|||`   |  中对齐输出  |
| `@##.##  ` | 固定精度数字 |
|    `@*`    |   多行文本   |

```perl
#!/usr/bin/perl
 
$text = "google runoob taobao";
format STDOUT = # 指定输出到 STDOUT
first: ^<<<<<  # 格式行 左边对齐，字符长度为6
    $text # 数据行
second: ^<<<<< # 左边对齐，字符长度为6
    $text
third: ^<<<< # 左边对齐，字符长度为5，taobao 最后一个 o 被截断
    $text  
.
write
```

## 格式变量

### `$~` (`$FORMAT_NAME`)

格式名称



### `$^` (`$FORMAT_TOPNAME`)

表头格式名字

+ 
