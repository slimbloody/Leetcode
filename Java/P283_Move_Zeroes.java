import java.util.Arrays;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class P283_Move_Zeroes {
  public void moveZeroes(int[] nums) {
    sol1(nums);
  }
  
  public void sol1(int[] nums) {
    int i = 0;
    
    for (int j = 0; j < nums.length; ++j) {
      if (nums[j] != 0) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        ++i;
      }
    }
  }
  
  // snow ball: move all the zeros
  public void sol2(int[] nums) {
    int snowBallSize = 0;
    for (int i = 0; i < nums.length; ++i){
      if (nums[i] == 0){
        ++snowBallSize;
      }
      else if (snowBallSize > 0) {
        int t = nums[i];
        nums[i] = 0;
        nums[i - snowBallSize]=t;
      }
    }
  }
  
  public static void main(String[] args) {
    P283_Move_Zeroes p = new P283_Move_Zeroes();
    int[] a1 = {0,1,0,3,12};
    p.moveZeroes(a1);
    System.out.println(Arrays.toString(a1));
  
    int[] a2 = {1,0};
    p.moveZeroes(a2);
    System.out.println(Arrays.toString(a2));
    
    int[] a3 = {1,0,1};
    p.moveZeroes(a3);
    System.out.println(Arrays.toString(a3));
  
    int[] a4 = {0,0,0};
    p.moveZeroes(a4);
    System.out.println(Arrays.toString(a4));
  }
}
