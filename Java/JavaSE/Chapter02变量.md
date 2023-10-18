# 字面量

## 程序中的数据

+ 开发软件是为了解决显示世界中的问题，现实世界中黄铎问题使用数据进行描述，所以软件执行过程中主要就是对数据的处理。
+ 软件在处理数据之前要能够表示数据，在 Java 中，数据被称为「字面量」。

## 字面量

```Java
public class VarTest01 {
    public VarTest01() {
    }

    public static void main(String[] var0) {
        System.out.println(100);
        System.out.println(true);
        System.out.println('a');
        System.out.println("中");
        System.out.println('国');
        System.out.println(3.14D);
        System.out.println("true");
    }
}
```

+ 以上代码中
  + `100`
  + `true`
  + `a`
  + `中`
  + `国`
+ 都是字面量，或者称为数据。

### 字面量的种类

+ 整数型字面量：`1` `2` `3` ……
+ 浮点型字面量：`1.3` `2.9` ……
+ 布尔型字面量：`true` `false` 没有别的值，表示真和假。
+ 字符型字面量：`'a'` `'b'` `'中'` ……
+ 字符串型字面量：`"abc"` `"国"` ……

其中字符型和字符串型都是描述显示世界中的文字，字符型只能使用单引号，字符串型只能使用双引号。

# 变量

## 变量与内存空间

```java
public class VarTest01 {
    public static void main(String[] var0) {
        byte var1 = 10;
        System.out.println(var1);
        System.out.println(var1);
        System.out.println(var1);
    }
}
```

+ `10` 是一个整数型数据，在内存中占有空间。

+ 现在做 `10 + 20 = 30` 的运算。

+ 过程为

  + 在内存中找一块空间存储 `10`
  + 在内存中找另一块内存空间存储 `20`
  + CPU 进行 `+` 计算，计算结果为 `30`
  + 结果 `30` 也会在内存中找一块临时空间存储起来

+ 以下 3 个 10 输出时，会占用三块不同的储存空间

  + ```java
    public class VarTest01 {
        public static void main(String[] var0) {
            System.out.println(10);
            System.out.println(10);
            System.out.println(10);
        }
    }
    ```

  + 