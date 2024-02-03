import sys
from collections import defaultdict
from heapq import heappush, heappop
V,E = map(int,sys.stdin.readline().split())

K = int(sys.stdin.readline())

graph = defaultdict(list)
for __ in range(E):
    u,v,w = map(int,sys.stdin.readline().split())
    graph[u].append([v,w])

answer = [987654321] * (V+1)

queue = [[0,K]]
answer[K] = 0
while queue:
    # print(queue[0])
    weight, idx = heappop(queue)
    for next_idx,next_w in graph[idx]:
        new_w = answer[idx] + next_w
        # print(next_idx, answer[next_idx], new_w)
        if answer[next_idx] <= new_w:
            continue
        answer[next_idx] = new_w    
        heappush(queue,[new_w,next_idx])

for num in answer[1:]:
    if num == 987654321:
        print("INF")
    else:
        print(num)
        