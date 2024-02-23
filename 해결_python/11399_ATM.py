import sys

sys.stdin.readline()
nums = list(map(int,sys.stdin.readline().split()))
nums.sort()
for i in range(1, len(nums)):
    nums[i] = nums[i]+nums[i-1]
    
print(sum(nums))