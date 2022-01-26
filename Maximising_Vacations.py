# Problem: https://www.codechef.com/START23C/problems/MAXVAC

'''
Time complexity O(N^2)
Space complexity O(X)
'''


def solve():
    n, x = map(int, input().split())
    s = list(input())
    c = ['0']*x
    maxVacation = 0
    k = 0
    while k <= n-x:
        if s[k:k+x] == c:
            maxVacation += 1
            k += x
            # print(1)
        else:
            k += 1

    for i in range(n):
        if s[i] == '1':
            k = 0
            s[i] = '0'
            currCount = 0
            while k <= n-x:
                # print(s[k:k+x])
                if s[k:k+x] == c:
                    currCount += 1
                    k += x
                    # print(s[k:k+x])
                else:
                    k += 1
            s[i] = '1'
            maxVacation = max(currCount, maxVacation)

    return maxVacation


# !driver code
if __name__ == '__main__':
    for _ in range(int(input())):
        print(solve())
