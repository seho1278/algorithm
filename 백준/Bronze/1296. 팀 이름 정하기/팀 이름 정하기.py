name = input()
N = int(input())
list_= sorted([input() for i in range(N)])
X, Y = 0, 0
for i in range(N):
    L = name.count('L') + list_[i].count('L')
    O = name.count('O') + list_[i].count('O')
    V = name.count('V') + list_[i].count('V')
    E = name.count('E') + list_[i].count('E')
    result = ((L+O)*(L+V)*(L+E)*(O+V)*(O+E)*(V+E)) % 100

    if X < result:
        X = result
        Y = i

print(list_[Y])