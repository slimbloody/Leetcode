public class P5453_Running_Sum_of_1d_Array {
  public int[] runningSum(int[] nums) {
    return sol1(nums);
  }
  
  public int[] sol1(int[] nums) {
    for (int i = 1; i < nums.length; ++i) {
      nums[i] = nums[i - 1] + nums[i];
    }
    
    return nums;
  }
}
