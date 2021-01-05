class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        return self.sol_1(s)

    def sol_1(self, s):
        str_dict = dict()

        for item in s:
            if item in str_dict:
                str_dict[item] += 1
            else:
                str_dict[item] = 1


