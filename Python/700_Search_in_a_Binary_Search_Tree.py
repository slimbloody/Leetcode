# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def searchBST(self, root, val):
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """
        return self.sol_2(root, val)

    def sol_1(self, root, val):
        while root:
            if root.val == val:
                return root
            elif root.val < val:
                root = root.right
            elif root.val > val:
                root = root.left

        # python 不写返回值就是None, 不需要这句
        # return None

    def sol_2(self, root, val):
        # 排除root为None的情况
        if not root:
            return None

        if root.val > val:
            return self.sol_2(root.left, val)
        elif root.val < val:
            return self.sol_2(root.right, val)
        else:
            return root






