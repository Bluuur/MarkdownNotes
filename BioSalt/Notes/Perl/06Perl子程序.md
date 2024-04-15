# 子程序（函数）

[toc]

## 定义子程序

```perl
#!/usr/bin/perl
 
# 函数定义
sub Hello{
   print "Hello, World!\n";
}
 
# 函数调用
Hello();
```

> 定义时不需要形式参数列表

## 向子程序传递参数

在函数体内，`@_` 为参数列表，是一个数组，`@_[0]` 为该函数的第一个参数。Perl 默认以引用的形式调用参数。

向子程序传递数组和哈希时，需要以引用的方式传递（Perl 中，向子程序传递参数默认是按值传递的）。

## 子程序返回值

使用 `return` 语句返回函数值。

如果没有 `return` 语句，会返回子程序最后一行语句。

## 私有变量

默认情况下，Perl 中的所有变量都是全局变量，变量可以在任何地方调用。使用 `my` 关键词可以创建私有变量，作用域与 Java 中的变量相同。

## 变量临时赋值

```perl
$str = "Hello, world!";

sub printBioSalt {
    local $str;
    print("local str 1: $str\n"); # 未赋值
    $str = "Hello, bio salt!";
    print("local str 2: $str\n");
}

printBioSalt();
print("$str\n");
```

结果：

```
local str 1: 
local str 2: Hello, bio salt!
Hello, world!
```

