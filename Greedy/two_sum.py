# https://leetcode.com/problems/two-sum/

'''
Time complexity O(n)
Space complexity O(n) -> storing check dict()
'''
def solve(nums=[], target=int()) -> list():
    # creating a dict to store element and their index in nums
    check = dict()

    # iterating over the nums
    for i, n in enumerate(nums):
        rem = target-n
        # checking if reminder is in check then returning their index
        # else adding number and its indext in check
        if rem in check:
            return [check[rem], i]
        else:
            check[n] = i
    return []


# !driver code
if __name__ == "__main__":
    nums = list(map(int, input().split(',')))
    target = int(input())
    print(solve(nums, target))
