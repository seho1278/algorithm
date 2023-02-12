N = int(input())
list_ = []
for n in range(N):
    S = list(input())
    list_.append(S)

result = []

for i in range(N):
    for j in range(i, N):
        for m in range(len(S)):
            for k in range(m,m+1):
                if list_[i][m] == list_[j][k]:
                    if j == 0:
                        result.append(list_[i][m])
                    else:
                        if result[m] == list_[i][m]:
                            result[m] = list_[i][m]
                else:
                    if j == 0:
                        result.append('?')
                    else:
                        result[m] = '?'

print(*result, sep = '')