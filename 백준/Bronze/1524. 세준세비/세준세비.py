from collections import deque

T = int(input())

for t in range(T):
    input()
    X = map(int, input().split())
    S = deque(sorted(list(map(int, input().split()))))
    B = deque(sorted(list(map(int, input().split()))))

    while S and B:
        if S[0] >= B[0]:
            B.popleft()
        else:
            S.popleft()

    if S:
        print('S')
    elif B:
        print('B')
    else:
        print('C')