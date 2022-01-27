# Problem: https://www.codechef.com/START23C/problems/SUBARRAYXOR

'''
Time complexity O(N)
Space complexity O(N)
'''


def preprocess():
    limit = int(1e5+5)
    result = [0]*limit
    result[0] = 1

    for i in range(1, limit):
        result[i] = (i+1) ^ i

    return result


def solve():
    n = int(input())
    return arr[:n]


# !driver code
if __name__ == '__main__':
    arr = preprocess()
    for _ in range(int(input())):
        print(*solve())
