import java.util.Arrays;
import java.util.stream.IntStream;

public class P1619_Mean_of_Array_After_Removing_Some_Elements {
  public double trimMean(int[] arr) {
    return sol1(arr);
  }
  
  public double sol1(int[] arr) {
    Arrays.sort(arr);
    int gap = (int) (arr.length * 0.05);
  
    double res = IntStream
      .range(gap, arr.length - gap)
      .boxed()
      .reduce(0, (sum, i) -> sum += arr[i])
      .doubleValue();
  
    res = res / (arr.length - 2 * gap);
    
    return res;
  }
}
