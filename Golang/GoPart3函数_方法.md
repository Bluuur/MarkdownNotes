# Go 语言入门 3

## 函数

声明

```go
func Intn(n int) int
```

```
keyword name  parameter  result
			(name type)
```

调用

`num := rand.Intn(10)`

`package.name(argument)`

+ 同一包内可以省略包名

### 函数声明

+ 在 Go 中, 大写字母开头的函数, 变量或其它标识符都会被导出, 对其它包可用
+ 小写字母开头的不行
+ 函数的参数可以是多个
+ 函数的返回值可以是多个
  + `func Atoi(s string) (int, error)`
  + 多个返回值需要用括号, 可以去掉返回值名字, 只保留类型

#### 可变参数函数

+ `Println` 可以接受多个参数, 参数类型可以不同
  + `func Println(a ...interface{}) (n int, err error)`
    + `...` 表示函数的参数的数量是可变的
    + 参数 `a` 的类型为 `interface{}`, 是一个空接口, 可以接受所有类型的参数 

```go
package main

import "fmt"

func main() {
	kelvin := 294.0
	celsius := kelvinToCelsius(kelvin)
	fmt.Println(kelvin, " K is ", celsius, "°C")
}

func kelvinToCelsius(k float64) float64 {
	k -= 273.15
	return k
}
```

+ 按值传递
  + 变量被传入的时候, 建立了新的副本, 而不是传递变量本身
  + `kelvin` 本身的值没有修改


### 一等函数

+ 在 Go 中, 函数是一等(头等)的, 它可以用在整数, 字符串或其他类型能用的地方

  + 将函数赋值给变量(不加括号)

    + ```go
      func doSome() {
      	fmt.Println("Do some!")
      }
      
      // myFunc 的变量类型为函数
      myFunc := doSome
      
      // 执行 doSome 函数
      myFunc()
      ```

  + 将函数作为参数传递给函数

    + ```go
      package main
      
      import (
      	"fmt"
      	"math/rand"
      	"time"
      )
      
      type celsius float64
      type kelvin float64
      
      func main() {
      	measureTemperature(3, fakeSensor)
      }
      
      func measureTemperature(samples int, sensor func() kelvin) {
      	for i := 0; i < samples; i++ {
      		k := sensor()
      		fmt.Printf("%v K\n", k)
      		time.Sleep(time.Second)
      	}
      }
      
      func fakeSensor() kelvin {
      	return kelvin(rand.Intn(151) + 150)
      }
      ```

### 声明函数类型

+ 为函数声明类型有助于精简和明确调用者的代码
  + 声明 `type sensro func() kelvin` 
    可以将 `func measureTemperature(samples int, s func() kelvin)`
    精简为 `func measureTemperature(samples int, s sensor)`

### 闭包和匿名函数

+ 匿名函数就是没有名字的函数, 在 Go 中也称作函数字面值

  + ```go
    var f = func() {
    	fmt.Println("hello")
    }
    
    func main(){
    	f()
    }
    ```

  + ```go
    func main() {
        //声明匿名函数并立即执行(不赋值给变量)
    	func() {
    		fmt.Println("Hello")
    	}()
    }
    ```

+ 因为函数字面值需要保留外部作用域的变量引用, 所以函数字面值都是闭包的

  + ```go
    package main
    
    import "fmt"
    
    type kelvin float64
    
    type sensor func() kelvin
    
    func main() {
    	// sensor 被赋值为 calibrate 函数的返回值, 是一个函数
    	sensor := calibrate(realSensor, 5)
    	fmt.Println(sensor())
    }
    
    func realSensor() kelvin {
    	return 0
    }
    
    func calibrate(s sensor, offset kelvin) sensor {
    	// 被返回的匿名函数包含了 calibrate 函数的参数 
    	return func() kelvin {
    		// s 是 realSensor 函数, 在这里被运行, 结果为 0
    		return s() + offset
    	}
    }
    
    ```

  + 闭包就是由于匿名函数封闭并包围作用域中的变量而得名的

## 方法

Java 中方法属于类

### 声明新类型

+ 关键字 `type` 用来声明新类型
  + `type celsius float64`
    + 新类型 `celsius` 的底层类型是 `float64`
    + 可以理解为 `celsius` 是 `float64` 的别名
    + 但 `celsius` 和 `float64` 不能混用

### 通过方法添加行为

+ Go 中提供了方法, 但没有提供类和对象

+ Go 比其他语言的方法灵活

+ 可以将方法与同包中声明的任何类型关联, 但不可以是 `int`, `float64` 等预声明类型

  + ```go
    package main
    
    import "fmt"
    
    type celsius float64
    type kelvin float64
    
    // keyword  receiver   methodName result
    //         (name type)
    func (k kelvin) celsius() celsius {
    	return celsius(k - 273.15)
    }
    ```

    + `celsius()` 方法是关联 `kelvin` 类型的
    + 类似于 Java 中 `kelvin` 类中的 `celsius` 方法
    + `kelvin` 是 `celsius()` 方法的接收者
    + 每个方法可以有多个参数, 但只能有一个接收者
    + 在方法体中,  接收者的行为和其他参数一样

