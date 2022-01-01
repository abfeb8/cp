# https://leetcode.com/problems/longest-palindromic-substring/

'''
Time complexity O(n^2)
Space complexity O(1)
'''


def getMaxLenPalindrome(p1, p2, s, maxLenPalindrome):
    while(p1 >= 0 and p2 < len(s)):
        if(s[p1] == s[p2]):
            p1 -= 1
            p2 += 1
        else:
            break
    if(len(maxLenPalindrome) < p2-p1-1):
        maxLenPalindrome = s[p1+1:p2]

    return maxLenPalindrome


def solve(s) -> str:
    # string will always have a unit length palindrome 
    maxLenPalindrome = s[0]

    for i, c in enumerate(s[:-1]):

        if s[i+1] == c:
            # check for even palindrome
            p1 = i-1
            p2 = i+2
            maxLenPalindrome = getMaxLenPalindrome(p1, p2, s, maxLenPalindrome)

        if(i-1 >= 0 and s[i-1] == s[i+1]):
            # check for odd palindrome
            p1 = i-1
            p2 = i+1
            maxLenPalindrome = getMaxLenPalindrome(p1, p2, s, maxLenPalindrome)

    return maxLenPalindrome


# !driver code
if __name__ == "__main__":
    s = input()
    print(solve(s))
