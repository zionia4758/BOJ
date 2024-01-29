from sys import setrecursionlimit

setrecursionlimit(10000)


n = int(input())

mat = []
max_int = 987654321
for _ in range(n):
    mat.append(list(map(int,input().split())))
dp = [[max_int]*3 for _ in range(n)]
def search(y,i):
    if y == n:
        return 0
    if dp[y][i] != max_int:
        return dp[y][i]
    for x in range(3):
        if x == i:
            continue
        dp[y][i] = min(dp[y][i],mat[y][x] + search(y+1,x))
    return dp[y][i]

print(search(0,-1))