T = int(input())
result = 0
r_list = [1]
for t in range(1, T+1):
    result += 1
    r_list.append(2**result)
    
print(*r_list)