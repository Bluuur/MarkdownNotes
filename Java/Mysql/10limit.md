## `limit`

​	`limit` 是 MySQL 中特有的，其他数据库都没有（Oracle 中有 `rownum` 能实现类似的功能）。`limit` 取结果集中的部分数据，是 SQL 语句中最后执行的环节。

​	语法：`limit startIndex, length` 下标从 0 开始，`startIndex` 可以省略，如果省略，默认为 0。

+ 取出工资前五名的员工

```mysql
# 可以省略 startIndex
# select ename, sal from emp order by sal desc limit 5;
mysql>  select ename, sal from emp order by sal desc limit 0, 5;
+-------+---------+
| ename | sal     |
+-------+---------+
| KING  | 5000.00 |
| SCOTT | 3000.00 |
| FORD  | 3000.00 |
| JONES | 2975.00 |
| BLAKE | 2850.00 |
+-------+---------+
5 rows in set (0.00 sec)
```

+ 取出工资排名在 4 到 9 的员工。

```mysql
mysql> select
    ->  ename, sal
    -> from
    ->  emp
    -> order by
    ->  sal desc
    -> limit 3, 6; # startIndex, length
+--------+---------+
| ename  | sal     |
+--------+---------+
| JONES  | 2975.00 |
| BLAKE  | 2850.00 |
| CLARK  | 2450.00 |
| ALLEN  | 1600.00 |
| TURNER | 1500.00 |
| MILLER | 1300.00 |
+--------+---------+
6 rows in set (0.00 sec)
```

### 通用标准分页 SQL

​	每页显示 `pageSize` 条记录
​		第 `pageNo` 页：`limit (pageNo - 1) * pageSize, pageSize`