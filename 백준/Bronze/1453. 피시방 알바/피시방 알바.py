N = int(input())
guest = map(int, input().split())
g_dict = {}
cnt = 0
for i in guest:
    if i not in g_dict:
        g_dict[i] = 1
    else:
        cnt += 1

print(cnt)
