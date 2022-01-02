'''
Time complexity O(n)
Space complexity O(1)
'''


def getLine(s: str, startIndex: int, firstJump: int, secondJump: int, n: int):
    line = ""
    curIndex = startIndex
    turn = 0
    while (curIndex < len(s)):
        if (turn & 1 == 0 and firstJump != 0):
            line += s[curIndex]
            curIndex += firstJump
        elif(secondJump != 0):
            line += s[curIndex]
            curIndex += secondJump
        turn += 1
    return line


def solve(s: str, numRows: int):
    if numRows == 1:
        return s

    result = ""

    gap = (2*numRows)-2

    for i in range(numRows):
        firstJump = 2*i
        secondJump = gap-firstJump
        result += getLine(s, i, secondJump, firstJump, numRows)

    return result


# !driver code
if __name__ == "__main__":
    s = input()
    n = int(input())
    print(solve(s, n))
