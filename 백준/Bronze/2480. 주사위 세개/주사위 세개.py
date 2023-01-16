result = list(map(int, input().split()))

prize_list = []

for i in result:
    if result.count(i) == 3:
        prize_list.append(10000+(i*1000))
        
    elif result.count(i) == 2:
        prize_list.append(1000+(i*100))
        
    else:
        prize_list.append(max(result)*100)

print(max(prize_list))