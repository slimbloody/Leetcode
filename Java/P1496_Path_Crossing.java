import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1496_Path_Crossing {
  public boolean isPathCrossing(String path) {
    return sol1(path);
  }
  
  // better hash
  // todo: long is faster then int???
  public boolean sol1(String path) {
    char[] paths = path.toCharArray();
    int x = 0, y = 0;
    Map<Character, int[]> direct = new HashMap<>();
    direct.put('N', new int[]{0, 1});
    direct.put('S', new int[]{0, -1});
    direct.put('E', new int[]{1, 0});
    direct.put('W', new int[]{-1, 0});
    Set<Long> set = new HashSet<>();
    set.add(0L);
    
    for (char c: paths) {
      int[] d = direct.get(c);
      x += d[0];
      y += d[1];
      long pos = (long) (x * 10001 + y);
      
      if (set.contains(pos)) {
        return true;
      }
      
      set.add(pos);
    }
    
    return false;
  }
  
  public boolean sol2(String path) {
    char[] paths = path.toCharArray();
    int x = 0, y = 0;
    Map<Character, int[]> direct = new HashMap<>();
    direct.put('N', new int[]{0, 1});
    direct.put('S', new int[]{0, -1});
    direct.put('E', new int[]{1, 0});
    direct.put('W', new int[]{-1, 0});
    Set<String> set = new HashSet<>();
    set.add("0,0");
    
    for (char c: paths) {
      int[] d = direct.get(c);
      x += d[0];
      y += d[1];
      String pos = String.format("%d,%d", x, y);
      
      System.out.println(pos);
      if (set.contains(pos)) {
        return true;
      }
      
      set.add(pos);
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    P1496_Path_Crossing p = new P1496_Path_Crossing();
    System.out.println(p.isPathCrossing("NESWW") == true);
    
  }
}
