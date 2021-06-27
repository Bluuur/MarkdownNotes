# Maven

## 主要内容

### Maven的简介

#### 简介

Maven【[ˈmevən]】这个词可以翻译为"专家","内行"。 作为Apache组织中的⼀个颇为成功的开源项目，

Maven主要服务于基于java平台的项目构建，依赖管理和项目信息管理。

⽆论是⼩型的开源类库项目，还是⼤型的企业级应⽤；    ⽆论是传统的瀑布式开发，还是流⾏的敏捷开发，

Maven都能⼤显身⼿。

 

## 项目构建

不管你是否意识到，构建（ build） 是每⼀位程序员每天都在做的⼯作。早上来到公司， 我们做的第⼀件事就是从源码库签出最新的代码，然后进⾏单元测试，如果测试失败，会找相关的同事⼀起调试，修复错误代码。 接着回到⾃⼰的⼯作上来，编写⾃⼰的单元测试及产品代码。

 仔细总结⼀下，我们会发现，除了编写源代码，我们每天有相当⼀部分时间花在了编译，运⾏单元测试，⽣成⽂档，打包和部署等繁琐且不起眼的⼯作上，这就是构建。    如果我们现在还⼿⼯这样做，那成本也太⾼了，于是有⼈⽤软件的⽅法让这⼀系列⼯作完全⾃动化，使得软件的构建可以像全⾃动流⽔线⼀样，只需要⼀条简单的命令，所有繁琐的步骤都能够⾃动完成，很快就能得到最终结果。

 

## 项目构建⼯具

#### Ant构建

最早的构建⼯具，基于IDE,    ⼤概是2000年有的，当时是最流⾏java构建⼯具，不过它的XML脚本编写格式让XML⽂件特别⼤。对⼯程构建过程中的过程控制特别好

#### Maven【JAVA】

项⽬对象模型，通过其描述信息来管理项⽬的构建，报告和⽂档的软件项⽬管理⼯具。它填补了Ant缺点， Maven第⼀次⽀持了从⽹络上下载的功能， 仍然采⽤xml作为配置⽂件格式。Maven专注的是依赖管理，使⽤Java编写。

#### Gradle

属于结合以上两个的优点，它继承了Ant的灵活和Maven的⽣命周期管理，它最后被google作为了Android御⽤管理⼯具。它最⼤的区别是不⽤XML作为配置⽂件格式，采⽤了DSL格式，使得脚本更加简  洁。

 

目前市⾯上Ant⽐较⽼, 所以⼀般是⼀些⽐较传统的软件企业公司使⽤, Maven使⽤Java编写, 是当下⼤多数互联⽹公司会使⽤的⼀个构建⼯具, 中⽂⽂档也⽐较⻬全, gradle是⽤groovy编写, ⽬前⽐较新型的构建⼯具⼀些初创互联⽹公司会使⽤, 以后会有很⼤的使⽤空间.

 

 

### Maven的四⼤特性

#### 依赖管理系统

Maven为Java世界引⼊了⼀个新的依赖管理系统jar包管理 jar 升级时修改配置⽂件即可。在Java世界中，可以⽤groupId、artifactId、version组成的Coordination（坐标）唯⼀标识⼀个依赖。

 

任何基于Maven构建的项⽬⾃身也必须定义这三项属性，⽣成的包可以是Jar包，也可以是war包或者

jar包。⼀个典型的依赖引⽤如下所示：

坐标属性的理解

Maven坐标为各种组件引⼊了秩序，任何⼀个组件都必须明确定义⾃⼰的坐标。

##### groupId

定义当前Maven项⽬⾪属的实际项⽬-公司名称。（jar包所在仓库路径）    由于Maven中模块的概念，因

此⼀个实际项⽬往往会被划分为很多模块。 ⽐如spring是⼀个实际项⽬，其对应的Maven模块会有很多， 如spring-core,spring-webmvc等。

##### artifactId

该元素定义实际项⽬中的⼀个Maven模块-项⽬名，  推荐的做法是使⽤实际项⽬名称作为artifactId的前缀。

⽐如： spring-bean, spring-webmvc等。

##### version

该元素定义Maven项⽬当前所处的版本。

 

#### 多模块构建

项⽬复查时 dao service controller 层分离将⼀个项⽬分解为多个模块已经是很通⽤的⼀种⽅式。

在Maven中需要定义⼀个parent POM作为⼀组module的聚合POM。在该POM中可以使⽤标签来定义⼀组⼦模块。parent POM不会有什么实际构建产出。⽽parent POM中的build配置以及依赖配置都会⾃动继承给⼦module。

 

#### ⼀致的项⽬结构

Ant时代⼤家创建Java项⽬⽬录时⽐较随意，然后通过Ant配置指定哪些属于source，那些属于testSource等。⽽Maven在设计之初的理念就是Conversion over configuration（约定⼤于配置）。其制定了⼀套项⽬⽬录结构作为标准的Java项⽬结构,解决不同ide 带来的⽂件⽬录不⼀致问题。

 

#### ⼀致的构建模型和插件机制

 

```xml
<plugin>

<groupId>org.mortbay.jetty</groupId>

<artifactId>maven-jetty-plugin</artifactId>

<version>6.1.25</version>

<configuration>

<scanIntervalSeconds>10</scanIntervalSeconds>

<contextPath>/test</contextPath>

</configuration>

</plugin>
```



## Maven的安装配置和⽬录结构

## Maven的安装配置

### 检查JDK的版本

JDK版本1.7及以上版本

 

### 下载Maven

下载地址： http://maven.apache.org/download.html

 

 

3.1.3.   配置Maven环境变量

解压后把Maven的根⽬录配置到系统环境变量中MAVEN_HOME，将bin⽬录配置到path变量中。注：maven解压后存放的⽬录不要包含中⽂和空格

 



## 认识Maven⽬录结构

好教育 实战派

Maven项⽬⽬录结构

 

 

任务:⼿动创建⼀个Maven项⽬，并编译运⾏成功！

3.2.1.   创建⼀个⽂件夹作为项⽬的根⽬录

在根⽬录中创建⼀个pom.xml⽂件，内容如下

 

Ps：标签定义解释

 

 

groupId定义了项⽬属于哪个组， 这个组往往和项⽬所在的组织和公司存在关联。

⽐如： com.xxxx

artifactId 定义了当前Maven项⽬在组中唯⼀的ID。

 

Version X.X.X-⾥程碑

⽐如：1.0.0-SNAPSHOT

第⼀个X ⼤版本 有重⼤变⾰

第⼆个X ⼩版本 修复bug，增加功能第三个X 更新

 

⾥程碑版本：

SNAPSHOT （快照，开发版）

alpha（ 内 部 测 试 ） beta

（ 公 开 测 试 ） Release | RC（ 发 布 版 ） GA（正常版本）

 

使⽤name标签声明⼀个对于⽤户更为友好的项⽬名称，虽然不是必须的，但还是推荐为每个Pom声明name，以⽅便信息交流。

 

3.2.2.   编写主函数

 

package com.xxxx.demo; public class Hello{

public static void main(String[] args)

{ System.out.println("hello maven");

}

 

3.2.3.   cmd 下编译并运⾏

cmd下⾯，进⼊项⽬的根⽬录

\1.  编译java⽂件mvn compile

\2.  执⾏main ⽅法

mvn exec:java -Dexec.mainClass="com.xxxx.demo.Hello"

 

 

 

注：第⼀次下载会⽐较慢，要修改maven解压之后的conf⽬录下的settings.xml。

 

 

 

\4.  Maven命令

作为开发利器的maven，为我们提供了⼗分丰富的命令，了解maven的命令⾏操作并熟练运⽤常⻅的maven命令还是⼗分必要的，即使譬如IDEA等⼯具给我提供了图形界⾯化⼯具，但其底层还是依靠maven命令来驱动的。

Maven的命令格式如下：

命令代表的含义：执⾏plugin-name 插件的 goal-name ⽬标

 

4.1. 常⽤命令

 

命令    描述

mvn clean  清理项⽬⽣产的临时⽂件,⼀般是模块下的target⽬录

mvn compile    编译源代码，⼀般编译模块下的src/main/java⽬录

mvn package   项⽬打包⼯具,会在模块下的target⽬录⽣成jar或war等⽂件

mvn test    测试命令,或执⾏src/test/java/下junit的测试⽤例.

mvn –version   显示版本信息

mvn install  将打包的jar/war⽂件复制到你的本地仓库中,供其他模块使⽤

mvn deploy 将打包的⽂件发布到远程参考,提供其他⼈员进⾏下载依赖

mvn site ⽣成项⽬相关信息的⽹站

mvn eclipse:eclipse  将项⽬转化为Eclipse项⽬

mvn dependency:tree   打印出项⽬的整个依赖树

mvn archetype:generate 创建Maven的普通java项⽬

mvn tomcat7:run    在tomcat容器中运⾏web应⽤

mvn jetty:run   调⽤ Jetty 插件的 Run ⽬标在 Jetty Servlet 容器中启动 web 应⽤

 

 

 

4.2.1.   -D 传⼊属性参数

例如：

 

以 -D 开头，将 maven.test.skip 的值设为 true ,就是告诉maven打包的时候跳过单元测试。同理， mvn deploy-Dmaven.test.skip=true 代表部署项⽬并跳过单元测试。

 

4.2.2.   -P 使⽤指定的Profile配置

⽐如项⽬开发需要有多个环境，⼀般为开发，测试，预发，正式4个环境，在pom.xml中的配置如下：

 

 

 

<id>dev</id>

<properties>

<env>dev</env>

</properties>

<activation>

<activeByDefault>true</activeByDefault>

</activation>

</profile>

<profile>

<id>qa</id>

<properties>

<env>qa</env>

</properties>

</profile>

<profile>

<id>pre</id>

<properties>

<env>pre</env>

</properties>

</profile>

<profile>

<id>prod</id>

<properties>

<env>prod</env>

</properties>

</profile>

</profiles>

 



```xml
<build>
<filters>
<filter>config/${env}.properties</filter>
</filters>
    
<resources>
<resource>
<directory>src/main/resources</directory>
<filtering>true</filtering>
</resource>
</resources>
```

 

</build>

 

profiles 定义了各个环境的变量 id ， filters 中定义了变量配置⽂件的地址，其中地址中的环境变量就是上⾯ profile 中定义的值， resources 中是定义哪些⽬录下的⽂件会被配置⽂件中定义的变量替换。

通过maven可以实现按不同环境进⾏打包部署，例如：

 

 

表示打包本地环境，并跳过单元测试

 

 

\5.  IDEA编辑器集成Maven环境

5.1. 设置Maven版本

选 择 "File" —> "Other Settings" —> "Settings for New Projects..." —> 搜 索 "Maven"

 

选择下载好的maven版本（⽬录选到bin⽬录的上⼀级⽬录）

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

设置settings.xml⽂件

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

设置好之后，选择 "Apply" 或者 "OK"

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\6.  Maven项⽬的创建

6.1. 创建Java项⽬

6.1.1.   新建项⽬

\1.  选择"File" —> "New" —> "Project"

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\2.  选择"Maven"，设置JDK版本，选择maven项⽬的模板

 

 

 

 

 

 

 

 

 

 

 

 

 

\3.  设置项⽬的GroupId 和 ArtifactId

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\4.  检查Maven环境，选择 "Next"

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\5.  检查项⽬名和⼯作空间，选择"Finish"

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\6.  等待项⽬创建，下载资源，创建完成后⽬录结构如下

 

 

 

 

 

 

 

 

 

 

 

 

注：右下⻆弹出的提示框，选择 "Enable Auto-Import"（Maven启动⾃动导⼊）

6.1.2.   编译项⽬

 

\1.  点击右上⻆的 "Add Configurations "，打开 "Run/Debug Configurations" 窗⼝

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\2.  点击左上⻆的"+" 号，选择 "Maven"

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\3.  设置编译项⽬的命令

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\4.  执⾏编译命令，两个图标分别代表"普通模式"和"调试模式"

 

 

 

 

 

 

\5.  编译成功

 

 

 

 

 

 

6.2. 创建Web项⽬

6.2.1.   创建项⽬

 

\1.  创建Web项⽬与创建Java项⽬步骤基本⼀致，区别在于选择 Maven模板（web项⽬选择webapp），如图：

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

2.

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

6.2.2.   启动项⽬

6.2.2.1.  修改JDK 的版本

 

 

 

6.2.2.2.  设置单元测试的版本

 

6.2.2.3.  删除pluginManagement标签

 

\2.  Tomcat插件

 

 

 

 

 

 

 

 

 

 

 

6.2.2.5.  启动项⽬

\1.  点击右上⻆的 "Add Configurations "，打开 "Run/Debug Configurations" 窗⼝

 

\2.  点击左上⻆的"+" 号，选择 "Maven"

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\3.  Jetty插件配置

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

也可以输⼊命令指定端⼝启动

 

 

点击启动图标，启动服务

 

启动成功

 

 

 

 

 

4.

 

 

启动⽅式如上，启动成功

 

 好教育 实战派

 

 

浏览器访问 http://localhost:8080/test

 

 

当Maven根据坐标寻找构件的时候，它⾸先会查看本地仓库，如果本地仓库存在，则直接使⽤；   如果本地没有，Maven就会去远程仓库查找，发现需要的构件之后，下载到本地仓库再使⽤。   如果本地仓库和远程仓库都没有，Maven就会报错。

远程仓库分为三种： 中央仓库，私服， 其他公共库。中央仓库是默认配置下，Maven下载jar包的地⽅。

 

私服是另⼀种特殊的远程仓库，为了节省带宽和时间，应该在局域⽹内架设⼀个私有的仓库服务器，

⽤其代理所有外部的远程仓库。 内部的项⽬还能部署到私服上供其他项⽬使⽤。

⼀般来说，在Maven项⽬⽬录下，没有诸如lib/这样⽤来存放依赖⽂件的⽬录。 当Maven在执⾏编译或测试时，如果需要使⽤依赖⽂件，它总是基于坐标使⽤本地仓库的依赖⽂件。

 

 好教育 实战派

默认情况下， 每个⽤户在⾃⼰的⽤户⽬录下都有⼀个路径名为.m2/repository/的仓库⽬录。 有时候， 因为某些原因（⽐如c盘空间不⾜）,需要修改本地仓库⽬录地址。

对于仓库路径的修改，可以通过maven 配置⽂件conf ⽬录下settings.xml来指定仓库路径

 

 

7.1. 中央仓库

由于原始的本地仓库是空的，maven必须知道⾄少⼀个可⽤的远程仓库，才能执⾏maven命令的时候下载到需要的构件。中央仓库就是这样⼀个默认的远程仓库。

maven-model-builder-3.3.9.jar maven⾃动的 jar 中包含了⼀个 超级POM。定义了默认中央仓库的位置。

中央仓库包含了2000多个开源项⽬，接收每天1亿次以上的访问。

7.2. 私服

私服是⼀种特殊的远程仓库，它是架设在局域⽹内的仓库服务，    私服代理⼴域⽹上的远程仓库，供局域

⽹内的maven⽤户使⽤。 当maven需要下载构件时， 它去私服当中找，如果私服没有， 则从外部远程仓库下载，并缓存在私服上， 再为maven提供。

此外，⼀些⽆法从外部仓库下载的构件也能从本地上传到私服提供局域⽹中其他⼈使⽤配置⽅式项⽬pom.xml 配置

 

<repositories>

<repository>

<snapshots>

<enabled>true</enabled>

</snapshots>

<id>public</id>

<name>Public Repositories</name>

<url>http://192.168.0.96:8081/content/groups/public/</url>

</repository>

<repository>

<id>getui-nexus</id>

<url>http://mvn.gt.igexin.com/nexus/content/repositories/releases/</url>

</repository>

</repositories>

 

公司内部应该建⽴私服：

节省⾃⼰的外⽹带宽加速maven构建

部署第三⽅控件提⾼稳定性

降低中央仓库的负荷

 

7.3. 其他公共库

常⽤的阿⾥云仓库配置

 

 

 

\8.  Maven环境下构建多模块项⽬

使⽤maven 提供的多模块构建的特性完成maven 环境下多个模块的项⽬的管理与构建。

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\2.  设置GroupId 和ArtifactId

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\3.  设置项⽬名称及⼯作空间

 

 

 

 

 

 

 

 

 

 

 

 

8.2. 创建maven_dao 模块

\1.  选择项⽬maven_parent，右键选择New ，选择Module

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\2.  选择Maven项⽬的模板（普通Java 项⽬）

 

 

 

 

 

 

 

 

 

 

 

 

 

\3.  设置⼦模块的的ArtifactId

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\4.  设置Maven的配置

 

 

 

 

 

 

 

 

 

 

 

 

 

\5.  设置⼦模块的名称及存放位置

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

8.3. 创建maven_service 模块

创建 maven_service 模块的步骤与 maven_dao模块⼀致。

 

8.4. 建maven_controller 模块

创建 maven_service 模块的步骤与 maven_dao模块基本⼀致，只需要将第⼀步选择Maven模板设置为web项⽬即可。（模板类型：maven-archetype-webapp）

 

模块全部创建完毕后，效果如下：

 

 

\1.  新建包

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\2.  在包中创建UserDao类

 

 

 

 

 

 

 

 

 

 

\3.  在类中添加⽅法

 

 

8.6.2.   maven_service

 

\1.  添加maven_dao的依赖

 

\2.  在项⽬中添加UserService类，并添加⽅法

 

 

 

 

 

 

 

 

 

 

 

 

8.6.3.   

1.

 

 

 

 

 

 

 

 

 

2.

 

\3.  新建Java 类，继承 HttpServlet 类，并重写 service⽅法

 

 

 

\4.  添加Tomcat插件

 

 

 

 

 

 

 

 

 

 

 

 

 

5.

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\6.  访问项⽬

访问地址： http://localhost:8080/web/user

访问结果：

 

 

 

\7.  如果启动失败，请先将⽗项⽬install

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

注：如果⽗项⽬ install 失败，则先将所有⼦模块 install 成功后，再 install ⽗项⽬。

 

 

\9.  Maven的打包操作

对于企业级项⽬，⽆论是进⾏本地测试，还是测试环境测试以及最终的项⽬上线， 都会涉及项⽬的打包操作，对于每个环境下项⽬打包时， 对应的项⽬所有要的配置资源就会有所区别，实现打包的⽅式有很多种，可以通过ant,获取通过idea ⾃带的打包功能实现项⽬打包，但当项⽬很⼤并且需要的外界配置很多时，此时打包的配置就会异常复杂，对于maven 项⽬，我们可以⽤过pom.xml 配置的⽅式来实现打包时的环境选择，相⽐较其他形式打包⼯具，通过maven    只需要通过简单的配置，就可以轻松完成不同环境先项⽬的整体打包。

 

⽐如下⾯这样⼀个项⽬,项⽬中配置了不同环境下项⽬所需要的配置⽂件，这时候需要完成不同环境下的打包操作，此时通过修改pom.xml 如下：

9.1. 建⽴对应的⽬录结构

使⽤idea创建项⽬，⽬录结构可能会缺失，需要通过⼿动添加对应的⽬录。

\1.  添加Java 源⽂件夹

选择项⽬的 main ⽂件夹，右键选择New，选择Directory

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

输⼊⽂件夹名 "Java"，如图：

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

选择 java ⽬录，右键选择 Mark Directory as，选择 Sources Root。将⽂件夹标记为源⽂件夹。

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

 

\2.  添加资源⽂件夹

步骤如上，创建⽂件夹，命名为 resources，并标记为 Resources Root

 

\3.  添加对应的⽂件夹⽬录，及添加不同环境下对应的配置⽂件。（本地环境、测试环境、正式环

 

 

 

 

 

 

 

 

境）

 

 

 

 

 

 

9.2. 添加

 

<!-- 打包环境配置 开发环境 测试环境 正式环境 -->

<profiles>

<profile>

<id>dev</id>

<properties>

<env>dev</env>

</properties>

<!-- 未指定环境时，默认打包dev环境 -->

<activation>

<activeByDefault>true</activeByDefault>

</activation>

</profile>

<profile>

<id>test</id>

<properties>

<env>test</env>

</properties>

</profile>

<profile>

<id>product</id>

<properties>

<env>product</env>

</properties>

</profile>

 

 

 

9.3. 设置资源⽂件配置

<!-- 对于项⽬资源⽂件的配置放在build中 -->

<resources>

<resource>

<directory>src/main/resources/${env}</directory>

</resource>

<resource>

<directory>src/main/java</directory>

<includes>

<include>**/*.xml</include>

<include>**/*.properties</include>

<include>**/*.tld</include>

</includes>

<filtering>false</filtering>

</resource>

</resources>

 

9.4. 执⾏打包操作

打开Run/Debug Configuarations窗⼝，输⼊对应的打包命令

 

 

 

 

 

 

 

 

 

 

 

 

 

 

此时对应打包命令

1.

 

打包默认环境（开发环境）并且跳过maven 测试操作

 

2.

打包测试环境并且跳过maven 测试操作

3.

打包⽣产环境并且跳过maven 测试操作打包成功

 

\10. Maven依赖的基本概念

10.1.    依赖的基本配置

根元素project下的dependencies可以包含多个 dependence元素，以声明多个依赖。每个依赖都应该包含以下元素：

\1.  groupId, artifactId, version : 依赖的基本坐标， 对于任何⼀个依赖来说，基本坐标是最重要的，

Maven根据坐标才能找到需要的依赖。

\2.  Type： 依赖的类型，⼤部分情况下不需要声明。 默认值为jar

\3.  Scope： 依赖范围（compile,test,provided,runtime,system）

 

compile: 编译依赖范围。

如果没有指定，就会默认使⽤该依赖范围。使⽤此依赖范围的Maven依赖，对于编译、测试、运⾏三种classpath都有效。

test: 测试依赖范围。

使⽤此依赖范围的Maven依赖，只对于测试classpath有效，在编译主代码或者运⾏项⽬的使

⽤时将⽆法使⽤此类依赖。典型的例⼦就是JUnit，它只有在编译测试代码及运⾏测试的时候才需要。

provided: 已提供依赖范围。

使⽤此依赖范围的Maven依赖，对于编译和测试classpath有效，但在运⾏时⽆效。典型的例

⼦是servlet-api，编译和测试项⽬的时候需要该依赖，但在运⾏项⽬的时候，由于容器已经提供，就不需要Maven重复地引⼊⼀遍(如：servlet-api)。

runtime: 运⾏时依赖范围。

使⽤此依赖范围的Maven依赖，对于测试和运⾏classpath有效，但在编译主代码时⽆效。典  型的例⼦是JDBC驱动实现，项⽬主代码的编译只需要JDK提供的JDBC接⼝，只有在执⾏测  试或者运⾏项⽬的时候才需要实现上述接⼝的具体JDBC驱动。

system: 系统依赖范围。

该依赖与三种classpath的关系，和provided依赖范围完全⼀致。但是，使⽤system范围依赖时必须通过systemPath元素显式地指定依赖⽂件的路径。由于此类依赖不是通过Maven仓库解析的，⽽且往往与本机系统绑定，可能造成构建的不可移植，因此应该谨慎使⽤。

\4.  Optional：标记依赖是否可选

\5.  Exclusions： ⽤来排除传递性依赖。

 

10.2.    依赖范围

⾸先需要知道，Maven在编译项⽬主代码的时候需要使⽤⼀套classpath。  ⽐如：编译项⽬代码的时候需要⽤到spring-core, 该⽂件以依赖的⽅式被引⼊到classpath中。 其次， Maven在执⾏测试的时候会使

⽤另外⼀套classpath。 如：junit。

最后在实际运⾏项⽬时，⼜会使⽤⼀套classpath， spring-core需要在该classpath中，⽽junit不需要。

 

那么依赖范围就是⽤来控制依赖与这三种classpath(编译classpath，测试classpath，运⾏时classpath)的   关系， Maven有以下⼏种依赖范围：

Compile 编译依赖范围。 如果没有指定，就会默认使⽤该依赖范围。 使⽤此依赖范围的Maven依赖， 对于编译，测试，运⾏都有效。

Test： 测试依赖范围。 只在测试的时候需要。⽐如junit

Provided： 已提供依赖范围。 使⽤此依赖范围的Maven依赖，对于编译和测试有效， 但在运⾏时

⽆效。 典型的例⼦是servlet-API, 编译和测试项⽬的需要， 但在运⾏项⽬时， 由于容器已经提供， 就不需要Maven重复地引⼊⼀遍。

Runtime： 运⾏时依赖范围。 使⽤此依赖范围的Maven依赖，对于测试和运⾏有效， 但在编译代码时⽆效。 典型的例⼦是：jdbc驱动程序， 项⽬主代码的编译只需要jdk提供的jdbc接⼝，只有在执

⾏测试或者运⾏项⽬的时候才需要实现上述接⼝的具体jdbc驱动。

 

System： 系统依赖范围。 ⼀般不使⽤。

 

 

10.3.    传递性依赖

传递依赖机制， 让我们在使⽤某个jar的时候就不⽤去考虑它依赖了什么。也不⽤担⼼引⼊多余的依赖。   Maven会解析各个直接依赖的POM，将那些必要的间接依赖，以传递性依赖的形式引⼊到当前项⽬中。

注意： 传递依赖有可能产⽣冲突！！ 冲突场景：

 

 

