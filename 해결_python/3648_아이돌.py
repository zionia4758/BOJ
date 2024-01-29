import sys
from collections import defaultdict


def dfs(i):
    global cur_id
    cur_id += 1
    parent = cur_id
    list_id[i] = parent
    stack.append(i)
    for next_idx in graph[i]:
        if list_id[next_idx] == 0:
            parent = min(parent, dfs(next_idx))
        elif finished[next_idx]:
            continue
        parent = min(parent, list_id[next_idx])
    finished[i] = True
    scc = []
    while stack:
        top = stack.pop()
        scc.append(top)
        if list_id[top] == parent:
            scc_group.append(scc)
            break
    list_id[i] = parent
    return parent

inputs = sys.stdin.readlines()
while inputs:
    n,m = map(int, inputs.pop(0).split())

    graph = defaultdict(list)
    for __ in range(m):
        a,b = map(int,inputs.pop(0).split())
        graph[-a].append(b)
        graph[-b].append(a)
    finished = [False] * (2*n+1)
    list_id = [0] * (2*n+1)
    stack = []

    cur_id = 0
    scc_group = []

    for i in range(-n,n+1):
        if i==0:
            continue
        if list_id[i] == 0:
            dfs(i)

    answer = "yes"
    win_list = [False]*(n+1)
    win_list[1] = True
    # for scc in scc_group[::-1]:
        
    print(scc_group)
    print(answer)