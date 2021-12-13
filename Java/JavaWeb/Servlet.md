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

    2.    在 `webapp` 的根下新建一个目录: WEB-INF

          - 注意: 这个目录的名字是 `Servlet` 规范中规定的, 必须全部大写, 必须一模一样. 

    3.    在 WEB-INF 目录下新建一个目录: `classes`

          - 注意: 这个目录的名字必须是全部小写的 `classes`. 这也是 Servlet 规范中规定的. 另外这个目录下一定存放的是 Java 程序编译之后的 class 文件(这里存放的是字节码文件)

    4.    在 WEB-INF 目录下新建一个目录: `lib`

          - 注意: 这个目录不是必须的. 但如果一个 `webapp` 需要第三方的 `jar` 包的话, 这个 `jar` 包要放到这个 `lib` 目录下，这个目录的名字也不能随意编写，必须是全部小写的 `lib`. 例如 Java 语言连接数据库需要数据库的驱动 `jar` 包. 那么这个 `jar` 包就一定要放到 `lib` 目录下. 这 Servlet 规范中规定的。

    5.    在 WEB-INF 目录下新建一个文件: `web.xml`

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

    6.    编写一个 Java 程序, 这个 Java 程序也不能随意开发, 必须实现 Servlet 接口

          - Servlet 接口不在 JDK 当中. (因为 Servlet 不是 Java SE 了. Servlet 属于 Java EE, 是另外的一套类库.）
          - Servlet 接口(`Servlet.class` 文件)是 Oracle 提供的. (最原始的是 SUN 公司提供的.)
          - Servlet 接口是 Java EE 的规范中的一员。
          - Tomcat 服务器实现了 Servlet 规范, 所以 Tomcat 服务器也需要使用 Servlet 接口. Tomcat 服务器中应该有这个接口, Tomcat 服务器的 `CATALINA_HOME\lib` 目录下有一个 `servlet-api.jar`, 解压这个 `servlet-api.jar` 之后, 你会看到里面有一个 `Servlet.class` 文件. 
          - 从 `Jakarta EE 9` 开始, Servlet 的接口全名变为: `Jakarta.servlet.Servlet`
          - Java 源文件可以放在任意位置, 只需要将 Java 源文件编译之后的 class 文件放在 classes 目录下即可 

    7.    编译 `HelloServlet `

          +   要让编译通过, 需要先配置环境变量 `CLASSPATH`
              +   `CLASSPATH=.;D:\Environments\apache-tomcat-10.0.14\lib\servlet-api.jar`

    8.    将编译之后的 `HelloServlet.class` 文件复制到  `WEB-INF\classes` 目录下

    9.    再 `web.xml` 文件中编写配置信息, 让「请求路径」和「Servlet 类名」关联在一起

          +   这一步叫做: 在 `web.xml` 文件中注册 `Servlet` 类

          +   ```xml
              <?xml version="1.0" encoding="UTF-8"?>
              
              <web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
                xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                                    https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
                version="5.0"
                metadata-complete="true">
              
              	<!--servlet描述信息-->
              	<!--任何一个servlet都对应一个servlet-mapping -->
              	<servlet>
              		<servlet-name>fdsafdsagfdsafdsa</servlet-name>
              		<!--这个位置必须是带有包名的全限定类名-->
              		<servlet-class>com.bjpowernode.servlet.HelloServlet</servlet-class>
              	</servlet>
              
              	<!--servlet映射信息-->
              	<servlet-mapping>
              		<!--这个也是随便的，不过这里写的内容要和上面的一样。-->
              		<servlet-name>fdsafdsagfdsafdsa</servlet-name>
              		<!--这里需要一个路径-->
              		<!--这个路径唯一的要求是必须以 / 开始-->
              		<!--当前这个路径可以随便写-->
              		<url-pattern>/fdsa/fd/saf/d/sa/fd/sa/fd</url-pattern>
              	</servlet-mapping>
              	
              </web-app>
              
              ```

    10.    启动 Tomcat

    11.    打开浏览器 输入对应 URL

           +   请求路径必须和 `web.xml` 文件中的 `url-pattern` 一致
           +   浏览器上的请求路径要有项目名

+   html 页面只能放在 WEB-INF 目录外面

+   不需要编写 `main` 方法, Tomcat 服务器负责调用 `main` 方法

+   JavaWeb 程序院只需要编写 `Servlet` 接口的实现类, 然后将其注册到 `web.xml` 文件中

+   一个合法的 webapp 目录结构:

    ```plaintext
    webapproot
         |------WEB-INF
         		  |------classes(存放字节码)
         		  |------lib(第三方jar包)
         		  |------web.xml(注册Servlet)
         |------html
         |------css
         |------javascript
         |------image
         ....
    ```

+   浏览器发送请求, 到最终服务器调用Servlet中的方法的大致过程

    - 用户输入 URL，或者直接点击超链接：http://127.0.0.1:8080/crm/hello
    - 然后 Tomcat 服务器接收到请求, 截取路径: `/crm/hello`  
    - Tomcat 服务器找到 `crm` 项目
    - Tomcat 服务器在 `web.xml` 文件中查找 `hello` 对应的 `Servlet` 是: `com.feidian.servlet.HelloServlet`
    - Tomcat 服务器通过反射机制, 创建 `com.bjpowernode.servlet.HelloServlet` 的对象
    - Tomcat 服务器调用 `com.bjpowernode.servlet.HelloServlet` 对象的 `service` 方法。

## 关于 JavaEE 的版本

+   JavaEE 目前最高版本是 JavaEE8
+   Oracle 将 JavaEE 规范捐献给 Apache 软件基金会
+   Apache 将 JavaEE 换名为 Jakarta EE
+   Java EE 8 版本升级之后叫做 Jakarta EE 9
+   Java EE 8 及之前版本对应的 Servlet 类名是 `javax.servlet.Servlet`
+   Jakarta EE 9 及之后对应的 Servlet 类名是 `jakarta.servlet.Servlet` 
+   如果之前的项目使用 `javax.servlet.Servlet`, 那么项目无法直接部署到 `Tomcat 10+` 版本上. 在 Tomcat 9 以及 Tomcat 9 之前的版本中还能够识别 `javax.servlet` 这个包

## 解决 Tomcat 服务器在 DOS 命令窗口中的乱码问题

将 `CATALINA_HOME/conf/logging.properties `文件中的内容修改如下: 

`java.util.logging.ConsoleHandler.encoding = GBK`

## 向浏览器响应一段 HTML 代码

```java
public void service(ServletRequest request, ServletResponse response){
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.print("<h1>hello servlet!</h1>");
}
```

## 在 Servlet 中连接数据库

- Servlet 是 Java 程序, 所以在 Servlet 中编写 JDBC 代码连接数据库
- 在一个 webapp 中连接数据库, 需要将驱动 jar 包放到 `WEB-INF/lib` 目录下(`com.mysql.cj.jdbc.Driver` 这个类就在驱动jar包当中)

# 在 IntelliJ IDEA 中开发 Servlet 程序

1.   创建项目 New Project

2.   新建模块 New Module

     +   创建普通的 Java SE 模块

3.   让 Module 变为 Java EE 的模块

     +   右键 Module, Add Framework Support (添加框架支持)
     +   在弹出的窗口中, 选择 Web Application
     +   IDEA 会自动生成一个符合 Servlet 规范的 webapp 目录结构
     +   在IDEA工具中根据 Web Application 模板生成的目录中有一个 web 目录, 这个目录就代表webapp的根

4.   (非必须) 根据 Web Application 生成的资源中有 `index.jsp` 文件, 这里选择删除这个 `index.jsp` 文件

5.   编写 Servlet (StudentServlet)

     +   `class StudentServlet implements Servlet`
     +   这里会提示没有 `Servlet.class` 文件
         +   将 `CATALINA_HOME/lib/servlet-api.jar` 和 `jsp-api.jar` 添加到 IDEA 的 classpath
         +   `File` -> `Project Structrue` -> `Modules` -> + 加号 -> `Add JARS....`
         +   实现 `jakarta.servlet.Servlet` 接口中的 5 个方法

6.   在 `Servlet` 当中的 `service` 方法中编写业务代码 这里连接了数据库

7.   在 WEB-INF 目录下新建了一个子目录: lib (这个目录名可不能随意, 必须是全部小写的lib), 并且将连接数据库的驱动 jar 包放到 lib 目录下

8.   在 `web.xml` 文件中完成 `StudentServlet` 类的注册

     ````xml
     <?xml version="1.0" encoding="UTF-8"?>
     <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
              version="4.0">
     
         <servlet>
             <servlet-name>studentServlet</servlet-name>
             <servlet-class>com.feidian.javaweb.servlet.StudentServlet</servlet-class>
         </servlet>
         <servlet-mapping>
             <servlet-name>studentServlet</servlet-name>
             <url-pattern>/servlet/student</url-pattern>
         </servlet-mapping>
         
     </web-app>
     ````

9.   通过 URL 发送请求 Tomcat 执行后台的 `StudentServlet`

     +   `student.html`

     - 这个文件不能放到 WEB-INF 目录里面, 只能放到 WEB-INF 目录外面

     - `student.html` 文件的内容

     - ```html
         <!DOCTYPE html>
         <html lang="en">
         <head>
             <meta charset="UTF-8">
             <title>student page</title>
         </head>
         <body>
             <!--这里的项目名是 /xmm ，无法动态获取，先写死-->
             <a href="/xmm/servlet/student">student list</a>
         </body>
         </html>
         ```

10.   IDEA 关联 Tomcat 服务器 关联的过程中将 webapp 布署到 Tomcat 服务器当中

      +   Add Configuration
      +   加号, Tomcat Server -> local
      +   设置服务器 Server 的参数
      +   Deployment 点击用来布署 webapp, 继续点击加号, 布署
      +   修改 Application context 为 `/xmm`

11.   启动 Tomcat 服务器

      +   建议使用 debug 模式启动 Tomcat

12.   在浏览器中输入 URL

# Servlet 对象的生命周期

+   Servlet 对象的生命周期
    +   Servlet 对象的创建
    +   Servlet 对象的销毁
    +   Servlet 对象的创建数量
    +   Servlet 对象生命周期表示 一个 Servlet 对象从创建到销毁的全过程

+   Servlet 对象的维护
    +   Servlet 对象的创建, 对象方法的调用, 对象最终的销毁, JavaWeb 程序员是无权干预的
    +   Servlet 对象的生命周期是由 Tomcat 服务器(WEB Server) 全权负责
    +   Tomcat 服务器又称为 WEB 容器

+   程序员自己创建的 Servlet 对象
    +   程序员自己创建的 Servlet 对象是不受 WEB 容器管理的
    +   WEB 容器创建的 Servlet 对象都会被发给到一个集合中(HashMap), 只有放到这个集合中的 Servlet 对象才能够被 WEB 容器管理, 自己创建的 Servlet 对象不会被 WEB 容器管理 (程序员自己创建的 Servlet 对象不在容器中)
    +   web 容器底层应该有一个 HashMap 这样的集合, 在这个集合中存储了 Servlet 对象和请求路径之间的关系

+   服务器在启动的 Servlet 对象是否被创建

    +   在 Servlet 中提供一个无参数的构造方法, 启动服务器的时候看构造方法是否执行
    +   测试结果: 在默认情况下, 服务器在启动时 Servlet 对象不会被实例化
    +   这个设计是合理的, 用户没有发送请求之前, 如果提前创建出来所有的 Servlet 对象, 会耗费内存, 而且创建出来的 Servlet 对象如果一直没有用户访问, 那么这个 Servlet 对象是没有必要创建的.

+   让服务器在启动时创建 Servlet 对象

    +   在 servlet 标签中添加 `<load-on-startup>` 子标签, 在该子标签中填写整数, 越小的整数优先级越高

    +   ```xml
        <servlet>
            <servlet-name>aservlet</servlet-name>
            <servlet-class>com.feidian.javaweb.servlet.AServlet</servlet-class>
            <load-on-startup>1</load-on-startup>
        </servlet>
        <servlet-mapping>
            <servlet-name>aservlet</servlet-name>
            <url-pattern>/a</url-pattern>
        </servlet-mapping>
        ```

+   Servlet 对象生命周期

    +   默认情况下服务器启动的时候 AServlet 对象并没有被实例化

    +   用户发送洗一次请求的时候, 控制台输出了一下内容:

        ```pliantext
        AServlet无参数构造方法执行了
        AServlet's init method execute!
        AServlet's service method execute!
        ```

    +   根据以上输出内容得出结论:

        +   用户在发闪送第一次请求的时候 Servlet 对象被实例化 (AServlet 的构造方法被执行了. 并且执行的是无参数构造方法.)
        +   AServlet 对象被创建出来之后, Tomcat 服务器马上调用了 AServlet 对象的 `init` 方法 (`init` 方法在执行的时候, AServlet 对象已经存在)
        +   用户发送第一次请求的时候, `init` 方法执行之后, Tomcat 服务器马上调用 AServlet 对象的 `service` 方法. 

    +   用户继续发送第二次请求, 控制台输出了以下内容

        ```plaintext
        AServlet's service method execute!
        ```

    +   根据以上输出结果得知, 用户在发送第二次及以后的请求的时候, Servlet 对象并没有新建, 还是使用之前创建好的 Servlet 对象, 直接调用该 Servlet 对象的 `service` 方法. 这说明:

        1.   Servlet 对象是单例的(单实例 但是要注意, Servlet 对象是单实例的, 但是 Servlet 类并不符合单例模式, 称之为假单例, 之所以单例是因为 Servlet 对象的创建不受 JavaWeb 程序员管理, 而是由 Tomcat 管理, Tomcat 只创建了一个, 所以单例. 真单例模式的构造方法是私有化的.)
        2.   无参数构造方法, `init` 方法只在第一次用户发送请求的时候执行,  也就是说无参数构造方法只执行一次, `init` 方法也制备 Tomcat 服务器调用一次.
        3.   只要用户发送一次请求, `service` 方法必然会被 Tomcat 服务器调用一次.

    +   关闭服务器的时候, 控制台输出了以下内容: 

        ```plaintext
        AServlet's destroy method execute!
        ```

    +   通过以上输出内容, 可以得出:

        1.   Servlet 的 `destroy` 方法只被 Tomcat 服务器调用一次
        2.   在服务器关闭, 会调用 `destroy` 方法
             +   服务器关闭的时候要销毁 AServlet 对象的内存
             +   服务器在销毁 AServlet 对象的内存之前, Tomcat 服务器会自动调用 AServlet 对象的 `destroy` 方法. 

    +   `destroy` 方法执行时 AServlet 对象还没有被销毁. `destroy` 方法执行结束之后, AServlet 对象的内存才会被 Tomcat 释放. 

    +   Servlet 类中方法的调用次数

        - 构造方法只执行 1 次
        - `init` 方法只执行 1 次
        - `service` 方法：用户发送 1 次请求则执行 1 次
        - `destroy` 方法只执行 1 次

    +   Servlet 类中编写一个有参数的构造方法, 但没有手动编写无参数构造方法

        - 报错了: 500错误
        - 500 一般情况下是因为服务器端的 Java 程序出现了异常
            服务器端的错误都是500错误：服务器内部错误。
        - 如果没有无参数的构造方法, 会导致出现 500 错误, 无法实例化 Servlet 对象
        - 所以, 在 Servlet 开发当中, 不建议程序员定义构造方法, 因为定义不当, 会导致无法实例化 Servlet 对象

    +   能否使用无参数构造方法代替 `init` 方法

        +   不能,  Servlet 规范中有要求, 作为 Javaweb 程序员, 编写 Servlet 类的时候, 不建议手动编写构造方法, 因为编写构造方法, 很容易让无参数构造方法消失, 这个操作可能会导致 Servlet 对象无法实例化. 所以 `init` 方法是有存在的必要的. 

    +   关于 `init`, `service`, `destroy` 方法

        +   使用最多的是 `service` 方法, `service` 方法是处理用户请求的核心方法.
        +   `init` 方法很少用, 通常在 `init` 方法当中做初始化操作, 并且这个初始化操作只需要执行一次. 例如, 初始化数据库连接池, 初始化线程池等
        +   
