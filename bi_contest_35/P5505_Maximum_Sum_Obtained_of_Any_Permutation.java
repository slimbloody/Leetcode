import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P5505_Maximum_Sum_Obtained_of_Any_Permutation {
  public int maxSumRangeQuery(int[] nums, int[][] requests) {
    return sol1(nums, requests);
  }
  
  public int sol1(int[] nums, int[][] requests) {
    return 1;
  }
  
  public int sol2(int[] nums, int[][] requests) {
    int res = 0;
    Arrays.sort(nums);
    int[] tempArr = new int[nums.length];
    
    for (int i = 0; i < requests.length; ++i) {
      for (int j = requests[i][0]; j <= requests[i][1]; ++j) {
        ++tempArr[j];
      }
    }
    System.out.println(Arrays.toString(tempArr));
    
    List<Integer> tempList = new ArrayList<>();
    for (int i = 0; i < tempArr.length; ++i) {
      if (tempArr[i] != 0) {
        tempList.add(tempArr[i]);
      }
    }
    Collections.sort(tempList);
    System.out.println(tempList.toString());
    
    for (int i = 0; i < tempList.size(); ++i) {
      res = (int) ((res + tempList.get(tempList.size() - 1 - i) * nums[nums.length - 1 - i]) % (Math.pow(10, 9) + 7));
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P5505_Maximum_Sum_Obtained_of_Any_Permutation p = new P5505_Maximum_Sum_Obtained_of_Any_Permutation();
    int[] a1 = new int[]{1,2,3,4,5};
    int[][] b1 = new int[][]{{1,3}, {0,1}};
    System.out.println(p.maxSumRangeQuery(a1, b1));
  
    int[] a2 = new int[]{1,2,3,4,5,6};
    int[][] b2 = new int[][]{{0,1}};
    System.out.println(p.maxSumRangeQuery(a2, b2));
  
    int[] a3 = new int[]{1,2,3,4,5,10};
    int[][] b3 = new int[][]{{0,2},{1,3},{1,1}};
    System.out.println(p.maxSumRangeQuery(a3, b3));
  }
}

