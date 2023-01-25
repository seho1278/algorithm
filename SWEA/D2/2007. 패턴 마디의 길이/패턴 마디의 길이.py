T = int(input())

for t in range(T):
    S = input()
    S_dict = {}
    for i in S:
        if i not in S_dict:
            S_dict[i] = 1
        else:
            S_dict[i] += 1
    result = 0
    m = min(S_dict.values())
    for j in S_dict.keys():
        result += S_dict[j] // m

    print(f'#{t+1} {result}')