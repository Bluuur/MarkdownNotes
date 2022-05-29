# Go Gin

> Go Gin 文档 https://gin-gonic.com/zh-cn/docs

1. 下载并安装 gin：

```sh
$ go get -u github.com/gin-gonic/gin
```

`example.main`:

```go
package main

import "github.com/gin-gonic/gin"

func main() {
	r := gin.Default()
    
    // 配置路由
    // 返回 JSON 的方法 1
	r.GET("/ping", func(c *gin.Context) {
        c.JSON(200, map[string]interface{}{
			"message": "pong",
		})
	})
    
    // 返回 JSON 的方法 2
    r.GET("/json", func(c *gin.Context) {
        c.JSON(200, gin.H{
            "success": true,
            "msg":     "hello gin",
        })
    })
	r.Run() // 监听并在 0.0.0.0:8080 上启动服务
    // 更改端口
	r.Run(":9999")
}
```

+ 返回 JSONP

  ```go
  User := User{
      Uid:      10001,
      UserName: "Zhang San",
      UserAge:  20,
      Gender:   true,
      Address:  "ShiZiShanJieYiHao",
  }
  
  // 将 struct 以 JSON 格式返回
  r.GET("/struct", func(c *gin.Context) {
  
      c.JSON(http.StatusOK, &User)
  })
  
  // 响应 JSONP 请求
  r.GET("/jsonp", func(c *gin.Context) {
  
      c.JSONP(http.StatusOK, &User)
  })
  ```

+ 响应 xml 数据

  ```go
  // 响应 xml 数据
  r.GET("/xml", func(c *gin.Context) {
  
      c.XML(http.StatusOK, &User)
  })
  ```

+ 响应 HTML

  ```go
  // 调用 HTML 需要 LoadHTMLGlob
  // 配置静态资源的路径
  r.LoadHTMLGlob("templates/*")
  
  // html 模板
  r.GET("index", func(c *gin.Context) {
      c.HTML(http.StatusOK, "index.html", gin.H{
          "title": "data from backend",
      })
  })
  ```

  + 访问后端数据

    ```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Index</title>
    </head>
    <body>
        <h2>{{.title}}</h2>
    </body>
    </html>
    ```

    ![image-20220529181427301](Go Gin.assets/image-20220529181427301.png)
