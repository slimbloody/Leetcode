# Input: numbers = [2,7,11,15], target = 9
# Output: [1,2]
# Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.

class Solution:
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        return self.sol_1(numbers, target)

    def sol_1(self, numbers, target):
        length = len(numbers)
        for index1 in range(0, length - 1):
            other_num = target - numbers[index1]
            low = index1 + 1
            high = length - 1

            while low <= high:
                mid = (low + high) // 2
                if numbers[mid] < other_num:
                    low = mid + 1
                elif numbers[mid] > other_num:
                    high = mid - 1
                else:
                    return [index1 + 1, mid + 1]

    # similar to 002 use hashing
    def sol_2(self, numbers, target):
        temp_dict = dict()

        for i, num in enumerate(numbers):
            if target - num in temp_dict:
                return [dict[target - num] + 1, i + 1]
            temp_dict[num] = i

    #
    def sol_3(self, numbers, target):
        l, r = 0, len(numbers)-1
        while l < r:
            s = numbers[l] + numbers[r]
            if s == target:
                return [l + 1, r + 1]
            elif s < target:
                l += 1
            else:
                r -= 1
# 0 1 2 3 4
s = Solution()
print(s.twoSum([2,7,11,15], 9))  # [0, 1]
print(s.twoSum([2,7,11,15], 13)) # [0, 2]
print(s.twoSum([2,7,11,15], 18)) # [1, 2]
print(s.twoSum([2,7], 9))        # [0, 1]
print(s.twoSum([2,7,11,15], 26)) # [2, 3]


