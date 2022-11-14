# Go 语言入门 5

## 结构体 struct

```go
package main

import "fmt"

func main() {
    // 创建结构体
	var curiosity struct {
		lat  float64
		long float64
	}

	curiosity.lat = -4.5895
	curiosity.long = 137.4417

	fmt.Println(curiosity.lat, curiosity.long)
	fmt.Println(curiosity)
}

// 用两点表示纬度和经度
func distance(lat1, long1, lat2, long2 float64) float64 {
	return 0.0
}

```

+ 上面的方法类似 Java 中通过匿名内部类创建对象

### 通过类型复用结构体

```go
package main

import "fmt"

func main() {
	type location struct {
		lat  float64
		long float64
	}

	var spirit location
	spirit.lat = -14.5684
	spirit.long = 175.472636

	var opportunity location
	opportunity.lat = -1.9462
	opportunity.long = 345.4734

	fmt.Println(spirit, opportunity)
}

```

+ 上面的方法类似 Java 中先编写类, 再通过类创建对象

通过复合字面值初始化 `struct`

+ 两种形式

  1. 通过成对的字段和值进行初始化

     ```go
     func main() {
     	type location struct {
     		lat  float64
     		long float64
     	}
     	insight := location{lat: 4.5, long: 135.9}
     	fmt.Println(insight)
     }
     ```

     + 可以无序, 可以不定义, 未定义的字段默认为零值

  2. 通过字段定义顺序初始化

     ```go
     func main() {
     	type location struct {
     		lat  float64
     		long float64
     	}
     
     	insight := location{4.5, 135.9}
     	fmt.Println(insight)
     }
     ```

### 打印结构体

打印结构体同时打印字段名

```go
insight := location{lat: 4.5, long: 135.9}
fmt.Printf("%v\n", insight)
fmt.Printf("%+v\n", insight)
```

```
{4.5 135.9}
{lat:4.5 long:135.9}
```

### 结构体的复制

直接用 `=` 赋值给新的变量, 两个变量相互独立

```go
var spirit location
spirit.lat = -14.5684
spirit.long = 175.472636

spirit2 := spirit

fmt.Println(spirit2)
fmt.Println(spirit)

spirit.lat += 100.0

fmt.Println("-------------")

fmt.Println(spirit2)
fmt.Println(spirit)
```

```
{-14.5684 175.472636}
{-14.5684 175.472636}
-------------
{-14.5684 175.472636}
{85.4316 175.472636}
```

结构体 `slice`

```go
package main

import "fmt"

func main() {

	type location struct {
		name string
		lat  float64
		long float64
	}

	locations := []location{
		{name: "Bradbury Landing", lat: -4.5895, long: 137.4417},
		{name: "Columbia Memorial Station", lat: -14.5684, long: 175.472636},
		{name: "Challenger Memorial Station", lat: -1.9462, long: 354.4734},
	}
	
	fmt.Println(locations)
}

```

### 将 `struct` 编码为 JSON

+ `json` 包的 `Marshal` 函数可以将 `struct` 中的数据转化为 JSON 格式

```go
package main

import (
	"encoding/json"
	"fmt"
	"os"
)

func main() {
	type location struct {
		Lat  float64
		Long float64
	}

	curiosity := location{-4.5895, 137.4417}

	bytes, err := json.Marshal(curiosity)
	exitOnError(err)

	fmt.Println(string(bytes))
}

func exitOnError(err error) {
	if err != nil {
		fmt.Println(err)
		os.Exit(1)
	}
}
```

```
{"Lat":-4.5895,"Long":137.4417}
```

+ 要想将结构体编码为 JSON, 结构体中的字段必须是可以导出的(大写开头)

### 使用 `struct` 标签自定义 JSON

+ Go 语言中的 `json` 包要求 `struct` 中的字段必须以大写字母开头, 类似 `CamelCase` 驼峰型命名规范

+ 如果需要 `snake_case` 命名规范

  + 可以为字段注明标签, 使得 `json` 包再进行编码的时候能够按照标签里的样式修改字段名

  ```go
  package main
  
  import (
  	"encoding/json"
  	"fmt"
  	"os"
  )
  
  func main() {
  	type location struct {
  		Lat  float64 `json:"latitude"`
  		Long float64 `json:"longtitude"`
  	}
  
  	curiosity := location{-4.5895, 137.4417}
  
  	bytes, err := json.Marshal(curiosity)
  	exitOnError(err)
  
  	fmt.Println(string(bytes))
  }
  
  func exitOnError(err error) {
  	if err != nil {
  		fmt.Println(err)
  		os.Exit(1)
  	}
  }
  
  ```

  + 转换为 JSON 时, 字段名会改为 `` ` `` 内 `""` 之间的内容
    + 转为 `xml` 时也可以自定义字段名

## Go 中没有 `class`

+ Go 语言没有对象, 也没有继承
+ 但是 Go 提供了 `struct` 和方法

### 将方法关联到 `struct`

```go
package main

import "fmt"

// 以度分秒为单位的坐标
type coordinate struct {
	// 度
	d float64

	// 分
	m float64

	// 秒
	s float64

	// 半球
	h rune
}

// 将度分秒单位坐标转换为 10 进制坐标
func (c coordinate) decimal() float64 {
	sign := 1.0
	switch c.h {
	case 'S', 'W', 's', 'w':
		sign = -1
	}
	return sign * (c.d + c.m/60 + c.s/3600)
}

func main() {

	// 4°35'22.2" S, 137°26'30.1" E
	lat := coordinate{4, 35, 22.2, 'S'}
	long := coordinate{137, 26, 30.12, 'E'}

	fmt.Println(lat.decimal(), long.decimal())
}

```

```
-4.5895 137.4417
```

### 构造函数

+ Go 语言没有专用的构造函数

```go
package main

import "fmt"

type coordinate struct {
	d, m, s float64
	h rune
}

type location struct {
	lat, long float64
}

func (c coordinate) decimal() float64 {
	sign := 1.0
	switch c.h {
	case 'S', 'W', 's', 'w':
		sign = -1
	}
	return sign * (c.d + c.m/60 + c.s/3600)
}

// 构造函数 习惯命名为 new + struct名, 大写 New 可以供其他包使用
func newLocation(lat, long coordinate) location {
	return location{lat.decimal(), long.decimal()}
}

func main() {
	// 4°35'22.2" S, 137°26'30.1" E
	lat := coordinate{4, 35, 22.2, 'S'}
	long := coordinate{137, 26, 30.12, 'E'}

	fmt.Println(lat.decimal(), long.decimal())
    curiosity := newLocation(
        coordinate{4, 35, 22.2, 'S'},
        coordinate{137, 26, 30.12, 'E'},
	)
	fmt.Println(curiosity)
}
```

### `New` 函数

+ 有一些用于构造的函数的名称就是 `New` (例如 `errors` 包中的 `New` 函数)
+ 函数调用使用 `package.func` 的形式, 不会重复

### `class` 的替代方案

+ Go 语言没有 `class`, 但使用 `struct` 并配备几 个方法也可以达到同样的效果

## 组合与转发 Composotion and Forwarding

+ 对象由更小的对象组合成
+ Go 通过结构体实现组合 (composition)
+ Go 提供了「嵌入」(embedding) 特性, 它可以实现方法的转发 (forwarding)

### 组合结构体

```go
package main

import "fmt"

type celsius float64

type temperature struct {
	high, low celsius
}

type location struct {
	lat, long float64
}

// 组合
type report struct {
	sol         int
	temperature temperature
	location    location
}

func main() {
	bradbury := location{lat: -4.5895, long: 137.4417}
	t := temperature{high: -1.0, low: -78.0}
	report := report{
		sol:         15,
		temperature: t,
		location:    bradbury,
	}
	fmt.Printf("%+v\n", report)
}

func (t temperature) average() celsius {
	return (t.high + t.low) / 2
}

// 方法转发
func (r report) average() celsius {
	return r.temperature.average()
}
```

```
{sol:15 temperature:{high:-1 low:-78} location:{lat:-4.5895 long:137.4417}}
```

##  接口

+ 接口关注于类型可以做什么, 而不是存储了什么
+ 接口通过列举类型必须满足的一组方法来进行声明
+ 在 Go 语言中, 不需要显式声明接口

```go
package main

import (
	"fmt"
	"strings"
)

var t interface {
	talk() string
}

type martain struct {
}

// 实现接口不是显式的
func (m martain) talk() string {
	return "nack nack"
}

type laser int

func (l laser) talk() string {
	return strings.Repeat("pew ", int(l))
}

func main() {
	t = martain{}
	fmt.Println(t.talk())

	t = laser(3)
	fmt.Println(t.talk())
}

```

+ 为了复用, 通常会把接口声明为了类型
+ 按约定, 接口通常以 `er` 结尾 

```go
package main

import (
	"fmt"
	"strings"
)

// 将接口声明为类型
type talker interface {
	talk() string
}

type martain struct {
}

// 实现接口不是显式的
func (m martain) talk() string {
	return "nack nack"
}

type laser int

func (l laser) talk() string {
	return strings.Repeat("pew ", int(l))
}

func shout(t talker) {
	louder := strings.ToUpper(t.talk())
	fmt.Println(louder)
}

func main() {
	// 多态
	shout(martain{})
	shout(laser(2))
}

```

+ Go 的接口都是隐式实现的

+ Go 通过简单的, 通常只有单个方法的接口, 来鼓励组合而不是继承, 这些接口在各个组件之间形成了简明易懂的界限.

+ 例如 `fmt` 包声明的 `Stringer` 接口

  + ```go
    package main
    
    import "fmt"
    
    type location struct {
    	lat, long float64
    }
    
    // fmt 包中声明的 Stringer j
    //type Stringer interface {
    //	String() string
    //}
    
    // location 结构体实现了 Stringer 接口, 可以以这里具体实现的格式, 被 Print 家族函数打印
    func (l location) String() string {
    	return fmt.Sprintf("%v, %v", l.lat, l.long)
    }
    
    func main() {
    	curiosity := location{-4.5895, 137.4417}
    	fmt.Println(curiosity)
    }
    
    ```

    
