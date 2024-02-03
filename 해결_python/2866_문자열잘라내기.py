import sys

r,c = list(map(int,sys.stdin.readline().split()))
mat = []
for __ in range(r):
    mat.append(list(sys.stdin.readline().rstrip()))

group = [i for i in range(c)]

answer = r
def search(group,y):
    global answer
    if y == -1:
        return
    if y < answer:
        answer = y
    new_group = {ch:[] for ch in "qwertyuiopasdfghjklzxcvbnm"}
    for x in group:
        new_group[mat[y][x]].append(x)
    for g in new_group:
        if len(new_group[g]) < 2:
            continue
        search(new_group[g],y-1)
search(group,r-1)
print(answer)
