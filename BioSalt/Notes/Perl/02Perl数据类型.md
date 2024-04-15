# 数据类型

[toc]

Perl 是一种弱类型语言，所以变量不需要指定类型，Perl 解释器会根据上下文自动选择匹配类型。

+ Perl 有三个基本的数据类型：标量、数组、哈希。

  + 标量

    + 这种数据类型可以是数据、字符串、浮点数，不作严格区分，使用时在变量名前加 `$`，表示是标量。

    + ```perl
      $num = 123;
      $str = "a string";
      ```

  + 数组

    + 数组变量以字符 `@` 开头，下标从 0 开始。

    + ```perl
      @arr = (1, 2, 3);
      ```

  + 哈希

    + 无序键值对集合，可以使用 key 获取 value。哈希变量以 `%` 开头。

    + ```perl
      %h = ('a' => 1, 'b' => 2); 
      ```

## 变量

不同类型的变量可以有相同的名称，例如 $foo 和 @foo 是两个不同的变量。

### 哈希变量

访问哈希值，可以使用 `$hash{key}` 格式访问。

```perl
#!/usr/bin/perl
 
%data = ('google', 45, 'runoob', 30, 'taobao', 40);
 
print("\$data{'google'} = $data{'google'}\n");
print("\$data{'runoob'} = $data{'runoob'}\n");
print("\$data{'taobao'} = $data{'taobao'}\n");
```

输出：

```
$data{'google'} = 45
$data{'runoob'} = 30
$data{'taobao'} = 40
```

### 变量上下文

将同一个变量赋值给不同数据类型的变量，会有不同的效果。

Perl 解释器会根据上下文来决定变量的类型。实例如下：

```perl
#!/usr/bin/perl
 
@names = ('google', 'runoob', 'taobao');
 
@copy = @names;   # 复制数组
$size = @names;   # 数组赋值给标量，返回数组元素个数
 
print("名字为 : @copy\n");
print("名字数为 : $size\n");
```

## 标量

### 标量运算

```perl
#!/usr/bin/perl
 
$str = "hello" . "world";       # 字符串连接
$num = 5 + 10;                  # 两数相加
$mul = 4 * 5;                   # 两数相乘
$mix = $str . $num;             # 连接字符串和数字
 
print("str = $str\n");
print("num = $num\n");
print("mix = $mix\n");
```

#### 字符串连接

使用 `.` 连接两个字符串，或连接字符串与数字。

#### 多行字符串

多行字符串可以使用单引号 `''` 或者 heredoc 来实现。

```perl
#!/usr/bin/perl
 
$string = '
这是
多行
字符串
';
 
print(<<EOF;
这是
多行
字符串
EOF);
```

## 特殊字符

1. `__FILE__` 表示当前执行脚本的文件名
2. `__LINE__` 表示当前执行脚本的行号
3. `__PACKAGE__` 表示当前执行脚本的包名

这些特殊字符不能写在字符串中。

## v 字符串

用 ASCII 码定义字符串。以 `v` 开头，每个字符之间用 `.` 分隔。

```perl
#!/usr/bin/perl
 
$smile  = v9786;
$foo    = v102.111.111;
$martin = v77.97.114.116.105.110; 
 
print("smile = $smile\n");
print("foo = $foo\n");
print("martin = $martin\n");
```

```
Wide character in print at test.pl line 7.
smile = &#x263a;
foo = foo
martin = Martin
```

## 数组

### 创建数组

数组变量以 `@` 符号开始，元素放在括号内，也可以以 `qw` 开始定义数组。

```perl
@array = (1, 2, 'Hello'); # 使用逗号分隔，放在圆括号内
@array = qw/这是 一个 数组/; # 空格或换行分隔，放在双斜线内，也可以放在任意一对符号内
```

### 数组序列号

可以以序列输出数组，格式为 `<begin>..<end>`。

```perl
#!/usr/bin/perl
 
@var_10 = (1..10);
@var_20 = (10..20);
@var_abc = ('a'..'z');
 
print("@var_10\n");   # 输出 1 到 10
print("@var_20\n");   # 输出 10 到 20
print("@var_abc\n");  # 输出 a 到 z
```

### 数组大小

使用 `scalar` 查看数组大小。返回的是数组的物理大小（容量），而不是元素个数。

```perl
@array = (1,2,3);
print("数组大小: ",scalar @array,"\n");
```

```perl
#!/uer/bin/perl
 
@array = (1,2,3);
$array[50] = 4;
 
$size = @array;
$max_index = $#array;
 
print("数组大小:  $size\n)";
print("最大索引: $max_index\n");
```

### 添加和删除数组元素

1. `push(@ARRAY, LIST)` 将列表的值放到数组的末尾
2. `pop(@ARRAY)` 删除数组的最后一个值
3. `shift(@ARRAY)` 弹出数组第一个值，并返回它。数组的索引值也依次减一。
4. `unshift(@ARRAY, LIST)` 将列表放在数组前面，并返回新数组的元素个数。

> 以上这些不需要索引值的操作方式比十四索引值的操作更快。

### 切割数组

```perl
#!/usr/bin/perl
 
@sites = qw/google taobao runoob weibo qq facebook 网易/;
 
@sites2 = @sites[3, 4, 5];
 
print "@sites2\n";
```

同样，连续的索引可以使用 `..` 指定范围：

```perl
#!/usr/bin/perl
 
@sites = qw/google taobao runoob weibo qq facebook 网易/;
 
@sites2 = @sites[3..5];
 
print("@sites2\n");
```

### `splice()` 替换数组元素

语法：

```perl
splice(@ARRAY, OFFSET, LENGTH, LIST)
```

+ 在列表上下文，函数返回溢出后的数组元素。
+ 在标量上下文，函数返回溢出的最后一个元素。
+ 如果无元素溢出，返回 `UNDEF`。

### `split()` 分割字符串

语法：

```perl
split(PATTERN, STR, LIMIT)
```

+ `PATTERN`：分隔符，默认为空格。
+ `STR`：指定字符串。
+ `LIMIT`：如果指定该参数，则返回该数组的元素个数。

### `join()` 连接数组为字符串

语法：

```perl
join(CONNECTER, LIST)
```

+ `CONNECTER`：连接符
+ `LIST`：列表或数组

### `sort()` 数组排序

语法：

```perl
sort(SUBROUTINE, LIST)
```

`sort()` 按照 ASCII 码顺序排序。在对数组进行排序时最好先将每个元素转换为小写后再排序。

### `$[` 特殊变量

`$[` 表示数组的第一索引值，一般为 0. 可以通过对 `$[` 赋值来手动设置数组第一索引值。

一般情况不建议使用特殊变量 `$[`，在新版 Perl 中，该变量已废弃。

### 合并数组

```perl
# 数组元素是以逗号分隔的，可以使用逗号来合并数组
@numbers = (1,3,(4,5,6));

# 也可以嵌套数组合并
@odd = (1,3,5);
@even = (2, 4, 6);

@numbers = (@odd, @even);
```

### 从列表中选择元素

可以直接把列表当作数组操作

```perl
@arr = (1..5)[1..3];
print("arr: @arr\n"); # 这里会输出 2 3 4
```

## 哈希

### 创建哈希

#### 对  `key` 设置 `value`

```perl
$data{'google'} = 'google.com';
$data{'runoob'} = 'runoob.com';
$data{'taobao'} = 'taobao.com';
```

#### 通过列表设置

```perl
%data = (
    'google', 'google.com',
    'runoob', 'runood.com',
    'taobao', 'taobao.com'
);
```

使用 `=>`：

```perl
%data = ('google'=>'google.com', 'runoob'=>'runoob.com', 'taobao'=>'taobao.com');
```

使用 `-` 代替引号：

```perl
%data = (-google=>'google.com', -runoob=>'runoob.com', -taobao=>'taobao.com');
```

使用 `-` 代替引号时，key 中不能出现空格。读取元素：

```perl
$val = $data{-google}
$val = $data{-runoob}
```

### 以数组方式获取哈希 value

```perl
#!/uer/bin/perl
 
 
%data = (-taobao => 45, -google => 30, -runoob => 40);
 
@array = @data{-taobao, -runoob};
 
print("Array : @array\n");
```

### 读取哈希的 key 和 value

#### 读取所有 key

使用 `keys()` 函数读取所有哈希 key：

```perl
keys(%HASH);
```

#### 读取所有 value

使用 `values()` 函数读取所有 value：

```perl
values(%HASH);
```

### 检测元素是否存在

如果在哈希中读取不存在的 key/value 对，会返回 `undefined` 值，并且在执行时会有警告提醒。

可以使用 `exists()` 函数来判断 key 是否存在：

```perl
#!/usr/bin/perl
 
%data = (
	'google'=>'google.com',
	'runoob'=>'runoob.com',
	'taobao'=>'taobao.com'
);
 
if (exists($data{'facebook'})) 
   print("facebook 的网址为 $data{'facebook'} \n");
} else {
   print("facebook 键不存在 \n");
}
```

### 获取哈希大小

哈希大小为元素的个数，可以通过先获取 key 或 value 的所有元素数组，在计算数组元素多少来获取哈希的大小：

```perl
#!/usr/bin/perl
 
%data = (
	'google'=>'google.com',
	'runoob'=>'runoob.com',
	'taobao'=>'taobao.com'
);

@keys = keys %data;
$size = @keys;
print("1 - 哈希大小: $size\n");
 
@values = values %data;
$size = @values;
print("2 - 哈希大小: $size\n");
```

### 添加或删除元素

添加 key/value 可以通过赋值完成：

```perl
$data{'facebook'} = 'facebook.com';
```

使用 `delete()` 函数删除元素：

```perl
delete($data{'taobao'});
```

### 迭代哈希

可以使用 `foreach` 和 `while` 迭代哈希：

```perl
%data = (
	'google'=>'google.com',
	'runoob'=>'runoob.com',
	'taobao'=>'taobao.com'
);

foreach $key (keys %data) {
	print "$data{$key}\n";
}
```

使用 `while`：

```perl
while(($key, $value) = each(%data)){
    print "$data{$key}\n";
}
```

