import sys

N = int(sys.stdin.readline())

stack = []
for n in range(N):
    X = sys.stdin.readline()
    if 'push' in X:
        stack.append(int(X.lstrip('push ')))
    
    elif 'pop' in X:
        if len(stack) != 0:
            print(stack.pop())
        else:
            print(-1)

    elif 'size' in X:
        print(len(stack))

    elif 'top' in X:
        if len(stack) != 0:
            print(stack[-1])
        else:
            print(-1)

    elif 'empty' in X:
        if len(stack) == 0:
            print(1)
        else:
            print(0)