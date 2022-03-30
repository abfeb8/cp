# https://leetcode.com/problems/next-permutation/

'''
Time complexity O(n^2)
Space complexity O(1)
'''


def swap(nums, a, b):
    temp = nums[a]
    nums[a] = nums[b]
    nums[b] = temp


def nextPermutation(nums: list[int]) -> None:
    n = len(nums)
    swapIndexR = n-1
    swapIndexL = -1
    isSwaped = False

    p1 = n-1
    while(p1 > swapIndexL):
        for i in range(p1-1, swapIndexL-1, -1):
            if(nums[p1] > nums[i]):
                isSwaped = True
                if(swapIndexL < i):
                    # print(i,p1)
                    swapIndexL = i
                    swapIndexR = p1
        p1 -= 1
    if(isSwaped):
        # print(swapIndexR, swapIndexL)
        swap(nums, swapIndexR, swapIndexL)
        for i, n in enumerate(sorted(nums[swapIndexL+1:])):
            nums[swapIndexL+1+i] = n
    else:
        for i in range(n//2):
            swap(nums, i, n-1-i)


# !driver code
if __name__ == '__main__':
    arr = [1, 2, 3]
    nextPermutation(arr)
    print(arr)
