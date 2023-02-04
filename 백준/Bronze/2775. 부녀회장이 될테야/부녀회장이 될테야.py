T = int(input())

for t in range(T):
    k = int(input())
    n = int(input())
    a = [_ for _ in range(1, n+1)]
    
    for i in range(k):
        for j in range(1, n):
            a[j] += a[j-1]
        
    print(a[-1])