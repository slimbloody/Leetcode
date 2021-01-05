import java.util.Arrays;

public class P5503_Sum_of_All_Odd_Length_Subarrays {
  public int sumOddLengthSubarrays(int[] arr) {
    return sol1(arr);
  }
  
  public int sol1(int[] arr) {
    int res = 0;
    int[] tempArr = new int[arr.length + 1];
    
    tempArr[0] = 0;
    for (int i = 0; i < arr.length; ++i) {
      tempArr[i + 1] = arr[i] + tempArr[i];
    }
    
    for (int i = 0; i < tempArr.length - 1; ++i) {
      for (int j = i + 1; j < tempArr.length; j += 2) {
        res += (tempArr[j] - tempArr[i]);
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P5503_Sum_of_All_Odd_Length_Subarrays p = new P5503_Sum_of_All_Odd_Length_Subarrays();
    int[] a1 = new int[]{1,4,2,5,3};
    System.out.println(p.sumOddLengthSubarrays(a1));
  
    int[] a2 = new int[]{1, 2};
    System.out.println(p.sumOddLengthSubarrays(a2));
  
    int[] a3 = new int[]{10, 11, 12};
    System.out.println(p.sumOddLengthSubarrays(a3));
  }
}
