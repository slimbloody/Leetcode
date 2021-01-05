import java.lang.reflect.Array;
import java.util.Arrays;

public class P581_Shortest_Unsorted_Continuous_Subarray {
  public int findUnsortedSubarray(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int[] sortNums = Arrays.copyOf(nums, nums.length);
    Arrays.sort(sortNums);
    int start = -1, end = -1;
    for (int i = 0; i < nums.length; ++i) {
      if (sortNums[i] != nums[i]) {
        start = i;
        break;
      }
    }
  
    for (int i = nums.length - 1; i >= 0; --i) {
      if (sortNums[i] != nums[i]) {
        end = i;
        break;
      }
    }
    
    return start == end ? 0 : end - start + 1;
  }
  
  public static void main(String[] args) {
    P581_Shortest_Unsorted_Continuous_Subarray p = new P581_Shortest_Unsorted_Continuous_Subarray();
    int[] a1 = new int[]{2, 6, 4, 8, 10, 9, 15};
    System.out.println(p.findUnsortedSubarray(a1));
  }
}
