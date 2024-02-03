n = int(input())
# dp = [987654321] * (n+1)
# for i in range(1,int(n**0.5)+1):
#     dp[i*i] = 1
# max_i = 2
# max_i2 = max_i**2
# for num in range(2,n+1):
#     if num == max_i2:
#         max_i += 1
#         max_i2 = max_i**2
#         continue
#     for i in range(1,max_i):
#         dp[num] = min(dp[num],dp[num-(i*i)]+dp[i*i])

dp = [n for n in range(n+1)]
max_i = int(n**0.5)+1

for num in range(2,n+1):
    for i in range(1,max_i):
        ii = i*i
        if ii > num:
            break
        if dp[num] > dp[num-ii]+1:
            dp[num] = dp[num-ii]+1
print(dp[n])