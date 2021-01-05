import java.util.Arrays;

public class P1460_Make_Two_Arrays_Equal_by_Reversing_Sub_arrays {
  public boolean canBeEqual(int[] target, int[] arr) {
    return sol1(target, arr);
  }
  
  public boolean sol1(int[] target, int[] arr) {
    Arrays.sort(target);
    Arrays.sort(arr);
    return Arrays.equals(target, arr);
  }
}
