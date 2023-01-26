T = int(input())

for t in range(T):
    nums = list(map(int, input().split()))
    nums.remove(max(nums))
    nums.remove(min(nums))
    
    print(f'#{t+1} {round(sum(nums)/len(nums))}')