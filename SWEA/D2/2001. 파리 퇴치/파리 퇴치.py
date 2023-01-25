T = int(input())

for t in range(T):
    N, M = map(int, input().split())
    M_list = []
    N_list = []

    for n in range(N):
        numbers = list(map(int, input().split()))
        N_list.append(numbers)

    for k in range(N-M+1):
        for l in range(N-M+1):
            R_list = []
            for i in range(M):
                for j in range(M):
                    R_list.append(N_list[k + i][l + j])
            M_list.append(sum(R_list))

    print(f'#{t+1} {max(M_list)}')