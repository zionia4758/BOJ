import sys
inputs = sys.stdin.readline().strip()
bomb = list(sys.stdin.readline().strip())
stack = []

bomb_len = len(bomb)
for c in inputs:
    stack.append(c)
    if len(stack)>=bomb_len and stack[-bomb_len:]==bomb:
        del stack[-bomb_len:]
    
print("".join(stack) if stack else "FRULA")