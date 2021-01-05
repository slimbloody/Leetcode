# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
# Output: (7 -> 0 -> 8)
# Explanation: 342 + 465 = 807.
# Definition for singly-linked list.

# Definition for singly-linked list.

def build_list(l):
    if not l:
        return None
    return_node = ListNode(l[0])
    cur_node = return_node
    l = l[1:]

    for item in l:
        cur_node.next = ListNode(item)
        cur_node = cur_node.next

    return return_node

def list_recursive(l):
    temp_list = list()
    while l:
        print(l.val)
        l = l.next

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        return self.sol_3(l1, l2)

    # O(n)
    # T(n)
    def sol_1(self, l1, l2):
        def calculate_list(l):
            total = 0
            count = 0
            while l:
                total = (10 ** count) * l.val + total
                count += 1
                l = l.next
            return total

        num_1 = calculate_list(l1)
        num_2 = calculate_list(l2)
        total = num_1 + num_2

        remainder = total % 10
        total = total // 10
        return_node = ListNode(remainder)
        cur_node = return_node

        print('remainder:', remainder)
        print('total:', total)

        while total > 0:
            remainder = total % 10
            total = total // 10
            print('remainder:', remainder)
            print('total:', total)
            cur_node.next = ListNode(remainder)
            cur_node = cur_node.next

        return return_node

    # O(n)
    # T(n)
    def sol_2(self, l1, l2):
        temp_list = list()
        carry = 0
        while l1 or l2 or carry:
            if l1:
                a = l1.val
                l1 = l1.next
            else:
                a = 0
            if l2:
                b = l2.val
                l2 = l2.next
            else:
                b = 0
            c = a + b + carry
            if c >= 10:
                c = c - 10
                carry = 1
            else:
                carry = 0
            temp_list.append(c)

        print(temp_list)
        return_node = ListNode(temp_list[0])
        cur_node = return_node
        for i in range(1, len(temp_list)):
            cur_node.next = ListNode(temp_list[i])
            cur_node = cur_node.next

        return return_node

    # O(n)
    # T(n)
    def sol_3(self, l1, l2):
        carry = 0
        root = n = ListNode(0)
        while l1 or l2 or carry:
            v1 = v2 = 0
            if l1:
                v1 = l1.val
                l1 = l1.next
            if l2:
                v2 = l2.val
                l2 = l2.next
            carry, val = divmod(v1 + v2 + carry, 10)
            n.next = ListNode(val)
            n = n.next
        return root.next

s = Solution()
#a = [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1]
#b = [5,6,4]
a=[2,4,3]
b=[5,6,4]
lfinal = s.addTwoNumbers(build_list(a), build_list(b))
list_recursive(lfinal)


