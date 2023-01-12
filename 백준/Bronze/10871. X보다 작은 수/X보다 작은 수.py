X, N = map(int, input().split())
A = list(map(int, input().split()))
N_list = []

for n in A:
    if n < N:
        N_list.append(n)
print(*N_list)