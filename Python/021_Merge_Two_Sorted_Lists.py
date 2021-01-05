# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """

        return self.sol_3(l1, l2)

    # iteratively
    def sol_1(self, l1, l2):
        return_node = cur = ListNode(0)

        while l1 and l2:
            if l1.val >= l2.val:
                cur.next = l2
                l2 = l2.next
            else:
                cur.next = l1
                l1 = l1.next
            tmp = return_node
        cur.next = l1 or l2
        return return_node.next

    # recursive solution is ugly, pass it!
    def sol_2(self, l1, l2):
        if not (l1 or l2):
            return l1 or l2

        if l1.val < l2.val:
            l1.next = self.sol_2(l1.next, l2)
            return l1
        else:
            l2.next = self.sol_2(l1, l2.next)
            return l2

    # in-place, iteratively
    # insert l2 element into l1
    def sol_3(self, l1, l2):
        if not (l1 or l2):
            return l1 or l2

        return_node = cur = ListNode(0)
        cur.next = l1
        while l1 and l2:
            if l1.val < l2.val:
                l1 = l1.next
            else:
                nxt = cur.next
                cur.next = l2

                tmp = l2.next
                l2.next = nxt
                l2 = tmp
            cur = cur.next
        cur.next = l1 or l2
        return return_node.next

    def build_list(self, a):
        if not a:
            return None

        cur = return_node = ListNode(a[0])

        for i in range(1, len(a)):
            cur.next = ListNode(a[i])
            cur = cur.next

        return return_node

    def to_list(self, node):
	    a = list()
	    while node:
	        a.append(node.val)
	        node = node.next
	    return a

s = Solution()
l1 = s.build_list([1, 2, 4])
l2 = s.build_list([1, 3, 4])
print(s.to_list(s.mergeTwoLists(l1, l2)))

# l1 = s.build_list([])
# l2 = s.build_list([])
# print(s.to_list(s.mergeTwoLists(l1, l2)))

# l1 = s.build_list([1, 2, 4])
# l2 = s.build_list([])
# print(s.to_list(s.mergeTwoLists(l1, l2)))

# l1 = s.build_list([])
# l2 = s.build_list([1, 3, 4])
# print(s.to_list(s.mergeTwoLists(l1, l2)))

