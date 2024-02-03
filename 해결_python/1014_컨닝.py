T=int(input())


def check_not_avail(y,bitmask):
    for i in range(m):
            if (1<<i)&bitmask and chair[y][i] == False:
                return True 
    return False
def check_can_see(bitmask,before_mask):
    for i in range(m):
            invalid_mask = 0b101 << i >> 1 if (before_mask&(1<<i)) else 0
            if (bitmask & invalid_mask):
                return True
    return False

def check_adj(bitmask):
    mask = 0b11
    for i in range(9):
        if (mask<<i)&bitmask == (mask<<i):
            return True
    return False

bitmasks = [num for num in range(1<<10) if not check_adj(num)]


def search(y, before_mask):
    #y에서 cur로 앉혔을 때 

    if y == n:
        return 0 
    if dp[y][before_mask] != -1:
        return dp[y][before_mask]
    # print(y,bin(before_mask))
    answer = 0
    #최대 2^10가짓수를 돌아보며 가능한 경우 y+1 탐색
    for bitmask in bitmasks:
        if bitmask >= limit:
            break
        if check_not_avail(y,bitmask):
            continue
        if check_can_see(bitmask,before_mask):
            continue
            # print(bin(bitmask),bin(before_mask))
        dp[y][before_mask] = max(dp[y][before_mask],search(y+1,bitmask)+bin(bitmask).count('1'))


    return dp[y][before_mask]


for _ in range(T):
    n,m = map(int,input().split())
    chair = []
    for _ in range(n):
        chair.append([True if ch == '.' else False for ch in list(input())])
    limit = 1<<m
    #dp[y][bitmask] : 이전에 bitmask형태로 앉혔을 때 앞으로 앉힐 수 있는 최대 인원
    dp = [[-1]*(1<<m) for _ in range(n)]

    #계산을 쉽게 하기 위해 뒤집기
    # chair = chair[::-1]
    print(search(0,0))
    # print(dp)
