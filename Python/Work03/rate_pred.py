# @time 2022/12/11 20:45
# @author Zidong Zh 生信 2001 张子栋
# @fileName rate_pred.py
# @IDE PyCharm
import os
import re

from time import sleep
from urllib.parse import urlencode
from urllib.request import urlopen

path_prefix = os.getcwd()

seq_file = open(path_prefix + '.\\ProSeq.fa')
origin_data = seq_file.readlines()

# sequence dict, id as key, seq as value
sequence = {}
seq_id = ''

for line in origin_data:
    if line[0] == '>':
        # read id
        seq_id = ''
        for char in line[1:]:
            if not char == ' ':
                seq_id += char
            else:
                break
    elif not line[0] == '\n':
        # read sequence
        sequence[seq_id] = ''
        sequence[seq_id] += line.strip('\n')












pro_folding_rate_file = open(path_prefix + '.\\ProFoldingRate.txt', 'w')
# format header for better display
header = "%10s\t%6s\n" % ("ID", "Rate")
print(header, end='')
pro_folding_rate_file.write(header)

for key in sequence:
    value = sequence[key]

    url = "http://ibi.hzau.edu.cn/FDserver/cido.php"
    inputs = {'textarea': value, 'radiobutton': 'Two', 'ButtonRatePred': 'Predict Folding Rate',
              'Folding Type': 'Unknown'}
    params = bytes(urlencode(inputs), encoding='utf-8')
    context = urlopen(url, params)

    result = context.read().decode()
    # find time cost with regex
    rate = re.findall(r"= (.+?)/", result)[0]

    # print("-------------------------------------")
    # print('Protein ID:' + key + '\n Result:')
    # print(result)

    line = str(key + '\t' + rate + '\n')
    pro_folding_rate_file.write(line)
    print(line, end='')
    sleep(1)

pro_folding_rate_file.close()
