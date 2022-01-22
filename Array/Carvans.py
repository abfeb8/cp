# Problem:

'''
Time complexity O(N) 
Space complexity O(N)
'''


def solve():
    n = int(input())
    arr = list(map(int, input().split()))
    currMax = arr[0]
    count = 0
    for i in arr:
        if i <= currMax:
            count += 1
            currMax = min(currMax, i)
    return count


# !driver code
if __name__ == '__main__':
    for _ in range(int(input())):
        print(solve())
