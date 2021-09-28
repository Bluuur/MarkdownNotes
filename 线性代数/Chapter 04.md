[TOC]

# 矩阵的特征值与特征向量

**定义** : 设$A$为$n$阶**方阵**,如果数$\lambda$和$n$维向量$x$满足关系式
$$
Ax=\lambda x,
$$
则数$\lambda$称为方阵$A$的特征值,非零向量$x$称为方阵$A$的对应于特征值$\lambda$的特征向量

**特征向量求法 : **
$$
\begin{aligned}
\because A\alpha&=\lambda \alpha\\
\lambda \cdot E\alpha-A\alpha&=O\\
(\lambda E-A)\alpha&=O\\
(\lambda E-A)\alpha=O的非零解&\leftrightarrow |\lambda E-A|=O
\end{aligned}
$$ {h}

+  特征矩阵 : $\lambda E-A$

+  特征行列式 : $|\lambda E-A|$
+  特征方程 : $|\lambda E-A|=O$

①$\lambda$是$A$的特征值,$\alpha$是$\lambda$对应的特征向量,则$c\alpha$也是$\lambda$的特征向量$(c\neq0)$

>  一个特征值可以对应无穷多个特征向量 ; 一个特征向量只能对应一个特征值

$$
\lambda是A的特征值,\alpha是\lambda对应的特征向量\\
A\alpha=\lambda\alpha\\
cA\alpha=c\lambda\alpha\\
A(c\alpha)=\lambda(c\alpha)\\
c\alpha也是\lambda的特征向量(c\neq 0)
$$

②$\alpha_1,\alpha_2$是$\lambda$的特征向量,则$c_1\alpha_1+c_2\alpha_2$是$\lambda$的特征向量
$$
A(c_1\alpha_1+c_2\alpha_2)=c_1A\alpha_1+c_2A\alpha_2=c_1\lambda\alpha_1+c_2\lambda\alpha_2=(c_1\alpha_1+c_2\alpha_2)\lambda
$$

---------

例题 : 

>  $A\alpha = \lambda\alpha$
>  特征方程 : $|\lambda E-A|=O$

$$
求A=\begin{pmatrix}
-1&1&0\\
-4&3&0\\
1&0&2
\end{pmatrix}的特征值和特征向量\\
\quad\\
\quad\\
\begin{aligned}解: 	
\lambda E-A&=\begin{pmatrix}
\lambda&&\\
&\lambda&\\
&&\lambda
\end{pmatrix}-
\begin{pmatrix}
-1&1&0\\
-4&3&0\\
1&0&2
\end{pmatrix}\\
&=\begin{pmatrix}
\lambda+1&1&0\\
-4&\lambda-3&0\\
1&0&\lambda-2
\end{pmatrix}\\\\
|\lambda E-A|&=\begin{vmatrix}
\lambda+1&1&0\\
-4&\lambda-3&0\\
1&0&\lambda-2
\end{vmatrix}\\
&=0
\end{aligned}
$$

>  直接展开会得到三次方程 :heavy_multiplication_x:
>  把某行(列)全部化为0,再按行展开 :heavy_check_mark:
>  提公因子:heavy_check_mark:
>  制造行(列)和:heavy_check_mark:

$$
\begin{aligned}
|\lambda E-A|&=(\lambda-2)(-1)^{3+3}\begin{vmatrix}\lambda+1&-1\\4&\lambda-3\end{vmatrix}\\
&=(\lambda-2)(\lambda-1)(\lambda-1)\\
\therefore \lambda_1=\lambda_2&=1\qquad\lambda_3=2
\end{aligned}
$$

>  **有重根要写出来**
>
>  求特征向量$x$ : $(\lambda E-A)x=O$

$$
\begin{aligned}
(1)\lambda_1=\lambda_2=1时\\
\lambda E- A&=\begin{pmatrix}
2&-1&0\\
4&-2&0\\
-1&0&-1
\end{pmatrix}\\
&=\begin{pmatrix}
1&0&1\\
0&1&2\\
0&0&0
\end{pmatrix}\\
&\begin{cases}
x_1=-x_3\\
x_2=0
\end{cases}\\
令x_3&=(1)\\
令\eta&=\begin{pmatrix}
1\\2\\-1
\end{pmatrix}\\
通解为c\eta,(c\neq 0)//要求特征向量,c不为0
\end{aligned}
$$

