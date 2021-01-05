import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P448_Find_All_Numbers_Disappeared_in_an_Array {
  public List<Integer> findDisappearedNumbers(int[] nums) {
    return sol1(nums);
  }
  
  public List<Integer> sol1(int[] nums) {
    List<Integer> res = new ArrayList<>();
    
    for (int i = 0; i < nums.length; ++i) {
      int index = Math.abs(nums[i]) - 1;
      if (nums[index] > 0) {
        nums[index] = -nums[index];
      }
    }
  
    for (int i = 0; i < nums.length; ++i) {
      if (nums[i] > 0) {
        res.add(i + 1);
      }
    }
  
    return res;
  }
  
  public List<Integer> sol2(int[] nums) {
    List<Integer> res = new ArrayList<>();
    int n = nums.length;
    for (int i = 0; i < nums.length; i ++) nums[(nums[i]-1) % n] += n;
    for (int i = 0; i < nums.length; i ++) if (nums[i] <= n) res.add(i+1);
    return res;
  }
  
  public static void main(String[] args) {
    P448_Find_All_Numbers_Disappeared_in_an_Array p = new P448_Find_All_Numbers_Disappeared_in_an_Array();
    int[] a1 = new int[]{4,3,2,7,8,2,3,1};
    System.out.println(p.findDisappearedNumbers(a1));
  }
  
  
}
