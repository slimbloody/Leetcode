public class P1464_Maximum_Product_of_Two_Elements_in_an_Array {
  public int maxProduct(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    if (nums.length < 2) {
      return 0;
    }
    
    int a = Math.max(nums[0], nums[1]);
    int b = Math.min(nums[0], nums[1]);
    
    for (int i = 2; i < nums.length; ++i) {
      if (nums[i] > b && nums[i] > a) {
        b = a;
        a = nums[i];
      }
      else if (nums[i] > b && nums[i] <= a) {
        b = nums[i];
      }
    }
    
    return (a - 1) * (b - 1);
  }
}
