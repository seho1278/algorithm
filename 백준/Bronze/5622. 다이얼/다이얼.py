S = input()
dial = {
    'ABC': 3,
    'DEF': 4,
    'GHI': 5,
    'JKL': 6,
    'MNO': 7,
    'PQRS': 8,
    'TUV': 9,
    'WXYZ': 10
}
d_list = []
for key, value in dial.items():
    for s in S:
        if s in key:
            d_list.append(value)

print(sum(d_list))