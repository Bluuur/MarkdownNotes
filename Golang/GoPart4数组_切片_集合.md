# Go 语言入门 4

## 数组

+ 数组是一种固定长度且有序的元素集合
+ `var planets [8]string` 声明了一个长度为 8 的 `string` 类型数组
+ 与 Java 一样, 通过 `[]` 索引访问数组中的元素

```go
package main

import "fmt"

func main() {
	var planets [8]string
	
	planets[0] = "Mercury"
	planets[1] = "Venus"
	planets[2] = "Earth"

	earth := planets[2]
	fmt.Println(earth)
}
```

+ 可以通过 `len()` 函数获取数组的长度
+ 没有赋值的元素值为数组类型的零值
  + `string` 类型的零值为空串`""`

### 数组越界

+ 访问越界会报错

  + ```go
    package main
    
    import "fmt"
    
    func main() {
    	var planets [8]string
    
    	planets[0] = "Mercury"
    	planets[1] = "Venus"
    	planets[2] = "Earth"
    
    	earth := planets[8]
    	fmt.Println(earth)
    }
    
    ```

    ```
    # LearnGo/Part4/array
    .\main.go:12:19: invalid argument: array index 8 out of bounds [0:8]
    ```

+ 如果 Go 编译器在编译时未能发现越界错误, 那么程序在运行是会出现 `panic`

  + ```go
    package main
    
    import "fmt"
    
    func main() {
       var planets [8]string
    
       i := 8
       planets[i] = "Pluto"
       pluto := planets[i]
    
       fmt.Println(pluto)
    }
    ```

    ```
    panic: runtime error: index out of range [8] with length 8
    
    goroutine 1 [running]:
    main.main()
            D:/Projects/goProjects/src/LearnGo/Part4/array/main.go:16 +0x69
    ```

  + `panic` 会导致程序崩溃

### 复合字面值初始化数组

+ 复合字面值 (composite literal) 是一种给复合类型初始化的紧凑语法

+ Go 的复合字面值语法允许我们只用一步就完成数组声明和数组初始化两步操作

  + ```go
    dwarfs := [5]string{"Ceres", "Pluto", "Haumea", "Makemake", "Eris"}
    ```

  + 复合字面值初始化数组可以使用 `...` 作为数组的长度, Go 编译器会自动算出数字的长度

### 遍历数组

+ `for` 循环

  + ```go
    dwarfs := [...]string{
        "Ceres",
        "Pluto",
        "Haumea",
        "Makemake",
        "Eris",
    }
    
    for i := 0; i < len(dwarfs); i++ {
        dwarf := dwarfs[i]
        fmt.Println(i, dwarf)
    }
    ```

+ `range`

  + ```go
    dwarfs := [...]string{
        "Ceres",
        "Pluto",
        "Haumea",
        "Makemake",
        "Eris",
    }
    
    for i, dwarf := range dwarfs {
        fmt.Println(i, dwarf)
    }
    ```

### 数组的复制

+ 无论数组赋值给新的变量还是将它传递给函数, 都会产生一个完整的数组副本
+ 数组也是一种值, 函数通过值传递来接受参数. 所以数组作为函数的参数非常低效
+ 数组的长度也是数组类型的一部分
  + 将长度不符的数组作为参数传递, 将会报错
+ 函数一般使用 `slice` 而不使用数组作为参数

## slice 切片

+ 假设 `planets` 是一个数组, 那么 `planets[0:4]` 就是一个切片, 它切分出了数组里前 4 个元素
+ 切分数组不会导致数组被修改, 它只是创建了指向数组的一个视图, 这种视图就是 `slice` 类型
+ `slice` 使用的是半开区间
  + 例如 `planets[0:4]`, 包含索引 0, 1, 2, 3 ( `[0,4)` )对应的元素,不包括索引 4 对应的元素.

```go
package main

import "fmt"

func main() {
	planets := [...]string{
		"Mercury",
		"Venus",
		"Earth",
		"Mars",
		"Jupiter",
		"Saturn",
		"Uranus",
		"Neptune",
	}

	terrestrial := planets[0:4]
	gasGiants := planets[4:6]
	iceGiants := planets[6:8]

	fmt.Println(terrestrial, gasGiants, iceGiants)
}
```

```
[Mercury Venus Earth Mars] [Jupiter Saturn] [Uranus Neptune]
```

### slice 的默认索引

+ 缺省 `slice` 的起始索引, 表示从数组的起始位置进行切分
+ 缺省 `slice` 的结束索引, 表示使用数组的长度作为结束索引

```go
terrestrial := planets[0:4]
gasGiants := planets[4:6]
iceGiants := planets[6:8]

// 上面可以写为

terrestrial := planets[:4]
gasGiants := planets[4:6]
iceGiants := planets[6:]
```

+ 缺省起始索引和结束索引, 就是包含数组所有元素的 `slice`
+ 切分数组的语法也可以用于切分字符串, 因为字符串底层是字符数组
  + 切分字符串时, 索引代表字节数, 而不是 `rune` 数

### slice 的复合字面值

+ Go 里面很多函数都倾向于使用 `slice` 而不是数组作为参数

+ 想要获得与底层数组相同元素的 `slice`, 那么可以使用 `[:]` 进行切分

+ 切分数组不是创建 `slice` 的唯一方法, 可以直接声明 `slice`

  + ```go
    // 中括号中不填入内容
    dwarfs := []string{
        "Ceres",
        "Pluto",
        "Haumea",
        "Makemake",
        "Eris",
    }
    
    fmt.Printf("dwarfs is %T.\n", dwarfs)
    ```

    ```
    dwarfs is []string.
    ```

    + 底层上也是先创建一个数组 

### slice 的作用

```go
package main

import (
	"fmt"
	"strings"
)

func main() {
	planets := []string{
		" Venus    ",
		"Earth   ",
		" Mars",
	}
	hyperspace(planets)

	// 拼接打印
	fmt.Println(strings.Join(planets, " "))
}

// 这个函数可以接受任意长度的 slice
// slice 有长度, 但长度不作为 slice 类型的一部分
func hyperspace(worlds []string) {
	for i := range worlds {
		// 去掉字符串中的空格
		worlds[i] = strings.TrimSpace(worlds[i])
	}
}
```

### 带有方法的 slice

+ 在 Go 中, 可以将 `slice` 或数组作为底层类型, 然后绑定其他方法

```go
package main

import "sort"

type StringSlice []string

func main() {
	planets := []string{
		"Mercury",
		"Venus",
		"Earth",
		"Mars",
		"Jupiter",
		"Saturn",
		"Uranus",
		"Neptune",
	}

	sort.StringSlice(planets).Sort()
}

func (p StringSlice) Sort() {

}
```

### 更大的 slice

#### `append` 函数

+ 可变参数的函数

```go
package main

import "fmt"

func main() {
	dwarfs := []string{
		"Ceres",
		"Pluto",
		"Haumea",
		"Makemake",
		"Eris",
	}
	dwarfs = append(dwarfs, "Orcus")
	
	fmt.Println(dwarfs)
}
```

#### 长度和容量 (Length & Capacity)

+ `slice` 中元素的个数决定了 `slice` 的长度
+ 如果 `slice` 的底层数组比 `slice` 还大, 那么就说该 `slice` 还有容量可供增长
  + 使用 `cap()` 函数查看 `slice` 容量

```go
package main

import "fmt"

func main() {
	dwarfs1 := []string{
		"Ceres",
		"Pluto",
		"Haumea",
		"Makemake",
		"Eris",
	}
	dump("dwarfs1", dwarfs)

    // append 但容量不够时, 会新建底层数组, 新数组长度为原来的两倍
	dwarfs2 = append(dwarfs1, "Orcus")
	dump("dwarfs2", dwarfs2)

	dwarfs3 = append(dwarfs2, "Salacia", "Quaoar", "Sedna")
	dump("dwarfs3", dwarfs3)
}

func dump(label string, slice []string) {
	fmt.Printf("%v: length %v, capacity %v %v\n", label, len(slice), cap(slice), slice)
}
```

```
dwarfs1: length 5, capacity 5 [Ceres Pluto Haumea Makemake Eris]
dwarfs2: length 6, capacity 10 [Ceres Pluto Haumea Makemake Eris Orcus]
dwarfs3: length 9, capacity 10 [Ceres Pluto Haumea Makemake Eris Orcus Salacia Quaoar Sedna]
```

+ `append` 但容量不够时, 会新建底层数组, 新数组长度为原来的两倍

```go
package main

import "fmt"

func main() {
   dwarfs1 := []string{
      "Ceres",
      "Pluto",
      "Haumea",
      "Makemake",
      "Eris",
   }

   // append 但容量不够时, 会新建底层数组, 新数组长度为原来的两倍
   dwarfs2 := append(dwarfs1, "Orcus")

   dwarfs3 := append(dwarfs2, "Salacia", "Quaoar", "Sedna")

    // 修改内容
   dwarfs3[1] = "Pluto!"

   dump("dwarfs1", dwarfs1)
   dump("dwarfs2", dwarfs2)
   dump("dwarfs3", dwarfs3)
}

func dump(label string, slice []string) {
   fmt.Printf("%v: length %v, capacity %v %v\n", label, len(slice), cap(slice), slice)
}
```

```
dwarfs1: length 5, capacity 5 [Ceres Pluto Haumea Makemake Eris]
dwarfs2: length 6, capacity 10 [Ceres Pluto! Haumea Makemake Eris Orcus]
dwarfs3: length 9, capacity 10 [Ceres Pluto! Haumea Makemake Eris Orcus Salacia Quaoar Sedna]
```

+ 由以上结果可以看出, 修改 `slice` `dwarfs3` 中的内容, `dwarfs2` 和 `dwarfs3` 均发生改变, 而 `dwarfs1` 内容不变
  + 因为 `dwarfs1` 底层是扩容前的数组, 而 `dwarfs2` 和 `dwarfs3` 共用扩容后的数组

### 三索引的切分操作

+ Go 1.2 中引入了能够限制新建切片容量的三索引切分操作

```go
package main

import (
	"fmt"
)

func main() {
	planets := []string{
		"Mercury",
		"Venus",
		"Earth",
		"Mars",
		"Jupiter",
		"Saturn",
		"Uranus",
		"Neptune",
	}

	// 限制新建切片容量为 4 
	terrestrial := planets[0:4:4]
	worlds := append(terrestrial, "Ceres")

	dump("planets", planets)
	dump("terrestrial", terrestrial)
	dump("worlds", worlds)
}

func dump(label string, slice []string) {
	fmt.Printf("%v: length %v, capacity %v %v\n", label, len(slice), cap(slice), slice)
}
```

```
planets: length 8, capacity 8 [Mercury Venus Earth Mars Jupiter Saturn Uranus Neptune]
terrestrial: length 4, capacity 4 [Mercury Venus Earth Mars]
worlds: length 5, capacity 8 [Mercury Venus Earth Mars Ceres]
```

### `make` 函数

使用 `make` 函数对切片进行预分配

+ 当 `slice` 的容量不足以执行 `append` 操作时, Go 必须创建新数组并复制旧数组中的内容
  + `make([]string, 10)` 创建长度为 10, 容量也为 10 的切片
  + `make([]string, 5, 10)`  创建长度为 5, 容量也为 10 的切片

### 声明可变参数的函数

+ 声明 `Printf`, `append` 这样的可变参数函数, 需要在函数的最后一个参数前面加上 `...`
+ 这一项可变的参数类型为 `slice`

```go
package main

import "fmt"

func main() {
	// 直接传入多个参数
	twoWorlds := terraform("New", "Venus", "Mars")
	fmt.Println(twoWorlds)

	planets := []string{"Venus", "Mars", "Jupiter"}
	// 传入切片 ... 表示把切片展开
	newPlanets := terraform("New", planets...)
	fmt.Println(newPlanets)
}

// 添加 prefix
func terraform(prefix string, worlds ...string) []string {
	// 直接传入的切片做修改, 会改变原切片的值
	// 所以新建切片接收
	newWorlds := make([]string, len(worlds))

	for i := range worlds {
		newWorlds[i] = prefix + " " + worlds[i]
	}

	return newWorlds
}

```

## `map`

+ `map` 是 Go 提供的一种集合
  + 可以将 `key` 映射到 `value`
  + 可快速通过 `key` 找到对应的 `value` 
  + `key` 几乎可以是任何类型
+ 使用 `range` 遍历 `map` 时, 遍历的顺序是无法保证的

### 声明 map

+ 声明 `map`, 必须指定 `key` 和 `value` 的类型
  + `map[string]int`

```go
package main

import (
   "fmt"
)

func main() {
    // 创建 map
   temperature := map[string]int{
      "Earth": 15,
      "Mars":  -65,
   }

   temp := temperature["Earth"]
   fmt.Printf("On average the Earth is %v°C.\n", temp)

   temperature["Earth"] = 16
   temperature["Venus"] = 464

   fmt.Println(temperature)

    // value 为 int 类型的零值
   moon := temperature["Moon"]
   fmt.Println(moon)

}
```

### `, ok` 写法

```go
// moon, ok := temperature["Moon"]
// 上行语句, moon 是取出的值; ok 是 bool 类型, 指明 moon 是否有值(是否不为零值)
if moon, ok := temperature["Moon"]; ok {
    // 如果有值, 输出以下语句
    fmt.Printf("On average the moon is %v °C.\n", moon)
} else {
    // 如果无值, 输出以下语句
    fmt.Println("Where is the moon?")
}
```

### `map` 不会被复制

+ 数组, `int`, `float64` 等类型在赋值给新变量或传递至函数/方法的时候会创建相应的副本, 但 `map` 不会
  + 类似 Java 中的引用数据类型

### 使用 `map` 计数

```go
package main

import "fmt"

func main() {
	temperature := []float64{
		-28.0, 32.0, -31.0, -29.0, -23.0, -29.0, -28.0, -33.0,
	}
	frequency := make(map[float64]int)

	for _, t := range temperature {
		frequency[t]++
	}

	for t, num := range frequency {
		fmt.Printf("%+.2f occurs %d times\n", t, num)
	}
}

```

```
-33.00 occurs 1 times
-28.00 occurs 2 times
+32.00 occurs 1 times
-31.00 occurs 1 times
-29.00 occurs 2 times
-23.00 occurs 1 times
```

### 使用 `map` 和 `range` 实现数据分组

```go
package main

import (
	"fmt"
	"math"
)

func main() {
	temperatures := []float64{
		-28.0, 32.0, -31.0, -29.0, -23.0, -29.0, -28.0, -33.0,
	}

	// key 为 float64, value 为 float64 的 slice
	groups := make(map[float64][]float64)

	for _, t := range temperatures {
		// Trunc 返回整数部分的浮点值
		g := math.Trunc(t/10) * 10
		groups[g] = append(groups[g], t)
	}

	for g, temperatures := range groups {
		fmt.Printf("%v: %v\n", g, temperatures)
	}
}

```

### 将 `map` 用作 `set`

+ `set` 集合类似数组, 但元素不能重复
+ Go 语言中没有提供 `set` 集合

### 常用函数

#### `delete`

+ 删除 `map` 中的元素

+ `delete(map, key)`

#### `make`

+ 对 `map` 进行预分配
+ 除非使用复合字面值来初始化 `map`, 否则必须使用内置的 `make` 函数来为 `map` 分配空间
+ 创建 `map` 时, `make` 函数可接受一个或两个参数
+ `make(map[float64]int, 8)`
  + 用于指定 key 数量
+ 使用 `make` 函数创建的 `map` 的初始长度为 0

