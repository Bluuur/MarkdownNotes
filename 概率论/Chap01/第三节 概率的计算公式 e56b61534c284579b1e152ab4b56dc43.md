# 第三节 概率的计算公式

# 加法公式

### 加法公式

若$\mathrm{A}_{1}, \mathrm{A}_{2}, \cdots, \mathrm{A}_{\mathrm{n}}$两两互斥, 则$\mathrm{P}\left(\sum{i=1}^{n} A_{i}\right)=\sum_{\mathrm{i}=1}^{\mathrm{n}} P\left(A_{\mathrm{i}}\right)$

- 推论1若$A$为任一事件, 则 $P(\bar{A})=1-P(A)$ .
- 推论2 若$A$$,B$ 为任意两事件, 则
$P(A)=P(A B)+P(A \bar{B}) ; P(B)=P(A B)+P(\bar{A} B)$
- 推论3 若$\mathrm{A} \subset \mathrm{B},$则
$P(B-A)=P(B)-P(A) ; P(A) \leq P(B)$
- 推论4 设$A,B$为任意两个事件, 则
$\begin{array}{l}
P(A \cup B)=P(A)+P(B)-P(A B) \\
\because A \cup B=A+(B-A B), \text { 而 } A B \subset B \\
\therefore P(A \cup B)=P(A)+P(B-A B)=P(A)+P(B)-P(A B) \\
\Rightarrow P(A \cup B) \leq P(A)+P(B)
\end{array}$
推论4还可以推广至多个事件

**例1** 设 $P(A)=p, P(B)=q, P(A \cup B)=r,$求$(1)P(A B), (2) P(\bar{A} B)$

$$\begin{aligned}(1)P(A\cup B)&=P(A)+P(B)-P(AB)\\P(AB)&=P(A)+P(B)-P(A\cup B)\\(2)P(A\overline B)&=P(A\cup B)-P(A)\end{aligned}$$

**例2** 设 $P(A)=0.3, P(B)=0.5,$ 根据下列事件, 求 $P(A \cup B), P(\bar{A} B)$
(1)$A, B$不相容
(2) $A \subset B$

# 条件概率

### 条件概率与乘法公式

谈及事件概率时总是在一定条件下讨论

**引例** 从1至10这10个数中任取一数$($大前提$)$, 求$A=\{取
到的数比3大\}$的概率? 
若已知已取到的数是偶数$($小前提$),$ 即$B =\{取到的数是偶数 \}$已发生, 求$A$的概率?

### 条件概率

事件B出现的条件下，事件A出现的概率记为

$$\mathrm{P}(\mathrm{A} \mid \mathrm{B}).
P(A \mid B)=\frac{P(A B)}{P(B)}, P(B)>0$$

![%E7%AC%AC%E4%B8%89%E8%8A%82%20%E6%A6%82%E7%8E%87%E7%9A%84%E8%AE%A1%E7%AE%97%E5%85%AC%E5%BC%8F%20e56b61534c284579b1e152ab4b56dc43/Untitled.png](%E7%AC%AC%E4%B8%89%E8%8A%82%20%E6%A6%82%E7%8E%87%E7%9A%84%E8%AE%A1%E7%AE%97%E5%85%AC%E5%BC%8F%20e56b61534c284579b1e152ab4b56dc43/Untitled.png)

**例3** 设某种动物由出生算起活$20$岁以上的概率为$0.8$,活$25$岁以上的概率为$0.4$，若现有一个$20$岁的这种动物，求它能够活$25$岁以上的概率。

$$A=\{活20岁以上\}，B=\{活25岁以上\}\\B\supset A\\P(B|A)=\frac{P(AB)}{P(A)}=0.4$$

## 乘法公式

$$\begin{aligned}
&\mathrm{A}, \mathrm{B} \text { 为任意两事件, } \mathrm{P}(\mathrm{A})>0, \mathrm{P}(\mathrm{B})>0 \text { 则 }\\
&P(A B)=P(A) P(B \mid A) ; \quad P(A B)=P(B) P(A \mid B)\\

\end{aligned}$$

乘法公式可以推广，如$\mathrm{P}(\mathrm{ABC})=\mathrm{P}(\mathrm{A}) \mathrm{P}(\mathrm{B} \mid \mathrm{A}) \mathrm{P}(\mathrm{C} \mid \mathrm{AB})$

**例4** 一批产品共$100$件, 次品率为$10\%$,从中任取$3$件，每次取$1$件。求如下事件的概率
$1.$第二次才取到正品的概率;$2.$在第三次才取到正品的概率。

**解** 设$\mathrm{A}_{\mathrm{i}}=\{第i次取出正品\} \qquad i=1,2,3$$*\begin{array}{l}
P\left(\overline{A_{1}} A_{2}\right)=P\left(\overline{A_{1}}\right) P\left(A_{2} \mid \overline{A_{1}}\right)=\frac{10}{100} \times \frac{90}{99}=\frac{1}{11} ; \\\\
P\left(\overline{A_{1}} \,\overline{A_{2}} A_{3}\right)=P\left(\overline{A_{1}}\right) P\left(\overline{A_{2}} \mid \overline{A_{1}}\right) P\left(A_{3} \mid \overline{A_{1}} \,\overline{A_{2}}\right)=\frac{10}{100} \times \frac{9}{99} \times \frac{90}{98}
\end{array}*$

# 全概率公式

如果随机试验的基本空间$\Omega=\left\{\mathrm{A}{1}, \mathrm{~A}{2}, \cdots, \mathrm{A}{\mathrm{n}}\right\}$$*,*$且$\Omega=\mathrm{A}{1}+\mathrm{A}{2}+\cdots+\mathrm{A}{\mathrm{n}},$事件$B \subset \Omega_{1}$

$$\begin{aligned}
B=B \Omega &=B\left(\mathrm{~A}{1}+\mathrm{A}{2}+\cdots+\mathrm{A}{\mathrm{n}}\right) \\
&=B \mathrm{~A}{1}+\mathrm{BA}{2}+\cdots+\mathrm{BA}{\mathrm{n}} \\
\therefore \mathrm{P}(B) &=P\left(B \mathrm{~A}{1}\right)+P\left(B \mathrm{~A}{2}\right)+\cdots+P\left(B \mathrm{~A}{n}\right) \\
&=P\left(\mathrm{~A}{1}\right) P\left(B \mid \mathrm{A}{1}\right)+\cdots+P\left(\mathrm{~A}{n}\right) P\left(B \mid \mathrm{A}{n}\right) \\
&=\sum{i=1}^{n} P\left(\mathrm{~A}{i}\right) P\left(B \mid A{i}\right)
\end{aligned}$$

**例5** 设某厂用甲、乙、丙三种机器生产相同的零件，它们的产量各占总产量的$25\%, 35\%, 40\%$。而在各自产品中次品 率分别为$5\%, 4\%, 2\%$。求从中任取一件恰好是次品的概率。

**解** $设B=\{取出次品 \}, \mathrm{A}{1}=\{ 甲生产 \}, \mathrm{A}{2}=\{ 乙生产 \},\mathrm{A}{3}=\{丙生产 \} \\\mathrm{A}{1}, \mathrm{~A}{2}, \mathrm{A}{3} 为一完备事件组.$

$$\begin{aligned}
\mathrm{P}\left(\mathrm{A}{1}\right)&=0.25\\\mathrm{P}\left(\mathrm{A}{2}\right)&=0.35 \\ \mathrm{P}\left(\mathrm{A}{3}\right)&=0.40 \\
\mathrm{P}\left(B \mid \mathrm{A}{1}\right)&=0.05\\\mathrm{P}\left(B \mid \mathrm{A}{2}\right)&=0.04\\\mathrm{P}\left(B \mid \mathrm{A}{3}\right)&=0.02 \\
\mathrm{P}(B)&=\mathrm{P}\left(\mathrm{A}{1}\right) \mathrm{P}\left(B \mid A{1}\right)+\mathrm{P}\left(\mathrm{A}{2}\right) \mathrm{P}\left(B \mid A{2}\right)+\mathrm{P}\left(\mathrm{A}{3}\right) \mathrm{P}\left(B \mid \mathrm{A}{3}\right)\\&=0.0345
\end{aligned}
$$

**例6** $6$个乒乓球，$4$个新球。第一次比赛时从中任取$2$个，用后放回，第二次比赛时从中任取$2$个。求第二次取得两个新球的概率。

# Bayes公式

贝叶斯公式

$$\begin{array}{l}
\mathrm{P}\left(A_{j} \mid B\right)=\frac{P\left(A_{j}\right) P\left(B \mid A_{j}\right)}{P(B)},(\mathrm{j}=1,2, \cdots, \mathrm{n}) \\\small
\text { 其中 } P(B)=\sum_{i=1}^{n} P\left(A_{i}\right)P\left(B \mid A_{i}\right)
\end{array}$$

$称为后验概率\\P\left(A_{j}\right) 称为先验概率。$

**例7** 某一地区患有甲型$H1N1$流感的人占$0.0004,$患者对一种试验反应是阳性的概率为$0.99,$ 正常人对这种试验反应是阳性的概率为$0.001,$现抽查了一个人，试验反应是阳性，问此人是甲型$H1N1$流感患者的概率有多大?

**解** 设 $A=\{ 阳性 \}, \quad B=\{ 患病\}\\
\begin{array}{ll}
P(B)=0.0004 & P(\bar{B})=0.9996 \\
P(A \mid B)=0.99 & P(A \mid \bar{B})=0.001
\end{array}$
由贝叶斯公式得$P(B \mid A)=0.284$

现在来分析一下结果的意义.
1.这种试验对于诊断一个人是否患有甲型$H1N1$流感有无意义?
2. 检出阳性是否一定忘有甲型$H1N1$流感?

1.这种试验对于诊断一个人是否患有流感有意义.
如果不做试验,抽查一人,他是患者的概率: $P(B)=0.004$
若试验后得阳性反应, 则根据试验得来的信息，此人是患者的概率为$P(B \mid A)=0.284$
从$0.004$增加到$0.284,$将近增加约$71$倍.

即使你检出阳性，此时下结论还为时过早。
试驳结果为阳性，此人确患病的概率为$P(B \mid A)=0.284$

**例7续** 假设进行复查，若化验结果仍呈阳性，患病的概率有多大?
代入数据计算得 $P(B \mid A)=0.997$