class Solution:
    def sortArrayByParity(self, A):
        """
        :type A: List[int]
        :rtype: List[int]
        """
        return self.sol_1(A)
    def sol_1(self, A):
        if not A:
            return []

        even_list = list()
        odd_list = list()
        for item in A:
            if item % 2 == 0:
                even_list.append(item)
            else:
                odd_list.append(item)
        return even_list + odd_list

s = Solution()
print(s.sortArrayByParity([]))
print(s.sortArrayByParity([3, 1, 2, 4]))

