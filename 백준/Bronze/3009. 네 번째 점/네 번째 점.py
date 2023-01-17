x = 0
y = 0
x_list = []
y_list = []

for n in range(3):
    numbers = list(map(int, input().split()))
    x_list.append(numbers[0])
    y_list.append(numbers[1])

for m in x_list:
    if x_list.count(m) == 1:
        x = m
        break

for l in y_list:
    if y_list.count(l) == 1:
        y = l
        break

print(x, y, sep=' ')