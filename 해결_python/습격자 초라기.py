from sys import setrecursionlimit
setrecursionlimit(1000000)

def solution():
    T = int(input())

    def search(cover_case,idx):
        if idx >= n:
            return 0
        if dp[cover_case][idx] != 0:
            return dp[cover_case][idx]
        #끝에 도달한 경우
        if idx == n-1:
            if cover_case == 0:
                if enemy[0][-1] == 0 or enemy[1][-1] == 0:
                    if enemy[0][-1] == 0 and enemy[1][-1] == 0:
                        return 0
                    else:
                        return 1
                #첫 탐색에서 두 지역을 사용하지 않은 경우만 추가
                if enemy[0][-1] + enemy[1][-1] <= m:
                    dp[0][idx] = 1
                    return 1
                else:
                    dp[0][idx] = 2
                    return 2
            elif cover_case ==1:
                #첫 탐색에서 아래쪽을 사용하지 않은 경우만 가능
                if enemy[0][-1] != 0:
                    if enemy[1][-1] == 0:
                        dp[1][idx] = 0
                        return 0
                    else:
                        dp[1][idx] = 1
                        return 1
                else:
                    return 987654321
            elif cover_case == 2:
                #첫 탐색에서 위쪽을 사용하지 않은 경우만 가능
                if enemy[1][-1] != 0:
                    if enemy[0][-1] == 0:
                        dp[2][idx] = 0
                        return 0
                    else:
                        dp[2][idx] = 1
                        return 1
                else:
                    return 987654321
        
        if cover_case == 0:
            #위아래 살아있는 경우
            #한칸식 두번 점유한 경우
            result = search(0, idx+1) + 2
            if enemy[0][idx] + enemy[1][idx] <= m:
                #위아래 탐색
                result = min(result, search(0,idx+1) + 1)
            if enemy[0][idx] + enemy[0][idx+1] <= m:
                #아래 두칸 탐색 및 위 한칸 탐색
                result = min(result, search(1,idx+1) + 2)
            if enemy[1][idx] + enemy[1][idx+1] <= m:
                #위 두칸 탐색 및 아래 한칸 탐색
                result = min(result, search(2,idx+1) + 2)
            if enemy[0][idx] + enemy[0][idx+1] <= m and enemy[1][idx] + enemy[1][idx+1] <= m:
                #위 아래 두칸 탐색
                result = min(result, search(0,idx+2) + 2)
            
        elif cover_case == 1:
            #위만 살아있는 경우
            #아래 1칸 점유
            result = search(0, idx+1) + 1
            if enemy[1][idx+1] + enemy[1][idx] <= m:
                #아래 2칸 점유
                result = min(result, search(2,idx+1)+1)
        elif cover_case == 2:
            #아래만 살아있는 경우
            #위 한칸 점유
            result = search(0,idx+1) + 1
            if enemy[0][idx+1] + enemy[0][idx] <= m:
                result = min(result, search(1,idx+1)+1)

        dp[cover_case][idx] = result
        return result


    for _ in range(T):
        n,m = map(int,input().split())
        # print(n,m)
        enemy = []
        #idx기준 나머지 구역을 커버하는데 필요한 최소의 팀 개수
        #dp[case][idx]
        dp = [[0]*n for _ in range(3)]
        for _ in range(2):
            enemy.append(list(map(int,input().split())))

        #일반 시작
        answer = search(0,0)
        # print(answer)
        if n >= 2:
            #아래 2칸 시작
            if enemy[0][0] + enemy[0][-1] <= m:
                dp = [[0]*n for _ in range(3)]
                temp = enemy[0][-1]
                enemy[0][-1] = 0
                result =  search(1,0) + 1
                answer = min(answer,result)
                enemy[0][-1] = temp
                # print(result)
            #위 2칸 시작
            if enemy[1][0] + enemy[1][-1] <= m:
                dp = [[0]*n for _ in range(3)]
                temp = enemy[1][-1]
                enemy[1][-1] = 0
                result = search(2,0)+1
                answer = min(answer, result)
                enemy[1][-1] = temp
                # print(result)
            #위아래 2칸 시작
            if enemy[0][0] + enemy[0][-1] <= m and enemy[1][0] + enemy[1][-1] <= m:
                dp = [[0]*n for _ in range(3)]
                enemy[1][-1] = 0
                enemy[0][-1] = 0
                result =  search(0,1)+2
                answer = min(answer,result)
                # print(result)
        print(answer)


solution()
