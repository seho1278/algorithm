N = int(input())

nums = []
for i in range(1000*N):
    if '666' in str(i):
        nums.append(i)
print(nums[N-1])