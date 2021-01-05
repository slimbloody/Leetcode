class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        return self.sol_2(nums)

    # 1.先去重, 再排序
    # 2.排序过程去重
    def sol_1(self, nums):
        repository = set()
        hash_place = dict()

        for item in nums:
           hash_place[item] = 2 if item in hash_place else 1
        num_list = sorted(hash_place.keys())

        nums = sorted(nums)
        for i in range(1, len(nums) - 1):
            l, r = 0, len(nums) - 1
            target = 0 - nums[i]

            while l < i and i < r:
                if nums[l] + nums[r] == target:
                    repository.add((nums[l], nums[i], nums[r]))
                    l = l + 1
                    r = r - 1
                elif nums[l] + nums[r] < target:
                    l = l + 1
                else:
                    r = r - 1
        return list(repository)

    # sort the nums
    # make sure the mid number index is the last of the same sequence
    # 确保中间的数字为相同序列的最后一个
    def sol_2(self, nums):
        nums = sorted(nums)
        repository = list()

        for i in range(0, len(nums) - 2):
            if i == 0 or nums[i] != nums[i - 1]:
                l, r = i + 1, len(nums) - 1
                target = 0 - nums[i]

                while l < r:
                    if nums[l] + nums[r] == target:
                        repository.append((nums[i], nums[l], nums[r]))
                        l = l + 1
                        r = r - 1
                    elif nums[l] + nums[r] < target:
                        l = l + 1
                    else:
                        r = r - 1
        return repository

s = Solution()
print(s.threeSum([-1, 0, 1, 2, -1, -4]))
print(s.threeSum([0, 0, 0, 0]))
print(s.threeSum([3,0,-2,-1,1,2]))
print(s.threeSum([-1, -1, 2]))
print(s.threeSum([-1, -1, -1, -1, -1, 2]))

