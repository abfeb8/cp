# Problem: https://leetcode.com/problems/valid-parentheses/

'''
Time complexity O(N)
Space complexity O(N)
'''
import collections


def solve(s: str) -> bool:
    stack = collections.deque()
    openB = "({["
    for i in s:
        try:
            # add open brakets to the stack
            if i in openB:
                stack.append(i)
            # check if the closing braket is matching the last braket for the stack
            elif i == ')' and stack.pop() == '(':
                continue
            elif i == '}' and stack.pop() == '{':
                continue
            elif i == ']' and stack.pop() == '[':
                continue
            else:
                return False
        # using exception as we are poping the stack and it can be empty
        except (Exception):
            return False

    # if no open braket is left return true
    if len(stack) == 0:
        return True

    return False


# !driver code
if __name__ == '__main__':
    print(solve(input()))
