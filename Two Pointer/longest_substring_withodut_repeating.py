# https://leetcode.com/problems/longest-substring-without-repeating-characters/

'''
Time complexity O(n)
Space complexity O(n)
'''


def solve(s: str) -> int:
    n = len(s)

    # if the string is empty or has only one char
    if n < 2:
        return n

    # initialising a dict to store visited characters
    check = dict()

    # initialising pointer
    p1 = 0

    # initialising maxLen variable
    maxLen = 0

    # iterating over s
    for p2, char in enumerate(s):

        if(char in check and check[char] >= p1):
            maxLen = max(maxLen, p2-p1)
            p1 = check[char]+1

        check[char] = p2

    # if no repeting char is found in the end of the string
    maxLen = max(maxLen, p2-p1+1)

    return maxLen


# !driver code
if __name__ == "__main__":
    s = input()
    print(solve(s))
