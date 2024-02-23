import sys
from collections import deque

r,c = map(int, input().split())
mat = [list(sys.stdin.readline().rstrip()) for __ in range(r)]

direction = [(-1,0),(1,0),(0,-1),(0,1)]

def search():
    answer = 1
    queue = set()
    queue.add((0,0,mat[0][0]))
    while queue:    
        y,x, bitmask = queue.pop()
        if len(bitmask)>answer:
            answer = len(bitmask)
        if len(bitmask)==26:
            return 26
        for dy,dx in direction:
            ny = dy+y
            nx = dx+x
            if 0<=nx<c and 0<=ny<r and mat[ny][nx] not in bitmask:
                next_mask = bitmask+mat[ny][nx]
                queue.add((ny,nx,next_mask))
    return answer

print(search())

    