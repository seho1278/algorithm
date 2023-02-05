M = int(input())
N = int(input())
list_ = []

for i in range(M, N+1):
    for j in range(2, i):
        if i % j == 0:
            break
    else:
        if i == 1:
            pass
        else:
            list_.append(i)

if list_:
    print(sum(list_), min(list_), sep='\n')
else:
    print(-1)