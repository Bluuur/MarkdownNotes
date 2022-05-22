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

