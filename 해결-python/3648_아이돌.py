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
        elif not finished[next_idx]:
            parent = min(parent, list_id[next_idx])
    if list_id[i] == parent:
        scc = []
        while True:
            top = stack.pop()
            finished[top] = True
            scc.append(top)
            if list_id[top] == parent:
                scc_group.append(scc)
                break
    return parent

inputs = sys.stdin.readlines()
while inputs:
    n,m = map(int, inputs.pop(0).rstrip().split())

    graph = defaultdict(list)
    for __ in range(m):
        a,b = map(int,inputs.pop(0).rstrip().split())
        graph[-a].append(b)
        graph[-b].append(a)
    if 1 not in graph[-1]:
        graph[-1].append(1)
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
    for scc in scc_group[::-1]:
        if len(scc) != len(set([abs(num) for num in scc])):
            answer = "no"
            break
    # print(list_id)
    # print(scc_group)
            

    print(answer)