r,c = map(int,input().split())
mine = []
max_size = 0
for _ in range(r):
    mine.append(list(input()))
def search(y,x,move_cnt):
    ly = y
    lx = x
    ry = y
    rx = x
    for i in range(move_cnt):
            ly += 1
        lx -= 1
        if mine[ly][lx] == '0':
            return False
        ry += 1
        rx += 1
        if mine[ry][rx] == '0':
            return False
        
    for i in range(move_cnt):
        ly += 1
        lx += 1
        if mine[ly][lx] == '0':
            return False
        ry += 1
        rx -= 1
        if mine[ry][rx] == '0':
            return False
    return True
def pruning(y,x,size):
    if x < size or x >= c - size:
        return True
    if y >= r-(2*size):
        return True
for y in range(r):
    for x in range(c):
        if pruning(y,x,max_size):
            continue
        if mine[y][x] == '0':
            continue
        # if y==0 and x == 3:
        #     print(max_size,(r-y+1)//2,x+1,c-x)
        for move_cnt in range(max_size, min((r-y+1)//2,min(x+1,c-x))):
            # print(move_cnt,search(y,x,move_cnt))
            if search(y,x,move_cnt):
                max_size = move_cnt+1
print(max_size)