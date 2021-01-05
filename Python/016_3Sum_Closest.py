class Solution:
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        return self.sol_3(nums, target)

    def sol_1(self, nums, target):
        import itertools
        combinations = itertools.combinations(nums, 3)

        total = sum(next(combinations))
        for item in combinations:
            if abs(sum(item) - target) < abs(total - target):
                total = sum(item)

        return total

    def sol_2(self, nums, target):
        pass

    # same thinking like 3Sum
    def sol_3(self, nums, target):
        nums = sorted(nums)
        length = len(nums)
        total = nums[0] + nums[1] + nums[-1]

        for i in range (length - 2):
            l, r = i + 1, length - 1

            while l < r:
                temp_sum = nums[i] + nums[l] + nums[r]
                if abs(temp_sum - target) < abs(total - target):
                    total = temp_sum

                    if total == target:
                        return total

                if temp_sum < target:
                    l += 1
                else:
                    r -= 1

        return total

s = Solution()
# print(s.threeSumClosest([-1,2,1,-4], 1)) # 2
# print(s.threeSumClosest([0, 1, 2], 3)) # 3
print(s.threeSumClosest([0, 2, 1, -3], 1)) # 0
# [-3, 0, 1, 2]
