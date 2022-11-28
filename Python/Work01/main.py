# @time     2022/11/28 16:06
# @author   Zidong Zh
# @fileName main.py
# @IDE      PyCharm
# @GitHub   https://github.com/Bluuur/MarkdownNotes/blob/main/Python/Work01/main.py
from os import mkdir
from os.path import exists

sequence = "MNAPERQPQPDGGDAPGHEPGGSPQDELDFSILFDYEYLNPNEEEPNAHKVASPPSGPAYPDDVLDYGLKPYSPLASLSGEPPGRFGEPDRVGPQKFLSAAKPAGASGLSPRIEITPSHELIQAVGPLRMRDAGLLVEQPPLAGVAASPRFTLPVPGFEGYREPLCLSPASSGSSASFISDTFSPYTSPCVSPNNGGPDDLCPQFQNIPAHYSPRTSPIMSPRTSLAEDSCLGRHSPVPRPASRSSSPGAKRRHSCAEALVALPPGASPQRSRSPSPQPSSHVAPQDHGSPAGYPPVAGSAVIMDALNSLATDSPCGIPPKMWKTSP"

# define file path
file_path = "D:\\test\\frq.txt"

# make dir when dir dose not exists
if not exists("D:\\test"):
    mkdir("D:\\test")

# init file obj
output_file = open(file_path, "w")

# init frequency dictionary
frq_dict = {}

# if char in sequence, frq + 1
# if char not in sequence, creat a key = char, value = 1
for char in sequence:
    if char in frq_dict:
        frq_dict[char] += 1
    else:
        frq_dict[char] = 1

# print(frq_dict)

# write file
# write amino acid
for key in frq_dict:
    output_file.write(key + "\t")

output_file.write("\n")

# write count
for key in frq_dict:
    output_file.write(str(frq_dict[key]) + "\t")

output_file.write("\n")

# write frequency
for key in frq_dict:
    # round frequency for better display
    output_file.write(str(round(frq_dict[key] / len(sequence), 3)) + "\t")

output_file.close()