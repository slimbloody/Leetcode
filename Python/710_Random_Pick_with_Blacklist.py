class Solution:

    def __init__(self, N, blacklist):
        """
        :type N: int
        :type blacklist: List[int]
        """
        self.item = [
            i for i in range(0, N)
            if i not in blacklist
        ]

    def pick(self):
        """
        :rtype: int
        """


# Your Solution object will be instantiated and called as such:
# obj = Solution(N, blacklist)
# param_1 = obj.pick()
