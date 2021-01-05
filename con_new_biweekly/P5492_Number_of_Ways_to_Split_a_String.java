import java.util.ArrayList;
import java.util.List;

public class P5492_Number_of_Ways_to_Split_a_String {
  public int numWays(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    List<Integer> mark = new ArrayList<>();
    
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '1') {
        mark.add(i);
      }
    }
    
    if (mark.size() % 3 != 0) {
      return 0;
    }
    
    if (mark.size() == 0) {
      return (1 + (s.length() - 2)) * (s.length() - 2) / 2;
    }
    else {
      int seg = mark.size() / 3;
//      System.out.println("seg: " + seg);
      Integer pos1 = mark.get(seg - 1);
//      System.out.println("pos1: " + pos1);
      Integer pos2 = mark.get(seg);
//      System.out.println("pos2: " + pos2);
  
      Integer pos3 = mark.get(2 * seg - 1);
//      System.out.println("pos3: " + pos3);
      Integer pos4 = mark.get(2 * seg);
//      System.out.println("pos4: " + pos4);
//      System.out.println("pos2 - pos1: " + (pos2 - pos1));
//      System.out.println("pos4 - pos3: " + (pos4 - pos3));
      Long res = (long) (pos2 - pos1) * (pos4 - pos3);
//      System.out.println("res: " + res);
  
      return (int) (res % Math.pow(10, 9) + 7);
    }
  }
  
  public static void main(String[] args) {
    P5492_Number_of_Ways_to_Split_a_String p = new P5492_Number_of_Ways_to_Split_a_String();
//    System.out.println(p.numWays("10101") == 4);
//    System.out.println();
//
//    System.out.println(p.numWays("1001") == 0);
//    System.out.println();
//
//    System.out.println(p.numWays("0000") == 3);
//    System.out.println();
//
//    System.out.println(p.numWays("100100010100110") == 12);
//    System.out.println();
//
//    System.out.println(p.numWays("010010000000001000"));
//    System.out.println();
  
    System.out.println();
  }
}
