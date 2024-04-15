# 引用

[toc]

## 创建引用

```perl
$scalarref = \$foo;     # 标量变量引用
$arrayref  = \@ARGV;    # 列表的引用
$hashref   = \%ENV;     # 哈希的引用
$coderef   = \&handler; # 子过程引用
$globref   = \*foo;     # GLOB句柄引用
```

### 匿名引用

#### 匿名数组引用

使用方括号 `[]` 定义。

```perl
$aref = [1, "foo", undef, 13];
```

`$aref` 变量的数据类型是「数组引用」。

---

「实名数组引用」：

```perl
@arr = (1, "foo", undef, 13);
$aref = \@arr;
```

匿名数组的元素可以是匿名数组，可以通过这种方法创建多维数组。

```perl
my $aref = [
        [1, 2, 3],
        [4, 5, 6],
        [7, 8, 9],
]
```

#### 匿名哈希引用

```perl
$href= { APR =>4, AUG =>8 };
```

#### 匿名子程序引用

```perl
$coderef = sub { print "Runoob!\n" };
```

## 取消引用

根据类型，使用 `$`，`@` 或 `%` 取消引用：

```perl
#!/usr/bin/perl
 
$var = 10;
 
# $r 引用 $var 标量
$r = \$var;
 
# 输出本地存储的 $r 的变量值
print "$var 为 : ", $$r, "\n";
 
@var = (1, 2, 3);
# $r 引用  @var 数组
$r = \@var;
# 输出本地存储的 $r 的变量值
print "@var 为: ",  @$r, "\n";
 
%var = ('key1' => 10, 'key2' => 20);
# $r 引用  %var 哈希
$r = \%var;
# 输出本地存储的 $r 的变量值
print "\%var 为 : ", %$r, "\n";
```

