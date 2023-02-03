T = int(input())

for t in range(T):
    N, M = map(int, input().split())
    fly = [list(map(int, input().split())) for _ in range(N)]

    result = []

    for i in range(N-M+1):
        for j in range(N-M+1):
            cnt = 0
            for k in range(j, j+M):
                for l in range(i, i+M):
                    cnt += fly[k][l]

            result.append(cnt)
    print(f'#{t+1} {max(result)}')
