# https://www.codechef.com/LRNDSA06/problems/COG2002

'''
Time Complexity O(N)
Space Complxity O(1)
'''

def solve():
    n = int(input())
    arr = list(map(int, input().split()))
    maxRating = 0
    for i in range(n-2):
        maxRating = max(maxRating, sum(arr[i:i+3]))

    maxRating = max(
        max(maxRating, arr[n-2]+arr[n-1]+arr[0]), arr[n-1]+arr[0]+arr[1])

    return maxRating


t = int(input())
for _ in range(t):
    print(solve())