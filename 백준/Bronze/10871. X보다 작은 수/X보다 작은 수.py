N, X = map(int, input().split())
A = list(map(int, input().split()))
result = []
for n in A:
    if n < X:
        result.append(n)

print(*result)