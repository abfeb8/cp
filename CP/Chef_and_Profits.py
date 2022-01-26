# Problem:

'''
Time complexity O(n)
Space complexity O()
'''


def solve():
    x, y, z = map(int, input().split())

    return (z-y)*x


# !driver code
if __name__ == '__main__':
    for _ in range(int(input())):
        print(solve())
