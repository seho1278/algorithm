N = int(input())
M = list(map(int, input().split()))
X = max(M)
r_list = []
result = 0

for n in M:
    result = n / X * 100
    r_list.append(result)
    

print(sum(r_list)/N)