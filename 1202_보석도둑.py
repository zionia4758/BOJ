import sys
# from heapq import heappush, heappop
from collections import deque
n,k = map(int,sys.stdin.readline().split())

jewels = []
bags = []
for __ in range(n):
    m,v = map(int,sys.stdin.readline().split())
    jewels.append([v,m])

for __ in range(k):
    c = int(sys.stdin.readline())
    bags.append(c)
    jewels = sorted(jewels,key = lambda x:x[1])
bags = sorted(bags)
answer = 0
for bag in bags:
    

print(answer)
 