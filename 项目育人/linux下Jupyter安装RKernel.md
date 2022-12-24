1. 安装 `devtools`

   1. 先在终端中安装两个包，因为直接从网络下载的包，需要有个URL的解析库，而URL解析库又依赖于XML库。
      ```shell
      sudo apt-get install libcurl4-gnutls-dev
      sudo apt-get install libxml2-dev
      ```

      或

      ```shell
      sudo apt-get install gfortran
      sudo apt-get install build-essential 
      sudo apt-get install libxt-dev 
      sudo apt-get install libcurl4-openssl-dev
      sudo apt-get install libxml++2.6-dev
      sudo apt-get install libssl-dev
      ```

2. 添加dependencies = T同时安装必要的依赖：

   ```bash
   install.packages("devtools", dependencies = T)
   library(devtools)  # 如果没有任何提示就代表成功了
   ```

3. 从Github安装R kernel：

   ```R
   devtools::install_github('IRkernel/IRkernel')
   ```

4. 在R中注册激活R kernel：

   ```R
   IRkernel::installspec()
   ```



---

报错

+ 在R语言中安装 `devtools`（ubuntu 22.04系统）时安装失败

```R
install.packages("devtools")
```

遇到错误:

*ERROR: dependency ‘ragg’ is not available for package ‘pkgdown’*

+ 尝试安装 `ragg` 包

```R
install.packages("ragg")
```

提示错误:

*ERROR: configuration failed for package ‘textshaping’*

*ERROR: dependency ‘textshaping’ is not available for package ‘ragg’*

+ 尝试安装 `texshaping` 包

```R
install.packages("textshaping")
```

发现错误：

-*------------------[ERROR MESSAGE]------------------------*

*<stdin>:1:10: fatal error: hb-ft.h: 没有那个文件或目录*

*--------------------------------------------------------------------*

及错误提示：

*ERROR: configuration failed for package ‘textshaping’*

+ 为系统环境中缺少 `GTK3` 工具包引起

**系统终端输入命令安装：**

```shell
sudo apt-get install libgtk-3-dev
```

**参考:** [Tina Linux wayland编译报错问题解决：fatal error: hb.h: No such file or directory](https://link.zhihu.com/?target=https%3A//blog.csdn.net/coolchen66/article/details/111588281)

+ 再次在 R 中依次安装 R 包：

```R
install.packages("textshaping")
install.packages("ragg")
install.packages("devtools")
```