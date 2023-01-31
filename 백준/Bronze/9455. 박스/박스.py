T = int(input())


for t in range(T):
    m, n = map(int, input().split())
    box = [list(map(int, input().split())) for _ in range(m)]
    cnt = 0
    for i in range(n):
        for j in range(m):
            if box[j][i] == 1:
                for k in range(j, m):
                    if box[k][i] == 0:
                        cnt += 1
    print(cnt)