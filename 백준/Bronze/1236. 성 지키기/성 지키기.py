N, M = map(int, input().split())

matrix = []
for n in range(N):
    x = input()
    matrix.append(x)

row = 0
for i in range(N):
    for j in range(M):
        if matrix[i][j] == 'X':
            break
    else:
        row += 1

col = 0
for k in range(M):
    for l in range(N):
        if matrix[l][k] == 'X':
            break
    else:
        col += 1

if row >= col:
    print(row)
else:
    print(col)