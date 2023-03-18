N, P = map(int, input().split())
X = N
list_ = []

while True:
    result = (X * N) % P
    if result in list_:
        print(len(list_) - list_.index(result))
        break

    list_.append(result)
    X = result