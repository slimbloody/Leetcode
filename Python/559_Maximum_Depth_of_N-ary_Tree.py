"""
# Definition for a Node.
class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children
"""
class Solution(object):
    def maxDepth(self, root):
        """
        :type root: Node
        :rtype: int
        """
        return self.sol_2(root)

    def sol_1(self, root):
        if not root:
            return 0
        elif not root.children:
            return 1
        else:
            ans = list()
            for item in root.children:
                ans.append(self.sol_1(item))
            return max(ans) + 1

    # 遍历所有节点(dfs), 找出最大深度节点
    def sol_2(self, root):
        """
        stack: [:] == [top:bottom]
        """
        if not root:
            return 0

        depth = 0
        vessel = [(root, 1)]

        while vessel:
            top = vessel.pop(0)
            cur_node = top[0]
            height = top[1]
            depth = height if height > depth else depth
            stack_top = [(child, height + 1) for child in cur_node.children]
            vessel = stack_top + vessel

        return depth



