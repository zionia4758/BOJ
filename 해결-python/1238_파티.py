import sys
from heapq import heappop, heappush

def daijkstra(start,dest):
    hq = [[0,start]]
    while hq:
        t, min_idx = heappop(hq)
        if mat[start][min_idx]<t:
            continue
        for next_t,next_node in graph[min_idx]:
            new_time = t+next_t
            if mat[start][next_node] > new_time:
                mat[start][next_node] = new_time
                heappush(hq,[new_time,next_node])
 
    return mat[start][dest]

n,m,x = map(int, sys.stdin.readline().split())
graph = {idx:[] for idx in range(n)}
mat = [[987654321]*n for __ in range(n)]
for i in range(n):
    mat[i][i] = 0

for __ in range(m):
    a,b,t = map(int, sys.stdin.readline().split())
    graph[a-1].append([t,b-1])
    # mat[a-1][b-1] = t
    
answer = 0
for i in range(n):
    answer = max(daijkstra(i,x-1)+daijkstra(x-1,i),answer)

print(answer)