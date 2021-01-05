# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.sol_3(root)

    def sol_1(self, root):
        if not root:
            return 0

        # 0: left   1: right
        vessal = [(root, 1)]  # 只有一个节点不计算
        val_list = list()

        while vessal:
            top, direction = vessal.pop(0)
            print('val:', top.val)

            if not (top.left or top.right):
                if direction == 0:
                    val_list.append(top.val)
            if top.right:
                vessal.insert(0, (top.right, 1))
            if top.left:
                vessal.insert(0, (top.left, 0))

        return sum(val_list)


    # slower than sol_1 but more adaptive than than sol_1
    def sol_2(self, root):
        if not root:
            return 0

        vessal = [root]  # 只有一个节点不计算
        ans = 0

        while vessal:
            top = vessal.pop(0)

            if top.right:
                vessal.insert(0, top.right)
            if top.left:
                if top.left.left is None and top.left.right is None:
                    ans += top.left.val
                else:
                    vessal.insert(0, top.left)

        return ans

    # recursive
    def sol_3(self, root):
        if not root:
            return 0

        ans = 0

        if root.left:
            if not (root.left.left or root.left.right):
                ans += root.left.val
            else:
                ans += self.sol_3(root.left)
        ans += self.sol_3(root.right)

        return ans


