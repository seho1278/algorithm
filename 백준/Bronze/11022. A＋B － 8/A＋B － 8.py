import sys
T = int(sys.stdin.readline())
C = 0
for i in range(T):
    A, B = map(int, sys.stdin.readline().split())
    C = A + B
    print(f'Case #{i + 1}: {A} + {B} = {C}')