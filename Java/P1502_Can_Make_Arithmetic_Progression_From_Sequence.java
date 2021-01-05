import java.util.Arrays;

public class P1502_Can_Make_Arithmetic_Progression_From_Sequence {
  public boolean canMakeArithmeticProgression(int[] arr) {
    Arrays.sort(arr);
    int[] diffs = new int[arr.length - 1];
    for (int i = 1; i < arr.length; ++i) {
      diffs[i - 1] = arr[i] - arr[i - 1];
    }
  
    for (int i = 1; i < diffs.length; ++i) {
      if ((diffs[i] ^ diffs[i - 1]) != 0) {
        return false;
      }
    }
    return true;
  }
}
