t=int(input())
for _ in range(t):
    n_str,str = input().split()
    n=int(n_str)
    answer = ""
    for c in str:
        answer += c*n
    print(answer)