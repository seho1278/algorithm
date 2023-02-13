N = int(input())
nums = list(map(int, input().split()))

if 2 in nums:
    print(max(nums)*2)
else:
    if len(nums) == 1:
        print(max(nums)**2)
    else:
        print(max(nums)*min(nums))