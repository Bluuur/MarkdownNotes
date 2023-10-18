## DBA 命令

### 导出数据库中的数据

​	以下在终端中执行：

```powershell
# 导出整个数据库
mysqldump 数据库名>输出路径\文件名 -uroot -p
# 导出一张表
mysqldump 数据库名 表名>输出路径\文件名 -uroot -p
```



### 导入数据到数据库

​	先创建数据库，使用数据库，再导入数据：

```mysql
create database 数据库名;
use 数据库名;
source .sql文件路径;
```

