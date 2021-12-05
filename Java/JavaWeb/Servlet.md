# 系统架构

## C/S 架构

- Client / Server (客户端 / 服务器)
- C/S架构的软件/系统
    - QQ (先去下载QQ软件, 然后安装软件客户端, 输入QQ号以及密码, 登录之后, 就可以和你的朋友聊天了)
- C/S架构的特点
    - 需要安装特定的客户端软件
- C/S架构的系统优点和缺点
    - 优点：
        - 速度快 (软件中的数据大部分都是集成到客户端软件当中的, 很少量的数据从服务器端传送过来, 所以C/S结构的系统速度快)
        - 体验好 (速度快, 界面, 当然体验好了)
        - 专门的语言去实现界面, 更加灵活
        - 服务器压力小 (因为大量的数据都是集成在客户端软件当中, 服务器只需要传送很少的数据量, 所以服务器压力小 )
        - 安全（因为大量的数据是集成在客户端软件当中的, 并且客户端有很多个, 服务器虽然只有一个, 就算服务器受灾, 问题也不大, 因为大量的数据在多个客户端上有缓存, 有存储, 所以从这个方面来说, C/S结构的系统比较安全 ）
    - 缺点：
        - 升级维护比较差劲。（升级维护比较麻烦。成本比较高。每一个客户端软件都需要升级。有一些软件不是那么容易安装的。）

## B/S 架构

- B/S (Browser / Server, 浏览器 / 服务器 ) 
- http://www.baidu.com
- http://www.jd.com
- http://www.126.com
- B/S 结构的系统是不是一个特殊的C/S系统 ?
    - 实际上 B/S 结构的系统还是一个 C/S, 只不过 Client 比较特殊, 是一个固定不变浏览器软件
- B/S结构的系统优点和缺点
    - 优点:
        - 升级维护方便, 成本比较低. (只需要升级服务器端即可)
        - 不需要安装特定的客户端软件, 用户操作极其方便. 只需要打开浏览器, 输入网址即可. 
    - 缺点:
        - 速度慢 (不是因为带宽低的问题, 是因为所有的数据都是在服务器上, 用户发送的每一个请求都需要服务器全身心的响应数据, 所以 B/S 结构的系统在网络中传送的数据量比较大 )
        - 体验差 (界面不是那么酷炫, 因为浏览器只支持三个语言 `HTML` `CSS` `JavaScript`. 在加上速度慢. )
        - 不安全 (所有的数据都在服务器上, 只要服务器发生火灾, 地震等不可抗力, 最终数据全部丢失 )

### 开发 B/S 结构的系统需要用到的技术

- WEB前端 (运行在浏览器上的程序)
    - HTML
    - CSS
    - JavaScript
- WEB后端 (WEB服务器端的程序)
    - Java
        - Java 做 WEB 开发我们称为 JavaWEB 开发. JavaWEB 开发最核心的规范: `Servlet` (Server Applet 服务器端的 Java 小程序.）
    - C 语言
    - C++
    - Python
    - PHP
    - $\cdots$

# 关于 JavaEE

## Java SE

Java 标准版 (一套类库: 开发者写好的一套类库, 标准类库, 是 EE, ME 的基础 )

## Java EE

WEB 方向(WEB 系统)

+   Java 企业版
    +   也是一套类库, 可以帮助程序员完成企业级项目的开发, 专门为企业内部提供解决方案的一套(多套)类库
+   目前最流行的方向

## Java ME

Java 微型版, 这套类库帮助程序员进行电子微型设备内核程序的开发

---

Java EE 包括 13 种规范, Servlet 就是 Java EE 规范之一.

# B/S 结构的系统通信原理

## WEB 系统的访问过程

+   打开浏览器
+   在地址栏种输入一个合法的网址
+   回车后会在浏览器上展示响应的结果

## 域名

`www.bing.com` 是一个域名, 在浏览器输入域名回车之后, 域名解析器会将域名解析为一个具体的 `IP` 地址和端口号, 解析结果也许是 `https://202.89.233.100:80/index.html`

## IP 地址

`IP` 是一种协议的名称(Internet Protocol), IP 协议的作用是把各种数据包传送给对方. 而要保证确实传送到对
方那里, 则需要满足各类条件. 其中两个重要的条件是 `IP` 地址和 `MAC`地址 (Media Access Control Address).

`IP` 地址指明了节点被分配到的地址, `MAC` 地址是指网卡所属的固定地址. `IP` 地址可以和 `MAC` 地址进行配对. `IP` 地址可变换, 但 `MAC` 地址基本上不会更改.

`IP` 间的通信依赖 `MAC` 地址. 在网络上, 通信的双方在同一局域网 (`LAN`) 内的情况是很少的, 通常是经过多台计算机和网络设备中转才能连接到对方. 而在进行中转时, 会利用下一站中转设备的 `MAC` 地址来搜索下一个中转目标. 这时, 会采用 `ARP` 协议 (Address Resolution Protocol). ARP 是一种用以解析地址的协议, 根据通信方的 `IP` 地址就
可以反查出对应的 `MAC` 地址.

`DNS` (Domain Name System) 服务是和 `HTTP` 协议一样位于应用层的协议. 它提供域名到 `IP` 地址之间的解析服务. 计算机既可以被赋予 `IP` 地址, 也可以被赋予主机名和域名. 比如 www.hackr.jp 用户通常使用主机名或域名来访问对方的计算机, 而不是直接通过 `IP` 地址访问. 因为与 `IP` 地址的一组纯数字相比, 用字母配合数字的表示形式来指定计算机名更符合人类的记忆习惯. 但要让计算机去理解名称, 相对而言就变得困难了. 因为计算机更擅长处理一长串数字.  为了解决上述的问题, `DNS` 服务应运而生. `DNS` 协议提供通过域名查找 `IP` 地址, 或逆向从 `IP` 地址反查域名的服务.

# WEB 服务器

+   WEB 服务器软件
    +   Tomcat (WEB 服务器)
    +   jetty (WEB 服务器)
    +   JBOSS (应用服务器)
    +   WebLogic (应用服务器)
    +   WebSphere (应用服务器)
+   应用服务器和 WEB 服务器的关系
    +   应用服务器实现了 Java EE 的所有规范 (共 13 个)
    +   WEB 服务器只实现了 Java EE 中的 Servlet + JSP 两个核心的规范
    +   应用服务器包含 WEB 服务器
+   Tomcat
    +   apache 官网地址: https://www.apache.org
    - tomcat 官网地址: https://tomcat.apache.org
    - tomcat 开源免费的轻量级WEB服务器
    - 使用 Java 语言编写
    - 需要有 JRE 才能运行
+   需要配置的环境变量
    +   `JAVA_HOME=C:\Program Files\Java\jdk-17.0.1`
    +   `PATH=%JAVA_HOME%\bin`
    +   `CATALINA_HOME=Tomcat根目录`
+   Tomcat 服务器的目录
    +   `bin`: Tomcat 服务器的命令文件存放的目录
    +   `conf`: Tomcat 服务器的核心程序目录, 因为 Tomcat 服务器是 Java 语言编写的, 这里的 `jar`包都是 `class` 文件
    +   `logs`: Tomcat 服务器的日志目录, Tomcat 服务器启动等信息都会在这个目录下生成日志文件
    +   `temp`: Tomcat 服务器的临时目录, 存储临时文件
    +   `webapps`: 这个目录当中就是用来存放大量的 webapp (web application, web 应用)
    +   `work`: 用来存放 `JSP` 文件翻译之后的 Java 文件以及编译之后的 class 文件
+   Tomcat 的启动与关闭
    +   `startup`
    +   `stop`
        +   把 `shutdown.bat` 文件重命名为 `stop.bat`, 因为 shutdown 与 Windows 中的关机命令冲突
+   测试 Tomcat 服务器是否启动成功
    +   打开浏览器, 输入 http://localhost:8080

# 实现最基本的 WEB 应用

1.   找到 `CATALINA_HOME\webapps` 目录

     +   所有的 webapp 要放到 webapps 目录下

2.   在 `CATALINA_HOME\webapps`目录下新建一个子目录, 起名 `oa`

     +   目录名 `oa` 就是 webapp 的名字

3.   在 `oa` 目录下新建资源文件, 例如`index.html`

4.   打开浏览器, 输入 http://localhost:8080/oa/index.html

5.   在浏览器中输入 URL 的动作与点击超链接一样

     ```html
     <!--注意以下的路径，以/开始，带项目名，是一个绝对路径。不需要添加：http://127.0.0.1:8080-->
     <a href="/oa/login.html">user login2</a>
     
     <!--多个层级也没有关系，正常访问即可。-->
     <!--注意：我们目前前端上的路径都以“/”开始的，都是加项目名的。-->
     <a href="/oa/test/debug/d.html">d page</a>
     ```


- http://127.0.0.1:8080/oa/userList.html 
    - 访问这个地址, 可以展示一个用户列表页面. 但是这个用户列表页面是写死在 HTML 文件当中的. 这种资源我们称为静态资源. 怎么能变成动态资源. 显然需要连接数据库. 
    - 连接数据库需要 JDBC 程序, 也就是说需要编写 Java 程序连接数据库, 数据库中有多少条记录, 页面上就显示多少条记录, 这种技术被称为动态网页技术. (动态网页技术并不是说页面中有动画. 动态网页技术是说页面中的数据是动态的, 根据数据库中数据的变化而变化. ）

# 参与 B/S 结构系统的角色

+   浏览器 Browser
+   WEB Server
+   DB Server
+   Webapp

---

+   需要遵守的规范与协议
    +   Webapps 开发团队与 WEB Server 开发团队
        +   Servlet 规范
            +   作用: WEB Server 和 webapp 解耦合
    +   Browser 和 WEB Server 之间有一套传输协议 :`HTTP` 协议
    +   webapp 开发团队与 DB Server 开发团队之间有一套规范 : JDBC 规范
+   Servlet 规范
    +   遵循Servlet规范的webapp，这个webapp就可以放在不同的WEB服务器中运行。（因为这个webapp是遵循Servlet规范的。）
    +   Servlet规范包括什么呢？
        +   规范了类与接口
        +   规范 web 应用中应该有哪些配置文件
        +   规范 web 应用中配置文件的名字
        +   规范 web 应用中配置文件存放的路径
        +   规范 web 应用中配置文件的内容
        +   规范合法有效的 web 应用它的目录结构

# 开发一个带有 Servlet 的 webapp

+   开发步骤

    1.    在 `webapps` 目录下新建一个目录, 起名 `crm` (这个 `crm` 就是 webapp 的名字), 当然, 也可以是其它项目, 比如银行项目, 可以创建一个目录 `bank`, 办公系统可以创建一个 `oa`.

         - 注意: `crm` 就是这个 `webapp` 的根

    2.   在 `webapp` 的根下新建一个目录: WEB-INF

        - 注意: 这个目录的名字是 `Servlet` 规范中规定的, 必须全部大写, 必须一模一样. 

    3.   在 WEB-INF 目录下新建一个目录: `classes`

        - 注意: 这个目录的名字必须是全部小写的 `classes`. 这也是 Servlet 规范中规定的. 另外这个目录下一定存放的是 Java 程序编译之后的 class 文件(这里存放的是字节码文件)

    4.   在 WEB-INF 目录下新建一个目录: `lib`

        - 注意: 这个目录不是必须的. 但如果一个 `webapp` 需要第三方的 `jar` 包的话, 这个 `jar` 包要放到这个 `lib` 目录下，这个目录的名字也不能随意编写，必须是全部小写的 `lib`. 例如 Java 语言连接数据库需要数据库的驱动 `jar` 包. 那么这个 `jar` 包就一定要放到 `lib` 目录下. 这 Servlet 规范中规定的。

    5.   在 WEB-INF 目录下新建一个文件: `web.xml`

        - 注意: 这个文件是必须的, 这个文件名必须叫做 `web.xml`. 这个文件必须放在这里. 一个合法的 webapp, `web.xml` 文件是必须的, 这个 `web.xml` 文件就是一个配置文件, 在这个配置文件中描述了请求路径和 Servlet 类之间的对照关系. 

        - 这个文件最好从其他的 webapp 中拷贝, 最好复制粘贴

        - ```xml
            <?xml version="1.0" encoding="UTF-8"?>
            
            <web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                                  https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
              version="5.0"
              metadata-complete="true">
            
            
            </web-app>
            
            ```

    6.   编写一个 Java 程序, 这个 Java 程序也不能随意开发, 必须实现 Servlet 接口

         - Servlet 接口不在 JDK 当中. (因为 Servlet 不是 Java SE 了. Servlet 属于 Java EE, 是另外的一套类库.）
         - Servlet 接口(`Servlet.class`文件)是 Oracle 提供的. (最原始的是 SUN 公司提供的.)
         - Servlet 接口是 Java EE 的规范中的一员。
         - Tomcat 服务器实现了 Servlet 规范, 所以 Tomcat 服务器也需要使用 Servlet 接口. Tomcat 服务器中应该有这个接口, Tomcat 服务器的 `CATALINA_HOME\lib` 目录下有一个 `servlet-api.jar`, 解压这个 `servlet-api.jar` 之后, 你会看到里面有一个 `Servlet.class` 文件. 
         - 
