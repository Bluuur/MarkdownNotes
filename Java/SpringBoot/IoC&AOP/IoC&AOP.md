# IoC & AOP

## IoC

Invert of Control, 控制反转, 将对象的创建进行反转, 常规情况下, 对象的创建由开发者完成.
使用 IoC 开发者不再需要创建对象, 而是由 IoC 容器根据实际需求自动创建项目所需要的对象.

### 使用 IoC

#### 通过 XML 配置

把需要的对象在 XML 中进行配置, Spring 框架读取这个配置文件, 根据配置文件的内容来创建对象



##### XML 配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean class="com.zidongzh.ioc.DataConfig" id="config">
        <property name="driverName" value="Driver"></property>
        <property name="url" value="localhost:8080"></property>
        <property name="userName" value="root"></property>
        <property name="password" value="root"></property>
    </bean>
</beans>
```

Spring 在启动的时候读取 XML 配置文件, 然后在容器中创建对象

使用时直接从容器中取出对象:

```java
package com.zidongzh.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zidong Zh
 * @date 2022/7/29
 */
public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println(context.getBean("config"));

    }
}

```

#### 通过注解

##### 配置类

用一个 Java 类来替代 XML 文件, 把在 XML 中配置的内容放到配置类中

```java
package com.zidongzh.configuration;

import com.zidongzh.ioc.DataConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zidong Zh
 * @date 2022/7/29
 */

// 类前面加 @Configuration 注解
@Configuration
public class BeanConfiguration {

		// 返回对象的方法前加 @Bean 注解
		// 可以通过 value 自定义 bean 的 id
    @Bean(value = "config")
    public DataConfig dataConfig() {
        DataConfig dataConfig = new DataConfig();
        dataConfig.setDriverName("Driver");
        dataConfig.setUrl("localhost:3306/dbname");
        dataConfig.setUserName("root");
        dataConfig.setPassword("root");

        return dataConfig;
    }
}
```

使用:

```java
package com.zidongzh.ioc;

import com.zidongzh.configuration.BeanConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Zidong Zh
 * @date 2022/7/29
 */
public class Test {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);

		// 两种方法获取对象
        // 通过类型
		System.out.println(context.getBean(DataConfig.class));

		// 对应名称为方法名
		System.out.println(context.getBean("dataConfig"));

    }
}
```

在配置类较多时, 可以放到一个包内

```java
ApplicationContext context = new AnnotationConfigApplicationContext("com.zidongzh.configuration");
```

##### 扫描包 + 注解

`@component` 注解标注在对象类的定义上

```java
@Data
@Component
public class DataConfig {
    private String url;
    private String driverName;
    private String userName;
    private String password;
}
```

告诉 Spring IoC 容器这个类需要注入

使用:

```java
ApplicationContext context = new AnnotationConfigApplicationContext("com.zidongzh.ioc");
```

通过 `@Value` 注解给 Bean 赋值

```java
@Data
@Component
public class DataConfig {
    @Value("localhost:3306")
    private String url;
    @Value("dbname")
    private String driverName;
    @Value("root")
    private String userName;
    @Value("root")
    private String password;
}
```

###### 依赖注入

一个对象的属性是另一个对象

使用 `@Autowired` 注解

```java
@Data
@Component
public class GlobalConfig {
    @Value("8080")
    private String port;
    @Value("/")
    private String path;
    @Autowired
    private DataConfig dataConfig;
}
```

`@Autowired` 默认通过类型(bytype)进行注入

通过名称取值(byName): 添加 `@Qualifier` 注解

```java
@Data
@Component
public class GlobalConfig {
    @Value("8080")
    private String port;
    @Value("/")
    private String path;
    @Autowired
    @Qualifier("config")
    private DataConfig dataConfig;
}
```

这里指定了 IoC 容器去找 Name 为 config 的对象, 所以要存在一个名为 config 的类
在 Component 注解中可以命名

```java
@Data
@Component("config")
public class DataConfig {
    @Value("localhost:3306")
    private String url;
    @Value("dbname")
    private String driverName;
    @Value("root")
    private String userName;
    @Value("root")
    private String password;
}
```

## AOP

Aspect Oriented Programming

面向切面编程, 是一种抽象化的面向对象编程
底层通过动态代理实现

下面是一个简单的计算器接口

```java
package com.zidongzh.aop;

/**
 * @author Zidong Zh
 * @date 2022/7/29
 */
public interface Cal {
    public int add(int num1, int num2);

    public int sub(int num1, int num2);

    public int mul(int num1, int num2);

    public int div(int num1, int num2);
}

```

这是它的实现类

```java
package com.zidongzh.aop;

/**
 * @author Zidong Zh
 * @date 2022/7/29
 */
public class CalImpl implements Cal {

    @Override
    public int add(int num1, int num2) {
        System.out.println("add 方法的参数是[" + num1 + "," + num2 + "]");
        int result = num1 + num2;
        System.out.println("add 方法的结果是" + result);
        return result;

    }

    @Override
    public int sub(int num1, int num2) {
        System.out.println("sub 方法的参数是[" + num1 + "," + num2 + "]");
        int result = num1 - num2;
        System.out.println("sub 方法的结果是" + result);
        return result;
    }

    @Override
    public int mul(int num1, int num2) {
        System.out.println("mul 方法的参数是[" + num1 + "," + num2 + "]");
        int result = num1 * num2;
        System.out.println("mul 方法的结果是" + result);
        return result;
    }

    @Override
    public int div(int num1, int num2) {
        System.out.println("div 方法的参数是[" + num1 + "," + num2 + "]");
        int result = num1 / num2;
        System.out.println("div 方法的结果是" + result);
        return result;
    }
}

```

这些方法在相同的地方有相同的代码
计算器方法中, 日志和业务混合在一起, AOP 要做的就是将日志代码全部抽象出去, 统一进行处理, 计算机方法中只保留核心的业务代码

做到核心业务和非业务代码的解耦合

- 相比函数:
    - 函数需要在业务代码中调用
    - AOP 不需要在业务代码中调用, 直接在切面类中配置即可

### AOP 的实现

AOP 主要用于 日志, 权限管理 等

**原理** :

- 创建切面类
- 将计算器和切面对象动态代理, 组成代理对象
- 对代理进行编程

**实现步骤** :

1. 创建实现类
    1. 实现类需要有 `@Component` 注解, 注入容器, 将目标类的对象创建权交给 Spring (IoC)
    
2. 创建切面类
    1. 切面类需要有 `@Component` 注解, 注入容器, 将代理类的对象创建权交给 Spring (IoC)
    
    2. 还需要有 `@Aspect` 注解, 表明这是一个切面类
    
    3. 切面类里面的方法通常有 `JoinPoint` 对象作为参数
        1. `getSignature()` 用于获取封装了署名信息的对象
        可以获取到(实现类对应方法的)方法名(`.getName()`)
        所属类的 `Class` 等信息
        2. `getArgs()` 获取传入目标方法的参数对象
        3. `getTarget()` 获取被代理的对象
        4. `getThis()` 获取代理对象
    
    4. 代理类的注解 (配置织入关系)
        1. `@Before` 注解:
        2. `@After` 注解
          在目标类方法执行完成后执行, 无法获取返回值
        3. `@AfterReturning` 注解
          在目标类方法返回完成后执行, 可以获取返回值
    
        ```java
        package com.zidongzh.aop;
        
        import org.aspectj.lang.JoinPoint;
        import org.aspectj.lang.annotation.AfterReturning;
        import org.aspectj.lang.annotation.Aspect;
        import org.aspectj.lang.annotation.Before;
        import org.springframework.stereotype.Component;
        
        import java.util.Arrays;
        
        /**
         * @author Zidong Zh
         * @date 2022/7/29
         */
        
        // @Component 注入对象
        // @Aspect 声明为切面
        
        @Component
        @Aspect
        public class LoggerAspect {
        
            // Joinpoint 将方法与切面对象连接起来
            // @Before 注解将切面类与对应的方法连接(link)起来, 要注明方法的全类名 *表示所有方法, ..表示所有参数
            @Before("execution(public int com.zidongzh.aop.CalImpl.*(..)")
            public void before(JoinPoint joinPoint) {
                String name = joinPoint.getSignature().getName();
                System.out.println(name + "方法的参数是" + Arrays.toString(joinPoint.getArgs()));
            }
        
            // @AfterReturning 表示在方法返回后执行, 这样才能拿到执行结果
        // JoinPoint 只能拿到方法名, 所以用 value = ..., returning = "return" 来拿到返回值
        // 同样在切面类方法参数中要有一个对象将返回值传进来
            @AfterReturning(value = "execution(public int com.zidongzh.aop.CalImpl.*(..)", returning = "result")
            public void after(JoinPoint joinPoint, Object result) {
                String name = joinPoint.getSignature().getName();
                System.out.println(name + "方法的结果是" + result);
            }
        }
        ```
    
        
    
3. 配置包扫描和开启 AOP 自动代理

4. 使用
    1. 加载 IoC 容器 (通过 xml 配置文件)
    
        ```xml
        <?xml version="1.0" encoding="UTF-8"?>
        <beans xmlns="http://www.springframework.org/schema/beans"
               xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
               xmlns:context="http://www.springframework.org/schema/context"
               xmlns:aop="http://www.springframework.org/schema/aop"
               xsi:schemaLocation="http://www.springframework.org/schema/beans
               http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/aop https://www.springframework.org/schema/aop/spring-aop.xsd">
            <!-- 自动扫包 -->
            <context:component-scan base-package="com.zidongzh.aop"></context:component-scan>
        
            <!-- 开启自动生成代理 -->
            <aop:aspectj-autoproxy></aop:aspectj-autoproxy>
        </beans>
        ```
    
    2. 获取代理对象
        1. 通过接口类取
          代理对象整合了目标类(实现类)和切面类
          本质上类型是一个接口
    
        ```java
        package com.zidongzh.aop;
        
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;
        
        /**
         * @author Zidong Zh
         * @date 2022/8/3
         */
        public class Test {
            public static void main(String[] args) {
                // 加载 IoC 容器(通过 xml 配置文件)
                ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
                // 取出代理对象
                Cal bean = context.getBean(Cal.class);
                System.out.println(bean.add(9, 8));
                System.out.println(bean.sub(9, 8));
                System.out.println(bean.mul(9, 8));
                System.out.println(bean.div(9, 3));
            }
        }
        ```
    

- 其他情况:
    - 有两个实现类都注入到了容器
        - 会生成两个目标对象和一个切面对象, 报错找不到对象
        因为代理对象是一个目标对象和一个切面对象的 link 
        无法生成代理对象