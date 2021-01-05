class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        return self.sol_1(s)

    # T: O(n^2) better than leetcode official solution
    # S: O(1)
    def sol_1(self, s):
        length = len(s)
        return_str = temp_str = ""

        for i in range(length):
            left = i - 1
            index = i

            while True:
                if index != length - 1 and s[index] == s[index + 1]:
                    right = index + 1
                    index += 1
                else:
                    right = index + 1
                    break
            #print('left:', left)
            #print('right:', right)

            while left >= 0 and right < length:
                if s[left] == s [right]:
                    left -= 1
                    right += 1
                else:
                    break

            temp_str = s[left + 1: right]
            #print(temp_str)
            if len(temp_str) > len(return_str):
                return_str = temp_str

        return return_str

    def sol_2(self, s):
        pass


def action(input, verdict):
    s = Solution()
    res = s.longestPalindrome(input)
    #print(res)
    assert res in verdict or res == verdict

action('0', '0')
action('101', '101')
action('5101', '101')
action('1017', '101')
action('babad', 'bab')
action('cbbd', 'bb')
action('ccc', 'ccc')



