T = int(input())

for t in range(T):
    N = list(range(1, int(input()) + 1))
    result = 0
    for n in N:
        if n % 2 == 1:
            result += n
        else:
            result -= n
    print(f'#{t+1} {result}')