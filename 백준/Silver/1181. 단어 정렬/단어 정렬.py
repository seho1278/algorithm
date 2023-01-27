import sys
N = int(sys.stdin.readline())

s_list = []
for n in range(N):
    s_list.append(input())

s_list = set(s_list)    
s_list = sorted(s_list)
s_list = sorted(s_list, key=lambda x: len(x))

print(*s_list, sep='\n')