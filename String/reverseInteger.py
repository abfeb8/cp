'''
Time complexity O(N)
Space complexity O(1)
'''
def solve(x:int):
    min = -2**31
    max = 2**31-1
    if(x>=0):
        s = int(str(x)[::-1])
        if s>max:
            return 0
    else:
        s = int(str(x)[1::][::-1])*-1
        if s<min:
            return 0
    return s


# !driver code
if __name__ == "__main__":
    n = int(input())
    print(solve(n))