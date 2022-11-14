# Go 语言入门

## Hello world

```go
package main

import "fmt"

func main() {
	fmt.Println("Hello world")
}

```

> + `fmt` 是一个包
>+ 花括号格式严格
> + `Println` 函数, 打印后换行
> + `Print` 函数, 打印后不换行
> + 打印多个字符串, 认为是接受多个参数, 而不是做拼接字符串操作(不用 `+`, 用 `,` 隔开)

## `Printf` 格式化输出

```go
package main

import "fmt"

func main() {

	// 第一个参数必须是字符串, 且包含 %v 格式化动词
	fmt.Printf("Today is %v.\n", "Tue")

	// 可以有多个格式化动词
	fmt.Printf("Today is %v, tomorrow is %v.\n", "Tue", "Wed")
}

```

### 对齐文本

+ 在格式化动词里指定宽度, 就可以对齐文本.
+ 例如 `%4v` 就是向左填充到足够 4 个宽度 (包括填充的字符在内)
+ 正数, 向左填充空格
+ 负数, 向右填充空格

```go
package main

import "fmt"

func main() {

	fmt.Printf("Today is %6v.\n", "Tue")

	fmt.Printf("Today is %-6v, tomorrow is %v.\n", "Tue", "Wed")
}

```

```
Today is    Tue.
Today is Tue   , tomorrow is Wed.
```

## 常量与变量

+ 先声明, 后调用
+ `const` 声明常量
+ `var` 声明变量
+ 命名均使用驼峰命名规则

```go
package main

import "fmt"

func main() {
	const lightSpeed = 299792
	var distance = 56000000

	fmt.Println(distance/lightSpeed, "seconds")

	distance = 401000000
	fmt.Println(distance/lightSpeed, "seconds")
}
```

### 声明多个变量

```go
var distance = 56000000
var speed = 100800

var (
    distance = 56000000
    speed    = 100800
)

var distance, speed = 56000000, 100800
```

### 作用域

在被声明的 `{}` 内

#### `package` 作用域

在 `main` 函数外声明的变量

对 `main` package 内所有函数起作用

### 短声明

+ 使用 `var` 声明

  + `var count = 10`

+ 短声明

  + `count := 10`

+ 两种方式效果相同

+ 短声明语句更短, 可以在无法使用 `var` 的地方使用

  + 如 `for` 循环的初始化语句

    + ```go
      for count := 10; count > 10; count-- {
          fmt.Println(count)
      }
      ```

  + `if` 语句中

    + ```go
      if num := rand.Intn(3); num == 0 {
          fmt.Println("num is 0")
      }
      ```

  + `switch` 语句中

    + ```go
      switch num := rand.Intn(10); num {
      case 0:
      	fmt.Println("is 0")
      case 1:
      	fmt.Println("is 1")
      default:
      	fmt.Println("> 1")
      }
      ```

    + 

+ 只能在函数内部使用短声明, 不能在 `package` 作用域使用短声明

+ 短变量声明语句中至少要声明一个新的变量

  + 如果同时包含新变量和已经声明的变量

  + 已经声明的变量只会被重新赋值

  + ```go
    a := 100
    
    a, b := 200, 300
    // 可以编译通过, 但 a 的内存地址不变
    ```

+ 在不同的作用域中, 重复使用短变量声明时, 如果变量名相同, 会重新声明新的变量

  + ```go
    package main
    
    import (
        "fmt"
        "os"
    )
    
    func main() {
        file, err := os.Open("file.go")
        if err != nil {
            file, err := os.Open("file2.go") // file 和 err 在 if 作用域中，是重新声明的两个变量
            fmt.Println(&file, &err)         // 通过两次输出的 file 和 err 的地址不同可以确认
        }
        fmt.Println(&file, &err)
    }
    ```

  + 

## 运算符

+ 自增自减只有 `var++` `var--`, 没有 `++var` `--var`
+ 只有短路与`&&`/或`||`, 没有逻辑与`&`/或`|`

其他与 Java 相同

## 常用包与方法

### 随机数

+ `math/rand` 包
  + `Intn` 
    + 返回一个指定范围的随机整数
    + `rand.Intn(10)` 返回 $[0,10)$

### 字符串

+ `strings` 包
  + `Contains` 
    + 判断某个字符串是否包含另外一个字符串.
    + `string.Contains(string1, string2)` 返回 `bool`, `string1` 是否包含 `string2`

## 循环和分支

### 循环语句

#### `for`

```go
package main

import (
	"fmt"
	"time"
)

func main() {
	var count = 10

	for count > 0 {
		fmt.Println(count)
		time.Sleep(time.Second)
		count--
	}
	fmt.Println("time off")
}

```



### 分支语句

#### `if`

不需要圆括号, 其他与 Java相同

#### `switch`

`case` 可以是字符串也可以是数字

```go
package main

import "fmt"

func main() {
	fmt.Println("There is a cavern entrance here and a path to the east.")
	var command = "go inside"

	switch command {
	case "go east":
		fmt.Println("You head further up the mountain.")
    // 可以包含多个 case
	case "enter cave", "go inside":
		fmt.Println("You find yourself in a dimly lit cavern.")
	case "read sign":
		fmt.Println("The sign reads 'No Minors'.")
	default:
		fmt.Println("Didn't quite get that.")
	}
}
```

```
There is a cavern entrance here and a path to the east
You find yourself in a dimly lit cavern.

```

+ 不需要 `break`, 默认没有 `case` 穿透
+ 使用 `fallthrough` 关键字引发 `case` 穿透, 执行下一个 `case` 的 `body`

## 练习

+ 假设我们要去火星，但是有多条航线，每条航线的时间、票的类型（单程、往返）、价格都不同：

  + 使用变量、常量、switch、if、for，fmt，math/rand 等编写这个程序。随机生成格式如下表所示的 10 条数据。
  + 一共四列
  + Spaceline 就是航空公司：
    + Space Adventures, SpaceX, or Virgin Galactic
  + Days 是指到火星单程所需的天数
    + 使用 2020 年 7 月 28 日作为出发日期。距离火星的距离为 62, 100, 000 公里。速度随机生成16-30 km/s
  + Trip Type 就是指单程还是往返
  + Price 的单位是百万美元
    + 票价随机生成：3600万-5000万之间（单程）

  ```
  Spaceline        Days Trip type  Price
  ======================================
  Virgin Galactic    31 One-way    $  43
  SpaceX             28 Round-trip $  96
  SpaceX             32 Round-trip $  98
  Space Adventures   29 One-way    $  40
  Space Adventures   34 One-way    $  48
  Virgin Galactic    29 Round-trip $  84
  Space Adventures   23 One-way    $  42
  Space Adventures   34 One-way    $  46
  Virgin Galactic    34 One-way    $  42
  Space Adventures   24 One-way    $  40
  ```

  ```go
  package main
  
  import (
  	"fmt"
  	"math"
  	"math/rand"
  )
  
  func main() {
  	const distances = 62100000
  	agents := [3]string{"Space Adventures", "SpaceX", "Virgin Galactic"}
  	tripTypes := [2]string{"Round-trip", "One-way"}
  
  	fmt.Println("Spaceline        Days Trip type  Price")
  	fmt.Println("======================================")
      
  	for count := 0; count < 10; count++ {
  		var agent = rand.Intn(3)
  		var tripType = rand.Intn(2)
  		var speed = rand.Intn(16) + 16
  		var price = rand.Intn(14) + 36
  		var days = distances / speed / 60 / 60 / 24
  		days = int(math.Round(float64(days)))
          
  		if tripType == 0 {
  			price *= 2
  		}
          
  		fmt.Printf("%-16v %4v %-10v $%4v\n", agents[agent], days, tripT
                     ypes[tripType], price)
  	}
  }
  
  ```
  

