import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class P504_Base_7 {
  public String convertToBase7(int num) {
    return sol2(num);
  }
  
  public String sol1(int num) {
    StringBuffer s = new StringBuffer();
    
    boolean flag = num >= 0;
    num = Math.abs(num);
    
    while(num > 0) {
      s.append(num %7);
      num /= 7;
    }
  
    if (s.length() == 0) {
      s.append("0");
    }
    
    if (!flag) {
      s.append("-");
    }
    
    return s.reverse().toString();
  }
  
  public String sol2(int num) {
    if (num < 0) {
      return "-" + sol2(-num);
    }
    if (num < 7) {
      return Integer.toString(num);
    }
    return sol2(num / 7) + num % 7;
  }
  
  public static void main(String[] args) {
    P504_Base_7 p = new P504_Base_7();
    System.out.println(p.convertToBase7(100));
    System.out.println(p.convertToBase7(-7));
  }
}
