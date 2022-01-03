'''
Time complexity O(N)
Space complexity O(1)
'''


def solve(s: str):
    # Read in and ignore any leading whitespace.
    s = s.strip()

    # Check if the next character (if not already at the end of the string) is '-' or '+'.
    # Read this character in if it is either. This determines if the final result is negative or positive respectively.
    # Assume the result is positive if neither is present.
    n = len(s)
    isPositive = True
    if(n > 0):
        if(s[0] == '-'):
            # negtive number
            isPositive = False
            s = s[1:]
        elif(s[0] == '+'):
            s = s[1:]

    # Read in next the characters until the next non-digit character or the end of the input is reached.
    # The rest of the string is ignored.
    for i, c in enumerate(s):
        if(not c.isdigit()):
            s = s[:i]

    # Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32).
    # If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
    if(len(s)>0):
        if(not isPositive):
            s = int(s)*-1
        else:
            s = int(s)
    else:
        return 0
    # If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1], then clamp the integer so that it remains in the range.
    # Specifically, integers less than -2^31 should be clamped to -2^31, and integers greater than 231 - 1 should be clamped to 231 - 1.
    min = -2147483648
    max = 2147483647
    if(s > max):
        s = max
    elif(s < min):
        s = min

    # Return the integer as the final result.
    return s


# !driver code
if __name__ == "__main__":
    print(solve(input()))
