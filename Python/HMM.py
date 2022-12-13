# @time 2022/12/8 1:45
# @author
# @fileName HMM.py
# @IDE PyCharm
from datetime import datetime

pi = [0.4, 0.4, 0.2]

matrixB = [
    [0.97, 0.03],
    [0.03, 0.97],
    [0.50, 0.50]
]

matrixA = [
    [0.98, 0.01, 0.01],
    [0.01, 0.98, 0.01],
    [0.01, 0.01, 0.98]
]

observed = [
    1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0,
    0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0,
    0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1,
    0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1,
    1, 1, 1, 0, 1, 1, 1, 1, 1
]

prob = [[0 for _ in range(3)] for _ in range(109)]

for i in range(109):
    for j in range(3):
        if i == 0:
            prob[i][j] = pi[j] * matrixB[j][observed[i]]
        else:
            for k in range(3):
                prob[i][j] += prob[i - 1][k] * matrixB[j][observed[i]] * matrixA[k][j]

arrayS = [0 for _ in range(109)]

for i in range(109):
    myMax = 0
    flag = 0
    for j in range(3):
        if prob[i][j] >= myMax:
            myMax = prob[i][j]
            flag = j
    arrayS[i] = flag

time2 = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
print("System time: ", time2)

for i in range(109):
    print(arrayS[i], end="")
