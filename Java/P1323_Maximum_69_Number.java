public class P1323_Maximum_69_Number {
  public int maximum69Number (int num) {
    return sol1(num);
  }
  
  public int sol1(int num) {
    char[] charArray = Integer.valueOf(num).toString().toCharArray();
    
    for (int i = 0; i < charArray.length; ++i) {
      if (charArray[i] == '6') {
        charArray[i] = '9';
        break;
      }
    }
    
    return Integer.valueOf(String.valueOf(charArray));
  }
  
  public static void main(String[] args) {
    P1323_Maximum_69_Number p = new P1323_Maximum_69_Number();
    System.out.println(p.maximum69Number(9669));
    System.out.println(p.maximum69Number(9996));
    System.out.println(p.maximum69Number(9999));
  }
}
