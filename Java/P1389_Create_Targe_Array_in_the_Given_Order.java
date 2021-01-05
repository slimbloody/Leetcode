import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1389_Create_Targe_Array_in_the_Given_Order {
  public int[] createTargetArray(int[] nums, int[] index) {
    return sol1(nums, index);
  }
  
  public int[] sol1(int[] nums, int[] index) {
    return new int[1];
  }
  
  public int[] sol2(int[] nums, int[] index) {
    int[] res = new int[nums.length];
    List<Integer> tempList = new ArrayList<>();
    for (int i = 0; i < nums.length; ++i) {
      tempList.add(index[i], nums[i]);
    }
  
    for(int i = 0; i < nums.length; ++i) {
      res[i] = tempList.get(i);
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P1389_Create_Targe_Array_in_the_Given_Order p = new P1389_Create_Targe_Array_in_the_Given_Order();
  
    int[] nums1 = new int[]{0,1,2,3,4};
    int[] index1 = new int[]{0,1,2,2,1};
    System.out.println(Arrays.toString(p.createTargetArray(nums1, index1)));
  
    int[] nums2 = new int[]{1};
    int[] index2 = new int[]{0};
    System.out.println(Arrays.toString(p.createTargetArray(nums2, index2)));
  
    int[] nums3 = new int[]{4,2,4,3,2};
    int[] index3 = new int[]{0,0,1,3,1};
    System.out.println(Arrays.toString(p.createTargetArray(nums3, index3)));
  }
}
