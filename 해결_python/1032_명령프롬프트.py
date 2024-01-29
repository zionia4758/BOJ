n = int(input())
commands = []
for _ in range(n):
    commands.append(input())

answer = ""
for word_set in zip(*commands):

    if len(set(list(word_set))) == 1:
        answer += word_set[0]
    else:
        answer += '?'
print(answer)