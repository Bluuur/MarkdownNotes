# IO流

```
I：Input
O：Output
通过IO可以完成硬盘文件的读和写
```

# IO流的分类

有多种分类方式

一种方式是按照流的方向进行分类

以内存作为参照物

往内存中去，叫做输入，或者叫做读

从内存中出来，叫做输出，或者叫做写

 

一种方式是按照读取数据的方式不同进行分类

有的流是按照字节（byte）的方式读取数据，一次读取一个byte，等同于一次读取8个二进制位。这种流是万能的，什么文件都能读取

有的流是按照字符的方式读取数据，一次读取一个字符，这种流是为了方便读取普通文本文件而存在的，这种流只能读取纯文本文件，连word文件都无法读取

综上所述，流的分类

输入流、输出流

字节流、字符流

# Java 中的 IO 流都已经写好

程序员只需要关心java中提供了哪些流，每个流的特点是什么，每个流对象的常用方法有哪些

 

Java中所有流都在java.io.*下

 

Java中主要研究

怎么new流对象

调用流对象的哪个方法是读，哪个方法是写

 

# JavaIO流有四大家族

以下四个都是抽象类

| Class Name | 类型 |
| ------------------- | ---------- |
| java.io.OutStream   | 字节输出流 |
| java.io.InputStream | 字节输入流 |

 

| Class Name | 类型 |
| -------------- | ---------- |
| java.io.Writer | 字符输出流 |
| java.io.Reader | 字符输入流 |

 

所有的流都实现了

`java.io.Closeable` 接口，都是可关闭的，都有 `close()` 方法

流是内存和硬盘之间的通道，用完之后一定要关闭

否则会占用很多资源

 

所有的输出流都实现了

`java.io.Flushable` 接口，都是可刷新的，都有 `flush()` 方法

输出流在最终输出之后，一定要 `flush()` 刷新

这个书信表示将通道中剩余的，为输出的数据强行输出完（清空通道）

如果没有 `flush()` 可能会导致数据丢失

 

·    注意：在 Java 中只要 “类名” 以 Stream 结尾的都是字节流，以 “ Reader/Writer ” 结尾的都是字符流

 

`java.io` 包下需要掌握的流有 16 个

文件专属

`java.io.FileInputStream`

`java.io.FileOutputStream`

`java.io.FileReader`

`java.io.FileWriter`

 

转换流（将字节流转换为字符流）

`java.io.InputStreamReader`

`java.io.OutputStreamWriter`

 

缓冲流专属

`java.io.BufferedReader`

`java.io.BufferedWriter`

`java.io.BufferedInputStream`

`java.io.BufferedOutputStream`

 

数据流专属

`java.io.DataInputStream`

`java.io.DataOutputStream`

 

标准输出流

`java.io.PrintWriter`

`java.io.PrintStream`

 

对象专属流

`java.io.ObjectInputStream`

`java.io.ObjectOutputStream`

