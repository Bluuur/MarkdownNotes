# Linux只有一个根目录 /

根目录下第一层级有

/root  /bin  /boot  /dev  /etc  /home  /var  /lib  /usr  /media  ……

+  usr : Unix System Resource
+  usr/bin: 存放系统的可执行文件，可以在任何目录下执行
+  usr/local/bin:存放用户的可执行文件，也可以在任何目录下执行
+  etc:存放系统的配置文件，如配置环境变量（/etc/profile）
+  home:用户的根目录，存放每个用户的私人数据
+  opt:给Linux额外安装软件所存放的目录，相当于Windows中的program files

## 创建目录

**mkdir** testDir

其中mkdir是命令，testDir是创建的文件夹的名称

mkdir是指make directory

 

**ls**

查看当前目录下的所有文件

 

**cd**

切换目录

cd是指change directory

 

**vi/vim** test

vi/vim命令新建名为test文件（当前目录下没有名为txt的文件）或打开名为txt的文件（当前目录下存在名为txt 的文件）

>  文件(目录)名中除了`\`之外,其他字符都是合法字符