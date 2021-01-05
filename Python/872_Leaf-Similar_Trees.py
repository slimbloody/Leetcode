# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def leafSimilar(self, root1, root2):
        """
        :type root1: TreeNode
        :type root2: TreeNode
        :rtype: bool
        """
        return self.sol_1(root1, root2)

    def sol_1(self, root1, root2):
        def get_leaf(root):
            if not root:
                return list()

            return_array = list()
            vessal = [root]
            while vessal:
                top = vessal.pop(0)
                if top.right:
                    vessal.insert(0, top.right)
                if top.left:
                    vessal.insert(0, top.left)
                if not (top.left or top.right):
                    return_array.append(top.val)


            return return_array

        a1 = get_leaf(root1)
        a2 = get_leaf(root2)

        return set(a1) == set(a2)

class Tree:
    def __init__(self, val):
        self.val = val
        self.left = None
        self.right = None

    def add(self, val):
        pass


