from random import randrange
from collections import deque

t = int(input())
for test in range(t):
    m,n,k = map(int, input().split())
    farm = [[0]*m for __ in range(n)]
    for __ in range(k):
        x,y = map(int, input().split())
        farm[y][x] = 1
    answer = 0
    direction = [[-1,0],[1,0],[0,-1],[0,1]]
    queue = deque([])
    for y in range(n):
        for x in range(m):
            if farm[y][x] == 1:
                queue.appendleft([x,y])
                farm[y][x] = 0
                answer += 1
            while queue:
                qx,qy = queue.popleft()
                for dx,dy in direction:
                    nx = qx+dx
                    ny = qy+dy
                    if nx<0 or nx==m or ny<0 or ny==n:
                        continue
                    if farm[ny][nx] == 0:
                        continue
                    queue.append([nx,ny])
                    farm[ny][nx] = 0
    print(answer)