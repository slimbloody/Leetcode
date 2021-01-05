class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        return self.twoSum_2(nums, target)

    # T O(n^2)
    # S O(1)
    def twoSum_1(self, nums, target):
        for i in range(0, len(nums) - 1):
            for j in range(i + 1, len(nums)):
                if nums[i] + nums[j] == target:
                    return [min(i, j), max(i, j)]
    # one-pass hashtable
    # T O(n)
    # S O(n)
    def twoSum_2(self, nums, target):
        buffer_dict = dict()
        for i in range(0, len(nums)):
            a = target - nums[i]
            b = buffer_dict.get(a, None)
            if b is not None:
                return [min(i, b), max(i, b)]
            else:
                buffer_dict[nums[i]] = i

    # one-pass hashtable
    # T O(n)
    # S O(n) = O(n)(存储) + O(1)(检索)
    # 完整存储一次hashtable再做检索

s = Solution()
print(s.twoSum([2,7,11,15], 9))







