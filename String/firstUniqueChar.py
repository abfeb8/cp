# Problem: https://leetcode.com/problems/first-unique-character-in-a-string/

'''
Time complexity O(N)
Space complexity O(1)
'''


def solve(s: str) -> int:
    check = dict()
    for i, c in enumerate(s):
        if c in check:
            check[c] = -1
        else:
            check[c] = i
    # print(check)
    for i in check:
        # print(check[i])
        if check[i] != -1:
            return check[i]
    return -1


# !driver code
if __name__ == '__main__':
    print(solve(input()))
