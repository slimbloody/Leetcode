import java.util.ArrayList;
import java.util.Collections;

public class P1399_Count_Larges_Group {
  public int countLargestGroup(int n) {
    return sol1(n);
  }
  
  public int getDigit(int num) {
    return num == 0 ? 0 : num % 10 + getDigit(num / 10);
  }
  
  public int sol1(int n) {
    ArrayList<Integer> cnt = new ArrayList<>(Collections.nCopies(37, 0));
    for (int i = 1; i <= n; ++i) {
      int temp = getDigit(i);
      cnt.set(temp, cnt.get(temp) + 1);
    }
    
    return Collections.frequency(cnt, Collections.max(cnt));
  }
  
  public static void main(String[] args) {
    P1399_Count_Larges_Group p = new P1399_Count_Larges_Group();
    System.out.println(p.countLargestGroup(13));
  }
}

