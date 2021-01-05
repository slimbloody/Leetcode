# Only the space character ' ' is considered as whitespace character.
# INT_MAX (231 − 1) or INT_MIN (−231) is returned.

# Input: "42"
# Output: 42

# Input: "   -42"
# Output: -42
# Explanation: The first non-whitespace character is '-', which is the minus sign.
#              Then take as many numerical digits as possible, which gets 42.

# Input: "4193 with words"
# Output: 4193
# Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

# Input: "words and 987"
# Output: 0
# Explanation: The first non-whitespace character is 'w', which is not a numerical
#              digit or a +/- sign. Therefore no valid conversion could be performed.

# Input: "-91283472332"
# Output:  -2147483648
# Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
#              Thefore INT_MIN (−231) is returned.


# 计算机组成原理 补码 反码
class Solution:
    def myAtoi(self, str):
        """
        :type str: str
        :rtype: int
        """
        return self.sol_1(str)

    def sol_1(self, string):
        string = string.strip()
        total = 0
        sign = 1
        index = 0

        if string[1] == '-1':
            sign = -1
            index = 1

        for i in range(index, len(string)):
            total = total * 10 + int(string[i])

        total = total * sign

    def sol_2(self, string):
        num = int(string)










































