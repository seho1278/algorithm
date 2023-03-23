N, M = map(int, input().split())



minpackage = 1001
minpiece = 1001

for i in range(M):
    x, y = map(int, input().split())
    minpackage = min(minpackage, x)
    minpiece = min(minpiece, y)

result = 0

if minpackage > minpiece*6:
    result += N * minpiece
else:
    result += (N//6) * minpackage

    if (N%6)*minpiece > minpackage:
        result += minpackage
    else:
        result += (N%6)*minpiece

print(result)