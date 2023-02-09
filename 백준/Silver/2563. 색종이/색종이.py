N = int(input())
matrix = [[0] * 100 for _ in range(100)]
cnt = 0
for n in range(N):
    X, Y = map(int, input().split())

    for i in range(X, X+10):
        for j in range(Y, Y+10):
            if matrix[i][j] == 0:
                matrix[i][j] = 1
                cnt += 1
            
print(cnt)