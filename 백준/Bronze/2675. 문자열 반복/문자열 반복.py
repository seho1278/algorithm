T = int(input())
for t in range(T):
    A, B = input().split()
    A = int(A)
    result = [a*A for a in B]
    print(*result, sep='')