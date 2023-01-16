def d(x):
    x_l = [int(a) for a in str(x)]
    return x + sum(x_l)

r_list = []
for n in range(1, 10001):
    r_list.append(d(n))

for m in range(1, 10001):
    if m not in r_list:
        print(m)