# Problem: https://www.codechef.com/LRNDSA01/problems/CONFLIP

'''
Time complexity O(n)
Space complexity O()
'''


def solve():
    i, n, q = map(int, input().split())
    # for even number of plays
    if n & 1 == 0:
        return n//2
    # for odd play
    if i == q:
        return n//2
    else:
        return (n+1)//2


# !driver code
if __name__ == '__main__':
    for _ in range(int(input())):
        g = int(input())
        for t in range(g):
            print(solve())
