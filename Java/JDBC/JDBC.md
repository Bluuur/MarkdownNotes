# JDBC

`Java DataBase Connectivity`

Java语言链接数据库

JDBC是SUN公司制定的一套接口

`java.sql.*`包下

面向接口调用,面向接口写实现类,这都属于面向接口编程

# 面向接口编程

解耦合:降低程序的耦合度,提高程序的扩展力

多态机制就是非常典型的面向抽象编程

建议:(面向父类型编程)

`Animal a = new Cat();`
`Animal b = new Dog();`

不建议:

`Dog a = new Dog()
Cat c = new Cat()`

# 为什么需要JDBC接口

因为每一个数据库的底层实现的原理都不一样

