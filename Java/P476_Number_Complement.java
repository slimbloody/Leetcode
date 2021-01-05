// same as P1009_Complement_of_Base_10_Integer
public class P476_Number_Complement {
  public int findComplement(int num) {
    return sol1(num);
  }
  
  public int sol1(int num) {
    String a = Integer.toBinaryString(num);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < a.length(); ++i) {
      sb.append("1");
    }
    return Integer.valueOf(sb.toString(), 2) ^ num;
  }
  
  // 100110, its complement is 011001, the sum is 111111.
  // So we only need get the min number large or equal to num,
  // then do substraction
  public int sol2(int num) {
    int i = 0, j = 0;
    
    while (i < num) {
      i += Math.pow(2, j++);
    }
    
    return i - num;
  }
  
  public static void main(String[] args) {
    P476_Number_Complement p = new P476_Number_Complement();
    System.out.println(p.findComplement(5));
  }
}
