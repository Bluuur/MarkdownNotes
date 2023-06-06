# 导入所需的模块
import numpy as np
import scipy.optimize as opt
import scipy.integrate as ode
import matplotlib.pyplot as plt


# 定义米氏方程
def michaelis_menten(S, Vmax, Km):
    return Vmax * S / (Km + S)


# 定义底物浓度的微分方程
def substrate_concentration(t, S, E0, k1, k2):
    return -k1 * E0 * S + k2 * (E0 - S)


# 定义一些已知的参数
E0 = 1  # 酶的初始浓度，单位为mol/L
k1 = 0.1  # 反应速率常数，单位为L/(mol*s)
k2 = 0.05  # 反应速率常数，单位为1/s
t_max = 100  # 反应时间，单位为s

# 生成一些模拟数据，假设Vmax = 0.5 mol/(L*s)，Km = 0.2 mol/L，S0 = 1 mol/L
Vmax_true = 0.5
Km_true = 0.2
S0 = 1
t_data = np.linspace(0, t_max, 21)  # 时间点，单位为s
S_data = ode.solve_ivp(substrate_concentration, [0, t_max], [S0], args=(E0, k1, k2), t_eval=t_data).y[
    0]  # 底物浓度，单位为mol/L
v_data = michaelis_menten(S_data, Vmax_true, Km_true)  # 反应速率，单位为mol/(L*s)
v_data += np.random.normal(0, 0.01, len(v_data))  # 加入一些噪声

# 使用非线性最小二乘法来估计Vmax和Km的值
popt, pcov = opt.curve_fit(michaelis_menten, S_data, v_data)
Vmax_est = popt[0]
Km_est = popt[1]
print(f"Estimated Vmax: {Vmax_est:.3f} mol/(L*s)")
print(f"Estimated Km: {Km_est:.3f} mol/L")

# 使用欧拉法来求解底物浓度的微分方程
dt = 0.01  # 时间步长，单位为s
t_euler = np.arange(0, t_max + dt, dt)  # 时间点，单位为s
S_euler = np.zeros(len(t_euler))  # 底物浓度，单位为mol/L
S_euler[0] = S0  # 初始条件
for i in range(1, len(t_euler)):
    S_euler[i] = S_euler[i - 1] + substrate_concentration(t_euler[i - 1], S_euler[i - 1], E0, k1, k2) * dt  # 欧拉法更新

# 绘制图形
plt.figure(figsize=(10, 5))
plt.subplot(121)
plt.scatter(S_data, v_data, label="Data")
plt.plot(S_data, michaelis_menten(S_data, Vmax_true, Km_true), label="True")
plt.plot(S_data, michaelis_menten(S_data, Vmax_est, Km_est), label="Estimated")
plt.xlabel("Substrate concentration (mol/L)")
plt.ylabel("Reaction rate (mol/(L*s))")
plt.legend()
plt.subplot(122)
plt.plot(t_euler, S_euler, label="Euler")
plt.scatter(t_data, S_data, label="Data")
plt.xlabel("Time (s)")
plt.ylabel("Substrate concentration (mol/L)")
plt.legend()
plt.show()
