# Condition

Condition 是在 Spring 4.0 增加的条件判断功能, 通过这个功能可以使实现选择性地创建 Bean 操作

+ 例如: 在 Spring 的 IoC 容器中有一个 User Bean, 要求:
  + 导入 Jedis 坐标后, 加载该 Bean, 否则不加载

---

1. 实体类

```java
package com.zidongzh.springbootcondition.domain;

public class User {
}
```

---

2. 配置类

```java
package com.zidongzh.springbootcondition.config;

import com.zidongzh.springbootcondition.contidon.ClassCondition;
import com.zidongzh.springbootcondition.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    // Conditional 注解, 传入条件类
    @Conditional(ClassCondition.class)
    public User user() {
        return new User();
    }
}

```

---

3. 条件类

```java
package com.zidongzh.springbootcondition.contidon;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ClassCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        // 在这写条件判断的代码, 如果返回 false, 则不会创建对应的 Bean
		
        // 1. 需求: 导入 Jedis 坐标后创建 Bean
        // 思路: 判断 redis.clients.jedis.Jedis 文件是否存在
        boolean flag = true;
        try {
            Class<?> cls = Class.forName("redis.clients.jedis.Jedis");
        } catch (ClassNotFoundException e) {
            flag = false;
        }
        return flag;
    }
}

```

