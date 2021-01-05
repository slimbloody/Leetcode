import java.util.Arrays;

public class P665_Non_decreasing_Array {
  public boolean checkPossibility(int[] nums) {
    return sol2(nums);
  }
  
  public boolean sol1(int[] nums) {
    return true;
  }
  
  public boolean sol2(int[] nums) {
    int counter =0;
    if (nums.length == 1) {
      return true;
    }
    
    for (int i = 0; i < nums.length - 1; ++i) {
      if (nums[i] > nums[i + 1]) {
        ++counter;
        
      }
  
      System.out.println(counter);
      if (counter >= 2) {
        return false;
      }
    }
    
    return true;
  }
  
  public static void main(String[] args) {
    P665_Non_decreasing_Array p = new P665_Non_decreasing_Array();
    int[] a1 = new int[]{4, 2, 3};
    System.out.println(p.checkPossibility(a1) == true);
  
    int[] a2 = new int[]{4, 2, 1};
    System.out.println(p.checkPossibility(a2) == false);
  }
}
