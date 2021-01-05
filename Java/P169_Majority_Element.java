public class P169_Majority_Element {
  public int majorityElement(int[] nums) {
    return sol2(nums);
  }
  
  // Boyer-Moore Voting Algorithm
  public int sol1(int[] nums) {
    int count = 0, res = 0;
    
    for (int num: nums) {
      if (count == 0) {
        res = num;
      }
      if (num != res) {
        --count;
      }
      else {
        ++count;
      }
    }
    
    return res;
  }
  
  // Bit manipulation
  public int sol2(int[] nums) {
    int[] bit = new int[32];
    for (int num: nums) {
      for (int i = 0; i < 32; ++i) {
        if ((num >> (31 - i) & 1) == 1) {
          ++bit[i];
        }
      }
    }
    
    int res = 0;
    for (int i = 0; i < 32; ++i) {
      bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
      res += bit[i] * (1 << (31 - i));
    }
    
    return res;
  }
  
  // hashmap
  
  // sorting
}
