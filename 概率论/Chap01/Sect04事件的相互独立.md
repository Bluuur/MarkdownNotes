# 第四节 事件的相互独立

# 两个事件相互独立

**定义**
若$P(AB)=P(A)P(B),$则称事件$A$与$B$相互独立

**性质**

- $A,B$独立$\Longleftrightarrow\overline{A},B$独立
- $A,B$独立$\Longleftrightarrow A,\overline{B}$独立
- $A,B$独立$\Longleftrightarrow\overline{A},\overline{B}$独立

**"独立"与"互不相容"的区别**

- 独立用于乘法
若A,B独立,则P(AB)=P(A)P(B);
- 互不相容用于加法
若A,B互不相容,则P(A+B)=P(A)+P(B)

互不相容一定不独立

![%E7%AC%AC%E5%9B%9B%E8%8A%82%20%E4%BA%8B%E4%BB%B6%E7%9A%84%E7%9B%B8%E4%BA%92%E7%8B%AC%E7%AB%8B%20d0134d30cb43474a9b7582919a353658/Untitled.png](%E7%AC%AC%E5%9B%9B%E8%8A%82%20%E4%BA%8B%E4%BB%B6%E7%9A%84%E7%9B%B8%E4%BA%92%E7%8B%AC%E7%AB%8B%20d0134d30cb43474a9b7582919a353658/Untitled.png)

## 推论:

- 若$\overline{A}$与$\overline{B}$相互独立,则$P(A\cup B)=1-P(\overline{A})P(\overline{B})$
- 若$\overline{A}_1,\overline{A}_2,\cdots,\overline{A}_n$相互独立,则$P(A_1\cup A_2\cup\cdots\cup A_n)=1-P(\overline{A}_1)P(\overline{A}_2)\cdots P(\overline{A}_n)$

# 多个事件相互独立

**两两独立**
对于事件$A,B,C,$若$P(AB)=P(A)P(B),P(BC)=P(B)P(C),P(AC)=P(A)P(C),$则称$A,B,C$两两独立

> 注:相互独立一定两两独立,但两两独立不一定相互独立

**例** 袋中四球，一球白色，一球黄色，一球红色，一球白、黄、红三种颜色。任取一球看颜色，事件$A＝｛有白色｝,B＝｛有黄色｝,C＝｛有红色｝，$求$𝑃(𝐴𝐵)、𝑃(𝐴𝐵𝐶).$

$$\begin{aligned}P(A)&=\frac{C_2^1}{C_4^1}=P(B)=P(C)\\P(AB)&=\frac{C_1^1}{C_4^1}=P(ABC)\frac{}{}\end{aligned}$$

**例** 甲系与乙系进行篮球、排球、足球比赛，篮球：甲胜乙的概率为$0.8$，排球：甲胜乙的概率为$0.4$，足球：甲胜乙的概率为$0.4$，若在$3$项比赛中至少胜$2$项才算胜，问哪一个系胜的概率大？

$$A=\{甲胜\},B=\{乙胜\}\\P(A)=C_3^20.4\times 0.4\times0.2+C_3^20.8\times 0.4\times0.6\times2+C_3^30.8\times0.4\times0.4 $$

# 二项概率公式

设某人独立射击$5$次，每次中的概率为 $\mathrm{P}(0<\mathrm{P}<1),$ 求
(1)只第1$, 2$枪中的概率;

$$\text { 设 } A_{i}=\{\text { 第i次中 }\}, P\left(A_{1} A_{2} \overline{A_{3}} \,\overline{A_{4}}\, \overline{A_{5}}\right)=P^{2}(1-P)^{3}
$$

(2)只$2$枪中的概率;

$$C_{5}^{3} P^{2}(1-P)^{3}
$$

(3)射击$n$次，中$k$枪的概率

$$C_{n}^{k} P^{k}(1-P)^{n-k}$$

## **伯努利概型试验**

1. 重复性:相同条件下可以重复进行
2. 独立性:试验之间没有影响
3. 明确性:每次试验只有两个可能结果

## 二项概率公式

$n$次重复独立试验, 若每次试验事件$A$出现的概率为$P(0<P<1),$则$n$次试驳中，事件$A$出现$k$次 $(0 \leq k \leq n)$ 的概率为

$$\large P_n(k)=C_{n}^{k} P^{k}(1-P)^{n-k}$$

**例4** 在一批次品率为0.2的产品中，进行重复抽样，共取5个样品，求次品数为3个的概率

$$解：P_5(3)=C_5^3\times 0.2^3\times(1-0.2)^{5-3}\approx0.0512$$

**例5** 某保险公司预计，每年因意外事故而死亡的客户占总数的0.005%，试计算一年内一万个客户中至少有4个需要理赔的概率

$$解：P_{10000}(k)=\sum_{k=4}^{10000} C_{10000}^k0.00005^k(1-0.00005)^{10000-k}$$

# Poisson公式

## Poisson公式

当 $n$ 很大、$P$很小、 $\lambda=n p$ 时, 二项概率公式

$$\large\mathrm{P}_{\lambda}(k)=\frac{\lambda^{k}}{k !} e^{-\lambda} \quad \mathrm{k}=0,1,2, \cdots$$

**例6** 某人进行射击，设每次射击的命中率0.02，独立射击400次，求至少击中两次的概率

解：用泊松分布

$$\begin{aligned}\lambda=np&=400\times0.02=8\\P(X=0)&\approx\frac{8^0}{0!}e^{-8}=e^{-8}\\P(X=1)&\approx\frac{8^1}{1!}e^{-8}=8e^{-8}\\P(X\geq2)&\approx1-e^{-8}-8e^{-8}\approx0.997\end{aligned}$$

## 结论

一次试验，小概率事件很难发生，但大量试验，小概率事件必然发生

**推断原理**：小概率事件在一次试验中几乎不可能发生，若在某种假设下发生了，则有理由华裔结合而正确性。

**例6** 若某人做某事的成功率为$1\%$，他重复努力$400$次，则至少成功一次的概率为？

解：成功次数服从二项概率$B(400,0.01)$

$$\begin{aligned}P\{X\geq1\}&=1-P\{X=0\}\\&=1-0.99^{400}\\&\approx0.9820\end{aligned}$$