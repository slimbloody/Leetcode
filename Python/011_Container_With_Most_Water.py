class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: int
        """
        return self.sol_1(height)

    def sol_1(self, height):
        total = 0
        for i in range(0, len(height) - 1):
            for j in range(1, len(height)):
                res = min(height[i], height[j]) * (j - i)
                if res > total:
                    total = res
        return total

s = Solution()
print(s.maxArea([1,8,6,2,5,4,8,3,7]))

