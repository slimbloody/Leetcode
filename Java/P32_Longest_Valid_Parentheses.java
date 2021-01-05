import java.util.Stack;

public class P32_Longest_Valid_Parentheses {
  public int longestValidParentheses(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    Stack<Character> stack = new Stack<>();
    int res = 0;
    int temp = 2;
    
    for (int i = 0; i < s.length(); ++i) {
      if (!stack.empty() && stack.peek() == '(' && s.charAt(i) == ')') {
        stack.pop();
        temp += 2;
      }
      else {
        stack.push(s.charAt(i));
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P32_Longest_Valid_Parentheses p = new P32_Longest_Valid_Parentheses();
    System.out.println(p.longestValidParentheses("()(()") == 2);
  }
}
