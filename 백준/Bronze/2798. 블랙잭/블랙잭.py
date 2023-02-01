import sys

N, M = map(int, sys.stdin.readline().split())
nums = list(map(int, sys.stdin.readline().split()))

result = 0
r_list = []
for i in range(N):
    for j in range(i+1, N):
        for l in range(j+1, N):
            result = nums[i] + nums[j] + nums[l]
            if result <= M:
                r_list.append(result)

print(max(r_list))