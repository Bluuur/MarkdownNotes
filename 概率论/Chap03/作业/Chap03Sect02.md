# 习题 3.2

3.若$X\sim N(\mu,\sigma^2).$试求$Y=e^X$的分布密度

解:$Y=e^X$的分布密度为:
$$
\Large\begin{aligned}
F_{Y}(y)&=P\{Y<y\}\\
&=P\left\{\mathrm{e}^{X}<y\right\}\\
&=\left\{\begin{array}{cl}
\int_{-\infty}^{\ln y} \frac{1}{\sqrt{2 \pi} \sigma} \mathrm{e}^{-\frac{(x-\mu)^{2}}{2 \sigma^{2}}} \mathrm{~d} x, & y>0 \\
0, & y \leqslant 0
\end{array}\right.
\end{aligned}
$$


$\therefore Y$的分布密度为
$$
\Large p_{Y}(y)=F_{Y}^{\prime}(y)=\left\{\begin{array}{cl}
\frac{1}{\sqrt{2 \pi} \sigma y} \cdot \mathrm{e}^{-\frac{(\ln y-\mu) 2}{2 \sigma^{2}}}, & y>0, \\
0, & y \leqslant 0 .
\end{array}\right.
$$


---

5.设X与Y相互独立且都服从N(0,1)分布,试求Z=X+Y的分布密度

解:由卷积公式$p_{z}(z)=\int_{-\infty}^{+\infty} p(x, z-x) \mathrm{d} x$,$Z=X+Y$的分布密度为
$$
\huge\begin{aligned}
p_{2}(z) &=\int_{-\infty}^{+\infty} \frac{1}{2 \pi} \cdot \mathrm{e}^{-\frac{x^{2}+(z-x) 2}{2}} \mathrm{~d} x \\
&=\frac{1}{2 \pi} \cdot \mathrm{e}^{-\frac{z^{2}}{2}} \int_{-\infty}^{+\infty} \mathrm{e}^{-\frac{2 x^{2}-2 z x}{2}} \mathrm{~d} x\\
&=\frac{1}{2 \pi} \cdot \mathrm{e}^{-\frac{z^2}{2}} \cdot \mathrm{e}^{\frac{x^2}{4}} \int_{-\infty}^{+\infty} \mathrm{e}^{-\left(x-\frac{z}{2}\right)^{2}} \mathrm{~d} x \\
&=\frac{1}{\sqrt{2 \pi} \cdot \sqrt{2}} \cdot \mathrm{e}^{-\frac{z^{2}}{4}}
\end{aligned}
$$
$\therefore X+Y\sim N(0.2)$

