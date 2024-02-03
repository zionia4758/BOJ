T = int(input())
for _ in range(T):
    n,m = map(int,input().split())

    #dp로 풀기
    # n-=1
    # m-=1
    # answer = 0
    # dp = [[0]*30 for _ in range(30)]
    # def cnt(n,m):
    #     if n == -1:
    #         return 1
    #     if dp[n][m] != 0:
    #         return dp[n][m]
    #     for i in range(m-n+1):
    #         dp[n][m] += cnt(n-1, m-i-1)
    #     return dp[n][m]
    
    #조합으로 풀기
    
    def cnt(n,m):
        answer = 1
        div = 1
        for i in range(1,n+1):
            answer *= m
            div *= i
            m -= 1
        return answer // div
    print(cnt(n,m))

    