# Problem: # https://leetcode.com/problems/intersection-of-two-arrays-ii/

'''
Time complexity O(N)
Space complexity O(N)
'''


def solve(nums1: list[int], nums2: list[int]) -> list[int]:
    count1 = dict()
    for i in nums1:
        count1[i] = count1.get(i, 0) + 1

    result = []
    for i in nums2:
        if i in count1 and count1[i] > 0:
            result.append(i)
            count1[i] -= 1

    return result


# !driver code
if __name__ == '__main__':
    print(solve(list(map(int, input().split())), list(map(int, input().split()))))
