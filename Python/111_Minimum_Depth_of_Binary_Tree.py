# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        return self.sol_2(root)

    # tuple
    def sol_1(self, root):
        if not root:
            return 0

        depth = 999999999

        vessal = [(root, 1)]

        while vessal:
            top, level = vessal.pop(0)
            if not (top.left or top.right):
                if level < depth:
                    depth = level
            if top.right:
                vessal.insert(0, (top.right, level + 1))
            if top.left:
                vessal.insert(0, (top.left, level + 1))
        return depth

    # 直接层序遍历, 如果有一层的节点有叶子节点, 则为最小level
    def sol_2(self, root):
        if not root:
            return 0

        level = 1
        level_vessal = [root]
        next_level_vessal = list()

        while level_vessal:
            for node in level_vessal:
                print(node.val, level)
                if not (node.left or node.right):
                    return level
                if node.left:
                    next_level_vessal.append(node.left)
                if node.right:
                    next_level_vessal.append(node.right)
            print([node.val for node in level_vessal])
            level += 1
            print('add here')
            level_vessal = next_level_vessal

    # recursive
    def sol_3(self, root):
        if not root:
            return 0

        depth = 999999999

        if not (root.left or root.right):
            return 1

        min_left = self.sol_3(root.left) if root.left else 999999999
        min_right = self.sol_3(root.right) if root.right else 999999999

        return min(min_left, min_right) + 1

