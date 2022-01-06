# https://leetcode.com/problems/contains-duplicate/

'''
Time complexity O(n)
Space complexity O()
'''
def solve(nums:list[int]):
    check = set(nums)
    if len(nums)==len(check): return False
    return True


# !driver code
if __name__ == "__main__":
    nums = list(map(int,input().split()))
    print(solve(nums))