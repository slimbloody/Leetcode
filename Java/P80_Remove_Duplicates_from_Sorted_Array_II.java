public class P80_Remove_Duplicates_from_Sorted_Array_II {
  public int removeDuplicates(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int i = 0;
    for (int n: nums) {
      if (i < 2 || n > nums[i - 2]) {
        nums[i++] = n;
      }
    }
    
    return i;
  }
  
  // bad solution by myself
  public int sol2(int[] nums) {
    int res = 0;
    
    int counter = 0;
    for (int i = 0; i < nums.length; ++i) {
      if (i == 0) {
        ++res;
        ++counter;
      }
      else {
        if (nums[res - 1] == nums[i]) {
          ++counter;
          
          if (counter <= 2) {
            nums[res++] = nums[i];
          }
        }
        else {
          counter = 1;
          nums[res++] = nums[i];
        }
        
      }
    }
    
    return res;
  }
}
