# https://leetcode.com/problems/merge-sorted-array/

'''
Time complexity O(n)
Space complexity O()
'''


def solve(nums1: list[int], m: int, nums2: list[int], n: int):
    while m>0 and n>0:
        if(nums1[m-1]>nums2[n-1]):
            nums1[m+n-1] = nums1[m-1]
            m-=1
        else:
            nums1[m+n-1] = nums2[n-1]
            n-=1
        
    if n>0:
        nums1[:n]=nums2[:n]
    


# !driver code
if __name__ == "__main__":
    nums1 = list(map(int, input().split()))
    m = int(input())
    nums2 = list(map(int, input().split()))
    n = int(input())

    solve(nums1, m, nums2, n)
    print(nums1)
