# Go 语言入门 6

## 指针 pointer

+ 指针是指向另一个变量地址的变量
+ Go 语言的指针强调安全性, 不会出现 dangling pointers

### `&` 和 `*` 符号

+ 变量会将它们的值存储在计算机的 RAM 里, 存储位置就是该变量的内存地址

+ `&` 表示地址操作符, 通过 `&` 可以获得变量的内存地址

  + ```go
    package main
    
    import "fmt"
    
    func main() {
    	answer := 42
    	fmt.Println(&answer)
    }
    ```

    ```
    0xc000018098
    ```

+ `&` 操作符无法获得字符串/数值/布尔字面值的地址

+ `*` 操作符与 `&` 的作用相反, 它用来解引用, 提供内存地址指向的值

  + ```go
    answer := 42
    //fmt.Println(&answer)
    
    address := &answer
    fmt.Println(*address)
    ```

    ```
    42
    ```

    + ` address` 的类型为 `*int` 表示 `address` 是一个指向 `int` 类型的指针

+ C 语言中的内存地址可以通过例如 `address++` 这样的指针运算进行操作, 但是在 Go 里面不允许这种不安全操作

+ 指针类型和其它普通类型一样, 出现在所有需要用到类型的地方, 如变量声明, 函数形参, 返回值类型, 结构体字段等

+ 将 `*` 放在类型前面表示声明指针类型
  将 `*` 放在变量前面表示解引用操作

+ 两个指针变量持有相同的内存地址, 那么它们就相等

### 指向结构的指针

+ 与字符串和数值不一样, 复合字面量的前面可以放置 `&`

  + ```go
    package main
    
    import "fmt"
    
    func main() {
    	type person struct {
    		name, superPower string
    		age              int
    	}
    
    	timmy := &person{
    		name: "Timothy",
    		age:  10,
    	}
    
    	timmy.superPower = "Flying"
    
    	fmt.Printf("%+v\n", timmy)
    }
    
    ```

    ```
    &{name:Timothy superPower:Flying age:10}
    ```

+ 访问字段时, 对结构体进行解引用并不是必须的

### 指向数组的指针

+ 和结构体一样, 可以把 `&` 放在数组的复合字面值前面来创建指向数组的指针

+ 数组在执行索引或切片操作时会自动解引用. 没有必要写 `(*superpower)[0]` 这种形式

  + ```go
    package main
    
    import "fmt"
    
    func main() {
    	superpower := &[3]string{"flying", "invisibility", "super strength"}
    
    	fmt.Println(superpower[0])
    	fmt.Println(superpower[1:2])
    }
    ```

+ 与 C 语言不一样, Go 里面数组和指针是两种完全独立的类型

+ `slice` 和 `map` 的复合字面值前面也可以放置 `&` 操作符, 但是 Go 并没有为它们提供自动解引用的功能

### 实现修改

+ Go 语言的函数和方法都是按值传递参数的, 这意味着函数总是操作于被传递参数的副本

+ 当指针被传递到函数时, 函数将接收传入的内存地址的副本. 之后函数可以通过解引用内存地址来修改指针指向的值

  + ```go
    package main
    
    import "fmt"
    
    type person struct {
    	name, superpower string
    	age              int
    }
    
    func birthday(p *person) {
    	p.age++
    }
    
    func main() {
    	rebecca := person{
    		name:       "Rebecca",
    		superpower: "imagination",
    		age:        14,
    	}
    
    	birthday(&rebecca)
    
    	fmt.Printf("%+v\n\n", rebecca)
    }
    
    ```

### 指针接收者

+ 方法的接收者和方法的参数在处理指针方面是很相似的

  + ```go
    package main
    
    import "fmt"
    
    type person struct {
    	name string
    	age  int
    }
    
    func (p *person) birthday()  {
    	p.age++
    }
    
    func main() {
    	terry := &person{
    		name: "Terry",
    		age: 15,
    	}
    	terry.birthday()
    	fmt.Printf("%+v\n", terry)
    }
    
    ```

  + 使用指针作为接收者的策略应该始终如一

  + 如果一种类型的某些方法需要用到指针作为接收者, 就应该为这种类型的所有方法都是用指针作为接收者

  

### 内部指针

+ 内部指针用于确定结构体中指定字段的内存地址

+ `&` 操作符不仅可以获得结构体的内存地址, 还可以获得结构体中指定字段的内存地址

  + ```go
    package main
    
    import "fmt"
    
    type stats struct {
    	level             int
    	endurance, health int
    }
    
    func levelUp(s *stats) {
    	s.level++
    	s.endurance = 42 + (14 * s.level)
    	s.health = 5 * s.endurance
    }
    
    type character struct {
    	name  string
    	stats stats
    }
    
    func main() {
    	player := character{name: "Matthias"}
    	// 可以获取 stats 的内存地址
    	levelUp(&player.stats)
    
    	fmt.Printf("%+v\n", player.stats)
    }
    
    ```

### 修改数组

+ 函数通过指针对数组的元素进行修改

  + ```go
    package main
    
    import "fmt"
    
    func reset(board *[8][8]rune) {
    	board[0][0] = 'r'
    }
    
    func main() {
    	var board [8][8]rune
    	reset(&board)
    
    	fmt.Printf("%c", board[0][0])
    }
    
    ```

### `slice` 指向数组

+ `slice` 在指向数组元素的时候也使用了指针

+ 每个 `slice` 内部都会被表示为一个包含 3 个元素的结构, 它们分别指向

  + 数组的指针
  + `slice` 的容量
  + `slice` 的长度

+ 当 `slice` 被直接传递至函数说方法时, `slice` 的内部指针就可以对底层数据进行修改

+ 指向 `slice` 的显示指针的唯一作用就是修改 `slice` 本身: `silce` 的长度, 容量以及起始偏移量

  + ```go
    package main
    
    import "fmt"
    
    func reclassify(planets *[]string) {
    	// 传入的是指针类型, 解引用, 取 [0,8)
    	*planets = (*planets)[0:8]
    }
    
    func main() {
    	planets := []string{
    		"Mercury", "Venus", "Earth", "Mars",
    		"Jupiter", "Saturn", "Uranus", "Neptune",
    		"Pluto",
    	}
    	reclassify(&planets)
    
    	fmt.Println(planets)
    }
    
    ```

### 指针和接口

```go
package main

import (
	"fmt"
	"strings"
)

type talker interface {
	talk() string
}

func shout(t talker) {
	louder := strings.ToUpper(t.talk())
	fmt.Println(louder)
}

type martian struct {
}

func (m martian) talk() string {
	return "nack nack"
}

type laser int

// 指针类型实现了接口
func (l *laser) talk() string {
	return strings.Repeat("pew ", int(*l))
}

func main() {
    
    // 两种都可以
	shout(martian{})
	shout(&martian{})

	pew := laser(2)
	// 这里传参必须用指针
	shout(&pew)
}
```

## `nil`

+ `nil` 是指针, `slice`,`map` 的零值
+ Go 语言的 `nil`, 比其他语言中的 `null` 更为友好, 而且用的没那么频繁, 但是仍需谨慎使用

`nil` 会导致 `panic`

+ 如果指针没有明确的指向, 那么程序将无法对其实施的解引用
+ 尝试解引用一个 `nil` 指针将导致程序崩溃

### 避免 `nil` 引发 `panic`

+ 因为值为 `nil` 的接收者和值为 `nil` 的参数在行为上并没有区别, 所以 Go 语言即使在接收者为 nil 的情况下, 也会继续调用方法

### `nil` 函数值

+ 当变量被声明为函数类型时, 它的默认值为 `nil`

  + ```go
    package main
    
    import "fmt"
    
    func main() {
    	var fn func(a, b int) int
    	fmt.Println(fn == nil)
    }
    ```

    ```
    true
    ```

+ 检查函数值是否为 `nil`, 并在有需要的时候提供默认行为

### `nil slice`

+ 如果 `slice` 在声明之后没有使用复合字面值或内置的 `make` 函数进行初始化, 那么它的值就是 `nil`

+ `range`, `len`, `append `等内置函数都可以正常处理值为 `nil` 的 `slice`

  + ```go
    package main
    
    import "fmt"
    
    func main() {
    	var soup []string
    	fmt.Println(soup == nil)
    
    	for _, ingredient := range soup {
    		fmt.Println(ingredient)
    	}
    
    	fmt.Println(len(soup))
    
    	soup = append(soup, "onion", "carrot", "celery")
    	fmt.Println(soup)
    }
    ```

    ```
    true
    0
    [onion carrot celery]
    ```
  
+ 虽然空 `slice` 和值为 `nil` 的 `slice` 并不相等, 但它们通常可以替换使用

### `nil map`

+ 和 `slice` 一样, 如果 `map` 在声明后没有使用复合字面值或内置的 `make` 函数进行初始化, 那么它的值将会是默认的 `nil`

### `nil interface`

+ 声明为接口类型的变量在未被赋值时, 它的零值是 `nil`

+ 对于一个未被赋值的接口变量来说, 它的接口类型和值都是 `nil`, 并且变量本身也等于 `nil`

+ 当接口类型的变量被赋值后, 接口就会在内部指向该变量的类型和值

  + ```go
    package main
    
    import "fmt"
    
    func main() {
    	var v interface{}
    	fmt.Printf("Type: %T, Value: %v, Is Nil: %v\n", v, v, v == nil)
    
    	var p *int
    	v = p
    	fmt.Printf("Type: %T, Value: %v, Is Nil: %v\n", v, v, v == nil)
    }
    ```

    ```
    Type: <nil>, Value: <nil>, Is Nil: true
    Type: *int, Value: <nil>, Is Nil: false 
    ```

+ 在 Go 中, 接口类型的变量只有在类型和值都为 `nil` 时才等于 `nil`

+ 检验接口变量的内部表示

  + ```go
    fmt.Printf("%#v\n", v)
    ```

    ```
    (*int)(nil)
    ```

## 错误处理

+ Go 语言允许函数和方法同时返回多个值
+ 函数在返回错误时, 最后一个返回值应该用来表示错误
+ 调用函数后, 应立即检查是否发生错误
  + 如果没有发生错误, 那么返回的错误值为 `nil`

+ Errors are values.
+ Don't just check errors, handle them gracefully.
+ Don't panic.
+ Make the zero value useful.
+ The bigger the interface, the weaker the abstraction.
+ `interface{}` says nothing.
+ Gofmt's style is no one's favorite, yet gofmt is everyone's favorite.
+ Documentation is for users.
+ A little copying is better than a little dependency.
+ Clear is better than clever.
+ Concurrency is not parallelism.
+ Don't communicate by sharing memory, share memory by communicating.
+ Channels orchestrate; mutexes serialize.

### 文件写入

+ 写入文件的时候可能出错
  + 路径不正确
  + 权限不够
  + 磁盘空间不足
  + ...
+ 文件写入完毕后, 必须先被关闭, 确保文件被刷到磁盘上, 避免资源的泄露.

### `defer` 关键字

+ 使用 `defer` 关键字, Go 可以确保所有 `deferred` 的动作可以在函数返回前执行
  + 无论在哪个语句 `return`, 都会保证 `defer` 修饰的语句执行
+ 可以 `defer` 任意的函数和方法
+ `defer` 并不是专门做错误处理的
+ `defer` 可以消除必须时刻执行资源释放的负担

### `New error`

+ `errors` 包里有一个构造用 `New` 函数,它接收 `string` 作为参数用来表示错误信息. 该函数返回 `error` 类型.

  + ```go
    err := errors.New("Out of bounds")
    ```

+ 错误信息应具有信息性

+ 可以把错误信息当作用户界面的一部分, 无论对最终用户还是开发者

### 按需返回错误

+ 按照惯例, 包含错误信息的变量名应以 `Err` 开头

### 自定义错误类型

+ `error` 类型是一个内置的接口, 任何类型只要实现了返回 `string` 的 `Error()` 方法就满足了该接口
+ 可以创建新的错误类型
  + `Part6_18`
+ 按照惯例, 自定义错误类型的名字应以 `Error` 结尾
  + 有时候名字就是 `Error`, 例如 `url.Error`

### 类型断言

+ 可以使用类型断言来访问每一种错误
+ 使用类型断言, 可以把接口类型转化成底层的具体类型
  + `Part6_19`
+ 如果类型满足多个接口, 那么类型断言可使它从一个接口类型转化为另一个接口类型

### Don't panic.

+ Go 语言中没有异常(`Exception`), 有类似机制 `panic`
+ 当 `panic` 发生时, 程序会崩溃
+ 其他语言的异常在行为和实现上与 Go 语言的错误值有很大的不同
  + 其他语言如果抛出(`throw`) 异常, 而且附近没有 `try ... catch ...` 那么它就会「冒泡」到函数的调用者那里, 如果还没有 `try ... catch ...` , 那么就会继续「冒泡」到更上层的调用者, 直到栈底(如 `main` 方法)
    + `Exception` 这种错误处理方式可被看作是可选的
      + 不处理异常, 就不需要加入其他代码
      + 要处理异常, 就要加入相当数量的专用代码 
  + Go语言中的错误值更简单灵活
    + 忽略错误时有意识的决定, 从代码上看也是显而易见的
+ 如何使用 `error`
  + 可能发生的错误只有一个时, 不使用 `error`, 返回 `bool` 类型
  + 不会出错的函数不使用 `error`
  + 多次尝试可以避免错误的时候, 不要立即返回错误
    + 例如访问网页, 刷新后可以进入

### `recover`

+ 为了防止 `panic` 导致程序崩溃, Go 提供了 `recover` 函数
+ `defer` 的动作会在函数返回前执行, 即使发生了 `panic`
+ 但如果 `defer` 的函数调用了 `recover`, `panic` 就会停止, 程序将继续运行

```go
package main

import "fmt"

func main() {

	defer func() {
		if e := recover(); e != nil {
			fmt.Println(e)
		}
	}()

	panic("Don't panic!")
}
```

