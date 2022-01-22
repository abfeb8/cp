# Problem: https://www.codechef.com/LRNDSA01/problems/LAPIN

'''
Time complexity O(N)
Space complexity O(N) -> keeping count of frequency
'''


def solve():
    s = input()
    n = len(s)
    # to keep frequency of characters
    charFreq = {}
    # iterating from both side of string
    # for char in left side : add 1 to frequency of character
    # for char in right side : subtract 1 from frequency of character
    for i in range(n//2):
        p1 = i
        p2 = n-i-1
        charFreq[s[p1]] = charFreq.get(s[p1], 0)+1
        charFreq[s[p2]] = charFreq.get(s[p2], 0)-1

    for i in charFreq.values():
        if i != 0:
            return "NO"
    return "YES"


# !driver code
if __name__ == '__main__':
    for _ in range(int(input())):
        print(solve())
