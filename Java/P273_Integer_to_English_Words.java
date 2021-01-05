import java.util.ArrayList;
import java.util.List;

public class P273_Integer_to_English_Words {
  public String numberToWords(int num) {
    return sol1(num);
  }
  
  //  2147483647
  public String sol1(int num) {
    StringBuilder sb = new StringBuilder();
    List<Integer> l = new ArrayList<>();
    
    while (num > 0) {
      int temp = num % 1000;
      l.add(temp);
      num /= 1000;
    }
    String[] bits = new String[]{"", "Thousand", "Million", "Billion"};
    
    String s;
    for (int i = 0; i < l.size(); ++i) {
      s = (sol1Interpret1000(l.get(i)) + " " + bits[i]);
      
      sb.insert(0, s);
    }
    
    return sb.toString();
  }
  
  private String sol1Interpret1000(int num) {
    String[] nums = new String[]{
      "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
      "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
      "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"
    };
    StringBuilder sb = new StringBuilder();
    if (num / 100 > 0) {
    }
    return "";
  }
  
  public static void main(String[] args) {
    P273_Integer_to_English_Words p = new P273_Integer_to_English_Words();
    System.out.println(p.numberToWords(123) == "One Hundred Twenty Three");
    System.out.println(p.numberToWords(12345) == "Twelve Thousand Three Hundred Forty Five");
    System.out.println(p.numberToWords(1234567) == "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven");
    System.out.println(p.numberToWords(1234567891) == "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One");
    System.out.println(p.numberToWords(1000010));
    System.out.println(p.numberToWords(1230567891));
  }
}
