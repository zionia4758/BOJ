from itertools import combinations



n,m, = map(int, input().split())

def find(idx):
    if idx == graph[idx]:
        return idx
    else:
        return find(graph[idx])

known = input().split()[1:]
graph = {str(i):str(i) for i in range(1,n+1)}
for k in known[1:]:
    graph[k] = known[0]

data = []
for _ in range(m):
    party = input().split()[1:]
    data.append(party)
    
    for p in party[1:]:
        graph[find(p)] = find(party[0])

for i in range(1,n+1):
    find(str(i))
# print(data)

known_idx = find(known[0]) if known else -1
# print(graph)
answer = 0
for d in data:
    # print(d)
    if find(d[0]) != known_idx:
        answer += 1
print(answer)