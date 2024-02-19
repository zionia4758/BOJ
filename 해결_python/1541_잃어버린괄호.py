inputs = input().split('-')
nums = []
for line in inputs:
    nums.append(sum(map(int,line.split('+'))))
answer = nums[0]
for num in nums[1:]:
    answer -= num
print(answer)