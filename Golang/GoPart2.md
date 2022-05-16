# Go 语言入门 2

## 数据类型

Go 是静态类型语言, 一旦某个变量被声明, 那么其类型不能再被改变

### 浮点型变量

#### 声明

+ `float64` 为双精度浮点类型
  + 64 bit, 占用 8 byte 内存
  + Java 中的 `double`
  + `math` 包中的函数操作均为 `float64` 类型
+ `float32` 为单精度浮点类型
  + 占用 4 byte 内存

+ 以下三个语句效果相同
+ 只要数字含有小数, 那么就是 `float64` 类型

```go
days := 365.2425
var days = 365.2425
var days float64 = 365.2425
```

+ 如果是整数想要声明为浮点型, 则需要指定类型为 `float64`

```go
var days float64 = 30
```

#### 打印精度

+ 使用 `Print` 或 `Println` 打印浮点类型的时候, 默认的行为是尽可能的多显示几位小数

+ 如果需要指定显示的位数, 需要使用 `Printf` 函数和 `%f` 格式化动词

  + ```go
    package main
    
    import "fmt"
    
    func main() {
    	oneThird := 1.0 / 3
    	fmt.Println(oneThird)
    
    	// %v 可以跟任意数据类型
    	fmt.Printf("%v\n", oneThird)
    
    	fmt.Printf("%f\n", oneThird)
    
    	fmt.Printf("%.3f\n", oneThird)
    
        // 不足8补齐空格(小数点计算在内)
    	fmt.Printf("%8.3f\n", oneThird)
    	fmt.Printf("%-8.3f\n", oneThird)
        
        // 用 0 代替空格
        fmt.Printf("%08.3f\n", oneThird)
    }
    ```

  + ```
    0.3333333333333333
    0.3333333333333333
    0.333333
    0.333
       0.333<-
    0.333   <-
    0000.333
    # 箭头为手动添加, 用于指示空格位置
    ```

#### 运算精度

```go
package main

import "fmt"

func main() {
	oneThird := 1.0 / 3
	fmt.Println(oneThird)

	fmt.Println(oneThird + oneThird + oneThird)
	
	num := 0.1
	num += 0.2
	fmt.Println(num)
}
```

```
0.3333333333333333
1
0.30000000000000004
```

+ 可以看出, 浮点类型不适合用于金融计算
+ 为了尽量最小化舍入错误, 建议先乘后除

```go
package main

import "fmt"

func main() {
	celsius := 21.0
	fmt.Println((celsius/5.0*9.0)+32, "°F")
	fmt.Println((9.0/5.0*celsius)+32, "°F")

	fahrenheit := (celsius * 9.0 / 5.0) + 32.0
	fmt.Println(fahrenheit, "°F")
}

```

```
69.80000000000001 °F
69.80000000000001 °F
69.8 °F
```

#### 比较浮点类型

可以使用 `math/Abs` 

```go
package main

import (
	"fmt"
	"math"
)

func main() {
	num := 0.1
	num += 0.2
	fmt.Println(num == 0.3)

	fmt.Println(math.Abs(num-0.3) < 0.0001)
}
```

```
false
true
```

### 整数型变量

+ Go 中有 10 种整数类型
  + 不可以存储小数部分
  + 范围有限
  + 通常根据数值范围来选取整数类型
+ 5 种整数类型是有符号的 (signed)
  + 能表示正整数, 0, 负整数
  + `int`
  + `int8`
  + `int16`
  + `int32`
  + `int64`
+ 5 种整数类型是无符号的 (unsigned)
  + 能表示正整数, 0
  + `uint`
  + `uint8`
  + `uint16`
  + `uint32`
  + `uint64`
+ `int` 和 `uint` 取值由操作系统决定(32 bit / 64 bit)

#### `uint8` 适合用于表示 8 bit 颜色

+ rgb 取值范围 0-255
+ 如果很多颜色数据连续存储, 例如未被压缩的图片, 那么使用 `uint8` 可以节省很多内存

#### 十六进制表示

+ 在数字前加 `0x` , 可以用十六进制的形式表示数字

+ 打印十六进制的数, 使用 `%x` 格式化动词

  + ```go
    package main
    
    import (
    	"fmt"
    )
    
    func main() {
    	r := 0
    	g := 125
    	b := 200
    
    	fmt.Printf("color: #%02x%02x%02x", r, g, b)
    }
    ```

    ```
    color: #007dc8
    ```

  + `%02x` 表示最小宽度为 2, 不足 2 用 0 填充

#### 整数环绕

+ 赋值超出整数取值范围会发生「环绕」

```go
package main

import (
   "fmt"
)

func main() {
   var num int8 = 127
   num++
   fmt.Println(num)
}
```

```
-128
```

#### 打印每个 bit

+ 以二进制打印

+ ```go
  var num = 3
  fmt.Printf("%08b\n", num)
  num++
  fmt.Printf("%08b\n", num)
  ```

  ```
  00000011
  00000100
  ```

#### 大数存储

+ 使用 `int64`
+ 使用 `uint64` (更大的正数)
+ 使用浮点类型 (精度不高)

> 使用科学计数法, 如 `24e10` 声明变量时, 默认为 `float64` 类型

##### 使用 `big` 包

+ `big.Int`

  + 较大整数 ($>10^{18}$)

  + 使用 `int64` 创建

    + `bigNum := big.NewInt(24e20)`

  + 使用字符串创建

    + ```go
      bigNum := new(big.Int)
      bigNum.SetString("240000000000000000000000000000000000000", 10)
      // 10 表示十进制
      ```

+ `big.Float`

  + 任意精度的浮点类型

+ `big.Rat`

  + 分数

##### 大数常量

+ Go 中不指明变量类型, 会使用类型推断

+ 常量可以是无类型的(untyped)

  + ```go
    // 报错
    const distance uint64 = 240000000000000000000
    
    // 不报错
    const distance = 240000000000000000000
    ```

### 字符串类型

#### 声明

```go
str := "String"
var str = "String"
var str string = "String"
```

#### `string`

+ 可一个给某个变量赋予不同的 `string` 值
+ 但是 `string` 本身是不可变的
  + 与 Java 相同
+ 本质是字符数组

```go
str := "string"
first := str[0]
fmt.Printf("%c\n", first)

// 报错
str[0] = 'S'
```

```
s

-------
# command-line-arguments
.\main.go:10:2: cannot assign to str[0] (value of type byte)
```

##### `len`

+ 返回字符串所占 `byte` 数
  + 如果字符都用 `utf-8` 编码, 则返回字符串长度
+ 使用 `utf-8` 包, 可以按 `rune` 计算字符串长度

`RuneCountInString`

+ 返回字符串长度(以 `rune` 计)

##### `DecodeRuneInString`

+ 返回第一个字符以及字符所占字节数
  + `Go` 中的函数可以返回多个值

##### `range` 关键字

+ 使用 `range` 关键字可以遍历各种集合

  ```go
  str := "Hello world"
  
  for i, c := range str {
      fmt.Printf("%v %c\n", i, c)
  }
  ```

  ```
  0 H
  1 e
  2 l
  3 l
  4 o
  5
  6 w
  7 o
  8 r
  9 l
  10 d
  ```

  + 使用 `_` 缺省

    ```go
    str := "Hello world"
    
    for _, c := range str {
    fmt.Printf("%c\n", c)
    }
    ```

    ```
    H
    e
    l
    l
    o
     
    w
    o
    r
    l
    d
    ```

    

#### 字符串字面值

+ 可以包含转义字符
+ 如果希望得到原始字符而不是转移, 可以使用反引号 `` ` `` 代替 `"`

#### 输出字符

+  打印数字对应的 Unicode 字符而不是数字值

  + ```go
    var pi rune = 960
    var alpha rune = 940
    var omega rune = 969
    var bang byte = 33
    
    fmt.Printf("%v %v %v %v \n", pi, alpha, omega, bang)
    
    fmt.Printf("%c %c %c %c \n", pi, alpha, omega, bang)
    ```

    ```
    960 940 969 33 
    π ά ω ! 
    ```

### 字符类型

+ 字符字面值使用 `'` 括起来
+ 如果没有指定字符类型, 那么 Go 会推断它的类型为 `rune`

### 类型别名

+ Unicode 联盟为超过 100 万个字符分配了相应的数值, 这个数叫做 code point
+ 为了表示这样的 uncode code point , Go 语言提供了 `rune` 类型, 它是 `int32` 的一个类型别名
+ `byte` 是 `uint8` 的别名
  + 可以表示 ASCII 定义的英语字符, 是 Unicode 的一个子集 (共 128 个字符)

+ 可以使用 `type` 关键字自定义类型别名

  + ```go
    type String = string
    ```

### 打印数据类型

+ 在 `Printf` 中使用 `%T` 打印数据类型

```go
package main

import (
	"fmt"
)

func main() {
	num := 0.1
	fmt.Printf("Type %T for %v\n", num, num)
}
```

```
Type float64 for 0.1
```



### 默认值

+ Go 里面每个类型都有一个默认值, 它称作零值
+ 声明变量但不初始化, 其值为零值

### 类型转换

#### 不能混用类型

+ 使用 `+` 连接字符串
  + `str := "Hello" + " world"`

+ 不能连接字符串和数值
  + 报错 `str := "Hello" + 10 + " World"`
    + Java 中可以这么写

+ 整形和浮点类型不能混用

+ 浮点类型转换为小数类型， 小数点后面的部分会被截断

+ 无符号和有符号整数类型之间需要转换

+ 大小不同的整数类型之间需要转换

  + 转换时超出类型容纳范围也会发生「环绕」
  + 可以通过 `math` 包下的 `max` `min` 常量判断是否超过范围

+ 数值转化为 `string`, 其值必须能转化为 `code point`

  + 不会报错, 但是会输出乱码

+ `strconv` 包下的 `Itoa` (Integer to ASCII)可以将数值转换为字符串

  +  ```go
     countdown := 123456
     str := "now time " + strconv.Itoa(countdown) + " seconds"
     fmt.Println(str)
     ```

    ```
    now time 123456 seconds
    ```

+ 也可以使用 `Sprintf`

  + 这个函数返回一个 `string`, 不向控制台打印字符串

  + ```go
    countdown := 123456
    str := fmt.Sprintf("now time %v seconds", countdown)
    fmt.Println(str)
    ```

+ `Atoi` (ASCII to integer)函数可以将字符串表示的数值转换为 `int` 数值

  + 如果要转换的数值过大, 可能会发生错误

  + 这个函数返回两个结果, 转换的数值和 `err`, 如果 `err == nil` 就是没有发生错误

    + `nil` 就是 Java 中的 `null`

    + ```go
      num, err := strconv.Atoi("12341231234567456456")
      if err != nil {
          fmt.Println(err.Error())
      }
      fmt.Println(num)
      ```

      ```
      strconv.Atoi: parsing "12341231234567456456": value out of range   # 错误信息
      9223372036854775807   # 整数环绕
      ```

+ `Print` 这一类函数会把 `bool` 类型的值打印为 `true` `flase` 的 `string`

+ Go 语言中 `bool` 类型只能是 `true` / `false` 不能把 1 / 0 作为 `true` / `false`
