N = int(input())

for n in range(1, N + 1):
    cnt = 0
    if '3' in str(n) or '6' in str(n) or '9' in str(n):
        cnt += str(n).count('3')
        cnt += str(n).count('6')
        cnt += str(n).count('9')
        n = '-'*cnt

    print(n, end=' ')