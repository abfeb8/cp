# https://leetcode.com/problems/maximum-subarray/
# Kadanes algo

'''
Time complexity O(N)
Space complexity O(1)
'''


def solve(nums: list):
    globalMax = nums[0]
    curMax = 0

    for i in nums:
        curMax += i
        globalMax = max(globalMax, curMax)
        if(curMax < 0):
            curMax = 0
    return globalMax


# !driver code
if __name__ == "__main__":
    print(solve([-2,1,-3,4,-1,2,1,-5,4]))
