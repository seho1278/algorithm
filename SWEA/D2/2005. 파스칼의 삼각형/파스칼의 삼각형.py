T = int(input())

for t in range(T):
    print(f'#{t+1}')
    N = int(input())
    result = []
    for i in range(0, N):
        result2 = []
        for j in range(0, i+1):
            if j == 0 or j == i:
                result2.append(1)
            else:
                result2.append(result[i-1][j-1] + result[i-1][j])
        result.append(result2)
    for i in result:
        print(*i)