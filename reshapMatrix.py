# Problem: https://leetcode.com/problems/reshape-the-matrix/

'''
Time complexity O(N*M) -> every element is visited only ones
Space complexity O(2N*M) -> storing result and flat array
'''


def solve(mat: list, r: int, c: int) -> list:
    # to check if the given mat can be converted
    if (r*c != len(mat)*len(mat[0])):
        return mat

    flat = []
    for arr in mat:
        for ele in arr:
            flat.append(ele)
 
    result = []
    for i in range(r):
        print(i*c,i*c+c)
        result.append(flat[i*c:i*c+c])

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
