# Problem: https://leetcode.com/problems/search-a-2d-matrix/

'''
Time complexity O(n)
Space complexity O()
'''


def solve(matrix: list, target: int) -> bool:
    # binary-search in rows
    n = len(matrix)
    m = len(matrix[0])
    left = 0
    right = m*n-1
    print(left, right)
    while(left <= right):
        mid = (left+right)//2
        # print(mid//m, mid % m)
        char = matrix[mid//m][mid % m]
        if(char == target):
            return True
        elif (char > target):
            right = mid-1
        else:
            left = mid+1
    return False


# !driver code
if __name__ == '__main__':
    print(solve([[3, 4, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]], 11))
