# Problem: https://www.codechef.com/LRNDSA01/problems/FCTRL

'''
Time complexity O(log5(N))
Space complexity O(1)
'''


def solve():
    n = int(input())
    count = 0
    curr = 5
    while (curr <= n):
        count += (n//curr)
        curr *= 5
    return count


# !driver code
if __name__ == '__main__':
    for _ in range(int(input())):
        print(solve())
