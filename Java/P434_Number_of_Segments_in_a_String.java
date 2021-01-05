import java.util.Arrays;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class P434_Number_of_Segments_in_a_String {
  public int countSegments(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    s = s.trim();
//    return s.length() == 0 ? 0 : s.split("\\s+").length;
    return s.split("\\s+").length;
  }
  
  public static void main(String[] args) {
    P434_Number_of_Segments_in_a_String p = new P434_Number_of_Segments_in_a_String();
    System.out.println(p.countSegments(" "));
    System.out.println(p.countSegments(""));
    System.out.println(p.countSegments(" ab bb"));
    
    String s1 = " ";
  }
}
