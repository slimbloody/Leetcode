class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        return self.sol_3(nums1, m, nums2, n)

    def sol_1(self, nums1, m, nums2, n):
        i = j = 0
        while i < m and j < n:
            if nums1[i] > nums2[j]:
                for x in range(m, i, -1):
                    nums1[x] = nums1[x - 1]
                nums1[i] = nums2[j]
                i = i + 1
                m = m + 1
                j = j + 1
            else:
                i = i + 1

        while j < n:
            nums1[i] = nums2[j]
            i = i + 1
            j = j + 1

        # return nums1

    # reverse order to accelerate
    def sol_2(self, nums1, m, nums2, n):
        i = m - 1
        j = n - 1
        end = m + n - 1

        while i >= 0 and j >= 0:
            if nums1[i] > nums2[j]:
                nums1[end] = nums1[i]
                end = end - 1
                i = i - 1
            else:
                nums1[end] = nums2[j]
                end = end - 1
                j = j - 1

        #########
        while j >= 0:
            nums1[end] = nums2[j]
            end = end - 1
            j = j - 1
        #########
        # replace
        #########
        # python beatiful solution:
        # if n > 0:
        #    nums1[:n] = nums2[:n]
        #########

        # return nums1

    # c++ short solution:
    # while(n>0) A[m+n-1] = (m==0||B[n-1] > A[m-1]) ? B[--n] : A[--m];

s = Solution()
print(s.merge([0, 0, 0], 0, [1, 2, 3], 3))
print(s.merge([1, 2, 3], 3, [], 0))
print(s.merge([], 0, [], 0))
print(s.merge([1, 3, 5, 0, 0, 0], 3, [2, 4, 6], 3))
print(s.merge([4, 5, 6, 0, 0, 0], 3, [1, 2, 3], 3))
print(s.merge([1, 2, 3, 0, 0, 0], 3, [2, 5, 6], 3))
print(s.merge([-50,-48,-46,-43,-41,-39,-37,-36,-34,-31,-26,-21,-21,-18,-14,-8,-6,-6,-6,-2,-1,0,9,10,15,16,18,19,19,23,24,24,24,31,31,34,35,36,37,38,39,42,45,48,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0], 44, [-44,-43,-42,-39,-38,-36,-35,-34,-33,-31,-28,-26,-26,-24,-21,-20,-16,-14,-11,-9,-9,-9,-9,-8,-5,-4,-3,-3,-2,0,4,5,5,10,11,13,23,24,25,26,27,28,29,31,33,34,35,35,37,38,39,39,43,44], 54))

