# Problem: https://www.codechef.com/LRNDSA01/problems/ZCO14003

'''
Time complexity O(n)
Space complexity O()
'''


def solve():
    n = int(input())
    arr = []
    for _ in range(n):
        arr.append(int(input()))

    maxRev = 0
    arr.sort()
    for i, k in enumerate(arr):
        maxRev = max(maxRev, k*(n-i))

    return maxRev


# !driver code
if __name__ == '__main__':
    print(solve())
