'''
Time complexity O(N)
Space complexity O(N)
'''


def solve(x: int):
    # negative number and egde cases can't be palindrome
    if x < 0 or (x % 10 == 0 and x != 0):
        return False

    # getting last half of the integer
    y = 0
    while(y < x):
        y = (y*10)+(x % 10)
        x //= 10

    # checking palindrome
    if x == y or x == y//10:
        return True

    return False


# !driver code
if __name__ == "__main__":
    if solve(int(input())):
        print("Y")
    else:
        print("N")
