import sys

n,k = map(int, sys.stdin.readline().split())

bags = []

for __ in range(n):
    bags.append(list(map(int,sys.stdin.readline().split())))

dp = [[-1] * (k+1) for __ in range(n)]

def search(i,remain_w):
    if i == n:
        return 0
    if dp[i][remain_w] != -1:
        return dp[i][remain_w]
    w,v = bags[i]
    result = search(i+1,remain_w)
    if remain_w >= w:
        result = max(result, search(i+1,remain_w-w) + v)
    dp[i][remain_w] = result
    return result

print(search(0,k))