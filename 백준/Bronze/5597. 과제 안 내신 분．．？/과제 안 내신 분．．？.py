N_list = []
N2_list = []

for n in range(1, 29):
    N = int(input())
    N_list.append(N)

for i in range(1,31):
    if i not in N_list:
        N2_list.append(i)

N2_list = sorted(N2_list)

print(N2_list[0], N2_list[1], sep='\n')