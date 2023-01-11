N = int(input())
result = 0
T = N
r_list = []


while True:
    if T >= 10:
        result = (T//10) + (T%10)
        result = int(str(T%10) + str(result%10))
    
    else:
        result = 0 + T
        result = int(str(T%10) + str(result%10))

    if result != N:
        r_list.append(result)
        T = result

    else:
        r_list.append(result)
        break

print(len(r_list))