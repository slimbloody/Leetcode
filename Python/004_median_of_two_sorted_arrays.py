# 1 2 3 == 1
# 0 1 2

# 1 2 3 4 == 2
# 0 1 2 3

class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        return self.sol_2(nums1, nums2)

    # T O(n)
    # S O(n)
    def sol_1(self, nums1, nums2):
        array = list()
        i = j = 0
        while i < len(nums1) and j < len(nums2):
            if nums1[i] > nums2[j]:
                array.append(nums2[j])
                j = j + 1
            else:
                array.append(nums1[i])
                i = i + 1

        array.extend(nums1[i:])
        array.extend(nums2[j:])

        length = len(array)
        index = length // 2

        if length % 2 == 0:
            return (array[index - 1] + array[index]) / 2
        else:
            return array[index]

    # sol_2 is slower then sol_1
    # stop judge when index == count - 1
    # T O(n)
    # S O(n)
    def sol_2(self, nums1, nums2):
        def judge(array, count, index, is_odd):
            if count - 1 == index:
                if is_odd:
                    return array[index]
                else:
                    return (array[index - 1] + array[index]) / 2
            else:
                return None

        len_nums1 = len(nums1)
        len_nums2 = len(nums2)

        len_total = len_nums1 + len_nums2
        index = len_total // 2

        if len_total % 2 == 0:
            is_odd = False
        else:
            is_odd = True

        array = list()
        i = j = 0
        count = 0
        while i < len_nums1 and j < len_nums2:
            if nums1[i] > nums2[j]:
                array.append(nums2[j])
                j = j + 1
            else:
                array.append(nums1[i])
                i = i + 1
            count = count + 1

            result = judge(array, count, index, is_odd)
            if result is not None:
                return result

        while i < len_nums1:
            array.append(nums1[i])
            i = i + 1
            count = count + 1
            result = judge(array, count, index, is_odd)
            if result is not None:
                return result

        while j < len_nums2:
            array.append(nums2[j])
            j = j + 1
            count = count + 1
            result = judge(array, count, index, is_odd)
            if result is not None:
                return result

s = Solution()
print(s.findMedianSortedArrays([1, 2, 3, 4], []))
print(s.findMedianSortedArrays([], [2, 3]))
print(s.findMedianSortedArrays([3], [-2, -1]))
print(s.findMedianSortedArrays([1, 3], [2]))

