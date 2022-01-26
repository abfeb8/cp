# Problem:

'''
Time complexity O(n)
Space complexity O()
'''


def solve():
    x = int(input())
    return [x-1, x, x+1]


# !driver code
if __name__ == '__main__':
    for _ in range(int(input())):
        print(*solve())
