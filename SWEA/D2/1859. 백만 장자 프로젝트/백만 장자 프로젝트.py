T = int(input())

for t in range(T):
  n = int(input())
  l = list(map(int, input().split()))
  cost = l[-1]
  benefit = 0
  for i in reversed(l):
    if cost <= i:
      cost = i
    benefit += cost - i
  print(f'#{t + 1} {benefit}')