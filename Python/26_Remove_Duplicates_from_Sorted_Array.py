class Solution:
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.sol_1(nums)

    def sol_1(self, nums):
        return len(nums) - len(set(nums)) + 1

