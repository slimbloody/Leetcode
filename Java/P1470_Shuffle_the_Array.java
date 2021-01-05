import java.util.Arrays;

public class P1470_Shuffle_the_Array {
  public int[] shuffle(int[] nums, int n) {
    return sol2(nums, n);
  }
  
  //
//  public int[] sol1(int[] nums, int n) {
//    int temp = Integer.MIN_VALUE;
//
//    for (int i = 1; i <= n; ++i) {
//    }
//
//    return 1;
//  }
  
  
  // bitwise
  // 1 <= nums[i] <= 10^3, 1024, so num[i] have 10 bit
  public int[] sol2(int[] nums, int n) {
    for (int i = 0; i < n; ++i) {
      nums[n + i] <<= 10;
      nums[n + i] |= nums[i];
    }
    System.out.println(Arrays.toString(nums));
  
    for (int i = 0, j = 0; i < n; i += 2, ++j) {
      nums[i] = nums[n + j] & 1023;
      nums[i + 1] = nums[n + j] >> 10;
    }
    
    return nums;
  }
  
  public static void main(String[] args) {
    P1470_Shuffle_the_Array p = new P1470_Shuffle_the_Array();
    p.shuffle(new int[]{2,5,1,3,4,7}, 3);
  }
}
