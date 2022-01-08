# https://leetcode.com/contest/biweekly-contest-69/problems/longest-palindrome-by-concatenating-two-letter-words/

'''
Time complexity O(n)
Space complexity O()
'''


def solve(arr: list):
    leftSid = dict()
    rightSid = dict()
    midEle = dict()
    for i in arr:
        if i[0] == i[1]:
            if i in midEle:
                midEle[i]+=1
            else:
                midEle[i]=1
        elif i in leftSid:
            leftSid[i] += 1
        elif i[::-1] in leftSid:
            if i[::-1] in rightSid:
                rightSid[i[::-1]] += 1
            else:
                rightSid[i[::-1]] = 1
        else:
            leftSid[i] = 1
    # print(leftSid, rightSid, midEle)

    l = 0
    for i in rightSid:
        l += min(rightSid[i], leftSid[i])*4

    takenMid = False
    for i in midEle:
        # print(i)
        if not takenMid:
            if midEle[i]&1!=0: 
                takenMid = True
                l+=((midEle[i]//2)*4)+2
                # print(((midEle[i]//2)*4)+2)
            else:
                l+=(midEle[i]//2)*4
                # print((midEle[i]//2)*4)
        else:
            l+=(midEle[i]//2)*4
            # print((midEle[i]//2)*4)
    return l


# !driver code
if __name__ == "__main__":
    print(solve(["ll","lb","bb","bx","xx","lx","xx","lx","ll","xb","bx","lb","bb","lb","bl","bb","bx","xl","lb","xx"]))
