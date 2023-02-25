import sys

for n in range(3):
    result = 0
    X = int(input())
    for x in range(X):
        Y = int(sys.stdin.readline())
        result += Y

    if result == 0:
        print(0)
    elif result > 0:
        print('+')
    else:
        print('-')