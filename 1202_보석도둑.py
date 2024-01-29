import sys
from heapq import heappush, heappop
from collections import deque
n,k = map(int,sys.stdin.readline().split())

jewels = []
avail_weights = [0]*(n+1)
for __ in range(n):
    m,v = map(int,sys.stdin.readline().split())
    heappush(jewels,[-v,m])
for __ in range(k):
    c = int(sys.stdin.readline())
    avail_weights[c] += 1
for w in range()

answer = 0
while jewels:
    v,m = heappop(jewels)
    if m > 
print(answer)
