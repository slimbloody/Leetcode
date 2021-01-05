public class P1437_check_if_all_1s_are_at_least_length_k_places_away {
  public boolean kLengthApart(int[] nums, int k) {
    return sol1(nums, k);
  }
  
  // evolve
  public boolean sol1(int[] nums, int k) {
    int previous = -1;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == 1) {
          if (previous != -1 && i - previous < k + 1) {
            return false;
          }
          previous = i;
        }
      }
    
    return true;
  }
  
  public boolean sol2(int[] nums, int k) {
    int previous = -1;
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == 1) {
        if (previous == -1) {
          previous = i;
        }
        else {
          if (i - previous < k + 1) {
            return false;
          }
          previous = i;
        }
      }
    }
    
    return true;
  }
}
