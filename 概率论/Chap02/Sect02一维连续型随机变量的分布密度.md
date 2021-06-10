# 第二节 一维连续型随机变量的分布密度

# 一维连续型随机变量的分布密度

## 定义

分布密度
设$p(x)$为非负可积函数，若$P\{a<X\leq b\}=\int_{a}^{b}dx$，则称$p(x)$为连续型随机变量的分布密度

$$F(x)=P\{X\leq x\}=\int_{-\infin}^{x}p(x)dx\\F'(x)=p(x),F(x)连续 $$

## 性质

- $p(x)\geq0$
- $\int_{-\infin}^{+\infin}p(x)dx=1$ 用来求$p(x)$中的待定系数
- 连续型随机变量$X$$,\forall a,$有$P\{X=a\}=0$

$$\begin{aligned}故&有P\{a\leq X<b\}\\&=P\{a<X<b\}\\&=P\{a<X\leq b\}\\&=P\{a\leq X\leq b\}\end{aligned}$$

$$\begin{aligned}
(1)\lim_{x\to+\infin}F(x)&=1\\
&=\lim_{x\to+\infin}\left(A+\frac{B}{e^{\frac{x^2}{2}}}\right)\\
&=A\\
&\because F(x)连续\\
\therefore F(0)&=0\\
&=\lim_{x\to0^+}\\
F(x)&=\lim_{x\to0^+}\left (A+Be^{-\frac{x^2}{2}}\right ) \\
&=A+B\\
\therefore B&=-1\\
(2)p(x)&=F'(x)\\
&=\begin{cases}
-Be^{-\frac{x^2}{x}}x\qquad x>0\\
0\qquad\qquad\qquad x\leq0
\end{cases}
\end{aligned}$$

$$\begin{aligned}    when \ x&\leq a\\    F(x)&=\int_{-\infin}^{x}p(x)dx\\    &=\int_{-\infin}^{x}0dx\\    &=0\\    when\ a&<x\leq b\\    F(x)&=\int_{-\infin}^{x}p(t)dt\\    &=\int_{-\infin}^{a}0dt+\int_{a}^{x}\frac{1}{b-a}dt\\    &=\left.\frac{t}{b-a }\right|_{a}^{x}\\&=\frac{x-a}{b-a}\\    when\ b&<x\\    F(x)&=\int_{-\infin}^{x}p(t)dt\\&=\end{aligned}$$

## 几个重要分布

### 均匀分布

若一维连续型随机变量$X$的密度函数

$$p(x)=\begin{cases}\frac{1}{b-a}\quad a<x<b\\0\quad其他\end{cases}$$

则称$X$服从$(a,b)$上的均匀分布，记作$X\sim U(a,b)$

### 指数分布

$$p(x)=\begin{cases}\lambda e^{-\lambda x}\quad x\geq 0\\0\qquad x<0 \end{cases}\quad其中\lambda>0$$

则称随机变量$X$服从参数为$\lambda$的指数分布，记作$X\sim E(\lambda)$

指数分布常用来描述“寿命”的分布

指数分布的无记忆性：

即如果一直寿命长于$s$年，则再活$t$年的可能性与年龄$s$无关

### 标准正态分布

若随机变量$X$满足

$$p(x)=\frac{1}{\sqrt{2\pi}}e^{\frac{-x^2}{2}} \qquad(-\infin<x<+\infin)$$

则称随机变量$X$服从标准正态分布，记作$X\sim N(0,1)$

$p(x)$的特征

 

1. $p(x)$是偶函数，曲线$y=p(x)$关于$y$轴对称
2. $\lim_{x\to\infin}p(x)=0$ , 曲线$y=p(x)$以$x$轴为渐近线
3. 最大值$\frac{1}{\sqrt{2}\pi e}$(当$x=0$时)
4. $(1,\frac{1}{\sqrt{2\pi}e}),(-1,\frac{1}{\sqrt{2\pi}e})$是拐点

正态分布表

### 正态分布

若随机变量$X$服从

$$\large p(x)=\frac{1}{\sqrt{2\pi}\sigma}e^{-\frac{(x-\mu)^2}{2\sigma^2}}
\qquad \small (-\infin<x<+\infin,\mu,\sigma是常数,\sigma>0)$$

则称随机变量$X$服从参数为$\mu,\sigma^2$的正态分布，记作$X\sim N(\mu,\sigma^2)$

$X\sim N(\mu,\sigma^2)$时，$X$的分布函数

$$\large F(x)=\frac{1}{\sqrt{2\pi}\sigma}\int_{-\infin}^{x}
e^{-\frac{(x-\mu)^2}{2\sigma^2}}dx$$

$$\lim_{n\to \infin}p\left\{\frac{Y-np}{\sqrt{np(1-p)}}<x\right\}=\Phi(x)$$

# 一维连续型随机变量常用的分布