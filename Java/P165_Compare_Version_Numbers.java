import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P165_Compare_Version_Numbers {
  public int compareVersion(String version1, String version2) {
    return sol1(version1, version2);
  }
  
  public int sol1(String version1, String version2) {
    List<Integer> l1 = Arrays
      .stream(version1.split("\\."))
      .map(Integer::valueOf)
      .collect(Collectors.toList());

    List<Integer> l2 = Arrays
      .stream(version2.split("\\."))
      .map(Integer::valueOf)
      .collect(Collectors.toList());
    
    int len = Math.max(l1.size(), l2.size());

    int i1, i2;
    for (int i = 0; i < len; ++i) {
      i1 = i < l1.size() ? l1.get(i) : 0;
      i2 = i < l2.size() ? l2.get(i) : 0;
      
      if (i1 > i2) {
        return 1;
      }
      else if (i1 < i2) {
        return -1;
      }
    }
    
    return 0;
  }
  
  public static void main(String[] args) {
    P165_Compare_Version_Numbers p = new P165_Compare_Version_Numbers();
    System.out.println(p.compareVersion("1.01", "1.001") == 0);
    System.out.println(p.compareVersion("1.0", "1.0.0") == 0);
    System.out.println(p.compareVersion("0.1", "1.1") == -1);
    System.out.println(p.compareVersion("1.0.1", "1") == 1);
    System.out.println(p.compareVersion("7.5.2.4", "7.5.3") == -1);
  }
}
