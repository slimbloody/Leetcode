class Solution:
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        return self.sol_3(x)

    def sol_1(self, x):
        if x == 0:
            return True
        if x % 10 == 0 or x < 0:
            return False
        else:
            a = list()
            while x != 0:
                a.append(x % 10)
                x //= 10

            total_len = len(a)
            end = total_len // 2
            for i in range(0, end):
                if a[i] != a[total_len - 1 - i]:
                    return False
            return True

    # fastest
    def sol_2(self, x):
        string = str(x)
        length = len(string)
        for i in range(0, length // 2 + 1):
            if string[i] != string[length - i - 1]:
                return False

        return True

    def sol_3(self, x):
        if  (x != 0 and x % 10 == 0) or x < 0:
            return False

        y = 0
        while y < x:
            y = x % 10 + y * 10
            x //= 10

        return x == y or y // 10 == x

    def sol_4(self, x):
        return int(str(abs(x))[::-1]) == x


s = Solution()
assert s.isPalindrome(0) is True
assert s.isPalindrome(1) is True
assert s.isPalindrome(123) is False
assert s.isPalindrome(-123) is False
assert s.isPalindrome(10) is False
assert s.isPalindrome(101) is True
assert s.isPalindrome(1001) is True

