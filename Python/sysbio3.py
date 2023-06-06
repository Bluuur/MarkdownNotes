import numpy as np
from scipy.integrate import odeint

# initial conditions
ATP0 = 1.0  # mM
ADP0 = 0.1  # mM
Pi0 = 2.0  # mM
NADH0 = 0.01  # mM
H0 = 0.1  # mM
FADH20 = 0.005  # mM
O20 = 0.8  # mM
H2O0 = 50.0  # mM

# parameters
k1 = 200.0  # mM^-2 s^-1
k2 = 10.0  # s^-1
k3 = 0.1  # s^-1
k4 = 0.01  # s^-1
k5 = 2.0  # mM^-1 s^-1
k6 = 0.1  # mM^-1 s^-1
Km = 0.1  # mM


def atp_model(y, t):
    ATP, ADP, Pi, NADH, H, FADH2, O2, H2O = y
    dATPdt = k1 * ADP * Pi - k2 * ATP
    dADPdt = k2 * ATP - k1 * ADP * Pi
    dPidt = k1 * ADP * Pi - k2 * ATP
    dNADHdt = -k3 * NADH * H + k4 * FADH2 * H
    dFADH2dt = -dNADHdt
    dO2dt = -k6 * O2 * H2O / (Km + H2O)
    dH2Odt = -dO2dt
    dHdt = -k5 * NADH * H + k6 * O2 * H2O / (Km + H2O)

    return [dATPdt, dADPdt, dPidt, dNADHdt, dHdt, dFADH2dt, dO2dt, dH2Odt]


# time points
t = np.linspace(0, 40, 100)

# solve ODE
y0 = [ATP0, ADP0, Pi0, NADH0, H0, FADH20, O20, H2O0]
sol = odeint(atp_model, y0, t)

import matplotlib.pyplot as plt

ATP = sol[:, 0]
ADP = sol[:, 1]
Pi = sol[:, 2]
NADH = sol[:, 3]
H = sol[:, 4]

# plot results
plt.plot(t, ATP, 'r', label='ATP')
plt.legend(loc='best')
plt.xlabel('time')
plt.ylabel('concentration (mM)')
plt.show()
plt.plot(t, ADP, 'g', label='ADP')
plt.legend(loc='best')
plt.xlabel('time')
plt.ylabel('concentration (mM)')
plt.show()
plt.plot(t, Pi, 'b', label='Pi')
plt.legend(loc='best')
plt.xlabel('time')
plt.ylabel('concentration (mM)')
plt.show()
plt.plot(t, NADH, 'm', label='NADH')
plt.legend(loc='best')
plt.xlabel('time')
plt.ylabel('concentration (mM)')
plt.show()
plt.plot(t, H, 'c', label='H')
plt.legend(loc='best')
plt.xlabel('time')
plt.ylabel('concentration (mM)')
plt.show()
