string = input()

stack = []

answer = ""

for c in string:
    if c.isalpha():
        answer += c
    elif c == ')':
        while stack and stack[-1] != '(':
            answer += stack.pop()
        stack.pop()
    elif c in ['+','-']:
        if answer == "ABC":
            pass
        while stack and stack[-1] in ['*','/']:
            answer += stack.pop()
        if stack and stack[-1] in ['+','-']:
            answer += stack.pop()
        stack.append(c)
    elif c in ['*','/']:
        if stack and stack[-1] in ['*','/']:
            answer += stack.pop()
        stack.append(c)
    elif c == '(':
        stack.append(c)

# print(answer, stack)
answer += "".join(stack[::-1])
print(answer)