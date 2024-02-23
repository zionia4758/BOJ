n = int(input())
star = ["  *  ",
        " * * ",
        "*****"]
n//=3

# print(level)
def next_star(star):
    blank = " "*(len(star[0])//2+1)
    up = [blank+s+blank for s in star]

    down = [s+" "+s for s in star]

    return up+down

while n>1:
    n//=2
    star = next_star(star)

print('\n'.join(star))