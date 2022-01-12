# Problem: https://leetcode.com/problems/ransom-note/

'''
Time complexity O(N)
Space complexity O(1) -> only smallcase letters are stored i.e 26 chars.
'''


def solve(ransomNote: str, magazine: str) -> bool:
    ranCount = dict()
    magCount = dict()

    for char in ransomNote:
        if char in ranCount:
            ranCount[char]+=1
        else:
            ranCount[char]=1

    for char in magazine:
        if char in magCount:
            magCount[char]+=1
        else:
            magCount[char]=1
    
    # print(ranCount, magCount)
    for char in ranCount:
        if char not in magCount or ranCount[char]>magCount[char]:
            return False

    return True


# !driver code
if __name__ == '__main__':
    print(solve(input(), input()))
