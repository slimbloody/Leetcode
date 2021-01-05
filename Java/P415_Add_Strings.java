import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class P415_Add_Strings {
  public String addStrings(String num1, String num2) {
    return sol1(num1, num2);
  }
  
  public String sol1(String num1, String num2) {
    char[] a = num1.toCharArray();
    char[] b = num2.toCharArray();
    int i = a.length - 1;
    int j = b.length - 1;
    int carry = 0;
    StringBuilder builder = new StringBuilder();
    
    while (i >= 0 || j >= 0 || carry == 1) {
      int numA = i >= 0 ? a[i--] - '0' : 0;
      int numB = j >= 0 ? b[j--] - '0' : 0;
      int temp = numA + numB + carry;
      builder.insert(0, temp % 10);
      carry = temp / 10;
    }
    
    return builder.toString();
  }
  
  public String sol2(String num1, String num2) {
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;
    List<Integer> out = new ArrayList<>();
    
    while (i >= 0  && j >= 0) {
      Integer temp = Character.getNumericValue(num1.charAt(i--)) +
          Character.getNumericValue(num2.charAt(j--)) + carry;
      System.out.println("temp: " + temp.toString());
      
      if (temp >= 10) {
        carry = 1;
        temp -= 10;
      }
      else {
        carry = 0;
      }
      
      out.add(temp);
    }
    System.out.println("i:" + i);
    System.out.println("j:" + j);
  
    carry = getCarry(num1, i, carry, out);
  
    carry = getCarry(num2, j, carry, out);
  
    if (carry == 1) {
      out.add(1);
    }
  
    Iterator<Integer> iterator = out.iterator();
    StringBuilder builder = new StringBuilder();
    while (iterator.hasNext()) {
      builder.append(iterator.next());
    }
    
    return builder.reverse().toString();
  }
  
  private int getCarry(String num1, int i, int carry, List<Integer> out) {
    System.out.println("carry: " + carry);
    System.out.println("i: " + i );
    while (i >= 0) {
      Integer temp = Character.getNumericValue(num1.charAt(i--)) + carry;
  
      if (temp >= 10) {
        carry = 1;
        temp -= 10;
      }
      else {
        carry = 0;
      }
  
      out.add(temp);
      System.out.println("temp: " + temp);
    }
    return carry;
  }
  
  public static void main(String[] args) {
    P415_Add_Strings p = new P415_Add_Strings();
    String a = p.addStrings("59", "88");
    System.out.println(a);
    String b = p.addStrings("9", "99");
    System.out.println(b);
    String c = p.addStrings("1", "9");
    System.out.println(c);
  }
}

