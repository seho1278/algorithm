N = int(input())
stack, result, find = [], [], True

cnt = 1
for _ in range(N):
    num = int(input())

    while cnt <= num:
        stack.append(cnt)
        result.append('+')
        cnt += 1
    
    if stack[-1] == num:
        stack.pop()
        result.append('-')

    else:
        find = False

if not find:
    print('NO')
else:
    for i in result:
        print(i)