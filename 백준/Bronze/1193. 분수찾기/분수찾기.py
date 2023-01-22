X = int(input())
result = 1
n = 1
while True:
    if result <= X and X < result + n:
        t = X - result
        if n % 2 == 0:
            print("%d/%d" %(t + 1, n - t))
        else:
            print("%d/%d" %(n - t, t + 1))
        break
    else:
        result += n
        n += 1