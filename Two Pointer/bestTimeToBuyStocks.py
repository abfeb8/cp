# Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

'''
Time complexity O(N)
Space complexity O(1)
'''


def solve(prices: list) -> int:
    currMinPrice = prices[0]
    maxProfit = 0
    p1 = 0
    for p2, price in enumerate(prices):
        if price <= prices[p1]:
            p1 = p2
            currMinPrice = price
        else:
            maxProfit = max(maxProfit, price-currMinPrice)
    return maxProfit


# !driver code
if __name__ == '__main__':
    print(solve(list(map(int, input().split()))))
