import java.util.ArrayList;
import java.util.List;

public class P1313_Decompress_Run_Length_Encoded_List {
  public int[] decompressRLElist(int[] nums) {
    return sol1(nums);
  }
  
  public int[] sol1(int[] nums) {
    List<Integer> l = new ArrayList<>();
    for (int i = 0; i < nums.length; i += 2) {
      int times = nums[i];
      for (int j = 0; j < times; ++j) {
        l.add(nums[i + 1]);
      }
    }
    
    int[] res = new int[l.size()];
    for (int i = 0; i < l.size(); ++i) {
      res[i] = l.get(i);
    }
    
    return res;
  }
}
