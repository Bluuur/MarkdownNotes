# 八种基本包装类

Java 中为基本数据类型又对应准备了 8 种包装类，8 种包装类属于引用数据类型，父类是 `Object`。

```java
package com.java.Integer;

public class IntegerTest01 {
    public static void main(String[] args) {
        
// 有没有这种需求：调用 doSome() 方法的时候需要传一个数字进去
// 但是数字属于基本数据类型，而 doSome 方法参数的类型是 Object
// doSome 方法无法接受基本数据类型的数字 

        //可以传一个数字对应的包装类进去
        Integer integer = new Integer(100);
        doSome(integer);
    }

    public static void doSome(Object obj){
        System.out.println(obj);
    }
}
```



| 基本数据类型 | 包装类型              | 包装类的父类 |
| ------------ | --------------------- | ------------ |
| `byte`       | `java.lang.Byte`      | `Number`     |
| `short`      | `java.lang.Short`     | `Number`     |
| `int`        | `java.lang.Integer`   | `Number`     |
| `long`       | `java.lang.Long`      | `Number`     |
| `float`      | `java.lang.Float`     | `Number`     |
| `double`     | `java.lang.Double`    | `Number`     |
| `boolean`    | `java.lang.Boolean`   | `Object`     |
| `char`       | `java.lang.Character` | `Object`     |

可以通过以上类将基本数据类型转换成引用数据类型（装箱）。

# Number类

Number 类是一个抽象类，无法通过 Number 类创建对象

| 返回值类型         | 方法摘要        |                                |
| ------------------ | --------------- | ------------------------------ |
| ` byte`            | `byteValue()`   | 以 `byte` 形式返回指定的数值   |
| `abstract  double` | `doubleValue()` | 以 `double` 形式返回指定的数值 |
| `abstract  float`  | `floatValue()`  | 以 `float` 形式返回指定的数值  |
| `abstract  int`    | `intValue()`    | 以 `int` 形式返回指定的数值    |
| `abstract  long`   | `longValue()`   | 以 `long` 形式返回指定的数值   |
| ` short`           | `shortValue()`  | 以 `short` 形式返回指定的数值  |

通过以上方法可以将引用数据类型转换为基本数据类型（拆箱）

# Java中的日期

```java
Date date = new Date();//获取系统当前时间(精确到毫秒)
```

## 日期的格式化

```java
System.out.println(date);
```

直接输入的格式为:`Wed Apr 14 20:43:54 GMT+08:00 2021`

可以通过 `SimpleDateFormat` 类将日期格式化
`SimpleDateFormat` 是 `java.text` 包下的,专门负责日期格式化

## `SimpleDateFormat` 的构造方法

```java
public SimpleDateFormat(String pattern)
```

>  用给定的模式和默认语言环境的日期格式符号构造 `SimpleDateFormat`。注：此构造方法可能不支持所有语言环境。要覆盖所有语言环境，请使用 `DateFormat `类中的工厂方法。 
>
>  参数：
>  `pattern` - 描述日期和时间格式的模式 
>  抛出： 
>  `NullPointerException` - 如果给定的模式为 `null `
>  `IllegalArgumentException` - 如果给定的模式无效

### 日期和时间模式

日期和时间格式由*日期和时间模式* 字符串指定。在日期和时间模式字符串中，未加引号的字母 `'A'` 到  `'Z'` 和 `'a'` 到 `'z'`  被解释为模式字母，用来表示日期或时间字符串元素。文本可以使用单引号 (`'`) 引起来，以免进行解释。`"''"`  表示单引号。所有其他字符均不解释；只是在格式化时将它们简单复制到输出字符串，或者在解析时与输入字符串进行匹配。 

定义了以下模式字母（所有其他字符 `'A'` 到 `'Z'` 和 `'a'` 到  `'z'` 都被保留）： 

>  | 字母 | 日期或时间元素           | 表示                                 | 示例                                        |
>  | ---- | ------------------------ | ------------------------------------ | ------------------------------------------- |
>  | `G`  | Era 标志符               | [Text](#text)                        | `AD`                                        |
>  | `y`  | 年                       | [Year](#year)                        | `1996`; `96`                                |
>  | `M`  | 年中的月份               | [Month](#month)                      | `July`; `Jul`; `07`                         |
>  | `w`  | 年中的周数               | [Number](#number)                    | `27`                                        |
>  | `W`  | 月份中的周数             | [Number](#number)                    | `2`                                         |
>  | `D`  | 年中的天数               | [Number](#number)                    | `189`                                       |
>  | `d`  | 月份中的天数             | [Number](#number)                    | `10`                                        |
>  | `F`  | 月份中的星期             | [Number](#number)                    | `2`                                         |
>  | `E`  | 星期中的天数             | [Text](#text)                        | `Tuesday`; `Tue`                            |
>  | `a`  | Am/pm 标记               | [Text](#text)                        | `PM`                                        |
>  | `H`  | 一天中的小时数（0-23）   | [Number](#number)                    | `0`                                         |
>  | `k`  | 一天中的小时数（1-24）   | [Number](#number)                    | `24`                                        |
>  | `K`  | am/pm 中的小时数（0-11） | [Number](#number)                    | `0`                                         |
>  | `h`  | am/pm 中的小时数（1-12） | [Number](#number)                    | `12`                                        |
>  | `m`  | 小时中的分钟数           | [Number](#number)                    | `30`                                        |
>  | `s`  | 分钟中的秒数             | [Number](#number)                    | `55`                                        |
>  | `S`  | 毫秒数                   | [Number](#number)                    | `978`                                       |
>  | `z`  | 时区                     | [General time zone](#timezone)       | `Pacific Standard Time`; `PST`; `GMT-08:00` |
>  | `Z`  | 时区                     | [RFC 822 time zone](#rfc822timezone) | `-0800`                                     |

模式字母通常是重复的，其数量确定其精确表示： 

-  **Text:** 对于格式化来说，如果模式字母的数量大于等于  4，则使用完全形式；否则，在可用的情况下使用短形式或缩写形式。对于解析来说，两种形式都是可接受的，与模式字母的数量无关。 

-  **Number:** 对于格式化来说，模式字母的数量是最小的数位，如果数位不够，则用  0 填充以达到此数量。对于解析来说，模式字母的数量被忽略，除非必须分开两个相邻字段。 

-  Year:

    如果格式器的 

   `Calendar`

     是格里高利历，则应用以下规则。

   -  对于格式化来说，如果模式字母的数量为 2，则年份截取为 2 位数,否则将年份解释为 [number](#number)。 
   -  对于解析来说，如果模式字母的数量大于 2，则年份照字面意义进行解释，而不管数位是多少。因此使用模式 "MM/dd/yyyy"，将 "01/11/12"  解析为公元 12 年 1 月 11 日。 
   -  在解析缩写年份模式（"y" 或 "yy"）时，`SimpleDateFormat`  必须相对于某个世纪来解释缩写的年份。这通过将日期调整为 `SimpleDateFormat` 实例创建之前的 80 年和之后 20  年范围内来完成。例如，在 "MM/dd/yy" 模式下，如果 `SimpleDateFormat` 实例是在 1997 年 1 月 1  日创建的，则字符串 "01/11/12" 将被解释为 2012 年 1 月 11 日，而字符串 "05/04/64" 将被解释为 1964 年 5 月 4  日。在解析时，只有恰好由两位数字组成的字符串（如 [`Character.isDigit(char)`](../../java/lang/Character.html#isDigit(char))  所定义的）被解析为默认的世纪。其他任何数字字符串将照字面意义进行解释，例如单数字字符串，3  个或更多数字组成的字符串，或者不都是数字的两位数字字符串（例如"-1"）。因此，在相同的模式下， "01/02/3" 或 "01/02/003" 解释为公元 3  年 1 月 2 日。同样，"01/02/-3" 解析为公元前 4 年 1 月 2 日。 

   否则，则应用日历系统特定的形式。对于格式化和解析，如果模式字母的数量为 4 或大于 4，则使用日历特定的 

   long form

   。否则，则使用日历特定的 

   short or abbreviated form

   。 

-  **Month:** 如果模式字母的数量为 3 或大于 3，则将月份解释为 [text](#text)；否则解释为 [number](#number)。 

-  General time zone:

    如果时区有名称，则将它们解释为 

   text

   。对于表示 GMT 偏移值的时区，使用以下语法： 

   ```
        GMTOffsetTimeZone:
                GMT Sign Hours : Minutes
        Sign: one of
                + -
        Hours:
                Digit
                Digit Digit
        Minutes:
                Digit Digit
        Digit: one of
                0 1 2 3 4 5 6 7 8 9
   ```

   Hours

    必须在 0 到 23  之间，

   Minutes

    必须在 00 到 59 之间。格式是与语言环境无关的，并且数字必须取自 Unicode 标准的 Basic Latin 块。 

   对于解析来说，[RFC 822 time zones](#rfc822timezone) 也是可接受的。 

-  RFC 822 time zone:

    对于格式化来说，使用  RFC 822 4-digit 时区格式： 

   ```
        RFC822TimeZone:
                Sign TwoDigitHours Minutes
        TwoDigitHours:
                Digit Digit
   ```

   TwoDigitHours

    必须在 00 和 23 之间。其他定义请参阅 

   general time zones

   。 

   对于解析来说，[general time zones](#timezone) 也是可接受的。 

`SimpleDateFormat` 还支持*本地化日期和时间模式*  字符串。在这些字符串中，以上所述的模式字母可以用其他与语言环境有关的模式字母来替换。`SimpleDateFormat`  不处理除模式字母之外的文本本地化；而由类的客户端来处理。 

#### 示例

以下示例显示了如何在美国语言环境中解释日期和时间模式。给定的日期和时间为美国太平洋时区的本地时间 2001-07-04 12:08:56。 

>  | 日期和时间模式                   | 结果                                   |
>  | -------------------------------- | -------------------------------------- |
>  | `"yyyy.MM.dd G 'at' HH:mm:ss z"` | `2001.07.04 AD at 12:08:56 PDT`        |
>  | `"EEE, MMM d, ''yy"`             | `Wed, Jul 4, '01`                      |
>  | `"h:mm a"`                       | `12:08 PM`                             |
>  | `"hh 'o''clock' a, zzzz"`        | `12 o'clock PM, Pacific Daylight Time` |
>  | `"K:mm a, z"`                    | `0:08 PM, PDT`                         |
>  | `"yyyyy.MMMMM.dd GGG hh:mm aaa"` | `02001.July.04 AD 12:08 PM`            |
>  | `"EEE, d MMM yyyy HH:mm:ss Z"`   | `Wed, 4 Jul 2001 12:08:56 -0700`       |
>  | `"yyMMddHHmmssZ"`                | `010704120856-0700`                    |
>  | `"yyyy-MM-dd'T'HH:mm:ss.SSSZ"`   | `2001-07-04T12:08:56.235-0700`         |

**注意** : 在日期格式中,除了y M d H m s S这些字符不能随便写之外,其余的符号格式可以自己随意组织



## 日期字符串String转为Date类型

```java
String time = "2018-11-25 11:59:30";
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date date1  = sdf2.parse(time);
System.out.println(date1);
```

## 统计方法运行时间

```java
System.currentTimeMillis()
```

>获取自1970年1月1日00:00:00 000到当前系统时间的总毫秒数

```java
package com.java.date;
/*
    获取自1970年1月1日00:00:00 000到当前系统时间的总毫秒数
        作用:统计一个方法耗时
 */
public class DateTest02 {
    public static void main(String[] args) {
        long nowMillis1 = System.currentTimeMillis();
        print();
        long nowMillis2 = System.currentTimeMillis();
        System.out.println(nowMillis2 - nowMillis1);

    }

    public static void print(){
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

```

### 简单总结 System 类中的方法

| 方法                       | 说明                                                        |
| -------------------------- | ----------------------------------------------------------- |
| `System.out`               | `out` 是 `System` 的静态变量                                |
| `System.out.println`       | `println()` 方法不是 `System `类的,是`PrintStream` 类的方法 |
| `System.gc()`              | 建议启动垃圾回收器                                          |
| `System.currentTimeMillis` | 获取自1970年1月1日00:00:00 000到当前系统时间的总毫秒数      |
| `System.exit(0);`          | 退出`JVM`                                                   |

## Date有参构造方法

```java
Date(long date) 
```

>  分配 Date 对象并初始化此对象，以表示自从标准基准时间（称为“历元（epoch）”，即 1970 年 1 月 1 日 00:00:00 GMT）以来的指定毫秒数。

# 数字格式化

数字格式:

+  `#`代表任意数字
+  `,`代表千分位
+  `.`代表小数点
+  `0`代表不够时补上0

`DecimalFormat`



## BigDecimal

`BigDecimal`属于大数据,精度极高. 不属于基本数据类型,属于Java对象(引用数据类型)