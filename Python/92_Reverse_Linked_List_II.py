# Input: 1->2->3->4->5->NULL, m = 2, n = 4
# Output: 1->4->3->2->5->NULL
class Solution:
    def reverseBetween(self, head, m, n):
        """
        :type head: ListNode
        :type m: int
        :type n: int
        :rtype: ListNode
        """
        return self.sol_1(head, m, n)

    def sol_1(self, head, m, n):
        cur = head

        count = 0
        while cur is not None:
            count += 1















