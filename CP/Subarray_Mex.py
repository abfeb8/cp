# Problem: https://www.codechef.com/START23C/problems/SUBMEX

'''
Time complexity O(N)
Space complexity O(X)
'''


def solve():
    n, k, x = map(int, input().split())
    part = []
    if k < x:
        print(-1)
        return
    else:
        for i in range(x-1, -1, -1):
            part.append(i)
    i = 0
    while i < n:
        print(part[i % (x)], end=" ")
        i += 1
    print()
    return


# !driver code
if __name__ == '__main__':
    for _ in range(int(input())):
        solve()
