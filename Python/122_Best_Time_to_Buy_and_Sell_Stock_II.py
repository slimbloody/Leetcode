class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        """
        interpret:
        有数组[a1, ..., an]无序排列, 已知i < j, 求多组(aj - ai)之和所得最大值, (i, j)区间不能重合
        """
        return self.sol_1(prices)

class Solution {
    public int maxProfit(int[] prices) {
        return calculate(prices, 0);
    }

    public int calculate(int prices[], int s) {
        if (s >= prices.length)
            return 0;
        int max = 0;
        for (int start = s; start < prices.length; start++) {
            int maxprofit = 0;
            for (int i = start + 1; i < prices.length; i++) {
                if (prices[start] < prices[i]) {
                    int profit = calculate(prices, i + 1) + prices[i] - prices[start];
                    if (profit > maxprofit)
                        maxprofit = profit;
                }
            }
            if (maxprofit > max)
                max = maxprofit;
        }
        return max;
    }
}

    # brute force
    def sol_1(self, prices):
        pass

    # Peak Valley Approach
    def sol_2(self, prices):
        pass

    # Simple One Pass
    def sol_3(self, prices):
        pass

    # 每日只能买入一次, 可以一日卖出多次
    # s.maxProfit([7,1,5,3,6,4]))  5 + 1 + 3 == 9
    def wrong_sol_4(self, prices):
        total = start = end = 0

        while start < len(prices):
            print(start, end)
            max_prices = prices[start]

            for i in range(start + 1, len(prices)):
                if prices[i] > max_prices:
                    max_prices = prices[i]
                    end = i

            total = total + (prices[end] * (end - start) - sum(prices[start:end]))
            end = start = end + 1

        return total

s = Solution()
print(s.maxProfit([7,1,5,3,6,4])) # 7 5 + 1 + 3 == 9
# Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
# Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
print(s.maxProfit([1,2,3,4,5]))   # 4
# Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
# Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
# engaging multiple transactions at the same time. You must sell before buying again.
print(s.maxProfit([7,6,4,3,1]))   # 0



























