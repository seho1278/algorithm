def fcn(arr):
    k = []
    k_temp = []
    for i in range(8):
        check = 0
        for j in range(6):
            if arr[j] != p[i][j]:
                check += 1
        k.append([check,i])
        k.sort()

    if k[0][0] == 1:
        return k[0][1]
    else:
        return -1


p = [['0', '0', '0', '0', '0', '0'],  # A
     ['0', '0', '1', '1', '1', '1'],  # B
     ['0', '1', '0', '0', '1', '1'],  # C
     ['0', '1', '1', '1', '0', '0'],  # D
     ['1', '0', '0', '1', '1', '0'],  # E
     ['1', '0', '1', '0', '0', '1'],  # F
     ['1', '1', '0', '1', '0', '1'],  # G
     ['1', '1', '1', '0', '1', '0']]  # H
pp = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']

n = int(input())
arr = list(str(input()))
ans = []
err = 0

for i in range(n):
    ch = False
    for j in range(8):
        if arr[0:6] == p[j]:
            ans.append(pp[j])
            ch = True
        else:
            pass

    if ch == False:
        if fcn(arr[0:6]) == -1:
            err = 1
            m = i+1
            break
        else:
            ans.append(pp[fcn(arr[0:6])])
    del arr[0:6]
    if err == 1:
        break

if err == 1:
    print(m)
else:
    for i in range(n):
        print(ans[i], end='')