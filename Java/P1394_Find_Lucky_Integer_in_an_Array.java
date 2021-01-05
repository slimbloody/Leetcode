import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P1394_Find_Lucky_Integer_in_an_Array {
  public int findLucky(int[] arr) {
    return sol1(arr);
  }
  
  public int sol1(int[] arr) {
    Map<Integer, Long> map = Arrays
        .stream(arr)
        .boxed()
        .collect(
            Collectors.groupingBy(Function.identity(),
                Collectors.counting())
        );
  
//    System.out.println(Arrays.asList(map)); // method 1
//    System.out.println(Collections.singletonList(map)); // method 2
//    example.entrySet().forEach(entry->{
//      System.out.println(entry.getKey() + " " + entry.getValue());
//    });
    int res = - 1;
  
    for (Map.Entry<Integer, Long> temp : map.entrySet()) {
      if (temp.getKey() == temp.getValue().longValue()) {
        if (temp.getKey() > res) {
          res = temp.getKey();
        }
      }
    }
    
    return res;
  }
  
  public int sol2(int[] arr) {
    int[] count = new int[501];
    for (int num: arr) {
      ++count[num];
    }
    
    for (int i = 500; i >= 0; --i) {
      if (count[i] == i) {
        return i;
      }
    }
    
    return -1;
  }
  
  
  public static void main(String[] args) {
    P1394_Find_Lucky_Integer_in_an_Array p = new P1394_Find_Lucky_Integer_in_an_Array();
    int[] a1 = {2,2,3,4};
    System.out.println(p.findLucky(a1));
    System.out.println(p.findLucky(a1) == 2);
  
    int[] a2 = {1,2,2,3,3,3};
    System.out.println(p.findLucky(a2));
    System.out.println(p.findLucky(a2) == 3);
  
    int[] a3 = {2,2,2,3,3};
    System.out.println(p.findLucky(a3));
    System.out.println(p.findLucky(a3) == -1);
  }
}
