# 系统生物学作业

<center>生信 2001 张子栋 2020317210101</center>

**5.1 等时间计时** 假设一个 SIM 由调节因子 X 调控，X 激活下游基因 $Z_i,~i=1,\ \dots,\ n,$ 其阈值分别为 $K_i$。在 $t=0$ 时刻，开始以一个固定的速率  $\beta$ 生成 X。设计阈值是的基因在相等的区间内一个接一个地被激活（利用逻辑输入函数）。

**解：**

在 $t=0$ 时刻，X 开始以固定速率 $\beta$ 生成，设 X 的降解/稀释作用速率为 $\alpha$，则 X 浓度随时间变化函数为：
$$
X(t)=\frac{\beta}{\alpha}\left(1-e^{-\alpha t}\right)
$$
设所需间隔时间为 $\Delta t$，则：

第一个下游基因 $Z_1$ 被激活的阈值为：
$$
K_1=X(\Delta t)=\frac{\beta}{\alpha}\left(1-e^{-\alpha \Delta t}\right)
$$
第二个下游基因 $Z_2$ 被激活的阈值为：
$$
K_2=X(2\Delta t)=\frac{\beta}{\alpha}\left(1-e^{-2\alpha \Delta t}\right)
$$
第 $i$ 个下游基因的激活阈值为：
$$
K_i=X(i\cdot\Delta t)=\frac{\beta}{\alpha}\left(1-e^{-\alpha i \Delta t}\right)\qquad i=1,2,\dots,n
$$
**5.6 双扇的动力学** 假设在一个双扇中，激活剂 $X_1$ 和 $X_2$ 调节基因 $Z_1$ 和 $Z_2$。$X_1$ 的输入信号 $S_{x1}$ 在 $t=0$ 时出现，在 $t=D$ 时小时。$X_2$ 的输入信号 $S_{x2}$ 在 $t=\frac{D}{2}$ 时出现，在 $t=2D$ 时消失。给定 $Z_1$ 和 $Z_2$ 的输入函数分别是逻辑 AND 和逻辑 OR，用图形表示 $Z_1$ 和 $Z_2$ 的启动子活性的动力学特征。

<img src="Week14作业.assets/双扇.svg" alt="双扇" style="zoom: 67%;" />

<img src="Week14作业.assets/sysbio.drawio.svg" alt="sysbio.drawio" style="zoom: 67%;" />

$Z_1$ 是逻辑 AND，随时间变化函数为：
$$
\begin{cases}
0&t<\frac{1}{2}D\\
\frac{\beta_1}{\alpha_1}\left(1-e^{-\alpha_1t}\right)&\frac{1}{2}D<t<D\\
\frac{\beta_1}{\alpha_1}e^{-\alpha_1t}&t>D
\end{cases}
$$
$Z_2$ 是逻辑 OR，随时间变化函数为：
$$
\begin{cases}
\frac{\beta_2}{\alpha_2}\left(1-e^{-\alpha_2t}\right)&t<2D\\
\frac{\beta_2}{\alpha_2}e^{-\alpha_2t}&t>2D
\end{cases}/
$$
