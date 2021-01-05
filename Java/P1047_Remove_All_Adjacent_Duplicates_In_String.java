import java.util.Stack;

public class P1047_Remove_All_Adjacent_Duplicates_In_String {
  public String removeDuplicates(String S) {
    return sol1(S);
  }
  
  public String sol1(String S) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < S.length(); ++i) {
      if (stack.empty()) {
        stack.push(S.charAt(i));
      }
      else {
        if (stack.peek() == S.charAt(i)) {
          stack.pop();
        }
        else {
          stack.push(S.charAt(i));
        }
      }
    }
    
    StringBuilder sb = new StringBuilder();
    while (!stack.empty()) {
      sb.append(stack.pop());
    }
    return sb.reverse().toString();
  }
  
  public String sol2(String S) {
    int i = 0;
    char[] res = S.toCharArray();
    
    for (int j = 0; j < S.length(); ++j, ++i) {
      res[i] = res[j];
      if (i > 0 && res[i - 1] == res[i]) {
        // count = 2
        i -= 2;
      }
    }
    
    return new String(res, 0, i);
  }
  
  public static void main(String[] args) {
  }
}
