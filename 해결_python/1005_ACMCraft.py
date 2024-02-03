from collections import deque
import sys
t = int(sys.stdin.readline())

def bfs(queue):
    while queue:
        node, time = queue.popleft()
        time += build_time[node]
        if node == w:
            return time
        max_time[node] = time
        next_list = graph[node]
        for next_node in next_list:
            max_time[next_node] = max(max_time[next_node], time )
            in_cnt[next_node] -= 1
            if in_cnt[next_node] == 0:
                queue.append([next_node,max_time[next_node]])
    return -1


for __ in range(t):
    n,k = map(int,sys.stdin.readline().split())
    max_time = [0]*(n+1)
    build_time = [0]+list(map(int,sys.stdin.readline().split()))
    in_cnt = [0]*(n+1)
    graph = {i+1:deque() for i in range(n)}
    
    for __ in range(k):
        f,t = map(int,sys.stdin.readline().split())
        graph[f].append(t)
        in_cnt[t] += 1
    w = int(sys.stdin.readline())
    print(bfs(deque([[i,0] for i, cnt in enumerate(in_cnt[1:], start = 1) if cnt == 0])))