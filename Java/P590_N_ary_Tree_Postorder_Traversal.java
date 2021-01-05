import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

class P590_N_ary_Tree_Postorder_Traversal {
    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        return sol1(root);
    }

    public List<Integer> sol1(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        Stack<Integer> rev = new Stack<Integer>();
        Stack<Node> st = new Stack<Node>();
        st.push(root);

        while(!st.empty()) {
            Node temp = st.pop();
            for (Node item: temp.children) {
                st.push(item);
            }
            rev.push(temp.val);
        }

        while(!rev.empty()) {
            ans.add(rev.pop());
        }

        return ans;
    }
}

