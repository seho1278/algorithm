N, L = map(int, input().split())

for i in range(2, L):
    if N % i == 0:
        print('BAD', i)
        break
else:
    print('GOOD')