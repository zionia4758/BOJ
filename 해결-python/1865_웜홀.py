import sys
t = int(sys.stdin.readline())
MAX_INT = 987654321
for __ in range(t):
    n,m,w = map(int, sys.stdin.readline().split())
    mat = [MAX_INT]*n
    graph = {i:[] for i in range(n)}

    for __ in range(m):
        s,e,t = map(int,sys.stdin.readline().split())

        s-=1
        e-=1
        graph[s].append([s,e,t])
        graph[e].append([e,s,t])

    #웜홀은 중복이 없는가?
    for __ in range(w):
        s,e,t = map(int,sys.stdin.readline().split())
        s-=1
        e-=1
        graph[s].append([s,e,-t])

    def bellmanford():
        result = False
        
        for cnt in range(n):
            for i in range(n):
                for s,e,t in graph[i]:
                    if mat[e] > mat[s]+t:
                        mat[e] = mat[s]+t
                        if cnt == n-1:
                            result = True
                            break
        return result
    answer = False

    if bellmanford():
        sys.stdout.write("YES\n")
    else:
        sys.stdout.write("NO\n")