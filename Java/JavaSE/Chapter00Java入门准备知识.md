# 熟悉 DOS 命令

## 磁盘操作系统 DOS

DOS 是磁盘操作系统的简称，是早期个人计算机上使用的一种操作系统。它可以直接操纵管理硬盘的文件，一般都是黑底白色文字的界面。从 1981 年到 1995 年的 15 年间，DOS 在 IBM PC 兼容机市场中占有举足轻重的地位。DOS 还有一些命令，可以用来执行不同的功能。

> (1) DOS（操作系统）百度百科. https://baike.baidu.com/item/dos/32025 
> (2) DOS是啥意思?怎么用的?百度知道. https://zhidao.baidu.com/question/5465349.html 
> (3) DOS命令百度百科. https://baike.baidu.com/item/dos%E5%91%BD%E4%BB%A4/5143255 

## 打开 DOS 命令窗口

1. Windows 徽标键 + R  打开「运行命令窗口」
2. 在运行窗口文本框中输入: `cmd`
3. 按下回车键回车

+   你也可以使用 `PowerShell` 
     `PowerShell` 支持所有的 DOS 命令 并且支持大部分的 Shell 命令。
    
+   PowerShell 和 DOS 是两种不同的命令行界面，可以用来与操作系统进行交互。它们的区别有以下几点：
    
    - PowerShell 是跨平台的，可以运行在 Windows、Linux 和 MacOS上，而 DOS 是 Windows 专用的。
    - PowerShell 使用称为 cmdlet 的命令，这些命令是独立的编程对象，可以访问 Windows 中的核心管理选项，而 DOS 使用传统的 DOS 命令。
    - PowerShell 有面向对象的管道，可以将一个命令的输出作为另一个命令的输入，而 DOS 的管道只能传递文本。
    - PowerShell 能够调用 .NET 的很多功能，可以编写更复杂的脚本，而 DOS 的功能相对有限。
    
    > (1) windows的cmd和powershell的区别（学习笔记，摘抄版）. https://blog.csdn.net/qq_34474071/article/details/122679462 
    > (2) windows powershell的中主要用处和其与DOS的区别_百度知道. https://zhidao.baidu.com/question/579183004.html 

>   默认情况下 DOS 命令窗口打开之后的工作目录 `C:\Users\<当前用户>`

虽然以上内容由许多参考自百度，但并不建议使用百度获取知识，你可以使用 Bing 或其他搜索引擎，如果可能的话，你也可以使用 Wikipedia.

## DOS 命令

在 DOS 命令窗口中才可以输入并执行 DOS 命令。
在最初的 Windows 计算机中没有图形界面，只有 DOS 命令窗口。
也就是说通过执行 DOS 命令窗口可以完全完成文件的新建、编辑、保存和删除等一系列操作。

## 常用的DOS命令

+   `mkdir <filename>` 
    +   创建目录名为 `<filename>` 的目录。

+   `cd <path>` 
    +   更改工作目录到 `<path>` .
    +   `cd` 指的是 change directory.
    +   如果需要切换盘符 例如切换到 D 盘 直接输入 `D:`。
    +   相对路径与绝对路径
        +   相对路径
            	从路径形式上来看，相对路径不以盘符为起点，相对路径一定是相对于当前所在位置而言的
            	（在 DOS 命令中，若使用 `cd` + 相对路径，计算机会在当前定位的目录下向下寻找）。
        +   绝对路径
            	在Windows系统中，凡是路径起点是盘符的都是绝对路径，例如：
            `C:\Program Files (x86)\Adobe`
    +   可以使用制表符键 `TAB` 自动补全路径。
    +   `cd ..` 
        +   返回上级目录。

    +   `cd \` 
        +   返回根目录。

    +   `cd .` 
        +   返回当前目录。

+   `cls` 
    +   清除DOS窗口上的内容。

+   `dir` 
    +   查看当前目录下的文件。

+   `exit` 
    +   退出 DOS 命令窗口。

+   `del` 删除一个或多个文件
    +   支持模糊匹配。

+   `ipconfig` 
    +   查看本机 `IP` 信息
        +   IP 地址：IP地址是可以看作计算机在同一个网络中的唯一标识。
        +   `ipconfig -all` 可以查看更加详细的信息。

+   `ping <ipAddress>` 插件两台计算机之间能否正常通信
    +   该命令来自 `pingpong` 一词。
    +   `ping <ipAddress> -t` 可以一直执行 ping 命令 直到主动停止。
        +   在一个 DOS 命令窗口中如果有一个命令一直在执行，可按 ctrl + C 停止。

# 使用文本编辑器编写 Java

1. 安装文本编辑器（以 Editplus 为例）

   + 你也可以直接安装并使用好用的 IDE（继承编译环境）如 IntelliJ IDEA.
   + 为了熟悉 Java 语法，你可以没有自动补全功能的文本编辑器。
       熟悉 Java 的语法，至少要能手写出 `main` 方法。

2. 下载安装 JDK (Java Development Kit) [Java Downloads | Oracle 中国](https://www.oracle.com/cn/java/technologies/downloads/)。

3. 对于 Java13 来说，如果想要生成一个独立于 JDK 之外的 JRE，需要另外操作。
    JDK13 安装的时候内置了一个 JRE (Java Runtime Environment)。需要注意的是，JDK8 在安装的时候，不仅 JDK 内置了一个 JRE，而且还会在 JDK 目录之外独立生成一个单独的 JRE (实际有两个 JRE)。

4. JDK 的 `bin` 目录下有：

    + `javac.exe` ：负责编译

    + `java.exe` ：负责运行

5. 编写 Java 代码。

6. 编译  Java 源代码产生字节码文件，只要修改就必须重新编译。

7. 运行字节码文件。

## 编译阶段

+   编译方法与编译命令
    +   需要使用的命令：`<YourJavaInstallPath>\Java\jdk-xx.x.x\bin\Javac.exe`
        +   这个命令需要先测试：打开 DOS 窗口，看看 `javac` 命令是否可用
        +   未配置环境变量时无法使用 `javac` 命令
            修改完环境变量必须重启 DOS 命令窗口
        +   环境变量包括系统变量和用户变量
            +   系统变量对所有用户起作用
            +   用户变量只对当前用户起作用
    
+   查看编译器版本 `javac -version`
+   查看 Java 虚拟机的版本 `java -version`

```
Java version "14.0.2" 2020-07-14
Java(TM) SE Runtime Environment (build 14.0.2+12-46)
Java HotSpot(TM) 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
```

### Javac 命令用法：

语法格式：`javac` + Java 源文件路径

>   把 Java 源文件拖进 DOS 命令窗口，可以直接显示路径，也适用于其他文件。

>   注：在存放 Java 源文件的目录下，上方地址栏中输入 cmd 后回车，可直接以前目录路径为工作目录下打开 DOS 命令窗口。

## 运行阶段

使用命令 `java`, 使用前可以先用 `java -version` 命令测试,

`java ` 命令语法格式: `java <className>`

运行结果：

```powershell
C:\Users\Documents\Java_learnling>java HelloWorld
Hello World!
```

>   需要注意的是 `java` 命令后跟的直接是需要执行的类的类名，而不能是文件名或文件路径。
>
>   如果输入的是 `java HelloWorld.class` 会提示以下错误: 
>
>   ```powershell
>   C:\Users\Documents\Java_learnling>Java C:\Users\12576\Documents\Java_learnling\HelloWorld
>   错误: 找不到或无法加载主类 C:\Users\12576\Documents\Java_learnling\HelloWorld
>   原因: Java.lang.ClassNotFoundException: C:\Users\12576\Documents\Java_learnling\HelloWorld
>   ```

### 运行Java程序的步骤

1. 先使用 cd 命令切换到字节码文件所在的路径。
2. 执行 Java 命令。

## `java helloWorld` 的执行过程及原理

`java HelloWorld`单击回车后，会发生：

1. 启动 JVM（Java Virtual Machine，Java 虚拟机）。
2. JVM 启动后
   +   JVM 会启动 「类加载器 classloader」
       +   类加载器的作用：加载类，本质上类加载器负责去硬盘上去找「类」对应的字节码文件。如果是 `java HelloWorld`，那么类加载器会在硬盘上搜索：`HelloWorld.class` 文件。
3. 如果类加载器在硬盘上找不到对应的字节码文件，会报错。

```powershell
C:\Users\Documents\Java_learnling>Java HelloWorld
错误: 找不到或无法加载主类 HelloWorld
原因: Java.lang.ClassNotFoundException: HelloWorld
```

+   如果类加载器在硬盘上找到了对应的字节码文件，类加载器会将该字节码文件装载到 JVM，JVM 启动解释器，将字节码解释为二进制码，操作系统执行二进制码和硬件交互。

>   +   默认情况下，类加载器去硬盘上找字节码文件的时候，默认查找路径。
>
>       +   当前目录下（相对路径），默认情况指没有配置 `classpath` 环境变量的情况。
>       
>+   给类加载器指定加载路径。
>   
>    +   需要设置一个环境变量，`classpath`，`classpath` 环境变量不属于 Windows OS，属于 Java，1 是 Java 特有的，`classpath` 环境变量不是必须要配置的。
>       +   `classpath=<PathA>; <PathB>`
>       +   `classpath` 是一个变量名，A 路径，B 路径是变量值，变量名不能随便写，大小写不敏感，但必须叫做 `classpath`。
>       +   配置好后，类加载器不会在当前目录下查找字节码文件，而是去配置的路径下查找。



+ 在高版本的 JDK 中，可以直接在 Java 命令后直接加 Java 源文件的路径，可以直接实现编译与运行。
  + 这个特性是为了简化开发而提出，还是会先进行编译，然后再运行，并且以上的运行方式编译。
  + 生成的 class 字节码文件在硬盘上不存在，只是在内存中生成。
  + 在当前(2020)广泛使用的 Java 8 中无此特性。

# Java 语言概述及发展史

JDK（Java 开发工具箱，做 Java 开发必须安装，是最根本的环境） 指 Java Development Kit，JDK 不是集成开发环境，是 Java 最核心的库，在 Java 中真正操作内存的是 JVM。

+ 1998 年时 Java 升级到 JDK 1.2，Java 被分为三大块：
  + J2SE：标准版（基础，学 Java 必须先学 SE，基础语法 + 基础库）
  + J2EE：企业版（专门为企业开发软件，提供解决方案）
  + J2ME：微型版（专门为微型设备做嵌入式开发）
+ 2005 年时改名
  + JavaSE
  + JavaEE
  + JavaME
+ 安卓底层是 Java 语言
  + Java 语言底层是 C++，所以 JVM（Java 虚拟机）就是用 C++ 写好的一个虚拟的电脑
  + 安装好 JDK 之后，就安装好了 JVM.
+ Java 语言特性
  + 简单性
    + 相对 C，C++ 语言更简单。
  + 面向对象
    + Java 中提供了封装、继承、多态等面向对象的机制。
    + Java 堪称完全面向对象 。
    + 采用面向对象的方式可以使复杂问题简单化。
  + 健壮性（Robust）
    + Java 中有一种自动垃圾回收机制（GC 机制 Garbage Collection），JVM 自动调度 GC 机制，程序员不需要干涉。
    + 也可以手动调度 GC 机制。
    + Java 不容易导致内存的泄露
    + C++ 或 C 语言使用不当使很容易导致内存泄漏
  + Java 完全支持多线程并发
  + 可移植性/跨平台
    + Java语言只要编写一次，可以做到到处运行。
      + 例如：Java 程序编写完之后，可以运行在 Windows OS 上。
        不需要任何改动就可以运行在 linux 上，也可以运行在 Mac OS（类 linux 系统）上（通过在不同操作系统上运行不同的Java虚拟机） 。
      + JVM 屏蔽了不同操作系统间的差异，JVM 是在安装 JDK 时得到的，不同版本 JDK 有不同 JVM.
  + JDK, JRE, JVM 三者之间的关系
    + JDK：Java 开发工具箱 Java Development Kit	
    + JRE：Java 运行环境 Java Runtime Environment	
    + JVM：Java 虚拟机 Java Virtue Machine
    + JDK 包括 JRE，JRE 包括 JVM，JVM 不能独立安装，JRE 和 JDK 可以单独安装。
      安装 JDK 的时候，JRE 自动安装，同时 JRE 内部的 JVM 也自动安装了，JRE 体积小，安装便捷快速。

> 内容参考动力节点Java零基础视频，已获得原作者许可。
> 视频链接https://www.bilibili.com/video/BV1Rx411876f