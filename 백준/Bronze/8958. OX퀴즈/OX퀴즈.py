N = int(input())

for n in range(N):
    S = input()
    r_list = []
    result = 0
    for m in S:
        if m == 'O':
            result += 1 
            r_list.append(result)
        else:
            result = 0
            r_list.append(result)

    print(sum(r_list))
