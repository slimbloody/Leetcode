

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P018_4Sum {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    return sol1(nums, target);
  }
  
  public List<List<Integer>> sol1(int[] nums, int target) {
    Arrays.sort(nums);
  
    int length = nums.length;
    if (length < 4) {
      return null;
    }
  
    int p1 = 0;
    int p4 = length - 1;
    int p2, p3;
  
    Set<List<Integer>> res = new HashSet<>();
  
    while (p1 + 3 <= p4) {
      p2 = p1 + 1;
      p3 = p4 - 1;
      
      while (true) {
        int cal = -99999;
        
        if (p2 < p3) {
          cal = nums[p1] + nums[p2] + nums[p3] + nums[p4];
          
          if (cal == target) {
            List<Integer> temp =
                Arrays.asList(nums[p1], nums[p2], nums[p3], nums[p4]);
            res.add(temp);
          } else if (cal < target) {
            ++p2;
          } else {
            --p3;
          }
          continue;
        }
        
        if (cal < target) {
          ++p1;
          break;
        }
        else {
          --p4;
          break;
        }
      }
    }
    
    return new ArrayList<>(res);
  }
  
  public static void main(String[] args) {
    P018_4Sum p = new P018_4Sum();
    int[] nums = {1, 0, -1, 0, -2, 2};
    int target = 0;
    List<List<Integer>> a = p.fourSum(nums, target);
    
    for (List<Integer> l: a) {
      System.out.println(Arrays.toString(l.toArray()));
    }
  }
}



