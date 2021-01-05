import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P506_Relative_Ranks {
  public String[] findRelativeRanks(int[] nums) {
    return sol1(nums);
  }

  public String[] sol1(int[] nums) {
    List<Integer> list = Arrays
        .stream(nums)
        .boxed()
        .sorted((o1, o2) -> o2 - o1)
        .collect(Collectors.toList());
  
    Map<Integer, Integer> map = IntStream
        .range(0, nums.length)
        .boxed()
        .collect(Collectors.toMap(list::get, Function.identity()));
  
    String[] res = new String[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      Integer rank = map.get(nums[i]) + 1;
      if (rank == 1) {
        res[i] = "Gold Medal";
      }
      else if (rank == 2) {
        res[i] = "Silver Medal";
      }
      else if (rank == 3) {
        res[i] = "Bronze Medal";
      }
      else {
        res[i] = rank.toString();
      }
    }

    return res;
  }
  
  public String[] sol2(int[] nums) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int i: nums) {
      min = min > i ? i : min;
      max = max < i ? i : max;
    }
    
    int[] bucket = new int[max - min + 1];
    for (int i = 0; i < nums.length; ++i) {
      bucket[nums[i] - min] = 1;
    }
    for (int i = 1; i < nums.length; ++i) {
      bucket[i] += bucket[i-1];
    }
  
    String[] res = new String[nums.length];
    for (int i = 0; i < nums.length; ++i) {
      Integer rank = bucket[nums[i] - min];
      if (rank == 1) {
        res[i] = "Gold Medal";
      }
      else if (rank == 2) {
        res[i] = "Silver Medal";
      }
      else if (rank == 3) {
        res[i] = "Bronze Medal";
      }
      else {
        res[i] = rank.toString();
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P506_Relative_Ranks p = new P506_Relative_Ranks();
    int[] nums1 = {5, 4, 3, 2, 1};
    String[] ans1 = {"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"};
    System.out.println(Arrays.equals(p.findRelativeRanks(nums1), ans1));
  
    int[] nums2 = {1, 1, 1};
    String[] ans2 = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    System.out.println(Arrays.equals(p.findRelativeRanks(nums2), ans2));
  
    int[] nums3 = {5, 10, 7, 4, 5, 3, 1, 2, 6};
    String[] ans3 = {
        "4", "Gold Medal", "Silver Medal", "6",
        "5", "7", "9", "8", "Bronze Medal",
    };
    System.out.println(Arrays.equals(p.findRelativeRanks(nums3), ans3));
  
    int[] nums4 = {2, 1, 1, 1, 3};
    String[] ans4 = {"Silver Medal", "Bronze Medal", "4", "5", "Gold Medal"};
    System.out.println(Arrays.equals(p.findRelativeRanks(nums4), ans4));
  
    int[] nums5 = {2, 1, 1, 4, 3};
    String[] ans5 = {"Bronze Medal", "4", "5", "Gold Medal", "Silver Medal"};
    System.out.println(Arrays.equals(p.findRelativeRanks(nums5), ans5));
  }
}

