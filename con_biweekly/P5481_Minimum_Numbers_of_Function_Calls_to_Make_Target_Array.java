import java.util.Arrays;

public class P5481_Minimum_Numbers_of_Function_Calls_to_Make_Target_Array {
  public int minOperations(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int counter = 0;
//    System.out.println(Arrays.toString(nums));
    while (true) {
      for (int i = 0; i < nums.length; ++i) {
        if ((nums[i] & 1) == 1) {
          ++counter;
          --nums[i];
        }
      }
//      System.out.println(Arrays.toString(nums));
  
      int smallCount = 0;
      for (int i = 0; i < nums.length; ++i) {
        if (nums[i] == 0) {
          ++smallCount;
        }
        else {
          nums[i] >>= 1;
        }
        
      }
      if (smallCount != nums.length) {
        ++counter;
      }
  
//      System.out.println(Arrays.toString(nums));
  
      if (smallCount == nums.length) {
        return counter;
      }
    }
  }
  
  public static void main(String[] args) {
    P5481_Minimum_Numbers_of_Function_Calls_to_Make_Target_Array p = new P5481_Minimum_Numbers_of_Function_Calls_to_Make_Target_Array();
    int[] a1 = new int[]{1,5};
    System.out.println(p.minOperations(a1));
    System.out.println();

    int[] a2 = new int[]{2,2};
    System.out.println(p.minOperations(a2));
    System.out.println();

    int[] a3 = new int[]{4,2,5};
    System.out.println(p.minOperations(a3));
    System.out.println();

    int[] a4 = new int[]{3,2,2,4};
    System.out.println(p.minOperations(a4));
    System.out.println();

    int[] a5 = new int[]{2,4,8,16};
    System.out.println(p.minOperations(a5));
    System.out.println();
  }
}
