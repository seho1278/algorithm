T = int(input())

for t in range(T):
    result = []
    S = input()
    VPS = True
    for s in S:
        if s == '(':
            result.append(s)
        elif s == ')':
            if '(' in result:
                result.pop()
            else:
                print('NO')
                VPS = False
                break
    
    if len(result) == 0 and VPS:
        print('YES')
    elif VPS:
        print('NO')