# Go 语言入门 7

## `goroutine`

+ 在 Go 中, 独立的任务叫做 `goroutine`
  + 虽然 `goroutine` 与其它语言中的协程, 进程, 线程都有相似之处, 但 `goroutine` 和它们并不完全相同
  + `goroutine` 创建效率非常高
  + Go 能直截了当的协同多个并发 (concurrent) 操作
+ 在某些语言中, 将顺序式代码转化为并发式代码需要做大量修改
+ 在 Go 里, 无需修改现有顺序式的代码, 就可以通过 `goroutine` 以并发的方式运行任意数量的任务

### 启动 `goroutine`

+ 在调用前加 `go` 关键字

  + ```go
    package main
    
    import (
    	"fmt"
    	"time"
    )
    
    func main() {
    	go sleepGopher()
    	time.Sleep(4 * time.Second)
    }
    
    func sleepGopher() {
    	time.Sleep(3 * time.Second)
    	fmt.Println("---snore---")
    }
    ```

+ 在 `main` 函数返回时, 其中的所有 `goroutine` 都会立即停止

### `goroutine` 的参数

+ 向 `goroutine` 传递参数就跟向函数传递参数一样, 参数都是按值传递的(传入的是副本)

 ```go
 package main
 
 import (
 	"fmt"
 	"time"
 )
 
 func main() {
 	for i := 0; i < 5; i++ {
 		go sleepGopher(i)
 	}
 	time.Sleep(4 * time.Second)
 }
 
 func sleepGopher(id int) {
 	time.Sleep(3 * time.Second)
 	fmt.Println("---snore---", id)
 }
 
 ```

## 通道  `channel`

+ 通道 (`channel`) 可以在多个 `goroutine` 之间安全的传值
+ 通道可以用作变量, 函数参数, 结构体字段
+ 创建通道用 `make` 函数, 并指定其传输数据的类型
  + `C := make(chan int)`

### 通道 `channel` 发送, 接受

+ 使用左箭头操作符 `<-` 向通道发送值或从通道接收值
  + 向通道发送值: `c <- 99`
  + 从通道接收值: `r := <- c`
+ 发送操作会等待直到另一个 `goroutine` 尝试对该通道进行接收操作为止
  + 执行发送操作的 `goroutine` 在等待期间将无法执行其它操作
  + 未在等待通道操作的 `goroutine` 让然可以继续自由的运行
+ 执行接收操作的 `goroutine` 将等待直到另一个 `goroutine` 尝试向该通道进行发送

### 使用 `select` 处理多个通道

+ `time.After` 函数, 返回一个通道, 该通道在指定时间后会接收到一个值(发送该值的 `goroutine` 是 Go 运行时的一部分)
+ `select` 和 `switch` 类似
  + 该语句包含的每个 `case` 都持有一个通道, 用来发送或接收数据
  + `select` 会等待直到某个 `case` 分支的操作就绪, 然后就会执行该 `case` 分支
+ 即使已经停止等待 `goroutine`, 只要 `mian` 函数还没返回, 仍在运行的 `goroutine` 将会继续占用内存

### `nil` 通道

+ 如果不使用 `make` 初始化通道, 那么通道变量的值就是 `nil` (零值)
+ 对 `nil` 通道进行发送或接收不会引起 `panic`, 但会导致永久阻塞
+ 对 `nil` 通道执行 `close` 函数, 那么会引起 `panic`
+ `nil` 通道的用处:
  + 对于包含 `select` 语句的循环, 如果不希望每次循环都等待 `select` 所涉及的所有通道, 那么可以先将某些通道设为 `nil`, 等到发送值准备就绪之后, 再将通道变成一个非 `nil` 值并执行发送操作

### 阻塞和死锁

+ 当 `goroutine` 在等待通道的发送或接收时, 处于阻塞状态
+ 除了 `goroutine` 本身占用少量的内存外, 被阻塞的 `goroutine` 并不消耗任何其它资源
+ `goroutine` 因为某些永远无法发生的事情被阻塞时, 称这种情况为死锁
  出现死锁的程序通常会崩溃或挂起

### 关闭通道

+ Go 允许在没有值可供发送的情况下通过 `close` 函数关闭通道
+ 通道被关闭后无法写入任何值, 如果尝试写入将引发 `panic`
+ 尝试读取被关闭的通道会获得与通道类型对应的零值
+ 注意: 如果循环里读取一个已关闭的通道, 并没检查通道是否关闭, 那么该循环可能会一直运转下去, 耗费大量CPU时间
+ 执行以下代码可以得知通道是否被关闭
  + `v, ok := <-c`
