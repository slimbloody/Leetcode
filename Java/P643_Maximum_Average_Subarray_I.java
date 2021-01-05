public class P643_Maximum_Average_Subarray_I {
  public double findMaxAverage(int[] nums, int k) {
    return sol1(nums, k);
  }
  
  // Sliding Window
  public double sol1(int[] nums, int k) {
    int max = Integer.MIN_VALUE;
    int prev = 0;
    for (int i = 0; i < nums.length - k + 1; ++i) {
      if (i == 0) {
        for (int j = 0; j < k; ++j) {
          prev += nums[j];
        }
      }
      else {
        prev = prev - nums[i - 1] + nums[i + k - 1];
      }
      max = Math.max(max, prev);
    }
    
    return (double) max / k;
  }
  
  // Cumulative Sum
  public double sol2(int[] nums, int k) {
    int[] sum = new int[nums.length];
    sum[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
      sum[i] = sum[i - 1] + nums[i];
    }
    double res = sum[k - 1] * 1.0 / k;
    for (int i = k; i < nums.length; i++) {
      res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P643_Maximum_Average_Subarray_I p = new P643_Maximum_Average_Subarray_I();
//    int[] a1 = new int[]{1,12,-5,-6,50,3};
//    System.out.println(p.findMaxAverage(a1, 4));
  
    int[] a2 = new int[]{0,4,0,3,2};
    System.out.println(p.findMaxAverage(a2, 1));
  }
}
