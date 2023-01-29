while True:
    S = input()
    array = []
    if S == '.':
      break

    
    for s in S:
        if s == '(' or s == '[':
            array.append(s)
        elif s == ')':
            if len(array) != 0 and '(' == array[-1]:
                array.pop()
            else:
                print('no')
                break

        elif s == ']':
            if len(array) != 0 and '[' == array[-1]:
                array.pop()
            else:
                print('no')
                break
    else:
        if len(array) == 0:
            print('yes')
        else:
            print('no')