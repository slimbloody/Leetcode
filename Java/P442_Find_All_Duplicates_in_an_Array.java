import java.util.ArrayList;
import java.util.List;

public class P442_Find_All_Duplicates_in_an_Array {
  public List<Integer> findDuplicates(int[] nums) {
    return sol1(nums);
  }
  
  // 把一个数据所有的位置都拿出来考虑, 看看哪些被用过, 可以存储数据
  
  // when find a number i, flip the number at position i-1 to negative.
  // if the number at position i-1 is already negative,
  // i is the number that occurs twice.
  public List<Integer> sol1(int[] nums) {
    List<Integer> res = new ArrayList<>();
    
    for (int i = 0; i < nums.length; ++i) {
      int index = Math.abs(nums[i]) - 1;
      
      if (nums[index] < 0) {
        res.add(Math.abs(index + 1));
      }
      nums[index] = -nums[index];
    }
    
    return res;
  }
  
  public List<Integer> sol2(int[] nums) {
    int temp;
    List<Integer> res = new ArrayList<>();
    
    for (int i = 0; i < nums.length; ++i) {
      while ((i != nums[i] - 1)) {
        temp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = temp;
      }
    }
    for (int i = 0; i < nums.length; ++i) {
      if (i != nums[i] - 1) {
        res.add(nums[i]);
      }
    }
    
    return res;
  }
}
