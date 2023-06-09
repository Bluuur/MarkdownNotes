import numpy as np
from scipy.integrate import odeint
import matplotlib.pyplot as plt

# initial conditions
ATP0 = 2.0  # mM
ADP0 = 0.5  # mM
Pi0 = 1.0  # mM
NADH0 = 0.01  # mM
H0 = 0.001  # mM
FADH2 = 0.01  # mM
O2 = 0.01  # mM
H2O = 1.0  # mM

# parameters
k1 = 200.0  # mM^-2 s^-1
k2 = 10.0  # s^-1
k3 = 0.1  # s^-1
k4 = 0.01  # s^-1
k5 = 2.0  # mM^-1 s^-1
k6 = 0.1  # mM^-1 s^-1
Km = 0.1  # mM


def atp_model(y, t):
    ATP, ADP, Pi, NADH, H = y
    dATPdt = k1 * ADP * Pi - k2 * ATP
    dADPdt = k2 * ATP - k1 * ADP * Pi
    dPidt = k1 * ADP * Pi - k2 * ATP
    dNADHdt = -k3 * NADH * H + k4 * FADH2 * H
    dHdt = -k5 * NADH * H + k6 * O2 * H2O / (Km + H2O)

    return [dATPdt, dADPdt, dPidt, dNADHdt, dHdt]


# time points
t = np.linspace(0, 0.02, 100)

# solve ODE
y0 = [ATP0, ADP0, Pi0, NADH0, H0]
sol = odeint(atp_model, y0, t)

# plot results
plt.plot(t, sol[:, 0], 'b', label='ATP')
plt.plot(t, sol[:, 1], 'g', label='ADP')
plt.plot(t, sol[:, 2], 'r', label='Pi')
plt.plot(t, sol[:, 3], 'c', label='NADH')
plt.plot(t, sol[:, 4], 'm', label='H')
plt.legend(loc='best')
plt.xlabel('Time')
plt.ylabel('Concentration (mM)')
plt.show()