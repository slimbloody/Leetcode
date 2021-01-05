import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class P682_Baseball_Game {
  public int calPoints(String[] ops) {
    return sol1(ops);
  }
  
  public int sol1(String[] ops) {
    List<Integer> history = new ArrayList<>();
    for (int i = 0; i < ops.length; ++i) {
      if (ops[i].equals("C")) {
        if (history.size() > 0) {
          history.remove(history.size() - 1);
        }
      }
      else if (ops[i].equals("D")) {
        if (history.size() > 0) {
          history.add(history.get(history.size() - 1) * 2);
        }
      }
      else if (ops[i].equals("+")) {
        if (history.size() > 1) {
          history.add(
              history.get(history.size() - 1) + history.get(history.size() - 2)
          );
        }
      }
      else {
        history.add(Integer.valueOf(ops[i]));
      }
    }
  
    return history.stream().reduce(0, Integer::sum);
  }
  
  public int sol2(String[] ops) {
    Stack<Integer> stack = new Stack<>();
    
    for(String op : ops) {
      if (op.equals("+")) {
        int top = stack.pop();
        int newtop = top + stack.peek();
        stack.push(top);
        stack.push(newtop);
      }
      else if (op.equals("C")) {
        stack.pop();
      }
      else if (op.equals("D")) {
        stack.push(2 * stack.peek());
      }
      else {
        stack.push(Integer.valueOf(op));
      }
    }
    
    int ans = 0;
    for(int score : stack) {
      ans += score;
    }
    return ans;
  }
  
  public static void main(String[] args) {
    P682_Baseball_Game p = new P682_Baseball_Game();
    String[] s1 = new String[]{"5","2","C","D","+"};
    System.out.println(p.calPoints(s1));
  
    String[] s2 = new String[]{"5","-2","4","C","D","9","+","+"};
    System.out.println(p.calPoints(s2));
  }
}
