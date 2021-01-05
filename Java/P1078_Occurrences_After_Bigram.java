import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1078_Occurrences_After_Bigram {
  public String[] findOcurrences(String text, String first, String second) {
    return sol1(text, first, second);
  }
  
  // update of sol2
  public String[] sol1(String text, String first, String second) {
    List<String> resList = new ArrayList<>();
    String[] sArray = text.split(" ");
    
    for (int i = 2; i < sArray.length; ++i) {
      System.out.println(i);
      if (sArray[i - 2].equals(first) && sArray[i - 1].equals(second)) {
        resList.add(sArray[i]);
      }
    }
    
    String[] res = new String[resList.size()];
    resList.toArray(res);
    return res;
  }
  
  public String[] sol2(String text, String first, String second) {
    List<String> resList = new ArrayList<>();
    String[] sArray = text.split(" ");
    
    for (int i = 0; i < sArray.length - 2; ++i) {
      System.out.println(i);
      if (sArray[i].equals(first) && sArray[i + 1].equals(second)) {
        resList.add(sArray[i + 2]);
        i += 1;
      }
    }
  
    String[] res = new String[resList.size()];
    resList.toArray(res);
    return res;
  }
  
  public static void main(String[] args) {
    P1078_Occurrences_After_Bigram p = new P1078_Occurrences_After_Bigram();
    
    System.out.println(
        Arrays.toString(
            p.findOcurrences(
                "we will we will rock you", "we", "will"
            ))
    );
    
  }
}
