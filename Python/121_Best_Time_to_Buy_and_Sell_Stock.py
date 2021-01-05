class Solution:
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """

        """
        interpret:
        有数组[a1, ..., an]无序排列, 已知i < j, 求aj - ai 所得最大值
        """
        return self.sol_2(prices)


    # brutely solve
    # T O(n ^ 2)
    def sol_1(self, prices):
        max_profit = 0
        for i in range(len(prices) - 1):
            for j in range(i + 1, len(prices)):
                diff = prices[j] - prices[i]

                if max_profit < diff:
                    max_profit = diff
        return max_profit

    # 单次买卖, 如果拿到了最低值, 只用看后面有没有比这个最低值更低的
    # 并且拿其他值比较看看会不会收益更大
    # T O(n)
    def sol_2(self, prices):
        max_profit = 0
        min_price = max(prices or [0]) # max() arg is an empty sequence
        for price in prices:
            if price < min_price:
                min_price = price
            else:
                if price - min_price > max_profit:
                    max_profit = price - min_price

        return max_profit


s = Solution()
print(s.maxProfit([7,1,5,3,6,4]))  # 5
print(s.maxProfit([7,6,4,3,1]))    # 0
print(s.maxProfit([0,0,0,0,0]))    # 0
print(s.maxProfit([]))    # 0


