from collections import deque
def isPrime(num):
    for p,pp in zip(primes,pprime):
        if pp >num:
            break
        if num%p == 0:
            return False
    return True


n = int(input())
primes = [2]
pprime = [4]
for num in range(3,int((10**n)**0.5)+1):
    if isPrime(num):
        primes.append(num)
        pprime.append(num*num)
print(len(primes))
queue = deque([2,3,5,7])
under = 10**(n-1)
while queue:
    num = queue.popleft()
    if num < under:
        num*=10
        for i in range(10):
            if isPrime(num+i):
                queue.append(num+i)
    else:
        print(num)