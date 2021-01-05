# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        return self.sol_1(root)

    def sol_1(self, root):
        if not root:
            return []

        vessal = [(root, 1)]
        cal_vessal = []

        while vessal:
            cur_node, height = vessal.pop(0)
            cal_vessal.append((cur_node.val, height))

            if cur_node.right:
                vessal.insert(0, (cur_node.right, height + 1))
            if cur_node.left:
                vessal.insert(0, (cur_node.left, height + 1))

        sum_val = 0
        height = 1
        cal_array = list()
        for item in cal_vessal:
            val, item_height = item

            if len(cal_array) >= item_height:
                cal_array[item_height - 1].append(val)
            else:
                cal_array.append(list())
                cal_array[item_height - 1] = [val]

        return cal_array


    def sol_2(self, root):
        ans, level = [], [root]
        while root and level:
            ans.append([node.val for node in level])
            level = [kid for n in level for kid in (n.left, n.right) if kid]
        return ans





