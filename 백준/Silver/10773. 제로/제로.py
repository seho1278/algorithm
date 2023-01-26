K = int(input())
num_list = []

for k in range(K):
    number = int(input())
    if number == 0:
        num_list.pop()
        
    else:
        num_list.append(number)

print(sum(num_list))