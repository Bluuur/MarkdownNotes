## MySQL 常用命令

### 常用命令

#### 查看当前使用的数据库

```mysql
select database();
```

#### 查看 MySQL 版本号

```mysql
select version();
```

#### 结束 SQL 语句

使用 `\c` 结束 SQL 语句。

#### 退出 MySQL

`\q` `exit` `quit` 均可以退出 MySQL。

#### 查看其他数据库中的表

```mysql
show tables from <database_name>;
```

#### 查看创建表的语句

```mysql
show create table <table_name>;
```