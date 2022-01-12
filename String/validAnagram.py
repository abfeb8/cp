# Problem: https://leetcode.com/problems/valid-anagram/

'''
Time complexity O(N)
Space complexity O(1)
'''


def solve(s: str, t: str) -> bool:
    setS = set(s)
    setT = set(t)

    if setS == setT:
        for i in setS:
            if s.count(i)!=t.count(i):
                return False
        return True
    else:
        return False


# !driver code
if __name__ == '__main__':
    print(solve(input(), input()))
