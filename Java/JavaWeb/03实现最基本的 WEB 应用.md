## 1. 实现最基本的 WEB 应用

1.  找到 `%CATALINA_HOME%\webapps` 目录
    - 所有的 Web app 要放到 `webapps` 目录下
2.  在 `%CATALINA_HOME%\webapps`目录下新建一个子目录，起名 `oa`
    - 目录名 `oa` 就是 Web app 的名字
3.  在 `oa` 目录下新建资源文件，例如`index.html`
4.  打开浏览器，输入 http://localhost:8080/oa/index.html
5.  在浏览器中输入 URL 的动作与点击超链接一样
    ```html
    <!-- 注意以下的路径，以/开始，带项目名，是一个绝对路径。不需要添加：http://127.0.0.1:8080 -->
    <a href="/oa/login.html">user login2</a>
    
    <!-- 多个层级也没有关系，正常访问即可。 -->
    <!-- 注意：我们目前前端上的路径都以「/」开始的，都是加项目名的。 -->
    <a href="/oa/test/debug/d.html">d page</a>
    ```
- http://127.0.0.1:8080/oa/userList.html
  - 访问这个地址，可以展示一个用户列表页面。但是这个用户列表页面是写在 HTML 文件当中的，这种资源称为静态资源。
  - 连接数据库需要 JDBC 程序，也就是说需要编写 Java 程序连接数据库，数据库中有多少条记录，页面上就显示多少条记录，这种技术被称为动态网页技术。
## 2. 参与 B/S 结构系统的角色

- 浏览器 Browser
- WEB Server
- DB Server
- Webapp
---
- 需要遵守的规范与协议
  - Webapps 开发团队与 WEB Server 开发团队
    - Servlet 规范
      - 作用：WEB Server 和 Web app 解耦合
  - Browser 和 WEB Server 之间有一套传输协议 :`HTTP` 协议
  - Web app 开发团队与 DB Server 开发团队之间有一套规范：JDBC 规范
- Servlet 规范 ^d540c6
  - 遵循 Servlet 规范的 Web app，这个 Web app 就可以放在不同的 WEB 服务器中运行。（因为这个 Web app 是遵循 Servlet 规范的。）
  - Servlet 规范包括的内容
    - 规范了类与接口
    - 规范 web 应用中应该有哪些配置文件
    - 规范 web 应用中配置文件的名字
    - 规范 web 应用中配置文件存放的路径
    - 规范 web 应用中配置文件的内容
    - 规范合法有效的 web 应用它的目录结构