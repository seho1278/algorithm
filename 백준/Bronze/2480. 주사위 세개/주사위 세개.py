n1, n2, n3 = map(int, input().split()) 
p = 0

if n1 == n2 and n2 == n3:
    p = 10000 + n1 * 1000
elif n1 == n2 or n2 == n3 or n1 == n3:
    if n1 == n2:
        p = 1000 + n1 * 100
    elif n2 == n3:
        p = 1000 + n2 * 100
    else:
        p = 1000 + n3 * 100

elif n1 != n2 and n1 != n3 and n2 != n3:
    if n1 > n2 and n1 > n3:
        p = n1 * 100
    elif n2 > n1 and n2 > n3:
        p = n2 * 100
    else:
        p = n3 * 100

print(p)