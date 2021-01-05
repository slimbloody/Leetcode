import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class P217_Contains_Duplicate {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> set = Arrays
        .stream(nums)
        .boxed()
        .collect(Collectors.toSet());
    return set.size() != nums.length;
  }
}
