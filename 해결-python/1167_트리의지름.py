import sys

v = int(sys.stdin.readline())

graph = {i:[] for i in range(1,v+1)}

for __ in range(v):
    v_list = list(map(int, sys.stdin.readline().split()))[:-1]
    a = v_list[0]
    for i in range(len(v_list)//2):
        b= v_list[2*i+1]
        w = v_list[2*i+2]
        graph[a].append([b,w])

answer = 0
visited = [False]*(v+1)
def search(idx):
    global answer
    first = 0
    second = 0
    visited[idx] = True
    for next_idx, w in graph[idx]:
        if visited[next_idx]:
            continue
        result = search(next_idx) + w
        if result > first:
            second = first
            first = result
        elif result > second:
            second = result
    if_root = first+second
    if if_root > answer:
        answer = if_root

    return first
search(1)
print(answer)