D, H, W = map(int, input().split())

x = ((H**2)*(D**2)/((H**2)+(W**2)))**(1/2)
y = ((W**2)*(D**2)/((H**2)+(W**2)))**(1/2)

print(int(x), int(y))