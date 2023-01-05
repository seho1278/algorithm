h, m = map(int, input().split())
m2 = int(input())

h = h + (m + m2) // 60
m = (m + m2) % 60

if h > 23:
    h %= 24

print(h, m)