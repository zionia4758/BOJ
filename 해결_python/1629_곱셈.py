a,b,c = map(int,input().split())
a%=c
def search(b):
    if b == 1:
        return a
    result = search(b//2)
    if b%2 == 0:
        return (result*result)%c
    else:
        return (result*result*a)%c
    
print(search(b))