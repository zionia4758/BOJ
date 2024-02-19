import sys

t=int(sys.stdin.readline())
for __ in range(t):
    n = int(sys.stdin.readline())
    dp = [[0],[0]]
    dp[0].extend(map(int,sys.stdin.readline().split()))
    dp[1].extend(map(int,sys.stdin.readline().split()))
    # dp=[[0]*(n+1) for _ in range(2)]
    # print(dp)
    for i in range(2,n+1):
        dp[0][i] = max(dp[1][i-1], dp[0][i-2],dp[1][i-2])+dp[0][i]
        dp[1][i] = max(dp[0][i-1],dp[1][i-2],dp[0][i-2])+dp[1][i]

    print(max(dp[0][-1],dp[1][-1]))