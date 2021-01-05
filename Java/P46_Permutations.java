import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P46_Permutations {
  public List<List<Integer>> permute(int[] nums) {
    return sol5(nums);
  }
  
  public List<List<Integer>> sol1(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    sol1Backtrack(list, new ArrayList<>(), nums);
    return list;
  }
  
  private void sol1Backtrack(
    List<List<Integer>> list, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    }
    else {
      for (int i = 0; i < nums.length; ++i) {
        if (tempList.contains(nums[i])) {
          continue;
        }
        tempList.add(nums[i]);
        sol1Backtrack(list, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
  
  public List<List<Integer>> sol2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    
    if (nums.length == 0) {
      return res;
    }
    
    List<Integer> l0 = new ArrayList<>();
    l0.add(nums[0]);
    res.add(l0);
    
    for (int i = 1; i < nums.length; ++i) {
      List<List<Integer>> new_res = new ArrayList<>();
      
      for (int j = 0; j <= i; ++j) {
        for (List<Integer> l: res) {
          List<Integer> new_l = new ArrayList<>();
          new_l.add(j, nums[i]);
          new_res.add(new_l);
        }
      }
      
      res = new_res;
    }
    
    return res;
  }
  
  public List<List<Integer>> sol5(int[] nums) {
   List<Integer> unUsedList = Arrays
      .stream(nums)
      .boxed()
      .collect(Collectors.toList());
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();
    sol5Itertative(res, cur, unUsedList);
  
    System.out.println(res);
    
    return res;
  }
  
  public void sol5Itertative(
    List<List<Integer>> res, List<Integer> cur, List<Integer> unUsedList) {
    if (unUsedList.size() == 0) {
      res.add(cur);
    }
    
    for (int i = 0; i < unUsedList.size(); ++i) {
      List<Integer> nextUnUsedList = new ArrayList<>(unUsedList);
      List<Integer> nextCur = new ArrayList<>(cur);
      
      nextCur.add(nextUnUsedList.get(i));
      nextUnUsedList.remove(i);
      
      sol5Itertative(res, nextCur, nextUnUsedList);
    }
  }
}

