class Solution:
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        return self.sol_2(digits)

    def sol_1(self, digits):
        carry = 1
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] + carry < 10:
                digits[i] += 1
                carry = 0
                break
            else:
                digits[i] = (digits[i] + carry) % 10
        if carry:
            digits.insert(0, 1)

        return digits

    def sol_2(self, digits):
        for i in range(len(digits) - 1, -1, -1):
            if digits[i] == 9:
                digits[i] = 0
            else:
                digits[i] += 1
                # the most significant digit that should add one position 
                return digits
        digits.insert(0, 1)
        return digits


s = Solution()
print(s.plusOne([1, 2, 3]))
print(s.plusOne([0]))
print(s.plusOne([9, 9]))
print(s.plusOne([1, 9]))


