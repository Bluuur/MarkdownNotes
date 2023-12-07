1. 创建项目 New Project
2. 新建模块 New Module
    - 创建普通的 Java SE 模块
3. 让 Module 变为 Java EE 的模块
    - 右键 Module，Add Framework Support（添加框架支持）
    - 在弹出的窗口中，选择 Web Application
    - IDEA 会自动生成一个符合 Servlet 规范的 Web app 目录结构
    - 在 IDEA 工具中根据 Web Application 模板生成的目录中有一个 web 目录，这个目录就代表 webapp 的根
4. （非必须） 根据 Web Application 生成的资源中有 `index.jsp` 文件，这里选择删除这个 `index.jsp` 文件
5. 编写 Servlet（StudentServlet）
    - `class StudentServlet implements Servlet`
    - 这里会提示没有 `Servlet.class` 文件
        - 将 `CATALINA_HOME/lib/servlet-api.jar` 和 `jsp-api.jar` 添加到 IDEA 的 classpath
        - `File` -> `Project Structrue` -> `Modules` -> + 加号 -> `Add JARS....`
        - 实现 `jakarta.servlet.Servlet` 接口中的 5 个方法
6. 在 `Servlet` 当中的 `service` 方法中编写业务代码 这里连接了数据库
7. 在 WEB-INF 目录下新建了一个子目录：lib（这个目录名可不能随意，必须是全部小写的 lib），并且将连接数据库的驱动 jar 包放到 lib 目录下
8. 在 `web.xml` 文件中完成 `StudentServlet` 类的注册
```xml
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
```
9. 通过 URL 发送请求 Tomcat 执行后台的 `StudentServlet`
	- `student.html`
	- 这个文件不能放到 WEB-INF 目录里面，只能放到 WEB-INF 目录外面
	- `student.html` 文件的内容
10. IDEA 关联 Tomcat 服务器 关联的过程中将 Web app 布署到 Tomcat 服务器当中
    - Add Configuration
    - 加号，`Tomcat Server -> local`
    - 设置服务器 Server 的参数
    - Deployment 点击用来布署 webapp，继续点击加号，布署
    - 修改 Application context 为 `/xmm`
11. 启动 Tomcat 服务器
    - 建议使用 debug 模式启动 Tomcat
12. 在浏览器中输入 URL