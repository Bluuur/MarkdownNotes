# Perl 基础语法

[toc]

## Hello world

### 交互式编程

可以直接在命令行使用 `-e` 选项运行 Perl 程序。

```shell
perl -e 'print "Hello World\n"'
```

单引号内是 Perl 语句。

### 脚本式编程

Perl 脚本的扩展名一般是 `.pl`，文件名可以包含数字、 符号和字母，但不能包含空格。

```perl
#!/usr/bin/perl
 
# 输出 "Hello, World"
print "Hello, world\n";
print ("Hello, world\n"); # Perl 可以用括号来输出字符串
```

运行 Perl 脚本前需要确保文件有可执行权限，可以修改文件权限为 0755：

```shell
chmod 0755 hello.pl
```

## 注释

### 单行注释

使用 `#` 进行单行注释。

### 多行注释

使用 POD(Plain Old Documentations) 来进行多行注释。

```perl
#!/usr/bin/perl
 
# 这是一个单行注释
print "Hello, world\n";
 
=pod 注释
这是一个多行注释
这是一个多行注释
这是一个多行注释
这是一个多行注释
=cut
```

## 单引号和双引号

Perl 会正常解析双引号内的转义字符与变量，单引号内的内容会按原样输出。

```perl
#!/usr/bin/perl
 
print "Hello, world\n";    # 双引号 输出 Hello, world 并换行
print 'Hello, world\n';    # 单引号 输出 Hello, world\n
```

用单引号定义字符串可以使用多行文本：

```perl
#!/usr/bin/perl 

$var='这是一个使用

多行字符串文本

的例子';

print($var);

```

## Here 文档

Perl 中的 here 文档又称作 heredoc、here 字串或 here 脚本，是可以在 Shell 命令行和程序语言（像 Perl、PHP、Python 等）里定义一个字串的方法。

语法：

```perl
#!/usr/bin/perl

$heredoc = <<"EOF"; # 开始 here 文档，标识符为 EOF
...
文档内容...

EOF # 结束 here 文档，标识符需要与前面的一致
```

## 获取输入

`<STDIN>` 表示从标准输入中读取内容，如果没有，则阻塞。一般情况下，`<STDIN>` 中读取到的结果中都自带换行符。

可以用 `chomp()` 函数去除字符串末尾的换行符。

+ `chomp()` 是安全版本的 `chop()`
  + `chop()` 函数会删除标量的最后一个字符或数组中每个元素的最后一个字符，并返回修改后的值。
  + `chomp()` 函数只在标量行末字符为换行符的时候才进行删除操作，返回删除后的字符数目。
