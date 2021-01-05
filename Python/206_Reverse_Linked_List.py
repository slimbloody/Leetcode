# Input: 1->2->3->4->5->NULL
# Output: 5->4->3->2->1->NULL

# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseList(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """

        return self.sol_1(head)

    def sol_1(self, head):
        return_node = ListNode(0)

        while head:
            temp = head
            head = head.next
            temp.next = return_node.next
            return_node.next = temp

        return return_node.next

    def get_list(self, head):
        temp = []

        while head:
            temp.append(head.val)
            head = head.next

        return temp

    def build_list(self, temp):
        cur = return_node = ListNode(0)

        for item in temp:
            cur.next = ListNode(item)
            cur = cur.next

        return return_node.next

def check(l):
    s = Solution()
    ll = s.build_list(l)
    ret = s.reverseList(ll)
    print(s.get_list(ret))

check([1, 2, 3, 4])


















