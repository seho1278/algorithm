import sys

N = int(sys.stdin.readline())
M = list(map(int, sys.stdin.readline().split()))
print(min(M), max(M), sep=' ')