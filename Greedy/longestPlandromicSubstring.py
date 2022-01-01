# https://leetcode.com/problems/longest-palindromic-substring/

'''
Time complexity O(n)
Space complexity O(n^3)
'''


def solve(s) -> str:

    n = len(s)

    maxLenPalindrome = s[0]

    for i, c in enumerate(s[:-1]):

        if s[i+1] == c:
            # check for even palindrome
            p1 = i-1
            p2 = i+2
            while(p1 >= 0 and p2 < n):
                if(s[p1] == s[p2]):
                    p1 -= 1
                    p2 += 1
                else:
                    break
            if(len(maxLenPalindrome) < p2-p1-1):
                maxLenPalindrome = s[p1+1:p2]

        if(i-1 >= 0 and s[i-1] == s[i+1]):
            # check for odd palindrome
            p1 = i-1
            p2 = i+1
            while(p1 >= 0 and p2 < n):
                if(s[p1] == s[p2]):
                    p1 -= 1
                    p2 += 1
                else:
                    break
            if(len(maxLenPalindrome) < p2-p1-1):
                maxLenPalindrome = s[p1+1:p2]

    return maxLenPalindrome


# !driver code
if __name__ == "__main__":
    s = input()
    print(solve(s))
