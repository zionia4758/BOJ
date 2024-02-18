
#2번째 코드 : 1번의 string scan으로 끝내기
n,k = map(int,input().split())
answer = 0
n = bin(n)[2:]
cnt = n.count('1')
if cnt > k:
    idx = len(n)
    encount = -1
    while cnt-encount > k and idx > 0:
        idx -= 1
        if n[idx] == '1':
            encount += 1
    answer = (1<<(len(n)-idx)) - int(n[idx:],2)
print(answer)


#1번째 코드 : 정답일 때까지 반복
# n,k = map(int,input().split())
# answer = 0
# n = list(map(int,bin(n)[2:]))
# n=n[::-1]+[0]

# cnt = n.count(1)
# idx = 0
# answer = 0
# while cnt > k:
#     if n[idx] == 1:
#         answer += (1<<idx)
#         cnt += 1
#         n[idx] += 1
#         i = idx
#         while i+1 < len(n):
#             if n[i] == 2:
#                 cnt -= 1
#                 n[i+1] += 1
#                 n[i] = 0
#             i += 1
#     idx += 1
# print(answer)



