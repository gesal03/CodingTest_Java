
count = int(input())
arr = []

for _ in range(count):
    str = input()
    arr.append(str)

i = 1 
index = 0
arr2 = []
que = []
while(True):
    if index == count:
        break
    for str in arr:
        if len(str) == i:
            que.append(str)
            index+=1
    que1 = list(set(que))
    que1.sort()
    for j in que1:
        arr2.append(j)
    que=[]
    i+=1

for i in arr2:
    print(i)