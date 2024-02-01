import sys
n = int(sys.stdin.readline())

bitter = []
sour = []

for __ in range(n):
    s,b = map(int, sys.stdin.readline().split())
    bitter.append(b)
    sour.append(s)
used = [False] * n

answer = 1<<32-1
for bitmask in range(1,(1<<n)):
    b = 0
    s = 1
    for i in range(n):
        if (1<<i)&bitmask:
            b += bitter[i]
            s *= sour[i]
    if answer > abs(b-s):
        answer = abs(b-s)
print(answer)