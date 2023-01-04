H, M = map(int, input().split())
a = M - 45
b = 60 + a
if a < 0:
    if H > 0:
        H -= 1
        print(H, b)
    else:
        print(23, b)
else:
    print(H, a)