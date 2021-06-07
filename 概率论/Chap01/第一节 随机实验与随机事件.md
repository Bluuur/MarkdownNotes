# 第一节 随机实验与随机事件

# 1.1 随机试验与随机事件

$$现实世界的客观现象\begin{cases}确定性现象\\非确定性现象\to 随机现象
\end{cases}$$

## 1.1.1 随机试验 $Random \,Experiments$

随机试验满足以下特征：

- 重复性	试验可以在相同的条件下重复地进行多次
- 明确性	实验前知道一切可能出现的试验结果
- 随机性	每次试验的具体结果不能预知

**注意：虽然一次实验的具体结果不能预支，但是在相同的条件下大量重复试验时，则会呈现出一定的数量规律性**

## 1.1.2 随机试验的样本空间

### 1.样本空间$(Sample\, Space)$

随机实验的所有可能结果组成的集合，记作$\Omega$

### 2.样本点$(Sample\,Point)$

样本空间的元素（及每次实验的可能结果）

注意：在进行随机试验时，关注满足某种条件的那些样本点所组成的集合（子集）

## 1.1.3 随机事件$(Random\, Events)$

在随机试验中可能出现的结果称为随机事件。
用大写字母$A，B，C$表示，简称为事件

- 随机事件是样本空间的某个子集
$A$：掷骰子掷出的点数为$1$	基本事件－集合元素－样本点
$B$：掷骰子掷出的点数小于$0$	不可能事件－空集
$C$：掷骰子掷出的点数小于$8$	必然事件－全集

## 1.1.4 随机事件的关系及运算

### 1.事件的包含与相等

若事件$A$出现必然导致$B$出现，则称$A$被$B$包含或$B$包含$A$，记作$A\subset B$或$B\supset A$，或称事件$A$为事件$B$的子事件

- $A$是$B$的子集$（subset）$；$B$是$A$的超集$（supset）$
- 显然，对任何事件$A$有$\Phi\subset A\subset \Omega$
- 若$A\sub B$且$B\sub A$，则称$A$与事件$B$相等，记作$A=B$

### 2.事件的并(和)

若事件$A$，$B$中至少有一个发生，即“$A$或$B$”是一个事件，被称为事件$A$与事件$B$的并事件或和事件，记作$A\cup B$或$A+B$
$A\cup B\to A+B\to A\ |\ B\ =\ true$

推广：$n$个事件$A_1,A_2,\cdots,A_n$中至少有一个发生的时间称为事件$A_1,A_2,\cdots,A_n$的并事件或和事件，记作$U_{i=1}^{n}=A_i$

### 3.事件的交(积)

事件$A，B$都发生，即发生“$A$且$B$”这一事件，称为A与B的交（或积）事件，记作$A\cap B$或$AB$

显然$AB\sub A,AB\sub B,$当$A\sub B$时$，AB=A$

$A\cap B\to AB\to A\ \&\ B\ =\ true$

推广：$n$个事件$A_1,A_2,\cdots,A_n$同时发生的时间称为事件$A_1,A_2,\cdots,A_n$的交事件或积事件，记作

### 4.互不相容事件

若事件$AB=\Phi,$则称事件$A$与$B$互不相容

### 5.对立事件

若事件$AB=\Phi$,且$A\cup B=\Omega,$则称事件A与B对立. 称事件$B$为$A$的逆事件,记作$\overline{A}$

显然$,\overline{A}=\Omega-A$

### 6.完备事件组

若$A_1,A_2,\cdots,A_n$两两互斥，且满足$\cup_{i=1}^{n}A_i=\Omega$则称$A_1,A_2,\cdots,A_n$为完备事件组

### 7.事件的差

事件$A$发生而同时事件$B$未发生的事件，称为事件$A$与事件$B$的差，记作$A－B$
$A-B\to A\overline{B}\to A\&(!B)=true$

$$A-B=A\overline{B}=A-AB$$

### 8.关系及运算的性质

- 包含的传递性
$A\subset B,B\subset C\to A\subset C$
- 交换律
$A\cup B=B\cup AB=BA$
- 结合律
$(AB)C=A(BC)$
- 分配律
$\begin{aligned}A\cup BC&=(A\cup B)(A\cup C)\\A\cup BC&=(A\cup B)(A\cup V)\end{aligned}$
- De-morgen 对偶律
$\overline{A\cup B}=\overline{A}\cap\overline{B},\overline{AB}=\overline{A}\cup\overline{B}$

例1：化简$(A\cup \overline{B})(\overline{A}\cup\overline{B})$

$$\begin{aligned}&=(A\cup \overline{B})\cap(\overline{A}\cup\overline{B})\\&=(A\cap \overline{A})\cup \overline{B}\\&=\Phi\cup \overline{B}\\&=\overline{B}\end{aligned}$$

## 1.1.5 事件的复合

设A，B，C为三事件；用A，B，C的运算关系表示下列各事件

- A与B都发生，C不发生

$$A_1=AB\overline{C}=AB-C=AB-ABC$$

- A发生，B与C不发生

$$A_2=A\overline{B}\,\overline{C}=A-B-C=A-(B\cup C)$$

- A，B，C都不发生

$$A_3=\overline{A}\,\overline{B}\,\overline{C}=\overline{A\cup B\cup C}$$

- A，B，C都发生

$$A_4=ABC$$

- A，B，C中只有一个发生

$$A_5=A\overline{B}\,\overline{C}+\overline{A}B\overline{C}+\overline{A}\,\overline{B}C$$

- A，B，C中至少有一个发生

$$A_6=A\cup B\cup C=\Omega-\overline{ABC}$$

- A，B，C中至少有两个发生

$$A_7=\overline{A}BC+A\overline{B}C+AB\overline{C}+ABC=AB\cup BC\cup CA$$

- A，B，C中不多于（至多）一个发生

$$A_8=\overline{A}\,\overline{B}\,\overline{C}+\overline{A}\,\overline{B}C+\overline{A}B\overline{C}+A\overline{B}\overline{C}=\overline{AB}\cup \overline{BC}\cup\overline{CA}\\=\overline{AB\cup BC\cup CA}$$