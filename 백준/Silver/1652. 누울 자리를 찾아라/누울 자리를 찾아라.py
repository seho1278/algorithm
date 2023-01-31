N = int(input())

matrix = [list(input()) for _ in range(N)]

row, col = 0, 0
for i in range(N):    
    cnt = 0
    for j in range(N):
        if matrix[i][j] == '.':
            cnt += 1
            
        else:
            if cnt >= 2:
                row += 1
            cnt = 0
    else:
        if cnt >= 2:
            row += 1


for i in range(N):    
    cnt2 = 0
    for j in range(N):
        if matrix[j][i] == '.':
            cnt2 += 1
    
        else:
            if cnt2 >= 2:
                col += 1
            cnt2 = 0

    else:
        if cnt2 >= 2:
            col += 1
            

print(row, col)