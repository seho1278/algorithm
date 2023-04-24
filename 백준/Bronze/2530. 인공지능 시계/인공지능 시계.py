A, B, C = map(int, input().split())
D = int(input())
C = C + D

if C >= 60:
    x = C % 60
    y = C // 60
    C = x
    B = B + y

if B >= 60:
    x = B % 60
    y = B // 60
    B = x
    A = A + y

if A >= 24:
    A = A % 24

print(A, B, C)