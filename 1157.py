s = input().upper()

count = [0 for i in range(26)]

for c in s:
    count[ord(c)-ord('A')] += 1

maxCount = -1
check = False
index = 0

for i in count:
    if check == False and maxCount == i:
        check = True
    
    if maxCount < i:
        maxCount = i
        check = False
        ansIndex = index
    
    index += 1
        
ans = chr(ord('A') + ansIndex)

if check == False:
    print(ans)
else:
    print('?')