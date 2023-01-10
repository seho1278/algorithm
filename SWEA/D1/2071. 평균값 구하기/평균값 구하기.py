T = int(input())
result = 0       # 평균값을 담을 상자

for t in range(1, T+1):
    nums = list(map(int, input().split()))   # 입력값을 리스트로 받는다
    result = round(sum(nums) / len(nums))    # 리스트로 받은 입력값들의 합을 갯수로 나눈뒤 반올림을 한 결과값을 result에 담는다
    print(f'#{t} {result}')