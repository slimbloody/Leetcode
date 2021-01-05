import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P1356_Sort_Integers_by_The_Number_of_1_Bits {
  public int[] sortByBits(int[] arr) {
    return sol1(arr);
  }
  
  public int[] sol1(int[] arr) {
    return Arrays
        .stream(arr)
        .boxed()
        .sorted(Comparator.comparingInt(i -> Integer.bitCount(i) * 10000 + i))
        .mapToInt(i -> i)
        .toArray();
  }
  
  // priority queue
  public int[] sol2(int[] arr) {
    return new int[1];
  }
  
  // todo:
  public int[] sol5(int[] arr) {
    Map<Integer, Integer> map = Arrays
        .stream(arr)
        .boxed()
        .collect(Collectors.toMap(Function.identity(), Integer::bitCount));
    return new int[1];
  }
}
