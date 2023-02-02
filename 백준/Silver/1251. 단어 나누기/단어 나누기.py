S = input()

result2 = []
for i in range(1, len(S)-1):
    for j in range(i+1, len(S)):
        result = []        
        result.append(S[:i])
        result.append(S[i:j])
        result.append(S[j:len(S)])
        result2.append(result[0][::-1]+result[1][::-1]+result[2][::-1])

result2 = sorted(result2)        
print(result2[0])