# Biostatistics

## Hypothesis Test

### One Sample

#### $\mu=\mu_0$

##### $\sigma^2$ known, U Test

$$
U=\frac{\bar x-\mu_0}{\sigma}
$$

##### $\sigma^2$ unknown, t Test

$$
\begin{aligned}
t&=\frac{\bar x-\mu_0}{s_x}\\
\\
s_x&=\frac{s}{\sqrt n}
\end{aligned}
$$

> $s$: sample deviation

#### $\sigma^2=\sigma_0^2$ Chi Square Test

$$
\chi^2=\frac{(n-1)s^2}{\sigma_0^2}
$$

### Two Sample

#### $\mu_1=\mu_2$

##### $\sigma_1,\sigma_2$ known, U Test

$$
U=\frac{\bar X-\bar Y-(\mu_1-\mu_2)}{\sqrt{\frac{\sigma_1^2}{n_1}+\frac{\sigma_2^2}{n_2}}}
$$

##### $\sigma_1,\sigma_2$ unknown, t Test

1. F Test, $H_0: \sigma_1^2=\sigma_2^2$
   $$
   F=\frac{s_1^2}{s_2^2}\sim F(n_1-1,n_2-1)
   $$

If accept $H_0$, go on step 2

2. t Test
   $$
   t=\frac{(\bar{X}-\bar{Y})-(\mu_1-\mu_2)}{\sqrt{\frac{(n_1-1)s_1^2+(n_2-1)s_2^2}{n_1+n_2-2}}\sqrt{\frac{1}{n_1}+\frac{1}{n_1}}}\sim t(n_1+n_2-2)
   $$
   

#### $\sigma_1^2=\sigma_2^2$, F Test

$$
F=\frac{s_1^2}{s_2^2}\sim F(n_1-1,n_2-1)
$$

## Chi Square Test

### $df>1$

$$
\chi^2=\sum\frac{(O-E)^2}{E}
$$

> $O$: Observed Value
>
> $E$: Expected Value
>
> $df$: degree of freedom

### $df =1$

$$
\chi_c^2=\sum\frac{(|O-E|-0.5)^2}{E}
$$

> $c$ in $\chi_c^2$ for correction

### Chi Square Test for certain proportion

$H_0:\ A:a=r:m$
$$
\chi^2=\sum\frac{(|mA-ra|-\frac{r+m}{2})^2}{rmn}
$$

### Chi Square Test for independence test

#### 2 by 2

$$
\begin{aligned}
df&=1\\
\chi_c^2&=\sum\frac{(|O-E|-0.5)^2}{E}
\end{aligned}
$$

#### other

$$
\chi^2=\sum\frac{(O-E)^2}{E}
$$

## ANalysis Of VAriation

Statics Values
$$
\begin{aligned}
C&=\frac{T^2}{nk}\\
SST&=\sum x^2-C\\
SSt&=\frac{1}{n}\sum T.^2-C\\
SSE &= SST-SSt
\end{aligned}
$$

> $T$: Grand Total

ANOVA
$$
\begin{array}{c}
\hline
&SOV &SS &df &MS &F &F_{0.05} &F_{0.01}\\
\hline
&Treatment &SSt &k-1 &MSt  &\frac{MSt}{MSE} &\text{check\ \ \ \ in}&\text{table}\\
&Error &SSR &k(n-1)&MSE\\
\hline
&Total &SST &kn-1\\
\hline
\end{array}
$$

### One Way ANOVA

#### LSD Method

$$
\begin{aligned}
LSD_\alpha&=t_\alpha\cdot s_{\bar x_1-\bar x_2}\\
s_{\bar x_1-\bar x_2}& =\sqrt{\frac{2SSE}{n}}
\end{aligned}
$$

#### SSR Method

$$
\begin{aligned}
LSR_\alpha&=SSR_\alpha\cdot s_{\bar x_1-\bar x_2}\\
s_{\bar x_1-\bar x_2}& =\sqrt{\frac{SSE}{n}}
\end{aligned}
$$

#### q Value Method

$$
\begin{aligned}
LSR_\alpha&=q_\alpha\cdot s_{\bar x_1-\bar x_2}\\
s_{\bar x_1-\bar x_2}& =\sqrt{\frac{SSE}{n}}
\end{aligned}
$$

### Two Way ANOVA

Data Structure
$$
\begin{array}{c}
\hline
&Trt\ B &\begin{array}{c} &&Trt\ A&\\\hline &A_1&\cdots &A_a\end{array} &T_{i}. &\bar x_i.\\
\hline
&B_1\\
&\cdots\\
&B_b\\
\hline
&T._j &&T\\
&\bar x._j&&&\bar x\\
\hline
\end{array}
$$
Statics Values
$$
\begin{aligned}
C&=\frac{T^2}{ab}\\
SST&=\sum x^2-C\\
SSA&=\frac{1}{b}\sum T^2_{i}.-C\\
SSB&=\frac{1}{a}\sum T^2._j -C\\
SSR&=SST-SSA-SSB\\
\end{aligned}
$$
ANOVA
$$
\begin{array}{c}
\hline
&SOV &SS &df &MS &F &F_{0.05} &F_{0.01}\\
\hline
&Trt\ A &SSA &a-1 &MSA  &\frac{MSA}{MSE} &\text{check\ \ \ \ in}&\text{table}\\
&Trt\ B &SSB &b-1 &MSB  &\frac{MSA}{MSE} \\
&Error &SSE &(a-1)(n-1) &MSE\\
\hline
&Total &SST &ab-1\\
\hline
\end{array}
$$

## Linear Regression

Statistics Values
$$
\begin{aligned}
SS_x&=\sum x^2-\frac{(\sum x)^2}{n}\\
SS_y&=\sum y^2-\frac{(\sum y)^2}{n}\\
SP&=\sum xy-\frac{\sum x\sum y}{n}\\
\end{aligned}
$$

$$
b=\frac{SP}{SS_x}\qquad a=\bar y-b\bar x\\
\text{get}\ \hat y=a+bx
$$

### t Test for b

$$
\begin{aligned}
U&=\frac{SP^2}{SS_x}\\
Q&=SS_x-U\\
s_{y/x}&=\sqrt{\frac{Q}{n-2}}\\
s_b&=\frac{s_{y/x}}{\sqrt{SS_x}}\\
\\
t&=\frac{b}{s_b}
\end{aligned}
$$

### Interval Estimation

#### $\beta$

$$
s_b=\frac{s_{y/x}}{\sqrt{SS_x}}\qquad t=\frac{b-\beta}{s_b}
$$

#### $\alpha$

$$
s_a=s_{y/x}\sqrt{\frac{1}{n}+\frac{\bar x^2}{SS_x}}\qquad t=\frac{a-\alpha}{s_a}
$$

#### $\mu_{y/x}$

for given $x$:
$$
s_{\hat y}=s_{y/x}\sqrt{\frac{1}{n}+\frac{(x-\bar x)^2}{SS_x}}\qquad t=\frac{\hat y-\mu_{y/x}}{s_{\hat y}}
$$

#### $y$

for given $x$:
$$
s_{ y}=s_{y/x}\sqrt{1+\frac{1}{n}+\frac{(x-\bar x)^2}{SS_x}}\qquad t=\frac{\hat y-y}{s_{ y}}
$$

### Correlation Coefficient

$$
r=\frac{SP}{SSx\cdot SS_y}=\sqrt{\frac{U}{SS_y}}
$$

coefficient of determination
$$
r^2=\frac{U}{SS_y}
$$

### t Test for Correlation Coefficient

$$
s_r=\sqrt{\frac{1-r^2}{n-2}}\qquad t=\frac{r-\rho}{s_r}
$$
