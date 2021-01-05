class Solution:
    def arrayPairSum(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        total = 0
        nums = sorted(nums)
        return sum([nums[i] for i in range(0, len(nums), 2)])

s = Solution()
print(s.arrayPairSum([1,4,3,2]))

