def rev(x):
    x1 = x[::-1]
    return x1

X, Y = input().split()

print(int(rev(str(int(rev(X)) + int(rev(Y))))))