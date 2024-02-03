#nPm 구현
#used = num이 이미 사용되었는지 확인하는 리스트
#answer = 현재 조합된 원소들을 저장하는 리스트
answer = [0,0,0]
used = [False,False,False,False,False,False]
m=3
n=6
def permutation(idx):
    global n,m
    if(idx==m):
        print(answer[:m])
        return
    for num in range(n):
        if used[num]:
            continue
        answer[idx] = num
        used[num] = True
        permutation(idx+1)
        used[num] = False
        
permutation(0)