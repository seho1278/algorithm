a, b = map(int, input().split())
a -= 1
b -= 1
x = divmod(a, 4)
y = divmod(b, 4)

row = abs(y[0] - x[0])
col = abs(y[1] - x[1])

print(row + col)