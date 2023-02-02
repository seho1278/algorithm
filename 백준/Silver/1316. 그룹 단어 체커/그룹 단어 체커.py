N = int(input())

result = 0
for n in range(N):
    S = input()
    cnt = 0
    check = []

    for i in range(cnt, len(S)):
        if i != len(S) - 1:
            if S[i] != S[i+1]:
                if S[i] not in check:
                    check.append(S[i])
                    cnt += i + 1
                else:
                    break
        else:
            if S[i] in check:
                break

            else:
                result +=1

print(result)