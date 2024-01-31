import sys
from heapq import heappush, heappop


def solution():
    n,m = map(int, sys.stdin.readline().split())
    t = 0
    plate = [[0]*(m+2)]
    for __ in range(n):
        p = [0]+list(map(int,sys.stdin.readline().split()))+[0]
        plate.append(p)
    plate.append([0]*(m+2))
    direction = [[1,0],[-1,0],[0,1],[0,-1]]
    visited = [[False]*(m+2) for __ in range(n+2)]
    queue = [[0,0,0]]
    visited[0][0] = True
    while queue:
        t,y,x = heappop(queue)
        for dy,dx in direction:
            ny = dy+y
            nx = dx+x
            if ny<0 or ny == n+2 or nx <0 or nx == m+2:
                continue
            if visited[ny][nx]:
                continue
            if plate[ny][nx] == 0:
                visited[ny][nx] = True
                heappush(queue,[t,ny,nx])
            
            if plate[ny][nx] == 1:
                plate[ny][nx] += 1
            elif plate[ny][nx] == 2:
                visited[ny][nx] = True
                plate[ny][nx] = 0
                heappush(queue,[t+1,ny,nx])
                
    print(t)
solution()