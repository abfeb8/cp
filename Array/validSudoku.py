# Problem: https://leetcode.com/problems/valid-sudoku/

'''
Time complexity O(1)
Space complexity O(1)
'''


def solve(board: list) -> bool:
    check = set()
    for i in range(9):

        # check row
        check.clear()
        for j in range(9):
            char = board[i][j]
            if(char != "."):
                if char in check:
                    return False
                else:
                    check.add(char)

        # check cloumn
        check.clear()
        for j in range(9):
            char = board[j][i]
            if(char != "."):
                if char in check:
                    return False
                else:
                    check.add(char)

    # check box
    for i in range(0, 9, 3):
        for j in range(0, 9, 3):
            check.clear()
            print(i,j)
            for k in range(i, i+3):
                for l in range(j, j+3):
                    char = board[k][l]
                    
                    if(char != "."):
                        print(char, end=" ")
                        if char in check:
                            return False
                        else:
                            check.add(char)

    return True


# !driver code
if __name__ == '__main__':
    print(solve([
        [".", ".", ".", ".", "5", ".", ".", "1", "."], 
        [".", "4", ".", "3", ".", ".", ".", ".", "."], 
        [".", ".", ".", ".", ".", "3", ".", ".", "1"], 
        ["8", ".", ".", ".", ".", ".", ".", "2", "."], 
        [".", ".", "2", ".", "7", ".", ".", ".", "."], 
        [".", "1", "5", ".", ".", ".", ".", ".", "."], 
        [".", ".", ".", ".", ".", "2", ".", ".", "."], 
        [".", "2", ".", "9", ".", ".", ".", ".", "."], 
        [".", ".", "4", ".", ".", ".", ".", ".", "."]]))
