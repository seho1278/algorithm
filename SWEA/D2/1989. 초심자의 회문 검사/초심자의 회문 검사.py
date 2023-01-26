T = int(input())
for t in range(T):
    S = input()
    if S[::] == S[::-1]:
        print(f'#{t+1} {1}')
    else:
        print(f'#{t+1} {0}')
