import java.util.ArrayList;
import java.util.List;

public class P1021_Remove_Outermost_Parentheses {
  public String removeOuterParentheses(String S) {
    return sol1(S);
  }
  
  public String sol1(String S) {
    char[] arr = S.toCharArray();
    StringBuilder stringBuilder = new StringBuilder();
    int count = 0;
    
    for (int i = 0; i < arr.length; ++i) {
      if (arr[i] == '(' && count++ > 0) {
        stringBuilder.append(S.charAt(i));
      }
  
      if (arr[i] == ')' && count-- > 1) {
        stringBuilder.append(S.charAt(i));
      }
    }
    
    return stringBuilder.toString();
  }
  
  // charAt cost a lot
  public String sol2(String S) {
    StringBuilder stringBuilder = new StringBuilder();
    int count = 0;
    
    for (int i = 0; i < S.length(); ++i) {
      if (S.charAt(i) == '(' && count++ > 0) {
        stringBuilder.append(S.charAt(i));
      }
      
      if (S.charAt(i) == ')' && count-- > 1) {
        stringBuilder.append(S.charAt(i));
      }
    }
    
    return stringBuilder.toString();
  }
  
  // charAt is as efficient as array[i]
  public String sol3(String S) {
    char[] arr = S.toCharArray();
    List<Character> temp = new ArrayList<>();
    StringBuilder stringBuilder = new StringBuilder();
    
    int count = 0;
    for (int i = arr.length - 1; i >= 0; --i) {
      if (arr[i] == ')') {
        ++count;
        if (count > 1) {
          temp.add(arr[i]);
        }
      }
      else if (arr[i] == '(') {
        --count;
        if (count > 0) {
          temp.add(arr[i]);
        }
      }
      
      if ((count == 0) && (temp.size() != 0)) {
        temp.forEach(stringBuilder::append);
        temp.clear();
      }
    }
    
    return stringBuilder.reverse().toString();
  }
  
  public static void main(String[] args) {
    P1021_Remove_Outermost_Parentheses p = new P1021_Remove_Outermost_Parentheses();
    String s1 = "(()())(())";
    String a1 = "()()()";
    System.out.println(p.removeOuterParentheses(s1).equals(a1));
  
    String s2 = "()()()";
    String a2 = "";
    System.out.println(p.removeOuterParentheses(s2).equals(a2));

    String s3 = "(()())()";
    String a3 = "()()";
    System.out.println(p.removeOuterParentheses(s3).equals(a3));
  }
}















