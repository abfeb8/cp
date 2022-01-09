# Problem: https://leetcode.com/problems/reshape-the-matrix/

'''
Time complexity O(N) -> every element is visited only ones
Space complexity O(2N) -> storing result and temp arr
'''


def solve(mat: list, r: int, c: int) -> list:
    # to check if the given mat can be converted
    if (r*c != len(mat)*len(mat[0])):
        return mat

    result = []  
    temp = []

    for arr in mat:
        for ele in arr:
            print(ele)
            if len(temp)==c:
                result.append(temp.copy())
                # print(result)
                temp.clear()
                temp.append(ele)
            else:
                temp.append(ele)
                # print(temp)
    
    result.append(temp)
    # print(result)
    return result


# !driver code
if __name__ == '__main__':
    n = int(input())
    mat = []
    for _ in range(n):
        mat.append(list(map(int, input().split())))
    r = int(input())
    c = int(input())
    print(solve(mat, r, c))
