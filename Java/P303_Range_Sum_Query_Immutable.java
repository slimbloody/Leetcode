import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

public class P303_Range_Sum_Query_Immutable {
  class NumArray1 {
  
    int[] nums;
  
    public NumArray1(int[] nums) {
      for (int i = 1; i < nums.length; i++)
        nums[i] += nums[i - 1];
    
      this.nums = nums;
    }
  
    public int sumRange(int i, int j) {
      if (i == 0)
        return nums[j];
    
      return nums[j] - nums[i - 1];
    }
  }
  
  // caching
  class NumArray2 {
    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
  
    public NumArray2(int[] nums) {
      for (int i = 0; i < nums.length; ++i) {
        int sum = 0;
        
        for (int j = i; j < nums.length; ++j) {
          sum += nums[j];
          map.put(new Pair<>(i, j), sum);
        }
      }
    }
  
    public int sumRange(int i, int j) {
      return map.get(new Pair<>(i, j));
    }
  }
  
  class NumArray3 {
    private int[] sum;
  
    public NumArray3(int[] nums) {
      sum = new int[nums.length + 1];
      
      for (int i = 0; i < nums.length; ++i) {
        sum[i + 1] = sum[i] + nums[i];
      }
    }
  
    public int sumRange(int i, int j) {
      return sum[j + 1] - sum[i];
    }
  }
}


