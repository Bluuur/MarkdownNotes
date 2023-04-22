# 系统生物学作业

<center>生信 2001 张子栋 2020317210101</center>

正自身调节对于响应时间有怎样的影响？用以下线性方程的模型：
$$
\frac{\mathrm{d}X}{\mathrm{d}t}=\beta + \beta_{1}X-\alpha X
$$
式中，$\beta_1 < \alpha$。解释其中的每一项，并求解响应时间。在什么时候这种设计是生物学上有用的？当 $\beta_1 > \alpha$ 时又会怎样？

**解：**

+ $\beta$ 是蛋白 X 在其他转录因子作用下的生成速率。
+ $\beta_1 X$ 是蛋白 X 受其自身激活作用下的生成速率，与 X 的浓度成正比。
+ $-\alpha X$ 是蛋白 X 的降解速率，与 X 的浓度成正比。

令：
$$
\frac{\mathrm{d}X}{\mathrm{d}t}=\beta+\beta_1 X-\alpha X =0
$$
解得稳态浓度：
$$
X_{\text{steady state}}=\frac{\beta}{\alpha - \beta_1}
$$
X 浓度随时间变化函数为：
$$
X(t)=\frac{\beta}{\alpha-\beta_1}\left(1-e^{(\beta_1-\alpha)t}\right)
$$
根据上式，解得响应时间：
$$
T_{\frac{1}{2}}=\frac{\ln 2}{\alpha -\beta_1}
$$
当 $\beta_1<\alpha$ 时，系统是稳定的。在这种情况下，正反馈对 X 的影响小于负反馈对 X 的影响。因此，当 X 偏离其平衡点时，负反馈会使 X 回到平衡点。这种设计在生物学上是有用的，因为它可以帮助生物体维持内部环境的稳定性。

当 $\beta_1>\alpha$ 时，系统是不稳定的。在这种情况下，正反馈对 X 的影响大于负反馈对 X 的影响。因此，当 X 偏离其平衡点时，正反馈会使 X 进一步偏离平衡点。