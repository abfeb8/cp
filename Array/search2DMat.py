# Problem: https://leetcode.com/problems/search-a-2d-matrix/

'''
Time complexity O(n)
Space complexity O()
'''


def solve(matrix: list, target: int) -> bool:
    # binary-search in rows
    n = len(matrix)
    right = n-1
    left = 0
    mid = int()
    while(left <= right and mid < n-1):
        mid = (left+right)//2
        # print("mid: ", mid)
        if matrix[mid][0] > target:
            right = mid-1
            continue
        elif (mid == n-1) or (matrix[mid][0] <= target and matrix[mid+1][0] > target):
            break
        else:
            left = mid+1

    # print('result: ', mid)

    # binary search row
    row = matrix[mid]
    # print('row:', row)
    n = len(row)
    left = 0
    right = n-1
    while (left <= right):
        mid = (left+right)//2
        if row[mid] == target:
            # print('index', mid)
            return True
        elif row[mid] > target:
            right = mid-1
        else:
            left = mid + 1

    return False


# !driver code
if __name__ == '__main__':
    print(solve([[3, 4, 5, 7], [10, 11, 16, 20], [23, 30, 34, 60]],
                61))
