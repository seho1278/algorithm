T = int(input())
result = 1
r_list = []
for t in range(1, T+2):
    r_list.append(result)
    result *= 2

print(*r_list)