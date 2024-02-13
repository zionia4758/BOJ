from sys import stdin

n = int(stdin.readline())
m = int(stdin.readline())

mat = [[987654321]*n for __ in range(n)]
for __ in range(m):
    start, dest, v = map(int, stdin.readline().split())
    mat[start-1][dest-1] = min(v, mat[start-1][dest-1])
    
for i in range(n):
    mat[i][i] = 0
    
def floyde():
    for i in range(n):
        for y in range(n):
            for  x in range(n):
                mat[y][x] = min(mat[y][i]+mat[i][x] , mat[y][x])
floyde()      

for line in mat:
    print(" ".join(map(lambda x: str(x) if x != 987654321 else '0',line)))
    