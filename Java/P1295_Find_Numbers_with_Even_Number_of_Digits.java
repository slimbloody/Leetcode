import java.util.Arrays;

public class P1295_Find_Numbers_with_Even_Number_of_Digits {
  public int findNumbers(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int res = 0;
    
    for (int i = 0; i < nums.length; ++i) {
      int temp = 0;
      while (nums[i] != 0) {
        System.out.print(nums[i] + " ");
        nums[i] /= 10;
        ++temp;
      }
  
      if ((temp & 1) == 0) {
        ++res;
      }
    }
    
    return res;
  }
  
  // 1 <= nums[i] <= 10^5
  public int sol2(int[] nums) {
    int res = 0;
    
    for (int num: nums) {
      if ((10 <= num && num <= 99)
          || (1000 <= num && num <= 9999 )
          || (num ==100000)) {
        ++res;
      }
    }
    
    return res;
  }
  
  public int sol3(int[] nums) {
    return (int) Arrays
        .stream(nums).filter(num -> String.valueOf(num).length() % 2 == 0).count();
  }
  
  public static void main(String[] args) {
    P1295_Find_Numbers_with_Even_Number_of_Digits p = new P1295_Find_Numbers_with_Even_Number_of_Digits();
    int[] a1 = new int[]{580,317,640,957,718,764};
    System.out.println(p.findNumbers(a1));
  }
}
