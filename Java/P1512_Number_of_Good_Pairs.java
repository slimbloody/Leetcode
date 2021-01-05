import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P1512_Number_of_Good_Pairs {
  public int numIdenticalPairs(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int res = 0;
    Map<Integer, Long> map = Arrays
        .stream(nums)
        .boxed()
        .collect(
            Collectors.groupingBy(Function.identity(), Collectors.counting()));
  
    for (Map.Entry<Integer, Long> integerLongEntry : map.entrySet()) {
      int num = (int) integerLongEntry.getValue().longValue();
      for (int i = 0; i < num; ++i) {
        res += i;
      }
    }
    
    return res;
  }
  // using array instead of hashmap
  public int sol2(int[] nums) {
    int res = 0, count[] = new int[101];
    for (int a: nums) {
      res += count[a]++;
    }
    return res;
  }
  
  public static void main(String[] args) {
    P1512_Number_of_Good_Pairs p = new P1512_Number_of_Good_Pairs();
    int[] a1 = {1,2,3,1,1,3};
    System.out.println(p.numIdenticalPairs(a1));
  
    int[] a2 = {1,1,1,1};
    System.out.println(p.numIdenticalPairs(a2));
  
    int[] a3 = {1,2,3};
    System.out.println(p.numIdenticalPairs(a3));
  }
}
