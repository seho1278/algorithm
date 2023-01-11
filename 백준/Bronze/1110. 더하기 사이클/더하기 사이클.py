N = str(input()).zfill(2)
result = 0
T = N
count = 0


while True:
    count += 1

    result = T[1] + str(int(T[0]) + int(T[1])).zfill(2)[1]
    result = str(result).zfill(2)
    
    
    if int(result) == int(N):
        break
    else:
        T = result

print(count)