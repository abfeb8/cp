# https://leetcode.com/problems/letter-combinations-of-a-phone-number/

class Solution:
    def letterCombinations(self, digits: str) -> list[str]:
        result = []
        phone = ["0", "1", "abc", "def", "ghi",
                 "jkl", "mno", "pqrs", "tuv", "wxyz"]

        if(len(digits) == 0):
            return result

        result.append("")

        for l, c in enumerate(digits):
            curList = list(phone[int(c)])
            while(len(result[0]) == l):
                curCh = result.pop(0)
                for s in curList:
                    result.append(curCh+s)

        return result
