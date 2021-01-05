import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class P884_Uncommon_Words_from_Two_Sentences {
  public String[] uncommonFromSentences(String A, String B) {
    return sol1(A, B);
  }
  
  public String[] sol1(String A, String B) {
    Map<String, Integer> count = new HashMap<>();
    List<String> res = new ArrayList<>();
  
    Stream.concat(
        Arrays.stream(A.split(" ")),
        Arrays.stream(B.split(" "))
    ).forEach(s -> count.put(s, count.getOrDefault(s, 0) + 1));
  
    Iterator it = count.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry pair = (Map.Entry) it.next();
      if ((Integer) pair.getValue() == 1) {
        res.add((String) pair.getKey());
      }
    }
    
    return new String[]{""};
//    return (String[]) res.toArray();
  }
  
  // find the intersector of set
  public String[] sol2(String A, String B) {
    return new String[]{""};
  }
  
  public static void main(String[] args) {
    P884_Uncommon_Words_from_Two_Sentences p = new P884_Uncommon_Words_from_Two_Sentences();
    String a1 = "this apple is sweet";
    String b1 = "this apple is sour";
    String[] r1 = p.uncommonFromSentences(a1, b1);
    String[] ans1 = new String[]{"sweet", "sour"};
    System.out.println(r1.equals(ans1));
  
    String a2 = "apple apple";
    String b2 = "banana";
    String[] r2 = p.uncommonFromSentences(a2, b2);
    String[] ans2 = new String[]{"banana"};
    System.out.println(r1.equals(ans2));
  }
}
