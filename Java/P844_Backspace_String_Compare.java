import java.util.Stack;

public class P844_Backspace_String_Compare {
  public boolean backspaceCompare(String S, String T) {
    return sol1(S, T);
  }
  // best python solution generator
  
  // two pointer: from right to left
  public boolean sol1(String S, String T) {
    int i = S.length() - 1, j = T.length() - 1;
    if (i != j) {
      return false;
    }
    
    while (i >= 0 && j >= 0) {
      int icount = 0;
      int jcount = 0;
      
      while (i >= 0 && (icount > 0 || S.charAt(i) == '#')) {
        if (S.charAt(i) == '#') {
          ++icount;
          --i;
        }
        else {
          --icount;
          --i;
        }
      }
  
      while (j >= 0 && (jcount > 0 || S.charAt(j) == '#')) {
        if (S.charAt(j) == '#') {
          ++jcount;
          --j;
        }
        else {
          --jcount;
          --j;
        }
      }
      if (i < 0 && j < 0) {
        return true;
      }
      else if ((i < 0 && j >= 0) || (i > 0 && j <= 0)) {
        return false;
      }
      else {
        if (S.charAt(i) != T.charAt(j)) {
          return false;
        }
        else {
          --i;
          --j;
        }
      }
    }
    
    return true;
  }
  
  private Stack<Character> getStack(String s) {
    Stack<Character> stack = new Stack<>();
  
    s
      .chars()
      .mapToObj(i -> (char) i)
      .forEach(c -> {
        if (c == '#') {
          if (! stack.empty()) {
            stack.pop();
          }
        }
        else {
          stack.push(c);
        }
      });
    
    return stack;
  }
  
  public boolean sol3(String S, String T) {
    Stack<Character> ss = getStack(S);
    Stack<Character> ts = getStack(T);
    
    if (ss.size() != ts.size()) {
      return false;
    }
    while (!ss.empty()) {
      if (ss.pop() != ts.pop()) {
        return false;
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    P844_Backspace_String_Compare p = new P844_Backspace_String_Compare();
    System.out.println(p.backspaceCompare("ab#c", "ad#c") == true);
    System.out.println(p.backspaceCompare("ab##", "c#d#") == true);
    System.out.println(p.backspaceCompare("##", "###") == true);
    System.out.println(p.backspaceCompare("##", "abcd#e###") == false);
    System.out.println(p.backspaceCompare("##", "abc#e###") == true);
  }
}

