T = int(input())

for t in range(T):
    h1, m1, h2, m2 = map(int, input().split())

    h3 = h1 + h2
    m3 = m1 + m2

    if m3 >= 60:
        m3 -= 60
        h3 += 1

    if h3 >= 13:
        h3 -= 12

    print(f'#{t+1} {h3} {m3}')