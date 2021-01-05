public class P405_Convert_a_Number_to_Hexadecimal {
  public String toHex(int num) {
    return sol1(num);
  }
  
  public String sol1(int num) {
    if (num == 0) {
      return "0";
    }
    
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    StringBuilder sb = new StringBuilder();
    
    while (num != 0) {
      sb.append(map[(num & 15)]);
      num = (num >>> 4); // unsigned right shift
    }
    
    return sb.reverse().toString();
  }
  
  public static void main(String[] args) {
    P405_Convert_a_Number_to_Hexadecimal p = new P405_Convert_a_Number_to_Hexadecimal();
    System.out.println(p.toHex(26));
    System.out.println(p.toHex(-1));
  }
}

