## Tomcat 的安装与配置

- Apache 官网地址：https://www.apache.org
- Tomcat 官网地址：https://tomcat.apache.org
- Tomcat 是一个开源免费的轻量级 WEB 服务器，使用 Java 语言编写，需要有 JRE 才能运行。
- 需要配置的环境变量
  - `JAVA_HOME=...\Java\jdk-17.0.1`
  - `PATH=%JAVA_HOME%\bin`
  - `CATALINA_HOME=Tomcat根目录`
- Tomcat 服务器的目录
  - `bin`：Tomcat 服务器的命令文件存放的目录
  - `conf`：Tomcat 服务器的核心程序目录，因为 Tomcat 服务器是 Java 语言编写的，这里的 `jar`包都是 `class` 文件。
  - `logs`：Tomcat 服务器的日志目录，Tomcat 服务器启动等信息都会在这个目录下生成日志文件。
  - `temp`：Tomcat 服务器的临时目录，存储临时文件。
  - `webapps`：用来存放大量的 Web app（Web application，Web 应用）。
  - `work`：用来存放 `JSP` 文件翻译之后的 Java 文件以及编译之后的 class 文件。
- Tomcat 的启动与关闭
  - `startup`
  - `stop`
    - 把 `shutdown.bat` 文件重命名为 `stop.bat`，或其他你喜欢的名称，因为 `shutdown` 与 Windows 中的关机命令冲突。
- 测试 Tomcat 服务器是否启动成功
  - 打开浏览器，输入 http://localhost:8080

## 解决 Tomcat 服务器在 DOS 命令窗口中的乱码问题

将 `%CATALINA_HOME%/conf/logging.properties `文件中的内容修改如下：
`java.util.logging.ConsoleHandler.encoding = GBK`