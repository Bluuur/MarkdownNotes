# MyBatis

# 第一章

## 1.三层架构

**界面层：** 和用户打交道的， 接收用户的请求参数， 显示处理结果的。（jsp ，html ，servlet）

**业务逻辑层：** 接收了界面层传递的数据，计算逻辑，调用数据库，获取数据

**数据访问层：** 就是访问数据库， 执行对数据的查询，修改，删除等等的。

###  三层对应的包

+  界面层： controller包 （servlet）

+  业务逻辑层： service 包（XXXService类）

+  数据访问层： dao包（XXXDao类）

###  三层中类的交互

   用户使用界面层$\to$业务逻辑层$\to$数据访问层（持久层）$\to$数据库（mysql）

### 三层对应的处理框架

+  界面层---servlet---springmvc（框架）
+  业务逻辑层---service类--spring（框架）
+  数据访问层---dao类--mybatis（框架）

  

##  2.框架

   框架是一个舞台， 一个模版

###    模版：

    1. 规定了好一些条款，内容。
    2. 加入自己的东西

### 框架是一个模块

​    1.框架中定义好了一些功能。这些功能是可用的。
​    2.可以加入项目中自己的功能， 这些功能可以利用框架中写好的功能。

   框架是一个软件，半成品的软件，定义好了一些基础功能， 需要加入你的功能就是完整的。
   基础功能是可重复使用的，可升级的。

### 框架特点

    1. 框架一般不是全能的， 不能做所有事情
    2. 框架是针对某一个领域有效。 特长在某一个方面，比如mybatis做数据库操作强，但是它不能做其它的。
    3. 框架是一个软件

###  MyBatis框架

   一个框架，早期叫做ibatis,  代码在github。
   MyBatis是 MyBatis SQL Mapper Framework for Java （sql映射框架）

#### 1）sql mapper : sql映射

​		可以把数据库表中的一行数据  映射为 一个java对象。
​	 	一行数据可以看做是一个java对象。操作这个对象，就相当于操作表中的数据

#### 2） Data Access Objects（DAOs）

​		数据访问 ， 对数据库执行增删改查。

###  mybatis提供了哪些功能：

  1. 提供了创建Connection ,Statement, ResultSet的能力 ，不用开发人员创建这些对象了

  2. 提供了执行sql语句的能力， 不用你执行sql

  3. 提供了循环sql， 把sql的结果转为java对象， List集合的能力
	
	```java
	while (rs.next()) {
		Student stu = new Student();
		stu.setId(rs.getInt("id"));
		stu.setName(rs.getString("name"));
		stu.setAge(rs.getInt("age"));
		//从数据库取出数据转为 Student 对象，封装到 List 集合
	    stuList.add(stu);
	}
	```


  4.提供了关闭资源的能力，不用你关闭Connection, Statement, ResultSet

 开发人员做的是： 提供sql语句
 最后是： 开发人员提供sql语句--mybatis处理sql---开发人员得到List集合或java对象（表中的数据）

**总结：**
mybatis是一个sql映射框架，提供的数据库的操作能力。增强的JDBC,使用mybatis让开发人员集中精神写sql就可以了，不必关心Connection,Statement,ResultSet的创建，销毁，sql的执行。 



#  第二章

##   1 主要类的介绍

1)Resources： mybatis中的一个类， 负责读取主配置文件

```java
InputStream in = Resources.getResourceAsStream("mybatis.xml");
```

2)SqlSessionFactoryBuilder : 创建SqlSessionFactory对象

```java
SqlSessionFactoryBuilder builder  = new SqlSessionFactoryBuilder();
//创建SqlSessionFactory对象
SqlSessionFactory factory = builder.build(in);
```

3)SqlSessionFactory ： 重量级对象， 程序创建一个对象耗时比较长，使用资源比较多。

>  在整个项目中，有一个就够用了。

```java
SqlSessionFactory:接口  ， 接口实现类： DefaultSqlSessionFactory
SqlSessionFactory作用： 获取SqlSession对象。SqlSession sqlSession = factory.openSession();
```

 	**openSession()方法说明：**

​		1.openSession() ：无参数的， 获取是非自动提交事务的SqlSession对象

​		2.openSession(boolean): 
​		   openSession(true)  获取自动提交事务的SqlSession. 
​		   openSession(false)  非自动提交事务的SqlSession对象 

 4)SqlSession: 
   SqlSession接口 ：定义了操作数据的方法 例如 selectOne() ,selectList() ,insert(),update(), delete(), commit(), rollback()
   SqlSession接口的实现类DefaultSqlSession。

	使用要求： SqlSession对象不是线程安全的，需要在方法内部使用， 在执行sql语句之前，使用openSession()获取SqlSession对象。
	在执行完sql语句后，需要关闭它，执行SqlSession.close(). 这样能保证他的使用是线程安全的。

# 第三章

  1. 动态代理： 使用SqlSession.getMapper(dao接口.class) 获取这个dao接口的对象
  2. 传入参数： 从java代码中把数据传入到mapper文件的sql语句中。
     1）parameterType ： 写在mapper文件中的 一个属性。 表示dao接口中方法的参数的数据类型。
	     例如StudentDao接口
		  public Student  selectStudentById(Integer id) 

	2) 一个简单类型的参数：
     简单类型： mybatis把java的基本数据类型和String都叫简单类型。
     在mapper文件获取简单类型的一个参数的值，使用 #{任意字符}

	  接口：public Student  selectStudentById(Integer id) 
	  mapper:select id,name, email,age from student where id=#{studentId}
	
	3) 多个参数，使用@Param命名参数
	  接口 public List<Student> selectMulitParam(@Param("myname") String name, @Param("myage") Integer age)
	  使用  @Param("参数名")  String name 
	 mapper文件：

	`<select>
	     select * from student where name=#{myname} or age=#{myage}
	</select>`

   4) 多个参数，使用java对象
      语法 #{属性名}

      vo: value object , 放一些存储数据的类。比如说 提交请求参数， name ,age 
         现在想把name ,age 传给一个service 类。
       
      vo: view object , 从servlet把数据返回给浏览器使用的类，表示显示结果的类。
       
      pojo: 普通的有set， get方法的java类。 普通的java对象
    
    Servlet --- StudentService( addStudent( MyParam  param)  )
    
    	 entity（domain域）: 实体类， 和数据库中的表对应的类， 


5) # 和  $
  select id,name, email,age from student where id=#{studentId}

`   select id,name, email,age from student where id=${studentId}`
**\$ 的结果：**select id,name, email,age from student where id=1001

  String sql="select id,name, email,age from student where id=" + "1001";
  使用的Statement对象执行sql， 效率比PreparedStatement低。

>  \$:可以替换表名或者列名， 你能确定数据是安全的。可以使用\$


	  # 和 $区别
	  1. #使用 ？在sql语句中做占位的， 使用PreparedStatement执行sql，效率高
	  2. #能够避免sql注入，更安全。
	  3. $不使用占位符，是字符串连接方式，使用Statement对象执行sql，效率低
	  4. $有sql注入的风险，缺乏安全性。
	  5. $:可以替换表名或者列名


 3. mybatis的输出结果
    mybatis执行了sql语句，得到java对象。

	 1）resultType结果类型， 指sql语句执行完毕后， 数据转为的java对象， java类型是任意的。
       resultType结果类型的它值 1. 类型的全限定名称   2. 类型的别名， 例如 java.lang.Integer别名是int


	处理方式：
		1. mybatis执行sql语句， 然后mybatis调用类的无参数构造方法，创建对象。
		2. mybatis把ResultSet指定列值付给同名的属性。


```xml
<select id="selectMultiPosition" resultType="com.bjpowernode.domain.Student">
      select id,name, email,age from student
</select>

对等的jdbc
ResultSet rs = executeQuery(" select id,name, email,age from student" )
while(rs.next()){
    Student  student = new Student();
    student.setId(rs.getInt("id"));
    student.setName(rs.getString("name"))
}
```

   2) 定义自定义类型的别名
	   1）在mybatis主配置文件中定义，使<typeAlias>定义别名
		2）可以在resultType中使用自定义别名


   3）resultMap:结果映射， 指定列名和java对象的属性对应关系。
	    1）你自定义列值赋值给哪个属性
		 2）当你的列名和属性名不一样时，一定使用resultMap


		 resultMap和resultType不要一起用，二选一

# 第四章 动态sql

 动态sql: sql的内容是变化的，可以根据条件获取到不同的sql语句。
           主要是where部分发生变化。

 动态sql的实现，使用的是mybatis提供的标签， <if> ,<where>,<foreach>

 1)<if>是判断条件的，
   语法<if test="判断java对象的属性值">
            部分sql语句
	    </if>

 2)<where> 用来包含 多个<if>的， 当多个if有一个成立的， <where>会自动增加一个where关键字，
            并去掉 if中多余的 and ，or等。

 3）<foreach> 循环java中的数组，list集合的。 主要用在sql的in语句中。
    学生id是 1001,1002,1003的三个学生

```java
 select * from student where id in (1001,1002,1003)

 public List<Student> selectFor(List<Integer> idlist)

 List<Integer> list = new ...
 list.add(1001);
 list.add(1002);
 list.add(1003);

 dao.selectFor(list)
```


```xml
 <foreach collection="" item="" open="" close="" separator="">
         #{xxx}
</foreach>

collection:表示接口中的方法参数的类型， 如果是数组使用array , 如果是list集合使用list
 item:自定义的，表示数组和集合成员的变量
 open:循环开始是的字符
 close:循环结束时的字符
separator:集合成员之间的分隔符
```

  4）sql代码片段， 就是复用一些语法
    步骤
	 1.先定义 <sql id="自定义名称唯一">  sql语句， 表名，字段等 </sql>
    2.再使用， <include refid="id的值" />

# 第五章：

  1. 数据库的属性配置文件： 把数据库连接信息放到一个单独的文件中。 和mybatis主配置文件分开。
     目的是便于修改，保存，处理多个数据库的信息。

	  1）在resources目录中定义一个属性配置文件， xxxx.properties ,例如 jdbc.properties
        在属性配置文件中， 定义数据，格式是 key=value 
		  key： 一般使用 . 做多级目录的。
		  例如 jdbc.mysql.driver    , jdbc.driver, mydriver
		  jdbc.driver=com.mysql.jdbc.Driver
		  jdbc.url=jdbc:mysql//.....
		  jdbc.username=root
		  jdbc.password=123456
	     
	  2）在mybatis的主配置文件，使用<property> 指定文件的位置
	     在需要使用值的地方， ${key}

 2.mapper文件，使用package指定路径
     <mappers>
    
```xml
    <!--第二种方式： 使用包名
        name: xml文件（mapper文件）所在的包名, 这个包中所有xml文件一次都能加载给mybatis
        使用package的要求：
         1. mapper文件名称需要和接口名称一样， 区分大小写的一样
         2. mapper文件和dao接口需要在同一目录
    -->
    <package name="com.bjpowernode.dao"/>
</mappers>
```

# 第六章：PageHelper

 PageHelper做数据分页的。

