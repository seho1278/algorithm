N, K = map(int, input().split())
A = list(map(int, input().split(',')))

if K == 0:
    print(*A, sep=',')

else:
    for k in range(K):
        B = []

        for i in range(N-1):
            B.append(A[i+1]-A[i])

        N -= 1
        A = B

    print(*B, sep=',')