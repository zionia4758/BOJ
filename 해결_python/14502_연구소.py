from collections import deque
from itertools import combinations
n,m = map(int, input().split())

v_cnt = 0
w_cnt = 0
mat = []
virus = []
direction = [[-1,0],[1,0],[0,-1],[0,1]]
for __ in range(n):
    mat.append(list(map(int,input().split())))


for y in range(n):
    for x in range(m):
        num = mat[y][x]
        if num == 1:
            w_cnt+=1
        elif num == 2:
            v_cnt += 1
            virus.append([y,x])
first_cnt = n*m - v_cnt - w_cnt -3
answer = 0

def bfs():
    result = first_cnt
    visited = [[False]*m for __ in range(n)]
    queue = deque(virus)
    while queue:
        y,x = queue.pop()
        for dy,dx in direction:
            ny=dy+y
            nx=dx+x
            if ny<0 or ny>=n or nx<0 or nx>=m:
                continue
            if visited[ny][nx] or mat[ny][nx] != 0:
                continue
            result -= 1
            visited[ny][nx] = True
            if result <= answer:
                queue=[]
                break
            queue.append([ny,nx])
    return result

def comb():
    global answer 

    for combi in combinations([(y,x) for x in range(m) for y in range(n)],3):
        if mat[combi[0][0]][combi[0][1]] != 0 or mat[combi[1][0]][combi[1][1]] != 0 or mat[combi[2][0]][combi[2][1]]!=0:
            continue
        for y,x in combi:
            mat[y][x] = 1
        answer = max(answer, bfs())
        for y,x in combi:
            mat[y][x] = 0
comb()
print(answer)
        