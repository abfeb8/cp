# https://leetcode.com/problems/next-permutation/

'''
Time complexity O(n)
Space complexity O(1)
'''


def swap(nums, a, b):
    nums[a], nums[b] = nums[b], nums[a]


def nextPermutation(nums: list[int]) -> None:
    n = len(nums)
    k = n-2
    l = n-1

    while(k >= 0):
        if(nums[k] < nums[k+1]):
            break
        k -= 1

    if(k < 0):
        for i, n in enumerate(nums[::-1]):
            nums[i] = n
    else:
        while(l > k):
            if(nums[k] < nums[l]):
                break
            l -= 1

        swap(nums, k, l)
        m = n-1
        k += 1
        while(k < m):
            nums[k], nums[m] = nums[m], nums[k]
            k += 1
            m -= 1


# !driver code
if __name__ == '__main__':
    arr = [1, 2, 3]
    nextPermutation(arr)
    print(arr)
