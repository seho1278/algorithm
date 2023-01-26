N = int(input())

num_list = list(range(1, N+1))

result = []
while len(num_list) > 1:
    # 우선, 제일 위에 있는 카드를 바닥에 버린다.
    # 큐에서 제일 위 : pop(0)
    result.append(num_list.pop(0))
    
    num_list.append(num_list.pop(0))

print(*result, *num_list)