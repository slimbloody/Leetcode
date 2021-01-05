class Solution:
    def flipAndInvertImage(self, A):
        """
        :type A: List[List[int]]
        :rtype: List[List[int]]
        """
        return_list = list()
        for item in A:
            for i in range(0, len(item)):
                item[i] = 1 if item[i] == 0 else 0
            return_list.append(item[::-1])
        return return_list

s = Solution()
print(s.flipAndInvertImage([[1,1,0],[1,0,1],[0,0,0]]))
