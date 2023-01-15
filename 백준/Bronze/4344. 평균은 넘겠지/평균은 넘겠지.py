C = int(input())

for i in range(C):
    N = list(map(int, input().split()))
    average = (sum(N) - N[0]) / N[0]
    r_list = []
    for n in N[1::]:
        if n > average:
            r_list.append(n)

    print(f'{"%.3f" % ((len(r_list)*100) / N[0])}%')