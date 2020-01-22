t = int(input())

for i in range(t):
    string = input()
    r = int(string[0])
    s = string[2:]
    
    string = ''
    
    for c in s:
        for j in range(r):
          string += c
          
    print(string)