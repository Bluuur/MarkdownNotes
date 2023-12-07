开发步骤
1. 在 `webapps` 目录下新建一个目录，起名 `crm`（这个 `crm` 就是 Web app 的名字），当然，也可以是其它项目，比如银行项目，可以创建一个目录 `bank`，办公系统可以创建一个 `oa`.
   + `crm` 就是这个 `webapp` 的根

2. 在 `webapp` 的根下新建一个目录：WEB-INF
   + 这个目录的名字是 `Servlet` 规范中规定的，必须全部大写，必须一模一样。

3. 在 WEB-INF 目录下新建一个目录：`classes`
   + 目录的名字必须是全部小写的 `classes`。这也是 Servlet 规范中规定的。另外这个目录下一定存放的是 Java 程序编译之后的 class 文件(这里存放的是字节码文件）

4. 在 WEB-INF 目录下新建一个目录：`lib`
   + 这个目录不是必须的。但如果一个 `webapp` 需要第三方的 `jar` 包的话，这个 `jar` 包要放到这个 `lib` 目录下，这个目录的名字也不能随意编写，必须是全部小写的 `lib`。例如 Java 语言连接数据库需要数据库的驱动 `jar` 包。那么这个 `jar` 包就一定要放到 `lib` 目录下。这 Servlet 规范中规定的。

5. 在 WEB-INF 目录下新建一个文件：`web.xml`
   + 注意：这个文件是必须的，这个文件名必须叫做 `web.xml`。这个文件必须放在这里。一个合法的 webapp，`web.xml` 文件是必须的，这个 `web.xml` 文件就是一个配置文件，在这个配置文件中描述了请求路径和 Servlet 类之间的对照关系。
   + 这个文件最好从其他的 Web app 中拷贝，最好复制粘贴
    ```xml
    <?xml version="1.0" encoding="UTF-8"?>
   
    <web-app xmlns="https://jakarta.ee/xml/ns/jakartaee"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="https://jakarta.ee/xml/ns/jakartaee
                          https://jakarta.ee/xml/ns/jakartaee/web-app_5_0.xsd"
      version="5.0"
      metadata-complete="true">
    </web-app>
    ```
6. 编写一个 Java 程序，这个 Java 程序也不能随意开发，必须实现 Servlet 接口
    - Servlet 接口不在 JDK 当中。(因为 Servlet 不是 Java SE 了。Servlet 属于 Java EE，是另外的一套类库）
    - Servlet 接口(`Servlet.class` 文件）是 Oracle 提供的。(最原始的是 SUN 公司提供的.）
    - Servlet 接口是 Java EE 的规范中的一员。
    - Tomcat 服务器实现了 Servlet 规范，所以 Tomcat 服务器也需要使用 Servlet 接口。Tomcat 服务器中应该有这个接口，Tomcat 服务器的 `CATALINA_HOME\lib` 目录下有一个 `servlet-api.jar`，解压这个 `servlet-api.jar` 之后，你会看到里面有一个 `Servlet.class` 文件。
    - 从 `Jakarta EE 9` 开始，Servlet 的接口全名变为：`Jakarta.servlet.Servlet`
    - Java 源文件可以放在任意位置，只需要将 Java 源文件编译之后的 class 文件放在 classes 目录下即可
7. 编译 `HelloServlet`
    - 要让编译通过，需要先配置环境变量 `CLASSPATH`
        - `CLASSPATH=.;D:\Environments\apache-tomcat-10.0.14\lib\servlet-api.jar`
8. 将编译之后的 `HelloServlet.class` 文件复制到 `WEB-INF\classes` 目录下
9. 再 `web.xml` 文件中编写配置信息，让「请求路径」和「Servlet 类名」关联在一起
    - 这一步叫做：在 `web.xml` 文件中注册 `Servlet` 类
    ```xml
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
10. 启动 Tomcat
11. 打开浏览器 输入对应 URL
    - 请求路径必须和 `web.xml` 文件中的 `url-pattern` 一致
    - 浏览器上的请求路径要有项目名
---
- HTML 页面只能放在 WEB-INF 目录外面
- 不需要编写 `main` 方法，Tomcat 服务器负责调用 `main` 方法
- JavaWeb 程序员只需要编写 `Servlet` 接口的实现类，然后将其注册到 `web.xml` 文件中
- 一个合法的 Web app 目录结构:
```
webapproot
├─WEB-INF
│	├─classes（存放字节码）
│   ├─lib（第三方 jar 包）
│   └─web.xml（注册 Servlet）
├─html
├─css
├─javascript
├─image
└─...
```
- 浏览器发送请求，到最终服务器调用 Servlet 中的方法的大致过程
    - 用户输入 URL，或者直接点击超链接：[http://127.0.0.1:8080/crm/hello](http://127.0.0.1:8080/crm/hello)
    - 然后 Tomcat 服务器接收到请求，截取路径：`/crm/hello`
    - Tomcat 服务器找到 `crm` 项目
    - Tomcat 服务器在 `web.xml` 文件中查找 `hello` 对应的 `Servlet` 是：`com.feidian.servlet.HelloServlet`
    - Tomcat 服务器通过反射机制，创建 `com.bjpowernode.servlet.HelloServlet` 的对象
    - Tomcat 服务器调用 `com.bjpowernode.servlet.HelloServlet` 对象的 `service` 方法。

## 1. 关于 JavaEE 的版本

- JavaEE 目前最高版本是 JavaEE8
- Oracle 将 JavaEE 规范捐献给 Apache 软件基金会
- Apache 将 JavaEE 换名为 Jakarta EE
- Java EE 8 版本升级之后叫做 Jakarta EE 9
- Java EE 8 及之前版本对应的 Servlet 类名是 `javax.servlet.Servlet`
- Jakarta EE 9 及之后对应的 Servlet 类名是 `jakarta.servlet.Servlet`
- 如果之前的项目使用 `javax.servlet.Servlet`，那么项目无法直接部署到 `Tomcat 10+` 版本上。在 Tomcat 9 以及 Tomcat 9 之前的版本中还能够识别 `javax.servlet` 这个包。

## 2. 向浏览器响应一段 HTML 代码

```java
public void service(ServletRequest request，ServletResponse response）{
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    out.print("<h1>hello servlet!</h1>");
}
```
## 3. 在 Servlet 中连接数据库
- Servlet 是 Java 程序，所以在 Servlet 中编写 JDBC 代码连接数据库。
- 在一个 Web app 中连接数据库，需要将驱动 jar 包放到 `WEB-INF/lib` 目录下（`com.mysql.cj.jdbc.Driver` 这个类在驱动 jar 包当中）。