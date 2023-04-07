N = int(input())

for i in range(N):
    result = []
    L = list(map(int, input().split()))
    for j in L:
        if j % 2 == 0:
            result.append(j)
    print(sum(result), min(result), sep=' ')