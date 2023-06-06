# 导入数学和绘图模块
import numpy as np
import matplotlib.pyplot as plt

# 定义ODE系统中的变量和参数
x = 0.1  # x 的初始值
y = 0.1  # y 的初始值
z = 0.1  # z 的初始值
k1 = 0.2  # k1 的值
k2 = 0.1  # k2 的值
k3 = 0.3  # k3 的值
k4 = 0.2  # k4 的值
k5 = 0.4  # k5 的值
k6 = 0.3  # k6 的值


# 定义非线性函数f(x)
def f(x):
    return x ** 2 / (1 + x ** 2)


# 定义时间相关的变量
t = 0                   # t 的初始值
t_max = 10              # t 的最大值
dt = 0.01               # t 的步长
n = int(t_max / dt)     # t 的迭代次数

# 创建空列表来存储变量和时间的值
x_list = []
y_list = []
z_list = []
t_list = []

# 使用欧拉法迭代求解ODE系统
for i in range(n):
    # 将当前变量和时间的值添加到列表中
    x_list.append(x)
    y_list.append(y)
    z_list.append(z)
    t_list.append(t)
    # 计算下一个变量和时间的值
    x_next = x + dt * (k1 - k2 * x)
    y_next = y + dt * (k3 * f(x) - k4 * y)
    z_next = z + dt * (k5 * y - k6 * z)
    t_next = t + dt
    # 更新变量和时间的值
    x = x_next
    y = y_next
    z = z_next
    t = t_next

# 将列表转化为数组方便绘图
x_array = np.array(x_list)
y_array = np.array(y_list)
z_array = np.array(z_list)
t_array = np.array(t_list)

# 绘制各个变量随时间变化的曲线图
plt.plot(t_array, x_array, label='x')
plt.plot(t_array, y_array, label='y')
plt.plot(t_array, z_array, label='z')
plt.xlabel('t')
plt.ylabel('Concentration')
plt.legend()
plt.show()
