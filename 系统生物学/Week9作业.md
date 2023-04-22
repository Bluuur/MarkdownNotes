# 系统生物学作业

<center>生信 2001 张子栋 2020317210101</center>

​	  考虑三个激活剂的级联，$X \to Y \to Z$。蛋白质 $X$ 起初以非激活的形态存在于细胞内，$X$ 的输入信号 $S_x$ 在时刻 $t=0$ 时出现。结果使得 $X$ 迅速变为活化状态，并于 $Y$ 基因的启动子结合，使蛋白质 $Y$ 开始以速率 $\beta$ 产出。当 $Y$ 的浓度超过阈值 $K_y$ 时，基因 Z 开始转录。所有蛋白质的降解/稀释速率均为 $\alpha$。作为时间的函数，蛋白 $Z$ 的浓度是什么？相对于信号 $S_x$ 的加载时间，其响应时间是什么？如果三个级联的蛋白质是阻抑物，情况又会怎样？

**解：**

1. 蛋白 Y 浓度随时间变化函数：
   $$
   \frac{\mathrm{d}Y}{\mathrm{d}t}=\beta-\alpha Y\\
   \text{when } t=0\text{, } Y=0
   $$
   解得：
   $$
   \begin{aligned}
   Y(t)&=\frac{\beta}{\alpha}\left(1-e^{-\alpha t}\right)\\
   \end{aligned}
   $$
   其中 $Y_{\text{steady state}}=\large\frac{\beta}{\alpha}$ 为 Y 的稳态浓度。

   设 Y 的浓度达到基因 Z 转录阈值 $K_y$ 的时刻为 $t_y$。

   即：
   $$
   \begin{aligned}
   Y(t)&=\frac{\beta}{\alpha}\left(1-e^{-\alpha t_{y}}\right)\\
   &=K_y
   \end{aligned}
   $$
   解得：
   $$
   t_y=-\frac{1}{\alpha}\ln \left(1-\frac{\alpha K_y}{\beta} \right)
   $$
   设 Z 蛋白的产生速率为 $\gamma$，则有：
   $$
   \frac{\mathrm{d}Z}{\mathrm{d}t}=\gamma=\alpha Z\\
   \text{when } t=t_y \text{, } Z=0
   $$
   解得：
   $$
   Z(t)=\frac{\gamma}{\alpha}\left(1-e^{-\alpha t}\right)
   $$
   其中 $Z_{\text{steady state}}=\large\frac{\gamma}{\alpha}$ 为 Z 的稳态浓度。

   综上，蛋白 Z 浓度随时间变化函数为：
   $$
   Z(t)\begin{cases}
   0 &t<t_y\\
   \frac{\gamma}{\alpha}\left(1-e^{-\alpha t}\right) &t\ge t_y
   \end{cases}
   $$
   
2. 设蛋白 Z 浓度达到其稳态一半的时刻为 $t_{\frac{1}{2}ss}$，带入 $Z(t)$ 解得：
   $$
   t_{\frac{1}{2}ss}=\frac{\ln 2}{\alpha}
   $$
   故其响应时间为：
   $$
   \begin{aligned}
   T_{\frac{1}{2}}&=t_y+t_z\\
   &=\frac{1}{\alpha}\left(\ln 2-\ln\left(1-\frac{\alpha K_y}{\beta}\right)\right)\\
   &=\frac{1}{\alpha}\ln \left(\frac{2 \beta}{\beta-\alpha K_y}\right)
   \end{aligned}
   $$

3. 如果是阻抑物，仍满足以上函数。

   蛋白 Y 的浓度大于阈值后，有：
   $$
   \frac{\mathrm{d} Z(t)}{\mathrm{d} t}=-\alpha Z\\
   \text{when } t = 0 \text{, } Z = Z_{\text{steady state}}=\frac{\gamma}{\alpha}
   $$
   蛋白 Z 浓度关于时间函数为：
   $$
   Z(t)\begin{cases}
   \frac{\gamma}{\alpha} &t<t_y\\
   \frac{\gamma}{\alpha}\left(e^{-\alpha t}\right) &t\ge t_y
   \end{cases}
   $$
   同上：
   $$
   \begin{aligned}
   Z(t)&=\frac{\gamma}{\alpha} e^{-\alpha t}\\
   &=\frac{1}{2}\cdot\frac{\gamma}{\alpha}\\
   \text{therefore}\quad t_z&=\frac{\ln 2}{\alpha}
   \end{aligned}
   $$
   其响应时间为：
   $$
   \begin{aligned}
   T_{\frac{1}{2}}&=t_y+t_z\\
   &=\frac{1}{\alpha}\ln \left(\frac{2 \beta}{\beta-\alpha K_y}\right)
   \end{aligned}
   $$
   同 2. 。
   
   