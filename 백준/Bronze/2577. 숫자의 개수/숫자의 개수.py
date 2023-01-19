A = int(input())
B = int(input())
C = int(input())
mul = A*B*C
result = {}

for i in range(10):
    result[i] = 0

for n in result.keys():
    for s in str(mul):
        if int(s) == n:
            result[n] += 1

print(*result.values(), sep='\n')