'''
Time complexity O(N)
Space complexity O(N)
'''


def solve(x: int):
    # negative number can't be palindrome
    if x < 0:
        return False

    # all single digit numbers are palindrome
    if x < 10:
        return True

    l = list()
    # n -> index of last element of l
    n = 0
    while(x > 9):
        l.append(x % 10)
        x //= 10
        n += 1

    # adding last element to the list
    l.append(x)
    
    # checking palindrome
    p = 0
    while (p < n):
        if(l[p] != l[n]):
            return False
        p += 1
        n -= 1

    return True


# !driver code
if __name__ == "__main__":
    if solve(int(input())):
        print("Y")
    else:
        print("N")
