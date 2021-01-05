class Solution:
    def searchInsert(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        return self.sol_1(nums, target)

    def sol_1(self, nums, target):
        low = 0
        high = len(nums) - 1

        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                return mid
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return low

s = Solution()
print(s.searchInsert([1,3,5,6], 5)) # Output: 2
print(s.searchInsert([1,3,5,6], 2)) # Output: 1
print(s.searchInsert([1,3,5,6], 7)) # Output: 4
print(s.searchInsert([1,3,5,6], 0)) # Output: 0

