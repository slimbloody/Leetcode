# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children

class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        return self.sol_2(root)

    def sol_1(self, root):
        return_array = list()
        vessel = list()
        vessel.append(root)

        if not root:
            return []

        while vessel:
            return_array.append(vessel[0].val)
            cur = vessel.pop(0)
            vessel = cur.children + vessel

        return return_array

    def sol_2(self, root):

        return_array = list()

        def visit(root):
            if not root:
                return

            return_array.append(root.val)

            for item in root.children:
                visit(item)

        visit(root)

        return return_array


