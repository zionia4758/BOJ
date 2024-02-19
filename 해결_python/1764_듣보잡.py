n,m = map(int, input().split())
not_l = set()
for __ in range(n):
    not_l.add(input())

answer = []
for __ in range(m):
    name = input()
    if name in not_l:
        answer.append(name)
answer.sort()
print(len(answer))
for name in answer:
    print(name)