# C(m, n) = n!/m!(n - m)!

class Solution:
    def getRow(self, rowIndex):
        """
        :type rowIndex: int
        :rtype: List[int]
        """
        return self.sol_1(rowIndex)

    def sol_1(self, rowIndex):
        def calculation(m, n):
            def factorial(num):
                from functools import reduce
                return reduce(lambda x, y: x * y, range(1, num + 1), 1)
            return factorial(n) / (factorial(m) * factorial(n - m))

        return [
            calculation(i, rowIndex) for i in range(0, rowIndex + 1)
        ]

    def sol_2(self, rowIndex):
        pass

s = Solution()
print(s.getRow(1))
print(s.getRow(2))
print(s.getRow(3))


