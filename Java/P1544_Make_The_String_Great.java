import java.util.Stack;

public class P1544_Make_The_String_Great {
  public String makeGood(String s) {
    return sol1(s);
  }
  
  public String sol1(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); ++i) {
      if (stack.empty()) {
        stack.push(s.charAt(i));
      }
      else {
        if (Math.abs(stack.peek() - s.charAt(i)) == 'a' - 'A') {
          stack.pop();
        }
        else {
          stack.push(s.charAt(i));
        }
      }
    }
    
    StringBuilder sb = new StringBuilder();
    while (!stack.empty()) {
      sb.append(stack.pop());
    }
    
    return sb.reverse().toString();
  }
  
  public static void main(String[] args) {
    P1544_Make_The_String_Great p = new P1544_Make_The_String_Great();
    System.out.println(p.makeGood("leEeetcode"));
  }
}
