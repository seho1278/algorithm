result = 0
r_list = []
for n in range(9):
    N = int(input())
    r_list.append(N)

for m in r_list:
    result += 1
    if m == max(r_list):
        print(m, result, sep="\n")