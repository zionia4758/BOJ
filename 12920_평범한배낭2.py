# import sys

# n,m = map(int, sys.stdin.readline().split())

# bags = []

# for __ in range(n):
#     bags.append(list(map(int,sys.stdin.readline().split())))
# bags.sort(key = lambda x: x[0]/x[1])

# dp = [[-1] * (m+1) for __ in range(n)]

# def search(i,remain_w, before_v, before_c):
#     if i == n:
#         return 0
#     if dp[i][remain_w] != -1:
#         return dp[i][remain_w]

#     v,c,k = bags[i]

#     #더이상 가치를 올릴 수 없는게 확정
#     if before_c > (remain_w+before_v)/v*c:
#         print(before_c,remain_w,v,c,before_v)
#         return -1

#     answer = 0
#     for cnt in range(min(k,(remain_w//v)),-1,-1):
#         total_v = cnt*v
#         result = search(i+1,remain_w-total_v,v,c)
#         if result == -1:
#             print(cnt,v,c)
#             print(123123)
#         answer = max(answer, result + c*cnt)
#     dp[i][remain_w] = answer
#     return answer

# print(search(0,m,0,0))


# # dp = [0 for __ in range(m+1)]
# # stack = []
# # for bag in bags:
# #     v,c,k = bag
# #     for before_v in range(m+1-v,-1,-1):
# #         for cnt in range(1,k+1):
# #             total_v = v*cnt
# #             if total_v + before_v > m:
# #                 continue
# #             total_c = c*cnt
# #             dp[before_v + total_v] = max(dp[before_v]+total_c, dp[before_v+total_v])

# # print(dp[-1])