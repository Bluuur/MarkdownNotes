# 熟悉DOS命令

## 打开DOS命令窗口

​	Windows徽标键 + R  打开 “运行命令窗口”
​	在运行窗口文本框中输入: `cmd`
​	然后回车

+   你也可以使用 `PowerShell` 
     `PowerShell` 支持所有的DOS命令 并且支持大部分的 `Shell` 命令

>   默认情况下DOS命令窗口打开之后的工作目录 `C:\Users\Adminstrator`

## DOS命令

​	在 DOS 命令窗口中才可以输入并执行 DOS 命令
​	在最初的 Windows 计算机中没有图形界面，只有 DOS 命令窗口
​	也就是说通过执行 DOS 命令窗口可以完全完成文件的新建、编辑、保存和删除等一系列操作

## 常用的DOS命令

+   `mkdir [filename]` 创建目录名为 `[filename]` 的目录
+   `cd [path]` 更改工作目录到 `[path]` 
    +   `cd` 指的是 change directory
    +   如果需要切换盘符 例如切换到 D盘 直接输入 `D:`
    +   相对路径与绝对路径
        +   相对路径
            	从路径形式上来看，相对路径不以盘符为起点，相对路径一定是相对于当前所在位置而言的
            	（在DOS命令中，若使用`cd` + 相对路径，计算机会在当前定位的目录下向下寻找）
        +   绝对路径
            	在Windows系统中凡是路径起点是盘符的都是绝对路径，例如：
            		`C:\Program Files (x86)\Adobe`
    +   使用制表符键 `TAB` 自动补全
    +   `cd ..` 返回上级目录
    +   `cd \` 返回根目录
    +   `cd .` 返回当前目录

+   `cls` 清除DOS窗口上的内容
+   `dir` 查看当前目录下的文件
+   `exit` 推出DOS命令窗口
+   `del` 删除一个或多个文件
    +   支持模糊匹配

+   `ipconfig` 查看本机 `IP` 信息
    +   IP地址：IP地址是可以看作计算机在同一个网络中的唯一标识 
    +   `ipconfig -all` 可以查看更加详细的信息

+   `ping [ipAddress]` 插件两台计算机之间能否正常通信
    +   该命令来自 `pingpong` 一词
    +   `ping [ipAddress] -t` 可以一直执行ping命令 直到主动停止
        +   在一个DOS命令窗口中如果有一个命令一直在执行，可按ctrl+c停止

## 步骤

+ 第一步：安装文本编辑器（Editplus） *
    + 你也可以直接安装好用的 IDE 如 IntelliJ IDEA
        但建议刚上手的时候, 先使用没有自动补全功能的文本编辑器
        熟悉 Java 的语法 至少要能手写出 `main` 方法
+ 第二步：安装JDK（先下载JDK）
	+ 对于 Java13 来说，如果想要生成一个独立于 JDK 之外的 JRE，需要另外操作
	JDK13 安装的时候内置了一个 JRE
	需要注意的是，JDK8 在安装的时候，不仅 JDK 内置了一个JRE，
	而且还会在JDK目录之外独立生成一个单独的 JRE (实际有两个JRE)
	+ JDK的bin目录下有：
		+ `javac.exe` 负责编译
		+ `java.exe` 负责运行
+ 第三步：写代码
+ 第四步：编译  Java 源代码只要修改就必须重新编译
+ 第五步：运行

## 编译阶段

+   怎么编译？编译命令怎么用？
    +   需要使用的命令：`C:\Program Files\Java\jdk-14.0.2\bin\javac.exe`
        +   这个命令需要先测试：打开DOS窗口，看看`javac`命令是否可用
            	
            未配置环境变量时无法使用javac命令
            修改完环境变量必须重启DOS命令窗口
            	
            注：环境变量包括系统变量和用户变量
            		系统变量对所有用户起作用
            		用户变量只对当前用户起作用
            		

+   查看编译器版本 `javac -version`

+   查看java虚拟机的版本 `java -version`

+   ```powershell
    java version "14.0.2" 2020-07-14
    Java(TM) SE Runtime Environment (build 14.0.2+12-46)
    Java HotSpot(TM) 64-Bit Server VM (build 14.0.2+12-46, mixed mode, sharing)
    ```

+   

### javac命令用法：

语法格式：`javac` + java源文件路径

>   把java源文件拖进DOS命令窗口，可以直接显示路径

>   注：在存放java源文件的目录下，上方地址栏中输入cmd后回车，
>   可直接在当前目录路径下打开DOS命令窗口

## 运行阶段

使用命令 `java`, 使用前可以先用`java -version`命令测试,

`java`命令语法格式: `java [className]`

运行结果：

```powershell
C:\Users\Documents\Java_learnling>java HelloWorld
Hello World!
```

>   需要注意的是 `java` 命令后跟的直接是需要执行的类 的类名而不能是文件名或文件路径
>
>   如果输入的是 `java HelloWorld.class` 会提示以下错误: 
>
>   ```powershell
>   C:\Users\Documents\Java_learnling>java C:\Users\12576\Documents\Java_learnling\HelloWorld
>   错误: 找不到或无法加载主类 C:\Users\12576\Documents\Java_learnling\HelloWorld
>   原因: java.lang.ClassNotFoundException: C:\Users\12576\Documents\Java_learnling\HelloWorld
>   ```



### 运行java程序的步骤

+   第一步 先使用cd命令切换到字节码文件所在的路径	
+   第二步 执行java命令

## Java hello world的执行过程及原理

`java HelloWorld`单击回车后, 会发生:

+   第一步:

    +   启动JVM

+   第二步:

    +   JVM启动之后
    +   JVM会去启动 “类加载器`classloader`”
        +   类加载器的作用: 加载类, 本质上类加载器负责去硬盘上去找 “类” 对应的字节码文件
            如果是“java HelloWorld”，那么类加载器会在硬盘上搜索：HelloWorld.class文件

+   第三步：

    +   如果类加载器在硬盘上找不到对应的字节码文件，会报错

    	+   ```powershell
            C:\Users\Documents\Java_learnling>java HelloWorld
            错误: 找不到或无法加载主类 HelloWorld
            原因: java.lang.ClassNotFoundException: HelloWorld
        
	    +   如果类加载器在硬盘上找到了对应的字节码文件
            类加载器会将该字节码文件装载到JVM
	        JVM启动解释器, 将字节码解释为二进制码
	        操作系统执行二进制码和硬件交互

>   +   默认情况下，类加载器去硬盘上找字节码文件的时候，默认从哪找？
>
>       +   当前目录下，见上文 “运行Java程序的步骤” 中第一步
>           默认情况指没有配置`classpath`环境变量的情况
>
>   +   能不能给类加载器指定一个路径让类加载器去指定的路径下加载字节码文件？
>
>       +   可以，但是需要设置一个环境变量，叫做：classpath
>           classpath环境变量不属于Windows OS，属于Java，classpath是Java特有的，是给类加载器指路的；
>           classpath环境变量不是必须要配置的
>           classpath=A路径；B路径…
>           classpath是一个变量名，A路径，B路径是变量值
>           注：变量名不能随便写，大小写无所谓，但必须叫做classpath
>
>           配置好后, 类加载器不会在当前目录下查找字节码文件, 而是去配置的路径下查找



>   在高版本的JDK中，可以直接在java命令后直接加java源文件的路径，可以直接一步到位
>   	这个特性是为了简化开发而提出，还是会先进行编译，然后再运行，并且以上的运行方式
>   	编译生成的class字节码文件在硬盘上不存在，只是在内存中生成
>   	注*：在当前(2020)广泛使用的java8中无此特性
>
>   注: 目前推荐使用更高版本的Java 因为后续需要学习的 Spring 框架 是基于 Java16+ 的



#内容参考动力节点Java零基础视频，已获得原作者许可。
#视频链接https://www.bilibili.com/video/BV1Rx411876f