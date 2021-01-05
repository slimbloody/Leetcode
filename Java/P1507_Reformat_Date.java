import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class P1507_Reformat_Date {
  public String reformatDate(String date) {
    return sol1(date);
  }
  
  public String sol1(String date) {
    String[] s = date.split(" ");
    List<String> month = Arrays.asList(
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    );
  
    
    return s[2] + "-" + String.format("%02d", month.indexOf(s[1]) + 1) + "-"
        + String.format(
            "%02d", Integer.valueOf(s[0].substring(0, s[0].length() - 2))
        );
  }
  
  public static void main(String[] args) {
    P1507_Reformat_Date p = new P1507_Reformat_Date();
    System.out.println(p.reformatDate("20th Oct 2052"));
  }
}
