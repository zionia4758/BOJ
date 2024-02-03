import sys
from heapq import heappush, heappop

v,e = map(int,sys.stdin.readline().split())

answer = 0
graph = {i:[] for i in range(1,v+1)}
for y in range(e):
    a,b,val = map(int,sys.stdin.readline().split())
    graph[a].append([val,a,b])
    graph[b].append([val,b,a])
hq = []
for edge in graph[1]:
    heappush(hq,edge)
v_set = set([1])

while edge and len(v_set) < v:
    val,a,b = heappop(hq)
    if b in v_set:
        continue
    v_set.add(b)
    for edge in graph[b]:
        if edge[2] not in v_set:
            heappush(hq,edge)
    answer += val

print(answer)