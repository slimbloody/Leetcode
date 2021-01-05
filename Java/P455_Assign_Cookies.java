import java.lang.reflect.Array;
import java.util.Arrays;

public class P455_Assign_Cookies {
  public int findContentChildren(int[] g, int[] s) {
    return sol1(g, s);
  }
  
  public int sol1(int[] g, int[] s) {
    Arrays.sort(g);
    Arrays.sort(s);
    int i = 0, j = 0;
    int sum = 0;
    while (i < g.length && j < s.length) {
      if (g[i] <= s[j]) {
        ++sum;
        ++i;
        ++j;
      }
      else {
        ++j;
      }
    }
    
    return sum;
  }
  
  public static void main(String[] args) {
    P455_Assign_Cookies p = new P455_Assign_Cookies();
    int[] a1 = {1, 2};
    int[] b1 = {1, 2, 3};
    System.out.println(p.findContentChildren(a1, b1));
  
    int[] a2 = {1, 2, 3};
    int[] b2 = {1, 2};
    System.out.println(p.findContentChildren(a2, b2));
  
  
    int[] a3 = {1, 2, 3};
    int[] b3 = {};
    System.out.println(p.findContentChildren(a3, b3));
  
    int[] a4 = {};
    int[] b4 = {1, 2, 3};
    System.out.println(p.findContentChildren(a4, b4));
  }
  
}
