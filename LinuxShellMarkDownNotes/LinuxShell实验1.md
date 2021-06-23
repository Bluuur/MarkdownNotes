# 实验报告

>  生信2001 张子栋 2020317210101

`ls [path]`显示目录与文件
	参数: 
		`ls -a`显示所有文件(包括以`.`开始的隐藏文件)
		`ls -lh`智能显示文件大小
			<img src="image-20210421141944699.png" alt="image-20210421141944699"  />

---

`cd [path]` 更改工作目录

---

`pwd` 显示当前工作目录

----

`rm [path/file]` 删除文件
	参数
		`rm -r`删除非空目录
		`rm - rf`强制删除目录,不提示错误信息

---

`touch [filename]`创建文件

---

`mv [srcFile] [destDir]`将源文件/目录`[src]`移动到目标目录`[dest]`
如果`[destDir]`不存在,将`[srcFile]`重命名为`[destFile]`

---

`cp [srcFile] [destDir]`将源文件/目录`[src]`复制到目标目录`[dest]`

---

`man [cmd]`显示`[cmd]`的帮助手册

---

`cat`查看文件内容
	`cat [file1] [file2]`拼接两个文件查看内容

---

`head [file]`查看文件前十行内容
	`head -[d] [file]`查看文件前d行内容

---

`tail [file]`查看文件后10行
	`tail -[d] [file]`查看文件后d行内容

---

`more [file]`分页查看文件
	`[Space]`键下翻
	`[b]`上翻
	`[q]`退出
	`[h]`帮助

---

`tac [file]`反向查看文件内容(cat反过来)

---

`rev [file]`将文件每一行的内容反向显示(字符串倒置)(reverse)

---

`wc [file]`显示文件的`行数 字数 字节数 文件名称`
	<img src="image-20210421144223123.png" alt="image-20210421144223123"  />

---

`sort [file]`排序文件内容

---

`split -n [file] [filename]`将文件`[file]`以`n`行为单位分为新的文件,新文件以`[filename]`开始

`split -n -d[file] [filename]`以数字命名文件

![image-20210421145535577](image-20210421145535577.png)

---

`tar -cvf [filename.tar] [file]`将`[file]`打包为`[filename.tar]`

`tar -czf [filename.tar.gz] [file]`将`[file]`打包并压缩为`[filename.tar.gz]`

`gzip [file.tar]`将`[file.tar]`压缩为`[file.tar.gz]`,源文件`[file.tar]`会被删除

`gunzip [file.tar.gz]`解压`[file.tar.gz]`并删除源文件

`gzip -d [file.tgz]`解压`[file.tgz]`并删除源文件

---

`ln -d [link1] [link2]`硬链接,不能跨文件系统

`ln -s [link1] [link2]`软连接,可以跨文件系统

+  连接可以嵌套

+  连接后有`@`符号
+  使用`ls -l`可以查看链接的路径

---

`alias [cmds]`别名

+  如果与内置命令相同,优先执行别名

`unalias [alias]`取消别名

---

`ps`查看进程
	参数
		`-a`：显示当前终端的所有进程信息
		`-u`：以用户的形式显示进程信息
		`-x`：显示后台进程运行的参数

`kill [opt] [PID]`杀死进程
	`[opt]`
		`-9`:强迫进程立即停止	

`top`进程视图
<img src="image-20210421152411924.png" alt="image-20210421152411924" style="zoom:80%;" />

`[ctrl] [c]`强行终止任务`(jobs)`

`[ctrl] [z]`将任务转到后台

