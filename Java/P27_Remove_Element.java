import java.util.Arrays;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class P27_Remove_Element {
  public int removeElement(int[] nums, int val) {
    return sol1(nums, val);
  }
  
  public int sol1(int[] nums, int val) {
    int i = 0;
    
    for (int j = 0; j < nums.length; ++j) {
      if (nums[j] != val) {
        nums[i++] = nums[j];
      }
    }
    System.out.println(Arrays.toString(nums));
    
    return i;
  }
  
  public static void main(String[] args) {
    P27_Remove_Element p = new P27_Remove_Element();
    int[] nums1 = {1, 1, 1, 1};
    System.out.println(p.removeElement(nums1, 1));
  
  
    int[] nums2 = {3, 2, 2, 3};
    System.out.println(p.removeElement(nums2, 3));
  }
}
