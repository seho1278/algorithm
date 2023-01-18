S = input()
a = 10
b = 0
while True:
    print(S[b:a])
    a += 10
    b += 10
    if S[b:a] == '':
        break
