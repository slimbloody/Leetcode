public class P485_Max_Consecutive_Ones {
  public int findMaxConsecutiveOnes(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int maxHere = 0, max = 0;
    
    for (int num: nums) {
      max = Math.max(max, maxHere = num == 0 ? 0 : maxHere + 1);
    }
    
    return max;
  }
  
  public int sol2(int[] nums) {
    int res = 0;
    int counter = 0;
    
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] == 1) {
        ++counter;
      }
      if (nums[i] == 0 || i == nums.length - 1) {
        res = Math.max(res, counter);
        counter = 0;
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P485_Max_Consecutive_Ones p = new P485_Max_Consecutive_Ones();
    int[] a1 = new int[]{1,1,0,1,1,1};
    System.out.println(p.findMaxConsecutiveOnes(a1));
  
    int[] a2 = new int[]{0};
    System.out.println(p.findMaxConsecutiveOnes(a2));
    
  }
}
