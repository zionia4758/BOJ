cnt = [0]*26
for ch in list(input()):
    cnt[ord(ch.lower())-ord("a")] += 1
max_cnt = max(cnt)

answer = ""
max_sum = 0
for i in range(26):
    if cnt[i] == max_cnt:
        max_sum += 1
        answer = chr(i+ord("A"))
if max_sum > 1 :
    answer = "?"

print(answer)