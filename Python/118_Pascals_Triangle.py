class Solution:
    def generate(self, numRows):
        """
        :type numRows: int
        :rtype: List[List[int]]
        """
        return_list = list()

        for i in range(0, numRows):
            a = list()
            length = 2 * i + 1
            a[0] = 1
            a[length - 1] = 1

            cal_list = return_list[numRows - 1]
            a[1: -2] = [
                a[i] + a[i + 1]
                for i in range(len(cal_list) - 1)
            ]
            return_list.append(a)

        return return_list

s = Solution()
print(s.generate(5))

