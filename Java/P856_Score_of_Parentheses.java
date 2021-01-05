import java.util.Stack;

public class P856_Score_of_Parentheses {
  public int scoreOfParentheses(String S) {
    return sol1(S);
  }
  
  public int sol1(String S) {
    int res = 0;
    Stack<String> s = new Stack<>();
    for (int i = 0; i < S.length(); ++i) {
      if (S.charAt(i) == '(') {
        s.push("(");
      }
      if (S.charAt(i) == ')') {
        if (s.peek().equals("(")) {
          s.pop();
          s.push("1");
        }
        else {
          int temp = 0;
          while (!s.peek().equals("(")) {
            temp += Integer.valueOf(s.pop());
          }
          s.pop();
          temp *= 2;
          s.push(Integer.toString(temp));
        }
      }
    }
    
    while (s.size() != 0) {
      res += Integer.valueOf(s.pop());
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P856_Score_of_Parentheses p = new P856_Score_of_Parentheses();
    System.out.println(p.scoreOfParentheses("()"));
    System.out.println(p.scoreOfParentheses("(())"));
    System.out.println(p.scoreOfParentheses("()()"));
    System.out.println(p.scoreOfParentheses("(()(()))"));
  }
}
