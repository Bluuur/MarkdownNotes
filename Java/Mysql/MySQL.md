# MySQL

## 数据库概述

### SQL、DB、DBMS 的关系

+ DB：DataBase，数据库，数据库实际上在硬盘上以文件的形式存在。
+ DBMS：DataBase Management System，数据库管理系统，常见的有：MySQL，Oracle，DB2，Sybase，MS SqlServer。
+ SQL：结构化查询语言，是一门标准通用的语言。标准的 SQL 适合于所有的数据库产品。SQL 语句在执行的时候，内部先编译，再执行 SQL，SQL 语句的编译由 DBMS 完成。

### 表 table

​	表是数据库的基本组成单元，所有的数据都以表的形式组织，目的是增强可读性。

+ 行：数据/记录（data）
+ 列：字段（column）

---

+ 字段需要包含的属性
  + 字段名
  + 数据类型
  + 相关约束

### SQL 语句的分类

1. DQL：数据查询语言，凡是 `select` 语句都是 DQL。
2. DML：数据操作语言，`insert` `delete` `update` 对表中数据的增删改。
3. DDL：数据定义语言，`create` `drop` `alter` 对表结构的增删改。
4. TCL：事务控制语言，`commit` 提交事务（Transaction），`rollback` 回滚事务。
5. DCL：数据控制语言，`grant` 授权，`revoke` 撤销权限。

### 导入数据

1. 登录 MySQL 

   ```powershell
   mysql -uroot -p
   ```

2. 查看数据库

   ```mysql
   show databases; # 不是 SQL 语句，属于 MySQL 命令。
   ```

3. 创建数据库

   ```mysql
   create database learn; # 不是 SQL 语句，属于 MySQL 命令。
   ```

4. 使用 `learn` 数据库

   ```mysql
   use learn; # 不是 SQL 语句，属于 MySQL 命令。
   ```

5. 查看当前使用的数据库中的表

   ```mysql
   show tables; # 不是 SQL 语句，属于 MySQL 命令。
   ```

6. 初始化数据，导入 `sql` 文件

   ```mysql
   source D:\Download\EdgeDownload\bjpowernode.sql
   ```

   数据初始化后，有三张表：

   ```
   mysql> show tables;
   +-----------------+
   | Tables_in_learn |
   +-----------------+
   | dept            |
   | emp             |
   | salgrade        |
   +-----------------+
   ```

### SQL 脚本

+ 编写 SQL 语句的文件称为 SQL 脚本。
+ 使用 `source` 命令执行 SQL 脚本。

### 查看表的结构

​	使用 `desc` 命令查看表的结构。

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

​	使用 `\c` 结束 SQL 语句。

#### 退出 MySQL

​	`\q` `exit` `quit` 均可以退出 MySQL。

#### 查看其他数据库中的表

```mysql
show tables from <database_name>;
```

#### 查看创建表的语句

```mysql
show create table <table_name>;
```

## 简单的查询

所有命令在 `learn` 数据库下进行，包含三张表。

```
mysql> show tables;
+-----------------+
| Tables_in_learn |
+-----------------+
| dept            |
| emp             |
| salgrade        |
+-----------------+
3 rows in set (0.00 sec)
```

数据库脚本：

```mysql
DROP TABLE IF EXISTS EMP;
DROP TABLE IF EXISTS DEPT;
DROP TABLE IF EXISTS SALGRADE;

CREATE TABLE DEPT
       (DEPTNO int(2) not null ,
	DNAME VARCHAR(14) ,
	LOC VARCHAR(13),
	primary key (DEPTNO)
	);
CREATE TABLE EMP
       (EMPNO int(4)  not null ,
	ENAME VARCHAR(10),
	JOB VARCHAR(9),
	MGR INT(4),
	HIREDATE DATE  DEFAULT NULL,
	SAL DOUBLE(7,2),
	COMM DOUBLE(7,2),
	primary key (EMPNO),
	DEPTNO INT(2) 
	)
	;

CREATE TABLE SALGRADE
      ( GRADE INT,
	LOSAL INT,
	HISAL INT );




INSERT INTO DEPT ( DEPTNO, DNAME, LOC ) VALUES ( 
10, 'ACCOUNTING', 'NEW YORK'); 
INSERT INTO DEPT ( DEPTNO, DNAME, LOC ) VALUES ( 
20, 'RESEARCH', 'DALLAS'); 
INSERT INTO DEPT ( DEPTNO, DNAME, LOC ) VALUES ( 
30, 'SALES', 'CHICAGO'); 
INSERT INTO DEPT ( DEPTNO, DNAME, LOC ) VALUES ( 
40, 'OPERATIONS', 'BOSTON'); 
commit;
 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7369, 'SMITH', 'CLERK', 7902,  '1980-12-17'
, 800, NULL, 20); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7499, 'ALLEN', 'SALESMAN', 7698,  '1981-02-20'
, 1600, 300, 30); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7521, 'WARD', 'SALESMAN', 7698,  '1981-02-22'
, 1250, 500, 30); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7566, 'JONES', 'MANAGER', 7839,  '1981-04-02'
, 2975, NULL, 20); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7654, 'MARTIN', 'SALESMAN', 7698,  '1981-09-28'
, 1250, 1400, 30); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7698, 'BLAKE', 'MANAGER', 7839,  '1981-05-01'
, 2850, NULL, 30); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7782, 'CLARK', 'MANAGER', 7839,  '1981-06-09'
, 2450, NULL, 10); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7788, 'SCOTT', 'ANALYST', 7566,  '1987-04-19'
, 3000, NULL, 20); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7839, 'KING', 'PRESIDENT', NULL,  '1981-11-17'
, 5000, NULL, 10); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7844, 'TURNER', 'SALESMAN', 7698,  '1981-09-08'
, 1500, 0, 30); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7876, 'ADAMS', 'CLERK', 7788,  '1987-05-23'
, 1100, NULL, 20); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7900, 'JAMES', 'CLERK', 7698,  '1981-12-03'
, 950, NULL, 30); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7902, 'FORD', 'ANALYST', 7566,  '1981-12-03'
, 3000, NULL, 20); 
INSERT INTO EMP ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM,
DEPTNO ) VALUES ( 
7934, 'MILLER', 'CLERK', 7782,  '1982-01-23'
, 1300, NULL, 10); 
commit;
 
INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES ( 
1, 700, 1200); 
INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES ( 
2, 1201, 1400); 
INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES ( 
3, 1401, 2000); 
INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES ( 
4, 2001, 3000); 
INSERT INTO SALGRADE ( GRADE, LOSAL, HISAL ) VALUES ( 
5, 3001, 9999); 
commit;

```

表的内容：

```
mysql> select * from dept;
+--------+------------+----------+
| DEPTNO | DNAME      | LOC      |
+--------+------------+----------+
|     10 | ACCOUNTING | NEW YORK |
|     20 | RESEARCH   | DALLAS   |
|     30 | SALES      | CHICAGO  |
|     40 | OPERATIONS | BOSTON   |
+--------+------------+----------+
4 rows in set (0.00 sec)

mysql> select * from emp;
+-------+--------+-----------+------+------------+---------+---------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL     | COMM    | DEPTNO |
+-------+--------+-----------+------+------------+---------+---------+--------+
|  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800.00 |    NULL |     20 |
|  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600.00 |  300.00 |     30 |
|  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250.00 |  500.00 |     30 |
|  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975.00 |    NULL |     20 |
|  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250.00 | 1400.00 |     30 |
|  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850.00 |    NULL |     30 |
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450.00 |    NULL |     10 |
|  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000.00 |    NULL |     20 |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000.00 |    NULL |     10 |
|  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500.00 |    0.00 |     30 |
|  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100.00 |    NULL |     20 |
|  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950.00 |    NULL |     30 |
|  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000.00 |    NULL |     20 |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300.00 |    NULL |     10 |
+-------+--------+-----------+------+------------+---------+---------+--------+
14 rows in set (0.00 sec)

mysql> select * from salgrade;
+-------+-------+-------+
| GRADE | LOSAL | HISAL |
+-------+-------+-------+
|     1 |   700 |  1200 |
|     2 |  1201 |  1400 |
|     3 |  1401 |  2000 |
|     4 |  2001 |  3000 |
|     5 |  3001 |  9999 |
+-------+-------+-------+
5 rows in set (0.00 sec)
```

### 查询字段 (DQL)

+ 任何一个 SQL 语句都以 `;` 结尾。
+ SQL 语句不区分大小写。
+ 查询多个字段使用 `,` 隔开。
+ 使用 `*` 查询全部字段。
  + 不建议使用，因为 `* ` 效率较低，编译器需要先将 `*` 转成全部字段后进行查询。

```mysql
mysql> select empno from emp;
+-------+
| empno |
+-------+
|  7369 |
|  7499 |
|  7521 |
|  7566 |
|  7654 |
|  7698 |
|  7782 |
|  7788 |
|  7839 |
|  7844 |
|  7876 |
|  7900 |
|  7902 |
|  7934 |
+-------+
14 rows in set (0.00 sec)

mysql> select empno, ename from emp;
+-------+--------+
| empno | ename  |
+-------+--------+
|  7369 | SMITH  |
|  7499 | ALLEN  |
|  7521 | WARD   |
|  7566 | JONES  |
|  7654 | MARTIN |
|  7698 | BLAKE  |
|  7782 | CLARK  |
|  7788 | SCOTT  |
|  7839 | KING   |
|  7844 | TURNER |
|  7876 | ADAMS  |
|  7900 | JAMES  |
|  7902 | FORD   |
|  7934 | MILLER |
+-------+--------+
14 rows in set (0.00 sec)

mysql> select * from emp;
+-------+--------+-----------+------+------------+---------+---------+--------+
| EMPNO | ENAME  | JOB       | MGR  | HIREDATE   | SAL     | COMM    | DEPTNO |
+-------+--------+-----------+------+------------+---------+---------+--------+
|  7369 | SMITH  | CLERK     | 7902 | 1980-12-17 |  800.00 |    NULL |     20 |
|  7499 | ALLEN  | SALESMAN  | 7698 | 1981-02-20 | 1600.00 |  300.00 |     30 |
|  7521 | WARD   | SALESMAN  | 7698 | 1981-02-22 | 1250.00 |  500.00 |     30 |
|  7566 | JONES  | MANAGER   | 7839 | 1981-04-02 | 2975.00 |    NULL |     20 |
|  7654 | MARTIN | SALESMAN  | 7698 | 1981-09-28 | 1250.00 | 1400.00 |     30 |
|  7698 | BLAKE  | MANAGER   | 7839 | 1981-05-01 | 2850.00 |    NULL |     30 |
|  7782 | CLARK  | MANAGER   | 7839 | 1981-06-09 | 2450.00 |    NULL |     10 |
|  7788 | SCOTT  | ANALYST   | 7566 | 1987-04-19 | 3000.00 |    NULL |     20 |
|  7839 | KING   | PRESIDENT | NULL | 1981-11-17 | 5000.00 |    NULL |     10 |
|  7844 | TURNER | SALESMAN  | 7698 | 1981-09-08 | 1500.00 |    0.00 |     30 |
|  7876 | ADAMS  | CLERK     | 7788 | 1987-05-23 | 1100.00 |    NULL |     20 |
|  7900 | JAMES  | CLERK     | 7698 | 1981-12-03 |  950.00 |    NULL |     30 |
|  7902 | FORD   | ANALYST   | 7566 | 1981-12-03 | 3000.00 |    NULL |     20 |
|  7934 | MILLER | CLERK     | 7782 | 1982-01-23 | 1300.00 |    NULL |     10 |
+-------+--------+-----------+------+------------+---------+---------+--------+
14 rows in set (0.00 sec)
```

#### 可以在查询语句中进行运算

+ 查询员工年薪（月薪 * 12）

```mysql
mysql> select ename, sal * 12 from emp;
+--------+----------+
| ename  | sal * 12 | # 也可以对查询后的字段重命名
+--------+----------+
| SMITH  |  9600.00 |
| ALLEN  | 19200.00 |
| WARD   | 15000.00 |
| JONES  | 35700.00 |
| MARTIN | 15000.00 |
| BLAKE  | 34200.00 |
| CLARK  | 29400.00 |
| SCOTT  | 36000.00 |
| KING   | 60000.00 |
| TURNER | 18000.00 |
| ADAMS  | 13200.00 |
| JAMES  | 11400.00 |
| FORD   | 36000.00 |
| MILLER | 15600.00 |
+--------+----------+
14 rows in set (0.00 sec)
```

#### `as` 对字段重命名

+ 使用 `as` 对参与数学运算的字段重命名
  + MySQL 不区分单引号与双引号。但建议使用单引号，因为在标准 SQL 中，字符串用单引号表示。
  + 如果重命名为中文，需要加上引号。
  + `as` 可以省略。

```mysql
mysql> select ename, sal * 12 as 'anual sal' from emp;
+--------+-----------+
| ename  | anual sal |
+--------+-----------+
| SMITH  |   9600.00 |
| ALLEN  |  19200.00 |
| WARD   |  15000.00 |
| JONES  |  35700.00 |
| MARTIN |  15000.00 |
| BLAKE  |  34200.00 |
| CLARK  |  29400.00 |
| SCOTT  |  36000.00 |
| KING   |  60000.00 |
| TURNER |  18000.00 |
| ADAMS  |  13200.00 |
| JAMES  |  11400.00 |
| FORD   |  36000.00 |
| MILLER |  15600.00 |
+--------+-----------+
14 rows in set (0.00 sec)
```

## 条件查询

​	必需按照以下顺序执行。

```mysql
select <字段> from <表名> where <条件>
```

### `=` 操作符

+ 查询工资等于 5000 的员工姓名

```mysql
mysql> select ename from emp where sal = 5000;
+-------+
| ename |
+-------+
| KING  |
+-------+
1 row in set (0.00 sec)
```

+ 查询 smith 的工资

```mysql
mysql> select sal from emp where ename = 'smith';
+--------+
| sal    |
+--------+
| 800.00 |
+--------+
1 row in set (0.00 sec)
```

### `<` `>` `<>`/`!=` 操作符

+ 查询工资高于 3000 的员工

```mysql
mysql> select ename from emp where sal > 3000;
+-------+
| ename |
+-------+
| KING  |
+-------+
1 row in set (0.00 sec)
```

+ 查询工资不等于 3000 的员工
  + 不等号可以使用 `<>` 也可以使用 `!=`

```mysql
mysql> select ename, sal from emp where sal <> 3000;
+--------+---------+
| ename  | sal     |
+--------+---------+
| SMITH  |  800.00 |
| ALLEN  | 1600.00 |
| WARD   | 1250.00 |
| JONES  | 2975.00 |
| MARTIN | 1250.00 |
| BLAKE  | 2850.00 |
| CLARK  | 2450.00 |
| KING   | 5000.00 |
| TURNER | 1500.00 |
| ADAMS  | 1100.00 |
| JAMES  |  950.00 |
| MILLER | 1300.00 |
+--------+---------+
12 rows in set (0.00 sec)
```

### `and` `between ... and ...`

+ 查询工资在 1100 和 3000 之间的员工，包括 1000 和 3000
  + 可以使用 `and` 将两个条件连起来
  + 也可以使用 `between ... and ...`
    + 是闭区间，[1000, 3000]
    + `and` 前面的数字必需大于 `and` 后面的数字，否则查询不到数据。
    + 可以使用在字符串上，但几乎用不到。
      + 如果使用在字符串上，左闭右开。

```mysql
mysql> select ename, sal from emp where sal >= 1100 and sal <= 3000;
+--------+---------+
| ename  | sal     |
+--------+---------+
| ALLEN  | 1600.00 |
| WARD   | 1250.00 |
| JONES  | 2975.00 |
| MARTIN | 1250.00 |
| BLAKE  | 2850.00 |
| CLARK  | 2450.00 |
| SCOTT  | 3000.00 |
| TURNER | 1500.00 |
| ADAMS  | 1100.00 |
| FORD   | 3000.00 |
| MILLER | 1300.00 |
+--------+---------+
11 rows in set (0.00 sec)

mysql> select ename, sal from emp where sal between 1100 and 3000;
+--------+---------+
| ename  | sal     |
+--------+---------+
| ALLEN  | 1600.00 |
| WARD   | 1250.00 |
| JONES  | 2975.00 |
| MARTIN | 1250.00 |
| BLAKE  | 2850.00 |
| CLARK  | 2450.00 |
| SCOTT  | 3000.00 |
| TURNER | 1500.00 |
| ADAMS  | 1100.00 |
| FORD   | 3000.00 |
| MILLER | 1300.00 |
+--------+---------+
11 rows in set (0.00 sec)

# select 使用在字符串上 左闭右开
mysql> select ename from emp where ename between 'A' and 'C';
+-------+
| ename |
+-------+
| ALLEN |
| BLAKE |
| ADAMS |
+-------+
3 rows in set (0.00 sec)

mysql> select ename from emp where ename between 'A' and 'D';
+-------+
| ename |
+-------+
| ALLEN |
| BLAKE |
| CLARK |
| ADAMS |
+-------+
4 rows in set (0.00 sec)
```

### `is null` `or`

+ 找出津贴为 `null` 的员工姓名
  + 津贴为 `0` 和津贴为 `	null` 都表示没有津贴
  + `null` 不是 `0`

```mysql
mysql> select ename from emp where comm is null;
+--------+
| ename  |
+--------+
| SMITH  |
| JONES  |
| BLAKE  |
| CLARK  |
| SCOTT  |
| KING   |
| ADAMS  |
| JAMES  |
| FORD   |
| MILLER |
+--------+
10 rows in set (0.00 sec)

# 找出没有津贴的员工姓名
mysql> select ename, comm from emp where comm is null or comm = 0;
+--------+------+
| ename  | comm |
+--------+------+
| SMITH  | NULL |
| JONES  | NULL |
| BLAKE  | NULL |
| CLARK  | NULL |
| SCOTT  | NULL |
| KING   | NULL |
| TURNER | 0.00 |
| ADAMS  | NULL |
| JAMES  | NULL |
| FORD   | NULL |
| MILLER | NULL |
+--------+------+
11 rows in set (0.00 sec)
```

+ 找出津贴不为 `null` 的员工

```mysql
mysql> select ename, comm from emp where comm is not null;
+--------+---------+
| ename  | comm    |
+--------+---------+
| ALLEN  |  300.00 |
| WARD   |  500.00 |
| MARTIN | 1400.00 |
| TURNER |    0.00 |
+--------+---------+
4 rows in set (0.00 sec)

```

#### `in` (选择一个字段的多个情况)

+ 找出工作岗位是 `manager` 和 `salesman` 的员工

```mysql
mysql> select ename, job from emp where job = 'manager' or job = 'salesman';
+--------+----------+
| ename  | job      |
+--------+----------+
| ALLEN  | SALESMAN |
| WARD   | SALESMAN |
| JONES  | MANAGER  |
| MARTIN | SALESMAN |
| BLAKE  | MANAGER  |
| CLARK  | MANAGER  |
| TURNER | SALESMAN |
+--------+----------+
7 rows in set (0.00 sec)
```

+ 使用 `in`
+ `in` 后面的括号不表示区间，只表示集合。

```mysql
mysql> select ename, job from emp where job in ('salesman', 'manager');
+--------+----------+
| ename  | job      |
+--------+----------+
| ALLEN  | SALESMAN |
| WARD   | SALESMAN |
| JONES  | MANAGER  |
| MARTIN | SALESMAN |
| BLAKE  | MANAGER  |
| CLARK  | MANAGER  |
| TURNER | SALESMAN |
+--------+----------+
7 rows in set (0.00 sec)
```





#### `and` 和 `or` 的优先级

+ 找出薪资大于 1000 并且部门编号为 20 或 30 的员工。
+ `and` 优先级大于 `or`
+ 运算符优先级不确定时，加小括号。

```mysql
mysql> select ename, sal, deptno from emp where sal > 1000 and (deptno = 20 or deptno = 30);
+--------+---------+--------+
| ename  | sal     | deptno |
+--------+---------+--------+
| ALLEN  | 1600.00 |     30 |
| WARD   | 1250.00 |     30 |
| JONES  | 2975.00 |     20 |
| MARTIN | 1250.00 |     30 |
| BLAKE  | 2850.00 |     30 |
| SCOTT  | 3000.00 |     20 |
| TURNER | 1500.00 |     30 |
| ADAMS  | 1100.00 |     20 |
| FORD   | 3000.00 |     20 |
+--------+---------+--------+
9 rows in set (0.00 sec)

mysql> select ename, sal, deptno from emp where sal > 1000 and deptno = 20 or deptno = 30;
+--------+---------+--------+
| ename  | sal     | deptno |
+--------+---------+--------+
| ALLEN  | 1600.00 |     30 |
| WARD   | 1250.00 |     30 |
| JONES  | 2975.00 |     20 |
| MARTIN | 1250.00 |     30 |
| BLAKE  | 2850.00 |     30 |
| SCOTT  | 3000.00 |     20 |
| TURNER | 1500.00 |     30 |
| ADAMS  | 1100.00 |     20 |
| JAMES  |  950.00 |     30 | 
| FORD   | 3000.00 |     20 |
+--------+---------+--------+
10 rows in set (0.00 sec)
```

### `like` 模糊查询

+ 在模糊查询中有两个通配符
  + `%` 表示任意多个字符
  + `_ ` 表示任意 1 个字符

+ 找出名字中有 O 的员工

```mysql
mysql> select ename from emp where ename like '%O%';
+-------+
| ename |
+-------+
| JONES |
| SCOTT |
| FORD  |
+-------+
3 rows in set (0.00 sec)
```

+ 找出名字第二个字母是 A 的员工

```mysql
mysql> select ename from emp where ename like '_A%';
+--------+
| ename  |
+--------+
| WARD   |
| MARTIN |
| JAMES  |
+--------+
3 rows in set (0.00 sec)
```

## 排序 `order by`

### 升序 `asc`

+ 查找员工名和工资，按照工资升序排列
+ 使用 `order by` 默认是升序，也可以使用 `asc` 关键字指定升序。 

```mysql
mysql> select ename, sal from emp order by sal;
# 或者 select ename, sal from emp order by sal asc;
+--------+---------+
| ename  | sal     |
+--------+---------+
| SMITH  |  800.00 |
| JAMES  |  950.00 |
| ADAMS  | 1100.00 |
| WARD   | 1250.00 |
| MARTIN | 1250.00 |
| MILLER | 1300.00 |
| TURNER | 1500.00 |
| ALLEN  | 1600.00 |
| CLARK  | 2450.00 |
| BLAKE  | 2850.00 |
| JONES  | 2975.00 |
| SCOTT  | 3000.00 |
| FORD   | 3000.00 |
| KING   | 5000.00 |
+--------+---------+
14 rows in set (0.00 sec)
```



### 降序 `desc`

+  使用 `desc` 指定降序

```mysql
mysql> select ename, sal from emp order by sal desc;
+--------+---------+
| ename  | sal     |
+--------+---------+
| KING   | 5000.00 |
| SCOTT  | 3000.00 |
| FORD   | 3000.00 |
| JONES  | 2975.00 |
| BLAKE  | 2850.00 |
| CLARK  | 2450.00 |
| ALLEN  | 1600.00 |
| TURNER | 1500.00 |
| MILLER | 1300.00 |
| WARD   | 1250.00 |
| MARTIN | 1250.00 |
| ADAMS  | 1100.00 |
| JAMES  |  950.00 |
| SMITH  |  800.00 |
+--------+---------+
14 rows in set (0.00 sec)
```

+ 按照工资的降序排列，工资相同时按照名字的升序排列。

```mysql
# asc 可以省略
mysql> select ename, sal from emp order by sal desc, ename asc;
+--------+---------+
| ename  | sal     |
+--------+---------+
| KING   | 5000.00 |
| FORD   | 3000.00 | #
| SCOTT  | 3000.00 | #
| JONES  | 2975.00 |
| BLAKE  | 2850.00 |
| CLARK  | 2450.00 |
| ALLEN  | 1600.00 |
| TURNER | 1500.00 |
| MILLER | 1300.00 |
| MARTIN | 1250.00 |#
| WARD   | 1250.00 | #
| ADAMS  | 1100.00 |
| JAMES  |  950.00 |
| SMITH  |  800.00 |
+--------+---------+
14 rows in set (0.00 sec)
```

