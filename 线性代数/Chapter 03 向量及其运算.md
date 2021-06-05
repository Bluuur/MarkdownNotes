

# 向量 Vector

**<font color=ee0000>定义 : </font>$n$个数,$a_1,a_2,\cdots,a_n$组成的有序数组$(a_1,a_2,\cdots,a_n)$ ; 向量中的$n$个数,称为$n$个分量 ; $n$维向量**

>  向量用$\alpha,\beta,\gamma$表示
>
>  行向量和列向量形式上有区别,本质上没有区别

+  分量都为零的向量称为零向量,记作$O$
+  向量相等的前提 : 两个向量是同维向量

:star:$k\alpha = 0 $的充要条件是$k=0$或$\alpha=O$

# 向量间的线性关系

## 线性组合

**<font color=ee0000>定义 : </font> $\beta,\alpha_1,\alpha_2,\cdots,\alpha_n$是$m$维向量,若存在$k_1,k_2,\cdots ,k_n$使$\beta=k_1\alpha_1+k_2\alpha_2+\cdots+k_n\alpha_n$,则称$\beta$是$\alpha$向量组的线性组合,或者$\beta$是$\alpha$向量组的线性表示 ; $k$称为组合系数,可以全取$0$**

+  零向量可由任意向量组表示

+  向量组中任取一向量,可有此向量组表示

   >  如对向量组$\alpha_1,\alpha_2,\alpha_3,\alpha_4$,其中$\alpha_3=0\times\alpha_1+0\times\alpha_2+1\times\alpha_3+0\times\alpha_4$

+  任意$n$维向量都可以用$\varepsilon_1=(1,0,\cdots,0),\varepsilon_2=(0,1,\cdots,0),\cdots,\varepsilon_n=(0,0,\cdots,n)$表示,这个向量组称为$n$维单位(基本)向量组

<font face = "楷体" size=4>例:$\beta =\left( -3,2,-4\right) ,\alpha _{1}=\left( 1,0,1\right) ,\alpha _{2}=\left( 2,1,0\right) ,a_{3}=\left( -1,1,2\right) $证明$\beta$是$\alpha$向量组的线性组合</font>

<font color="blue">解 : </font>
$$
\begin{aligned}
设
\beta &=k_{1}\alpha _{1}+k_{2}\alpha _{2}+k_{3}\alpha _{3}\\
\left( -3,2,-4\right) &=k_{1}\left( 1,0,1\right) +k_{2}\left( 2,1,0\right) +k_{3}\left( -1,1,-2\right) \\
&\begin{cases}
k_1-2k_{2}-k_{3}=-3\\
\,\,\,\,\qquad k_{2}+k_{3}=2\\
k_1\,\,\,\qquad-2k_{3}=-4\end{cases}
\qquad\begin{cases}
k_1=2\\
k_2=-1\\
k_3=3
\end{cases}
\end{aligned}
$$


>  +  是线性组合,则方程组有解 ; 不是线性组合,则方程组无解
>
>  不管题目给的是行向量还是列向量,$\alpha_1,\alpha_2,\cdots,\alpha_n$,均按列作为方程组的系数 ; $\beta$也按列作为等号右边的常数项

## 向量组的等价

两个向量组之间可以相互线性表示,记作$\{\alpha_1,\alpha_2,\cdots,\alpha_m\}\sim\{\beta_1,\beta_2,\cdots,\beta_n\}$

+  反身性 : $\{\alpha_1,\alpha_2,\cdots,\alpha_m\}\sim\{\alpha_1,\alpha_2,\cdots,\alpha_m\}$

+  对称性 : $\{\alpha_1,\alpha_2,\cdots,\alpha_m\}\sim\{\beta_1,\beta_2,\cdots,\beta_n\}\longleftrightarrow\{\beta_1,\beta_2,\cdots,\beta_n\}\sim\{\alpha_1,\alpha_2,\cdots,\alpha_m\}$

+  传递性 : $\{\alpha_1,\alpha_2,\cdots,\alpha_m\}\sim\{\beta_1,\beta_2,\cdots,\beta_n\},\{\beta_1,\beta_2,\cdots,\beta_n\}\sim\{\gamma_1,\gamma_2,\cdots,\gamma_n\}\longrightarrow\{\alpha_1,\alpha_2,\cdots,\alpha_m\}\sim\{\gamma_1,\gamma_2,\cdots,\gamma_n\}$

## 线性相关与线性无关

### 线性相关

**<font color=ee0000>定义 : </font>如果$\alpha_1,\alpha_2,\cdots,\alpha_n$是$n$个$m$维向量,若存在<font color="red">一组</font><font color="blue">不全为$0$</font>的$k_1,k_2,\cdots,k_n$,使$k_1\alpha_1+k_2\alpha_2+\cdots+k_n\alpha_n=0$,则称$\alpha_1,\alpha_2,\cdots,\alpha_m$线性相关**

### 线性无关

**<font color=ee0000>定义 : </font>如果$\alpha_1,\alpha_2,\cdots,\alpha_n$是$n$个$m$维向量,若不存在<font color="red">一组</font><font color="blue">不全为$0$</font>的$k_1,k_2,\cdots,k_n$,使$k_1\alpha_1+k_2\alpha_2+\cdots+k_n\alpha_n=0$,则称$\alpha_1,\alpha_2,\cdots,\alpha_m$线性相关**

+  如果向量组中两向量成比例,则这个向量组中的向量线性相关

   >  这两个成比例的向量使至少有一个非零$k$存在,其他$k$都可为$0$

+  含有零向量的任意向量组一定线性相关

+  一个零向量必线性相关

+  一个非零向量必线性无关

   >  $\alpha\neq O,要让k\alpha=0,则k=0$

+  一个向量$\alpha$线性相关的充分必要条件是$\alpha=O$

+  $\alpha_1,\alpha_2,\cdots,\alpha_r$线性相关,则$\alpha_1,\alpha_2,\cdots,\alpha_r,\alpha_{r+1},\cdots,\alpha_s$线性相关

   >  部分组线性相关,则整体组也线性相关

+  线性无关的向量组的接长向量组也线性无关
   线性相关的向量组的截短向量组也线性相关

+  $n$个$n$维向量，组成行列式$D$，若$D\neq0$,则这些向量线性无关 ; 若D=0,则这些向量线性相关

   >  向量的个数等于向量的维数

+  $n$个$n$维单位向量线性无关(行列式不等于$0$)

   

<font face = "楷体" size=4>例:$\left( 1,0,-1\right) ,\left( -1,-1,2\right) ,\left( 2,3,-5\right) $是否线性相关?</font>

<font color="blue">解</font>
$$
\begin{aligned}
设k_{1},k_{2},k_{3},\quad k_{1}\alpha _{1}+k_{2}\alpha _{2}+k_{3}\alpha _{3}=0\\
k_{1}\left( 1,0,-1\right) +k_{2}\left( -1,-1,2\right) +k_{3}\left( 2,3,-5\right) =0\\
\begin{cases}k,-k_{2}+2k_{3}=0\\
-k_{2}+3k_{3}=0\\
-k_{1}+2k_{2}-5k_{3}=0
\end{cases}
\qquad\begin{cases}
k_{1}=k_{3}\\
k_{2}=3k_{3}
\end{cases}\\
\therefore k_{3}=1,k_{1}=1,k_{2}=3
\end{aligned}
$$

>  如果线性相关,则方程组有非零解 ; 如果线性无关,则方程只有零解

###　例题:heavy_exclamation_mark:

:heavy_exclamation_mark:<font face="楷体">$\alpha,\beta,\gamma$线性无关,证明:$\alpha+\beta,\beta+\gamma,\alpha+\gamma$线性无关</font>
$$
设k_1,k_2,k_3\qquad k_{1}\left( \alpha +\beta \right) +k_{2}\left( \beta +\gamma \right) +k_{3}\left( x+\gamma \right) =0\\
\left( k_{1}+k_{3}\right) \alpha +\left( k_{1}+k_{2}\right) \beta +\left( k_{2}+k_{3}\right) \gamma =0\\
\because \alpha,\beta,\gamma线性无关\\
\therefore\begin{aligned}\begin{cases}k_{1}+k_{3}=0\\
k_{1}+k_2=0\\
k_{2}+k_{3}=0\end{cases}\\
\therefore k_{1}=k_{2}=k_{3}=0\end{aligned}\\
\therefore\alpha+\beta,\beta+\gamma,\alpha+\gamma线性无关
$$

### 定理

+  $\alpha_1,\alpha_2,\cdots,\alpha_s$相关的充要条件是至少此向量组中至少有一个向量可以由其他向量表示

+  如果$\alpha_1,\alpha_2,\cdots,\alpha_s$线性无关,$\alpha_1,\alpha_2,\cdots,\alpha_s,\beta$线性相关,则$\beta$可由$\alpha_1,\alpha_2,\cdots,\alpha_s$唯一线性表示

   >  证明:
   >  $\because\alpha_1,\alpha_2,\cdots,\alpha_s,\beta$线性相关,$\therefore$存在不全为$0$的$k_1,k_2,\cdots,k_{s+1}$
   >  使$$k_1\alpha_1+k_2\alpha_2+\cdots+k_s\alpha_s+k_{s+1}\beta=0$$
   >
   >  下证$k_{s+1}\neq0$
   >
   >  >  假设$k_{s+1}=0$
   >  >  因$k_1\alpha_1+k_2\alpha_2+\cdots+k_s\alpha_s+k_{s+1}\beta=0$且$\alpha_1,\alpha_2,\cdots,\alpha_s,\beta$线性相关
   >  >  则在$k_1,k_2,\cdots,k_{s}$中存在不为$0$的元素
   >  >  与$\alpha_1,\alpha_2,\cdots,\alpha_s$线性无关矛盾,故$k_{s+1}\neq0$
   >
   >  所以:$$k_{s+1}\beta=k_1\alpha_1+k_2\alpha_2+\cdots+k_s\alpha_s$$
   >  $\beta=\frac{k_1}{k_{s+1}}\alpha_1+\frac{k_2}{k_{s+1}}\alpha_2+\cdots+\frac{k_s}{k_{s+1}}\alpha_s$
   >
   >  下证唯一性:
   >  假设$\beta$可以有两种表示
   >  $\beta=m_1\alpha_1+m_2\alpha_2+\cdots+m_s\alpha_s\\\beta=n_1\alpha_1+n_2\alpha_2+\cdots+n_s\alpha_s$
   >
   >  两式作差:
   >  $(m_1-n_1)\alpha_1+(m_2-n_2)\alpha_2+\cdots+(m_s-n_s)\alpha_s=0$
   >  $\because\alpha_1,\alpha_2,\cdots,\alpha_s均不为0\\\therefore(m_1-n_1),(m_2-n_1),\cdots,(m_s-n_s)均等于0\\\therefore m_1=n_1 ,m_2=n_1,\cdots,m_s=n_s\\\therefore\beta向量组可以由\alpha向量组唯一表示$

+  $\alpha_1,\alpha_2,\cdots,\alpha_s$线性无关,且可由$\beta_1,\beta_2,\cdots,\beta_t$表示 , 则$s\leq t$

   $\alpha_1,\alpha_2,\cdots,\alpha_s$可由$\beta_1,\beta_2,\cdots,\beta_t$表示 , 且$s> t$ , 则$\alpha_1,\alpha_2,\cdots,\alpha_s$线性相关

   +  若$m>n$,则$m$个$n$维向量线性相关

      >  $m>n\to$向量个数>向量维数

      +  **$n+1$个$n$维向量线性相关**

   +  两个等价的线性无关组含向量的个数相同

# 向量组的秩

>  矩阵的秩:非零子式的最高阶数

## 极大线性无关组

**<font color=ee0000>定义 :</font> 设有向量组$A$,如果它的一个部分组$\alpha_1,\alpha_2,\cdots,\alpha_r$满足:**

+  **$\alpha_1,\alpha_2,\cdots,\alpha_r$线性无关**
+  **任取$\alpha\in A$,可以用$\alpha_1,\alpha_2,\cdots,\alpha_r$表示**

**则称$\alpha_1,\alpha_2,\cdots,\alpha_r$是$A$的极大线性无关组**

>  一个向量组的极大线性无关组一般是不唯一的 ; 每个极大线性无关组所含向量个数是相同的

+  全是$0$的向量组没有极大线性无关组
+  一个线性无关的向量组的极大线性无关组是它本身
+  向量组和它的极大线性无关组是等价的
   +  同一个向量组的多个极大线性无关组之间等价

## 向量组的秩

**<font color=ee0000>定义 : </font>向量组的极大线性无关组所含向量个数**

$\alpha_1,\alpha_2,\cdots,\alpha_s$的秩记作$r(\alpha_1,\alpha_2,\cdots,\alpha_r)$

注:

+  <font color="grey">$0\leq r(\alpha_1,\alpha_2,\cdots,\alpha_s)\leq s$</font>

   +  $\large 0\leq r(\alpha_1,\alpha_2,\cdots,\alpha_s)\leq min\{向量的个数\quad向量的维数\}$

   >若$m>n$,则$m$个$n$维向量线性相关
   >(三维向量只需要三个基向量表示)

+  若$\alpha_1,\alpha_2,\cdots,\alpha_s$线性无关 , 则$r=s$
+  若$\alpha_1,\alpha_2,\cdots,\alpha_s$线性相关 , 则$r<s$

**<font color=ee0000>定理 : </font>如果$\alpha_1,\alpha_2,\cdots,\alpha_s$可以由$\beta_1,\beta_2,\cdots,\beta_t$表示 , 则$r(\alpha_1,\alpha_2,\cdots,\alpha_s)\leq r(\beta_1,\beta_2,\cdots,\beta_t)$**

>  ​	两个向量组等价时取等

# 矩阵的行秩和列秩

+  **矩阵的行秩=矩阵的列秩=矩阵的秩**

**<font color=ee0000>定理 : </font>$r(AB)\leq min\{r(A)\quad r(B)\}$**

>  求行秩或列秩 : 直接求矩阵的秩,将矩阵通过初等行变换化为阶梯型矩阵



**<font color=ee0000>定理 : </font>初等行变换不改变矩阵列向量的线性关系**

>  初等行变换后,线性相关的向量仍线性相关,且线性表示的系数不变
>  线性无关的向量仍线性无关

## 极大线性无关组的求法

**例题:**

求$\alpha_1=(1,-2,2,-1),\alpha_2=(2.-4,8,0),\alpha_3=(-2,4,-2,3),\alpha_4=(3,-6,0,-6)$的一个极大线性无关组,并给出其余向量用该极大线性无关组的线性表示

:heavy_exclamation_mark:

>  +  **不管原向量组时行向量还是列向量,都按行写成矩阵**
>  +  **只用初等行变化,化成<font color=ee0000>行简化阶梯型</font>**
>  +  **首非零元所在的列作极大无关线性无关组**
>  +  **其余向量表示系数直接写出**

解:
$$
\begin{aligned}
不管原向量组时行向量还是列向量,都按行写成矩阵&\quad\begin{pmatrix}
   1&2&-2&3\\
   -2&-4&4&-6\\
   2&8&-2&0\\
   -1&0&3&-6
\end{pmatrix}\\
只用初等行变化,化成行简化阶梯型&=\begin{pmatrix}
1&0&-3&6\\
0&1&\frac{1}{2}&-\frac{3}{2}\\
0&0&0&0\\
0&0&0&0
\end{pmatrix}\\
首非零元所在的列作极大无关线性无关组:\beta_1&=
\begin{pmatrix}
1\\
0\\
0\\
0
\end{pmatrix},\beta_2=
\begin{pmatrix}
0\\
1\\
0\\
0
\end{pmatrix}\\
其余向量表示系数直接写出\quad\beta_3&=(-3)\beta_1+\frac{1}{2}\beta_2\\
\beta_4&=3\beta_1+(-\frac{3}{2})\beta_2\\
由于初等行变换不改变矩阵列向量的线性关系\therefore\alpha_3 &=(-3)\alpha_1+\frac{1}{2}\alpha_2\\
\alpha_4&=3\alpha_1+(-\frac{3}{2})\alpha_2
\end{aligned}
$$



# 线性方程组

## 线性方程组解的判定

>  $\begin{cases}x_1+x_2+x_3=1\\x_1-x_2-x_3=-3\\2x_1+9x_2+10x_3=11\end{cases}$
>  系数矩阵:$A=\begin{pmatrix}1&1&1\\1&-1&-1\\2&9&10\end{pmatrix}$
>
>  增广系数矩阵:$\overline{A}=\begin{pmatrix}1&1&1&\vdots&1\\1&-1&-1&\vdots&-3\\2&9&10&\vdots&11\end{pmatrix}$
>
>  >  在原系数矩阵的右边加上等号右边的常数
>
>  将原线性方程组写成向量的形式:$x_1\begin{pmatrix}1\\1\\2\end{pmatrix}+x_2\begin{pmatrix}1\\-1\\9\end{pmatrix}+x_3\begin{pmatrix}1\\-1\\10\end{pmatrix}=\begin{pmatrix}1\\-3\\11\end{pmatrix}$
>
>  对增广系数矩阵进行初等行变换:$\begin{pmatrix}
>  1 & 0 & 0 & \vdots & -1 \\
>  0 & 1 & 0 & \vdots  & 7 \\
>  0 & 0 & 1 & \vdots  & -5
>  \end{pmatrix}$
>
>  $\therefore\begin{cases}x_{1}=-1\\
>  x_{2}=7\\
>  x_{3}=-5\end{cases}$
>
>  +  在上面的解中:
>
>     +  $r(A)=r(\overline{A})=未知数个数\longrightarrow$有唯一解
>
>  +  第二种情况 : 
>
>     >  $\begin{pmatrix}
>     >  1 & 0 & 1 & \vdots  & 5 \\
>     >  0 & 1 & 1 & \vdots  & 9 \\
>     >  0 & 0 & 0 & \vdots  & 0
>     >  \end{pmatrix}\longrightarrow\begin{cases}x_{1}=5-x_{3}\\
>     >  x_{2}=9-x_{3}\end{cases}$
>
>     +  $r(A)=r(\overline{A})<未知数个数\longrightarrow$有无穷个解
>     
>  +  第三种情况：
>
>     >  $\begin{pmatrix}
>     >  1 & 0 & 1 & \vdots  & 3 \\
>     >  0 & 1 & 1 & \vdots  & 4 \\
>     >  0 & 0 & 0 & \vdots  & 1
>     >  \end{pmatrix}\longrightarrow\begin{cases}x_{1}+x_3=3\\
>     >  x_{2}=4\\0=1\end{cases}$
>
>     +  $r(A)\neq r(\overline{A})\longrightarrow$无解

有解 : $r(A)=r(\overline{A})\begin{cases}r(A)=r(\overline{A})=n,唯一解\\r(A)=r(\overline{A})<n,无穷个解\end{cases}$

无解 : $r(A)\neq r(\overline{A})$

>  $m$ : 方程的个数
>
>  $n$ : 未知数的个数

## 解线性方程组的步骤

+  写出方程组的增广系数矩阵

   >化为阶梯型后,画出阶梯型折线,如果折线直接穿过增广矩阵的虚线,则有解 ; 如果折线与虚线有重合,则无解

+  只作初等行变化,化成阶梯型矩阵

+  看$r(A)$与$r(\overline{A})$是否相等
   看虚线左边非零行行数与虚线右边非零行行数是否相等

   +  相等 , 且等于未知数个数$\to$有唯一解
   +  相等 , 小于未知数个数$\to$有无穷个解
      +  化为行简化阶梯型
         不管零行
         非零行的首非零元留在等号左边,
         其他元素移到等号右边
         得到一般解,等号右边的$x_i$为自由未知量
   +  不相等 , 无解

`对于有参数的线性方程组,在作初等行变换时不能将参数放到分母上`

# 齐次线性方程组的解

>  齐次线性方程组:等号右边都是$0$
>  齐次线性方程组一定有解 , 至少有零解
>
>  有解$\to r(A)=r(\overline{A})$
>
>  >  $r(\overline{A})$比$r(A)$多一列$0$,在原矩阵的基础上添加任意行/列$0$,不改变矩阵的秩
>  >  因为矩阵的秩是*非零子式的最高阶数*,添加的$0$不影响非零子式的取值

①一定有解:$r(A)=r(\overline{A})\begin{cases}r(A)=r(\overline{A})=n,有零解\\r(A)=r(\overline{A})<n,有非零解\end{cases}$

②齐次线性方程组有非零解的充要条件是 : $r(A)<n$

`只要找到一个非零解,就有无数个非零解`

③方程个数$m<$未知数个数$n\to$有非零解

>$\large 0\leq r(A)\leq min\{方程个数m\quad未知量个数n\}=m<n$②

④方程个数$m$=未知数个数$n$,齐次线性方程组有非零解的充要条件是$|A|=0$

>  ②齐次线性方程组有非零解的充要条件是 : $r(A)<n$
>  $r(A)$ : 非零子式的最高阶数$\to$$A$的$k(k>r(A))$阶子式的值都为零
>  $\therefore |A|_{n\times n}=0$

+  推论 : 方程个数$m$=未知数个数$n$,齐次线性方程组只有零解的充要条件是$|A|\neq0$
   +  推论的推论 : 推论中$|A|\neq0\to A$可逆
      $原方程组:Ax=0\to A^{-1}Ax=A^{-1}\cdot0\to x=0\to方程组只有零解$

例题 : 判断$(1,3,0,5),(1,2,1,4),(1,1,2,3),(2,5,1,9),(1,-3,6,-1)$的线性相关性|

>因为是5个4维向量,所以一定线性相关

$$
设x_1\alpha_1+x_2\alpha_2+x_3\alpha_3+x_4\alpha_4+设x_1\alpha_1+x_2\alpha_2+x_3\alpha_3+x_4\alpha_4+x_5\alpha_5=0 //有解则线性相关,无解则线性无关\\
\begin{cases}
x_1+x_2+x_3+2x_4+x_5=0\\
3x_1+2x_2+x_3+5x_4-3x_5=0\\
\quad+x_2+2x_3+x_4+6x_5=0\\
5x_1+4x_2+3x_3+9x_4-x_5=0
\end{cases}\\
\begin{pmatrix}
1&1&1&2&1\\
3&2&1&5&-1\\
0&1&2&1&6\\
5&4&3&9&-1
\end{pmatrix}//写出系数矩阵\\
\begin{pmatrix}
1&0&-1&1&-5\\
0&1&2&1&6\\
0&0&0&0&0\\
0&0&0&0&0
\end{pmatrix}//化为行阶梯最简形\\
\begin{cases}
x_1=x_3-x_4+5x_5\\
x_2=-2x_3-x_4-6x_5
\end{cases}//写出通解方程组
$$

# 解的结构

+  唯一解
+  无解
+  无穷多解

## 齐次线性方程组解的结构

$$
Ax=0
$$

+  唯一解
+  无穷多解

### 性质1

$\eta_1,\eta_2$是齐次线性方程组$Ax=0$的解,那么$\eta_1+\eta_2$也是方程组的解 <span id="齐次性质一"></span>

>  $\because A\eta_1=0,A\eta_2=0\\\therefore A(\eta_1+\eta_2)=A\eta_1+A\eta_2=0$

### 性质2

$\eta$是齐次线性方程组$Ax=0$的解,那么$c\eta$也是方程组的解



## 基础解系<span id ="基础解系"></span>

$\eta_1,\eta_2,\cdots,\eta_s$

+  $\eta_1,\eta_2,\cdots,\eta_s$线性无关
+  $Ax=0$的任意解都可以由$\eta_1,\eta_2,\cdots,\eta_s$表示

则$\eta_1,\eta_2,\cdots,\eta_s$是$Ax=0$的基础解系



例题 : 
$$
A的行简化阶梯型:\begin{pmatrix}
1&0&-\frac{9}{4}&-\frac{3}{4}&\frac{1}{4}\\
0&1&\frac{3}{4}&-\frac{7}{4}&\frac{5}{4}\\
0&0&0&0&0
\end{pmatrix}\\
\begin{cases}
x_1=\frac{9}{4}x_3+\frac{3}{4}x_4-\frac{1}{4}x_5\\
x_2=-\frac{3}{4}x_3+\frac{7}{4}x_4-\frac{5}{4}x_5
\end{cases}\\
其中,x_3,x_4,x_5是自由未知量\\
令x_3=\begin{pmatrix}1\\0\\0\end{pmatrix},x_4\begin{pmatrix}0\\1\\0\end{pmatrix},x_5=\begin{pmatrix}0\\0\\1\end{pmatrix}//这里取得三个向量只要是线性无关就行\\
将x_3,x_4,x_5带入上面的等式\\
令\eta_1=\begin{pmatrix}\frac{9}{4}\\-\frac{3}{4}\\1\\0\\0\end{pmatrix},\eta_2=\begin{pmatrix}\frac{3}{4}\\\frac{7}{4}\\0\\1\\0\end{pmatrix},\eta_3=\begin{pmatrix}-\frac{1}{4}\\-\frac{5}{4}\\0\\0\\1\end{pmatrix}\\
则A的基础解系为\eta_1,\eta_2,\eta_3
$$

>+  $\eta_1,\eta_2,\eta_3$是线性无关的
>
>   +  因为$\begin{pmatrix}1\\0\\0\end{pmatrix},\begin{pmatrix}0\\1\\0\end{pmatrix},\begin{pmatrix}0\\0\\1\end{pmatrix}$线性无关, **线性无关向量组的接长向量组也线性无关**
>
>+  $Ax=0$的任意解都可以由$\eta_1,\eta_2,\cdots,\eta_s$表示
>
>   +  假设解为$\begin{pmatrix}x_1\\x_2\\x_3\\x_4\\x_5\end{pmatrix}$
>      $$
>      \begin{pmatrix}
>      x_1\\
>      x_2\\
>      x_3\\
>      x_4\\
>      x_5
>      \end{pmatrix}
>      =\begin{pmatrix}
>      \frac{9}{4}x_3+\frac{3}{4}x_4-\frac{1}{4}x_5\\
>      -\frac{3}{4}x_3+\frac{7}{4}x_4-\frac{5}{4}x_5\\
>      x_3+0x_4+0x_5\\
>      0x_3+x_4+0x_5\\
>      0x_3+0x_4+x_5
>      \end{pmatrix}
>      =\begin{pmatrix}\frac{9}{4}x_3\\-\frac{3}{4}x_3\\1x_3\\0x_3\\0x_3\end{pmatrix}+
>      \begin{pmatrix}\frac{3}{4}x_4\\\frac{7}{4}x_4\\0x_4\\1x_4\\0x_4\end{pmatrix}+\begin{pmatrix}-\frac{1}{4}x_5\\-\frac{5}{4}x_5\\0x_5\\0x_5\\1x_5\end{pmatrix}=x_3\eta_1+x_4\eta_2+x_5\eta_3\\
>      x_3,x_4,x_5取任意值
>      $$

**基础解系中向量的个数有$n-r(A)$个**<span id="基础解系中向量的个数"></span>



例题 : 
$$
A\to\begin{pmatrix}
1&-2&0&-\frac{2}{7}\\
0&0&1&\frac{5}{7}\\
0&0&0&0
\end{pmatrix}\qquad
\begin{cases}
x_1=2x_2+\frac{2}{7}x_4\\
x_3=-\frac{5}{7}x_4
\end{cases}\\
令x_2,x_4取\begin{pmatrix}1\\0\end{pmatrix},\begin{pmatrix}0\\1\end{pmatrix}\qquad则\eta_1=\begin{pmatrix}2\\1\\0\\0\end{pmatrix},\eta_2=\begin{pmatrix}\frac{2}{7}\\0\\-\frac{5}{7}\\1\end{pmatrix}\\
Ax=0的通解为c_1\eta_1+c_2\eta_2,其中c_1,c_2为任意常数
$$
还有一种情况:
$$
A\to\begin{pmatrix}1&0&0&0&0&1\\0&0&1&0&0&0\\0&0&0&0&0&0\end{pmatrix}\qquad
\begin{cases}
x_1=-x_6\\
x_3=0
\end{cases}//注意,这里不在等号左边的,都是自由未知量\\
x_2,x_4,x_5,x_6是自由未知量,令x_2=\begin{pmatrix}1\\0\\0\\0\end{pmatrix},x_4=\begin{pmatrix}0\\1\\0\\0\end{pmatrix},x_5=\begin{pmatrix}0\\0\\1\\0\end{pmatrix},x_6=\begin{pmatrix}0\\0\\0\\1\end{pmatrix}\\
则\eta_1=\begin{pmatrix}0\\0\\1\\0\\0\\0\end{pmatrix}\eta_2=\begin{pmatrix}0\\0\\0\\1\\0\\0\end{pmatrix}\eta_3=\begin{pmatrix}0\\0\\0\\0\\1\\0\end{pmatrix}\eta_4=\begin{pmatrix}-1\\0\\0\\0\\0\\1\end{pmatrix}\\
Ax=0的通解为c_1\eta_1+c_2\eta_2+c_3\eta_3+c_4\eta_4,其中c_1,c_2,c_3,c_4为任意常数
$$


自由未知量的取值要灵活 : 
$$
\begin{cases}
x_1=\frac{1}{4}x_3-\frac{3}{4}x_4+\frac{17}{4}x_5\\
x_2=\frac{9}{4}x_3+\frac{1}{4}x_4-\frac{23}{4}x_4
\end{cases}\\
取x_3,x_4,x_5为\begin{pmatrix}4\\0\\0\end{pmatrix},\begin{pmatrix}0\\4\\0\end{pmatrix},\begin{pmatrix}0\\0\\4\end{pmatrix}\\
相应的:\eta_1=\begin{pmatrix}1\\9\\4\\0\\0\end{pmatrix},\eta_2=\begin{pmatrix}-1\\1\\0\\4\\0\end{pmatrix},\eta_3=\begin{pmatrix}17\\-23\\0\\0\\4\end{pmatrix}
$$
:star::star:结论:
例题 $A_{m\times n},B_{n\times s},AB=O,证明r(A)+r(B)\leq n$​

>注意 : $AB=O,O是零矩阵,阶数为m\times s$

$$
\begin{aligned}
B&=(\beta_1,\beta_2,\cdots,\beta_s)//写成矩阵乘向量的形式\\
AB&=A(\beta_1,\beta_2,\cdots,\beta_s)=(O,O,\cdots,O)\\
A\beta_i&=0,(i=1,2,\cdots,s)\\
\beta_i是Ax&=0的解\\
(1)r(A)=n,Ax&=0有唯一零解\to\beta_i=O\to r(B)=0\& r(A)=n\to r(A)+r(B)\leq n成立\\
(2)r(A)\leq n,Ax&=0有无穷解,基础解系中有n-r(A)个解(锚点1)\to r(\beta_1,\beta_2,\cdots,\beta_s)\leq n-r(A)\\
\to r(A)+r(B)&\leq n成立
\end{aligned}
$$

[锚点1](#基础解系中向量的个数)

## 非齐次线性方程组解的结构

非齐次线性方程组$Ax=b\to Ax=0$ $Ax=0$叫做原非齐次线性方程组的<span id="导出组">导出线性方程组</span>

+  如果$\alpha_1,\alpha_2$是$Ax=b$的解,则$\alpha_1-\alpha_2$是$Ax=0$的解<span id="非齐次性质一"></span>

   >  $A(\alpha_1-\alpha_2)=A\alpha_1-A\alpha_2=b-b=0$

+  如果$\alpha_0$是$Ax=b$的解,$\eta$是$Ax=0$的解,则$\alpha_0+\eta$是$Ax=b$的解<span id="非齐次性质二"></span>

   >  $A(\alpha_0+\eta)=A\alpha_0+a\eta=b+0=b$

### 非齐次线性方程组解的结构

**如果$\alpha_0$是$Ax=b$的一个解,$\eta$是$Ax=0$的一个解**
$$
\begin{aligned}
\eta=C_1\eta_1+C_2\eta_2+\cdots+C_{n-r}\eta_{n-r}\quad(\eta_1,\eta_2,\cdots\eta_{n-r})是Ax&=0的基础解系\\
则\alpha_0+C_1\eta_1+C_2\eta_2+\cdots+C_{n-r}\eta_{n-r}是Ax&=b的通解
\end{aligned}
$$

>$\alpha_0$ : $Ax=b$的一个特解
>$C_1\eta_1+C_2\eta_2+\cdots+C_{n-r}\eta_{n-r}$ : $Ax=0$的基础解系的线性组合

### 非齐次线性方程组的通解<span id="非齐次线性方程组的通解"></span>

+  写出$\overline{A}$,只使用初等行变化化为行简化阶梯型
+  非零行的首非零元$1$留在等号左边,其余的移到等号右边,写出非齐次的通解方程组,指出自由未知量(不在等号左边的都是自由未知量)
+  令自由未知量都取$0$,得到$Ax=b$的一个特解
+  令通解方程组右边的常数项取$0$,得到$Ax=0$的同解方程组,指出自由未知量,令自由未知量[取值](#基础解系)
+  特解 + $Ax=0$的基础解系的线性组合

------

例题:
$$
\begin{aligned}
&(1)求特解\\
\overline{A}=&\begin{pmatrix}
1&5&-1&-1&\vdots&-1\\
1&-2&1&3&\vdots&3\\
3&8&-1&1&\vdots&1\\
1&-9&3&7&\vdots&7
\end{pmatrix}\\
&\begin{pmatrix}
1&0&\frac{3}{7}&\frac{13}{7}&\vdots&\frac{13}{7}\\
0&1&-\frac{2}{7}&-\frac{4}{7}&\vdots&-\frac{4}{7}\\
0&0&0&0&\vdots&0\\
0&0&0&0&\vdots&0
\end{pmatrix}//化为行简化阶梯型\\
&\begin{cases}
x_1=\frac{13}{7}-\frac{3}{7}x_3-\frac{13}{7}x_4\\
x_2=-\frac{4}{7}+\frac{2}{7}x_3+\frac{4}{7}x_4
\end{cases}//写出同解方程组\\
&x_3,x_4是自由未知量\\
&取\begin{pmatrix}
x_3\\
x_4
\end{pmatrix}=\begin{pmatrix}
0\\0
\end{pmatrix}\quad 则\alpha_0是Ax=b的一个特解\\
&(2)求基础解系\\
导出组的同解方程组为
&\begin{cases}
x_1=-\frac{3}{7}x_3-\frac{13}{7}x_4\\
x_2=\frac{2}{7}x_3+\frac{4}{7}x_4
\end{cases}\\
&x_3,x_4为自由未知量\\
&取\begin{pmatrix}
x_3\\
x_4
\end{pmatrix}=\begin{pmatrix}
1\\0
\end{pmatrix},\begin{pmatrix}
0\\1
\end{pmatrix}\\
则导出组的基础解系为\eta_1&=\begin{pmatrix}-\frac{3}{7}\\\frac{2}{7}\\1\\0\end{pmatrix},\eta_2=\begin{pmatrix}-\frac{13}{7}\\\frac{4}{7}\\0\\1\end{pmatrix}\\
\\
Ax&=b的解为\alpha_0+C_1\eta_1+C_2\eta_2\quad C_1,C_2为任意常数
\end{aligned}
$$

----

例题:
$$
四元非齐次线性方程组Ax=b,r(A)=3,\alpha_1,\alpha_2,\alpha_3是三个解\\\alpha_1=(2 3 4 5)^T,\alpha_2+\alpha_3=(1 2 3 4)^T,求方程组的通解
$$

>  [非齐次线性方程组的通解](#非齐次线性方程组的通解) : 特解(已经给出($\alpha_1$)) + $Ax=0$的基础解系的线性组合
>  [导出组](#导出组)基础解系中向量的个数 : $n-r(A)=1$ `(n:未知数个数)`

解 : $\alpha_1,\alpha_1$是$Ax=b$的解,则$\alpha_1-\alpha_2$是$Ax=0$的解
   	$\alpha_1,\alpha_3$是$Ax=b$的解,则$\alpha_1-\alpha_3$是$Ax=0$的解 [注](#非齐次性质一)
       则$2\alpha_1-(\alpha_2+\alpha_3)$是$Ax=0$的解 [注](#齐次性质一)
		$Ax=0$的解为$(3,4,5,6)^T$
	   则$Ax=b$的解为$\alpha_1+C_1(3,4,5,6)^T$

------

$$