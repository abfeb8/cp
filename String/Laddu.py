# Problem: https://www.codechef.com/LRNDSA01/problems/LADDU

'''
Time complexity O(N) -> number of activities 
Space complexity O(1)
'''


def solve():
    n, origin = map(str, input().split())
    totalLaddu = 0
    for _ in range(int(n)):
        activity_score = list(input().split())
        if activity_score[0] == "CONTEST_WON":
            if int(activity_score[1]) <= 20:
                totalLaddu += 300 + 20 - int(activity_score[1])
            else:
                totalLaddu += 300
        elif activity_score[0] == "TOP_CONTRIBUTOR":
            totalLaddu += 300
        elif activity_score[0] == "BUG_FOUND":
            totalLaddu += int(activity_score[1])
        elif activity_score[0] == "CONTEST_HOSTED":
            totalLaddu += 50

    if origin == "INDIAN":
        return totalLaddu//200
    else:
        return totalLaddu//400


# !driver code
if __name__ == '__main__':
    for _ in range(int(input())):
        print(solve())
