x, y, w, h = map(int, input().split())
list_ = []
list_.append(w-x)
list_.append(h-y)
list_.append(x-0)
list_.append(y-0)
print(min(list_))