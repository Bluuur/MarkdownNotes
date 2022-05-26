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
 ```



