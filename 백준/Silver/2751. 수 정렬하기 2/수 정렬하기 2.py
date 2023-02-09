import sys
N = int(sys.stdin.readline())
list_ = [int(sys.stdin.readline()) for n in range(N)]
list_ = sorted(list_)
print(*list_, sep='\n')