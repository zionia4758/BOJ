n = int(input())

num_arr = list(map(lambda x: int(x), input().split()))

cnt = [0]*1001
for num in num_arr:
    cnt[num] += 1
sum = 0
for i in range(0,1000):
    cnt[i] += sum
    sum = cnt[i]
    
answer = []
for num in num_arr:
    answer.append(str(cnt[num-1]))
    cnt[num-1] += 1
print(" ".join(answer))