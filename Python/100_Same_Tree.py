# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSameTree(self, p, q):
        """
        :type p: TreeNode
        :type q: TreeNode
        :rtype: bool
        """
        return self.sol_3(p, q)

    """
    def sol_1(self, p, q):
        bitwise unsupport, wrong answer
        if not (p ^ q):
            if not p:
                return True
        else:
            return False
    """

    def sol_1(self, p, q):
        """
        bitwise unsupport
        """
        if (not p) and (not q):
            return True
        elif p and q:
            p_vessal = [p]
            q_vessal = [q]

            while True:
                if (not p_vessal) and (not q_vessal):
                    return True
                elif p_vessal and q_vessal:
                    p_top = p_vessal.pop(0)
                    q_top = q_vessal.pop(0)

                    if p_top.val != q_top.val:
                        return False

                    if (not p_top.right) and (not q_top.right):
                        pass
                    elif p_top.right and q_top.right:
                        p_vessal.insert(0, p_top.right)
                        q_vessal.insert(0, q_top.right)
                    else:
                        return False

                    if (not p_top.left) and (not q_top.left):
                        pass
                    elif p_top.left and q_top.left:
                        p_vessal.insert(0, p_top.left)
                        q_vessal.insert(0, q_top.left)
                    else:
                        return False
                else:
                    return False
        else:
            return False

        return True

    def sol_2(self, p, q):
        """
        bitwise unsupport
        """
        if (not p) and (not q):
            return True
        elif p and q:
            p_vessal = [p]
            q_vessal = [q]

            while p_vessal or q_vessal:
                if p_vessal and q_vessal:
                    p_top = p_vessal.pop(0)
                    q_top = q_vessal.pop(0)

                    if not (p_top or q_top):
                        pass
                    # elif注意条件顺序
                    elif not p_top or not q_top or p_top.val != q_top.val:
                        return False
                    else:
                        p_vessal.insert(0, p_top.right)
                        q_vessal.insert(0, q_top.right)
                        p_vessal.insert(0, p_top.left)
                        q_vessal.insert(0, q_top.left)
                else:
                    return False
            return True
        else:
            return False

    # nice solution use one stack
    def sol_3(self, p, q):
        """
        bitwise unsupport
        """
        vessal = [p, q]

        while vessal:
            p_top = vessal.pop(0)
            q_top = vessal.pop(0)
            if not (p_top or q_top):
                pass
            # elif注意条件顺序
            elif not p_top or not q_top or p_top.val != q_top.val:
                return False
            else:
                vessal.insert(0, p_top.right)
                vessal.insert(0, q_top.right)
                vessal.insert(0, p_top.left)
                vessal.insert(0, q_top.left)
        return True

    # recursive
    def sol_4(self, p, q):
        if (not p) and (not q):
            return True
        if p and q:
            if p.val == q.val:
                return self.sol_3(p.left, q.left) and self.sol_3(p.right, q.right)
        return False


