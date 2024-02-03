from sys import stdin
from collections import defaultdict as dd
from sys import setrecursionlimit
setrecursionlimit(100000)

n,m = map(int,stdin.readline().split())

graph = dd(list)


for __ in range(m):
    i,j = map(int,stdin.readline().split())
    graph[-i].append(j)
    graph[-j].append(i)
for i in range(1,n+1):
    graph[i].sort()
node_id = [0 for i in range(2*n+1)]
finished = [False for __ in range(2*n+1)]

stack = []
scc_group = []
cnt = 0 
def dfs(i):
    global cnt
    cnt += 1
    node_id[i] = cnt
    stack.append(i)

    parent = node_id[i]
    for next_i in graph[i]:
        if node_id[next_i] == 0:
            parent = min(parent,dfs(next_i))
        elif not finished[next_i]:
            parent =  min(parent,node_id[next_i])

    if parent == node_id[i]:
        scc = []
        while True:
            node = stack.pop()
            scc.append(node)
            finished[node] = True

            if node == i:
                scc_group.append(scc)
                break
    return parent


for i in range(-i,i+1):
    if i == 0:
        continue
    if node_id[i] == 0:
        dfs(i)
# print(scc_group)
answer = 1
values = ['-1']*(n+1)
for group in scc_group[::-1]:
    if len(group) != len(set([abs(num) for num in group])):
        answer = 0
        break
    for num in group:
        idx = abs(num)
        val = "1" if num<0 else "0"
        if values[idx] == '-1':
            values[idx] = val

# print(values)
print(answer)
if answer == 1:
    print(" ".join(values[1:]))
