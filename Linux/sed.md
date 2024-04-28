# `sed`

## 基础语法

```bash
sed [-hnV][-e<script>][-f<script文件>][文本文件]
```

### 参数

+ `-e<script>` 或 `--expression=<script>`  以选项中指定的 script 来处理输入的文本文件。
+ `-f<script文件>` 或 `--file=<script文件>` 以选项中指定的 script 文件来处理输入的文本文件。
+ `-h` 或 `--help` 显示帮助。
+ `-n` 或 `--quiet` 或 `--silent` 仅显示 script 处理后的结果。
+ `-V` 或 `--version` 显示版本信息。

### 动作

```
a ：新增，a 的后面可以接字串，而这些字串会在新的一行出现（目前的下一行）；
c ：取代，c 的后面可以接字串，这些字串可以取代 n1, n2 之间的行；
d ：删除，d 后面通常不接任何东西；
i ：插入，i 的后面可以接字串，而这些字串会在新的一行出现(目前的上一行)；
p ：打印，亦即将某个选择的数据印出。通常 p 会与参数 sed -n 一起运行；
s ：取代，通常这个 s 的动作可以搭配正则表达式。
```

## 实例

### 添加

+ 原文件

```bash
$ cat testfile #查看testfile 中的内容  
HELLO LINUX!  
Linux is a free unix-type opterating system.  
This is a linux testfile!  
Linux test 
Google
Taobao
Runoob
Tesetfile
Wiki
```

以下命令在文件的第 4 行后添加一行，并将结果输出到 stdout：

```bash
sed -e 4a\newLine testfile 
```

+ `-e` 后的 `4a\newLine` 中：
  + `4` 表示第 4 行
  + `\` 表示换行
    + 添加多行可以用 `\` 分隔
  + `a` 表示 「添加」操作
  + `newLine` 是添加的内容

最后输出的结果为：

```bash
$ sed -e 4a\newLine testfile 
HELLO LINUX!  
Linux is a free unix-type opterating system.  
This is a linux testfile!  
Linux test 
newLine
Google
Taobao
Runoob
Tesetfile
Wiki
```

### 以行为单位的新增 / 删除

```bash
$ nl testfile | sed '2,5d'
     1  HELLO LINUX!  
     6  Taobao
     7  Runoob
     8  Tesetfile
     9  Wiki
```

> `nl` 命令的作用是显示行号
>
> 	-b ：指定行号指定的方式，主要有两种：
> 	    -b a ：表示不论是否为空行，也同样列出行号(类似 cat -n)；
> 	    -b t ：如果有空行，空的那一行不列出行号(默认值)；
> 	-n ：列出行号表示的方法，主要有三种：
> 	    -n ln ：行号在萤幕的最左方显示；
> 	    -n rn ：行号在自己栏位的最右方显示，且不加 0 ；
> 	    -n rz ：行号在自己栏位的最右方显示，且加 0 ；
> 	-w ：行号栏位的占用的位数。
> 	-p ：在逻辑定界符处不重新开始计算。
>

+ 命令中的 `'2,5d'`
  + `2,5` 表示对 2 - 5 行操作
  + `d` 表示删除
+ 对行的操作中：
  + `<num>` 直接输入数字表示直接根据行号定位
  + `<first>~<step>` 从 `first` 开始，步长为 `step`
  + `<rowNum>i` 定位到第 `rowNum` 的前一行
  + `$` 表示最后一行
  + `/<regex>/` 正则表达式放在 `/.../` 内
  + `<rowNum>,+<num>` 定位从 `rowNum` 行起，到其后 `num` 行

+ 可以省略命令中的 `-e`，但是 `sed` 后的动作需要放在 `'...'` 两个单引号内。

### 以行为单位的替换 / 显示

将 2 -5 行的内容替换为 "No 2-5 number"（替换 2 - 5 行的全部内容，而不是将 2 - 5 行每行的内容替换为指定字符串）

```bash
$ nl testfile | sed '2,5c No 2-5 number'
     1  HELLO LINUX!  
No 2-5 number
     6  Taobao
     7  Runoob
     8  Tesetfile
     9  Wiki
```

---

仅列出 testfile 文件内的第 5 - 7 行：

```bash
$ nl testfile | sed -n '5,7p'
     5  Google
     6  Taobao
     7  Runoob
```

### 数据的搜寻并执行命令

搜索 testfile，找到 `oo` 对应的行，执行后面花括号中的一组命令，每个命令之间用分号分隔，这里把 `oo` 替换为 `kk`，再输出这行：

```bash
$ nl testfile | sed -n '/oo/{s/oo/kk/;p;q}'  
     5  Gkkgle
```

> `q` 表示退出 sed

### 数据的查找与替换

```bash
sed 's/<oldStr>/<newStr>/g' # 由于没有指定行号，这里只会替换第一次出现的字符串
```

`g` 标识符表示全局查找替换，使 sed 对文件中所有符合的字符串都被替换，修改后内容会到标准输出，不会修改原文件：

```bash
sed -e 's/oo/kk/g' testfile
```

使用 `i` 标识符可以使 sed 修改文件：

```bash
sed -i 's/oo/kk/g' testfile
```

批量操作当前目录下以 `test` 开头的文件：

```bash
sed -i 's/oo/kk/g' ./test*
```

### 多点编辑

一条 sed 命令，删除 testfile 第三行到末尾的数据，并把 HELLO 替换为 RUNOOB :

```bash
$ nl testfile | sed -e '3,$d' -e 's/HELLO/RUNOOB/'
     1  RUNOOB LINUX!  
     2  Linux is a free unix-type opterating system.  
```

