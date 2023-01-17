N = int(input())
num_list = []
for n in range(N):
    num = int(input())
    num_list.append(num)

num_list = sorted(num_list)

for m in num_list:
    print(m)