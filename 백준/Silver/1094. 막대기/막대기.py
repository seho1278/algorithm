X = int(input())
stick = [64, 32, 16, 8, 4, 2, 1]
cnt = 0

for i in range(len(stick)):
    if X >= stick[i]:
        cnt += 1
        X -= stick[i]

    if X == 0:
        break
    
print(cnt)