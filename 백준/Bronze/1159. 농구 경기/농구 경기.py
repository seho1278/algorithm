N = int(input())

dict_ = {}
for n in range(N):
    player = input()
    x = player[0]
    if x not in dict_:
        dict_[x] = 1
    else:
        dict_[x] += 1

list_ = []
for key, value in dict_.items():
    if value >= 5:
        list_.append(key)
        
list_ = sorted(list_)

if list_:
    print(*list_, sep='')
else:
    print('PREDAJA')