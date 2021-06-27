# 组

Linux中的组相当于角色的概念，可以对有共性的用户进行统一管理

每一个用户至少属于一个组，不能独立于组存在，但可以属于多个组

新建用户时如果不指定组，则会新建一个组，组名跟用户名相同，并且把该用户添加到该组中

#   添加组

```
命令：groupadd <groupname>
例如：groupadd dev //创建名为dev的组
 
```

# 删除组

```shell
命令：groupdel <groupname>
例如：groupdel dev
```

# 把用户添加到组中

命令：gpasswd -a <username> <groupname>

```
例如：gpasswd -a zzd dev
```

 

# 把用户从组中移除

```

命令：gpasswd -d <username> <groupname>
例如：gpassed -d zzd dev
注：主组不能改变，不能将zzd从zzd组中移除
一般在添加用户时就指定到某个组
 
添加用户时指定所属的组（主组）
命令：usersdd -g <groupname> <username>
 
```