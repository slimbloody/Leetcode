import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P144P1441_Build_an_Array_With_Stack_Operations {
  public List<String> buildArray(int[] target, int n) {
    return sol1(target, n);
  }
  
  public List<String> sol1(int[] target, int n) {
    List<String> res = new ArrayList<>();
    int targetLen = target.length;
    
    for (int i = 1, j = 0; j < targetLen; ++i) {
      if (target[j] != i) {
        res.add("Push");
        res.add("Pop");
      }
      else {
        res.add("Push");
        ++j;
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P144P1441_Build_an_Array_With_Stack_Operations p = new P144P1441_Build_an_Array_With_Stack_Operations();
    int[] a1 = {};
    int b1 = 3;
    System.out.println(Arrays.toString(a1));
    System.out.println(p.buildArray(a1, b1));
  
    int[] a2 = {1, 2, 3};
    int b2 = 3;
    p.buildArray(a2, b2);
    System.out.println(Arrays.toString(a2));
    System.out.println(p.buildArray(a2, b2));
  
    int[] a3 = {2, 3};
    int b3 = 4;
    System.out.println(Arrays.toString(a3));
    System.out.println(p.buildArray(a3, b3));
  
    int[] a4 = {2, 3, 6, 8};
    int b4 = 9;
    System.out.println(Arrays.toString(a4));
    System.out.println(p.buildArray(a4, b4));
  }
}
