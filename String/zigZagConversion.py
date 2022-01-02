'''
Time complexity O(n) -> Since every elemnet is visited only once
Space complexity O(1) -> storing only result
'''


def solve(s: str, numRows: int):
    # edge case
    if numRows == 1:
        return s
    # empty string to store result
    result = ""
    # this is the gap between 1st char and 2nd char in zigZagString
    gap = (2*numRows)-2
    # solution
    '''
    normal position: 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
    zigZag position: 1 7 13 2 6 8 12 14 3 5 9 11 15 4 10 16

    there is a pattern between the distance of indexes of each row
    1    7      13  -> 6,6,6
    2  6 8   12 14  -> 4,2,4,2
    3 5  9 11   15  -> 2,4,2,4
    4    10     16  -> 6,6,6
    '''
    strLen = len(s)
    for i in range(numRows):
        firstJump = 2*i
        secondJump = gap-firstJump
        curIndex = i
        turn = 0
        while (curIndex < strLen):
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
