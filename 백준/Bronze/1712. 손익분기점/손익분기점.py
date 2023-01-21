import sys

A, B, C = map(int, sys.stdin.readline().split())

if B >= C:
    print(-1)

else:
    N = int((A / (C - B)) + 1)
    print(N)