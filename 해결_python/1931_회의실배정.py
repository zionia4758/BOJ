from collections import deque
import sys
n = int(sys.stdin.readline())
queue = [list(map(int,sys.stdin.readline().split())) for __ in range(n)]


# print(queue)
queue = deque(sorted(queue, key = lambda x:(x[1],x[0])))
answer = 0
end = 0
while queue:
    start_time,end_time = queue.popleft()
    if start_time >= end:
        end = end_time 
        answer += 1
print(answer)