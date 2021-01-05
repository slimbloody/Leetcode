# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.sol_1(root)

    def sol_1(self, root):
        if not root:
            return 0

        depth = 0
        vessal = [(root, 1)]
        while vessal:
            top = vessal.pop(0)
            cur_node, height = top

            if height > depth:
                depth = height

            if cur_node.right:
                vessal.insert(0, (cur_node.right, height + 1))
            if cur_node.left:
                vessal.insert(0, (cur_node.left, height + 1))

        return depth

    def sol_2(self, root):
        if not root:
            return 0

        if not (root.left or root.right):
            return 1

        return 1 + max(self.sol_2(root.left), self.sol_2(root.right))




