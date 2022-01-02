'''
Time complexity O(n) -> Since every elemnet is visited only once
Space complexity O(1) -> storing only result
'''

def solve(s: str, numRows: int):
    # edge case 
    if numRows == 1:
        return s

    result = ""

    gap = (2*numRows)-2

    for i in range(numRows):
        firstJump = 2*i
        secondJump = gap-firstJump
        curIndex = i
        turn = 0
        while (curIndex < len(s)):
            if (turn & 1 == 1 and firstJump != 0):
                result += s[curIndex]
                curIndex += firstJump
            elif(secondJump != 0):
                result += s[curIndex]
                curIndex += secondJump
            turn += 1

    return result


# !driver code
if __name__ == "__main__":
    s = input()
    n = int(input())
    print(solve(s, n))
