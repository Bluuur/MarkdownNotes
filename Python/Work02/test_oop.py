# @time 2022/12/7 21:52
# @author Zidong Zh 2020317210101
# @fileName test_oop.py
# @IDE PyCharm

# define relative atom mass as const
C_WEIGHT = 12.01
H_WEIGHT = 1.008
O_WEIGHT = 16.00
N_WEIGHT = 14.01
S_WEIGHT = 32.07


class Molecule:

    # constructor
    def __init__(self):
        self.elements = []
        self.weight = None

    # relative molecular mass
    def show_weight(self):
        print("Weight: ", self.weight)

    # print molecule elements
    def show_element(self):
        print("elements: ", self.elements)


class AminoAcid(Molecule):

    # constructor
    def __init__(self):
        super().__init__()
        self.weight = 0
        self.composition = {'C': 0, 'H': 0, 'O': 0, 'N': 0, 'S': 0}

    # calculate a.a. relative molecular mass
    def calc_mw(self):
        self.weight += self.composition["C"] * C_WEIGHT
        self.weight += self.composition["H"] * H_WEIGHT
        self.weight += self.composition["O"] * O_WEIGHT
        self.weight += self.composition["N"] * N_WEIGHT
        self.weight += self.composition["S"] * S_WEIGHT

    # calculate & print a.a. relative molecular mass
    # override parent method
    def show_weight(self):
        self.calc_mw()
        super().show_weight()

    def show_element(self):

        for compos in self.composition:
            if self.composition[compos] != 0:
                self.elements.append(compos)

        print("elements: ", self.elements)


# 个人认为以下三层继承是多余的，实际写代码可以直接创建 AminoAcid 类型的三种氨基酸对象
# 以及每种氨基酸类中的 show_composition 方法可以写入 AminoAcid 类中

# Leucine $C_6H_{13}NO_2$
class Leucine(AminoAcid):
    # constructor
    def __init__(self):
        super().__init__()
        self.composition = {'C': 6, 'H': 13, 'O': 2, 'N': 1, 'S': 0}

    # print Leucine composition
    def show_composition(self):
        print("composition: ", self.composition)

    def is_isoform(self, another):
        if (self.composition == another.composition) and (self is not another):
            return True
        else:
            return False


# Isoleucine $C_6H_{13}NO_2$
class Isolecucine(AminoAcid):
    def __init__(self):
        super().__init__()
        self.composition = {'C': 6, 'H': 13, 'O': 2, 'N': 1, 'S': 0}

    def show_composition(self):
        print("composition ", self.composition)


# Cysteine $C_3H_7NO_2S$
class Cysteine(AminoAcid):
    def __init__(self):
        super().__init__()
        self.composition = {'C': 3, 'H': 7, 'O': 2, 'N': 1, 'S': 1}

    def show_composition(self):
        print("composition ", self.composition)


if __name__ == '__main__':
    # test code
    # construct objects
    leu = Leucine()
    iso = Isolecucine()
    cys = Cysteine()

    # methods from leu
    print("Methods from leu: ")
    leu.show_weight()
    leu.show_element()
    leu.show_composition()

    print("--------------------")

    # methods from iso
    print("Methods from iso: ")
    iso.show_weight()
    iso.show_element()
    iso.show_composition()

    print("--------------------")

    # methods from cys
    print("Methods from cys: ")
    cys.show_weight()
    cys.show_element()
    cys.show_composition()

    print("--------------------")

    # test is_isoform method
    print("result from leu.is_isoform(iso): ", leu.is_isoform(iso))
    print("result from leu.is_isoform(cys): ", leu.is_isoform(cys))
