def d(x):
    x_l = [int(a) for a in str(x)]
    return x_l

N = int(input())
result = 0
for n in range(1, N+1):
    if n < 10:
        result += 1
    elif 10 <= n and n < 100:
        result += 1
    elif 100 <= n and n < 1000:
        if d(n)[2] - d(n)[1] == d(n)[1] - d(n)[0]:
            result += 1

print(result)