matrix = []
result = -1
row = 0
col = 0
for _ in range(9):
    num = list(map(int, input().split()))
    matrix.append(num)

for i in range(9):
    for j in range(9):
        if matrix[i][j] > result:
            result = matrix[i][j]
            row = j + 1
            col = i + 1

print(result)
print(col, row)