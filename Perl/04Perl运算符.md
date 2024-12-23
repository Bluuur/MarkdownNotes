# 运算符

[toc]

## 算数运算符

求幂为 `**`

## 比较运算符

+ `<=>`
  + 左边小于右边：return -1
  + 左边等于右边：return 0
  + 左边大于右边：return 1

### 字符串比较

| 字符串运算符 | 数学运算符 |
| :----------: | :--------: |
|      lt      |     <      |
|      gt      |     >      |
|      le      |     <=     |
|      ge      |     >=     |
|      eq      |     ==     |
|      ne      |     !=     |
|     cmp      |    <=>     |

## 逻辑运算符

`not` "`!`"

## 赋值运算符

`**=` "^="

## 位运算符

### `&`

```
$a		=	0011 1100
$b		=	0000 1101
-----------------^^------
$a & $b	=	0000 1100	output: 12(dec)
```

### `|`

```
$a		=	0011 1100
$b		=	0000 1101
--------------^^-^^-^----
$a | $b	=	0011 1101	output: 61(dec)
```

### `^`

异或

```
$a		=	0011 1100
$b		=	0000 1101
--------------^^----^----
$a ^ $b	=	0011 0001	output: 49(dec)
```

### `~`

反码

```
$a	= 0011 1100
~$a	= 1100 0011
```

### `<<`

二进制左移，每左移一位，大小 $\times 2$

```
$a		= 0011 1100
$a << 2	= 1111 0000
```

### `>>`

二进制右移，每右移一位，大小 $\times \frac{1}{2}$

```
$a		= 0011 1100
$a >> 2	= 0000 1111
```

## 引号运算符

| 运算符  |        描述        |              实例              |
| :-----: | :----------------: | :----------------------------: |
| `q{ }`  | 为字符串添加单引号 |   `q{abcd}` 结果为 `'abcd'`    |
| `qq{ }` | 为字符串添加双引号 |   `qq{abcd}` 结果为 `"abcd"`   |
| `qx{ }` | 为字符串添加反引号 | `qx{abcd}` 结果为 `` `abcd` `` |

添加反引号会将反引号的内容在 UNIX 下运行。

## 其他运算符

| 运算符 |               描述               |                          实例                          |
| :----: | :------------------------------: | :----------------------------------------------------: |
|  `.`   | 点号 (`.`) 用于连接两个字符串。  | 如果 `$a="run", $b="oob"` ， `$a.$b` 结果为 `"runoob"` |
|  `x`   | `x` 运算符返回字符串重复的次数。 |               `('-' x 3)` 输出为 `---`。               |
|  `..`  |       `..` 为范围运算符。        |           `(2..5)` 输出结果为 `(2, 3, 4, 5)`           |
|  `->`  |         指定一个类的方法         |       `$obj->$a` 表示对象 `$obj` 的 `$a` 方法。        |