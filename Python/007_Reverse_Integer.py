# Input: 123
# Output: 321

# Input: -123
# Output: -321

# Input: 120
# Output: 21

class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        return self.sol_2(x)

    def sol_1(self, x):
        array = list()
        if x > (2 ^ 31 - 1) or x < -(2 ^ 31):
            return 0
        if x > 0:
            is_pos = True
        elif x < 0:
            is_pos = False
            x =  abs(x)
        elif x == 0:
            return 0
        else:
            raise ValueError


        while x != 0:
            array.append(x % 10)
            x = x // 10

        total = 0
        for num in array:
            total = total * 10 + num

        return total if is_pos else total * -1

    def sol_2(self, x):
        max_int = 2 ** 31 - 1
        min_int = -(2 ** 31)
        if x > max_int or x < min_int:
            return 0

        if x < 0:
            sign = -1
            x = abs(x)
        else:
            sign = 1

        res = int(str(x)[::-1]) * sign
        return res if min_int < res < max_int else 0

s = Solution()
print(s.reverse(123))
print(s.reverse(-123))
print(s.reverse(120))
print(s.reverse(1534236469))

