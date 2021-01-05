public class P5479_Thousand_Separator {
  public String thousandSeparator(int n) {
    return sol1(n);
  }
  
  public String sol1(int n) {
    String s = Integer.valueOf(n).toString();
    StringBuilder sb = new StringBuilder();
    int counter = 0;
    for (int i = s.length() - 1; i >= 0; --i) {
      ++counter;
      sb.append(s.charAt(i));
      if (counter == 3 && i != 0) {
        counter = 0;
        sb.append('.');
      }
    }
    
    return sb.reverse().toString();
  }
  
  public static void main(String[] args) {
    P5479_Thousand_Separator p =  new P5479_Thousand_Separator();
    System.out.println(p.thousandSeparator(987));
  
    System.out.println(p.thousandSeparator(1234));
    
    System.out.println(p.thousandSeparator(123456789));
  
    System.out.println(p.thousandSeparator(0));
  }
}
