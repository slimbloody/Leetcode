import java.util.Arrays;

public class P724_Find_Pivot_Index {
  public int pivotIndex(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int sum = 0;
    int total = Arrays.stream(nums).sum();
    
    for (int i = 0; i < nums.length; sum += nums[i++]) {
      if (sum * 2 == total - nums[i]) {
        return i;
      }
    }
    
    return -1;
  }
  
  public int sol2(int[] nums) {
    int left = 0, right = 0;
    
    for (int i = 0; i < nums.length; ++i) {
      right += nums[i];
    }
  
    for (int i = 0; i < nums.length; ++i) {
      if (i - 1 >= 0) {
        left += nums[i - 1];
      }
      right -= nums[i];
//      System.out.println("left: " + left + " right: " + right);
      
      if (left == right) {
        return i;
      }
    }
    
    return -1;
  }
  
  public static void main(String[] args) {
    P724_Find_Pivot_Index p = new P724_Find_Pivot_Index();
    int[] a1 = new int[]{1,7,3,6,5,6};
    System.out.println(p.pivotIndex(a1));

    int[] a2 = new int[]{1,2,3};
    System.out.println(p.pivotIndex(a2));
  
    int[] a3 = new int[]{-1,-1,-1,-1,1,1};
    System.out.println(p.pivotIndex(a3));
  }
}
