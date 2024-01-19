from itertools import combinations
down, up = map(int,input().split())



# def isPrime(num):
#     for div in range(2,int(num**0.5)+1):

#         if num%div == 0:
#             return False
#     return True

# prime = [4]
# for num in range(3,int(up**0.5)+1):
#     if isPrime(num):
#         prime.append(num**2)


dp = [1] * (up-down+1)
# for p in prime:
#     for num in range((down+p-1)//p*p, up//p*p+1, p):
#         dp[down-num] = 0

for p in range(2,int(up**0.5)+1):
    p = p**2
    for num in range((down+p-1)//p*p, up//p*p+1, p):
        dp[down-num] = 0
print(sum(dp))


# def cnt(num):
#     answer = num
#     for i in range(1,len(prime)+1):
#         result = 0
#         for combi in combinations(prime,i):
#             mul = listMul(combi)
            
#             result += num//mul
#         if mul == 0:
#             break
#         if i%2==1:
#             answer -= result
#         elif i%2 == 0:
#             answer += result
#     return answer

# def cntv2(down, up):
#     result = 0
#     for num in range(down,up+1):
#         print(num)
#         for p in prime:
#             if num%p==0:
#                 result -= 1
#                 break
#         result += 1
#     return result
# print(cnt(down-1),cnt(up))
# print(cntv2(down,up))