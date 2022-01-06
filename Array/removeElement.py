# https://leetcode.com/problems/remove-element/

'''
Time complexity O(N)
Space complexity O(1)
'''


def solve(nums: list, val: int):
    k = 0
    l = 0
    for i, c in enumerate(nums):
        if c == val:
            k += 1
        else:
            nums[i-k] = c
            l += 1

    print(nums[:l])
    return l


# !driver code
if __name__ == "__main__":
    nums = list(map(int, input().split(",")))
    val = int(input())
    solve(nums, val)
