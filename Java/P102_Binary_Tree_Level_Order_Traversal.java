import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class P102_Binary_Tree_Level_Order_Traversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        return sol1(root);
    }

    public List<List<Integer>> sol1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        while(!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < num; ++i) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                list.add(temp.val);
            }
            res.add(list);
        }

        return res;
    }

    // dfs
    public List<List<Integer>> sol2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelHelper(ans, root, 0);
        return ans;
    }

    public void levelHelper(List<List<Integer>> ans, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() <= level) {
            ans.add(new LinkedList<>());
        }
        ans.get(level).add(root.val);
        levelHelper(ans, root.left, level + 1);
        levelHelper(ans, root.right, level + 1);
    }
}

