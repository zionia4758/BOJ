from sys import stdin
from collections import defaultdict
from heapq import heappush, heappop,heapify
readline = stdin.readline

n,e = map(int,readline().split())
graph = defaultdict(list)

for __ in range(e):
    a,b,c = map(int, readline().split())
    graph[a].append([c,b])
    graph[b].append([c,a])
def dijkstra(start):
    result = [987654321]*(n+1)
    hq = [[0,start]]
    result[start]=0
    while hq:
        v,dest = heappop(hq)
        if v > result[dest]:
            continue

        for dest_v,new_dest in graph[dest]:
            if dest_v + v >= result[new_dest]:
                continue
            heappush(hq, [dest_v+v,new_dest])
            result[new_dest] = v+dest_v
    return result

v1,v2 = map(int, readline().split())
answer = -1
start = dijkstra(1)
mid = dijkstra(v1)
end = dijkstra(n)
# print(start, mid, end)
#case1 : 1->v1->v2->n
if start[v1]!= 987654321 and mid[v2] != 987654321 and end[v2] != 987654321:
    answer = start[v1]+mid[v2]+end[v2]
#case2 : 1->v2->v1->n
if start[v2]!= 987654321 and mid[v2] != 987654321 and end[v1] != 987654321:
    if answer == -1:
        answer = start[v2]+mid[v2]+end[v1]
    else:
        answer = min(answer, start[v2]+mid[v2]+end[v1])

print(answer)   