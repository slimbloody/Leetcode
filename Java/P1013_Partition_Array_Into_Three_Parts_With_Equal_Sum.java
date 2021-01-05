import java.util.Arrays;

public class P1013_Partition_Array_Into_Three_Parts_With_Equal_Sum {
  public boolean canThreePartsEqualSum(int[] A) {
    return sol2(A);
  }
  
  public boolean sol1(int[] A) {
    for (int i = 1; i < A.length; ++i) {
      A[i] = A[i - 1] + A[i];
    }
    
    if (A[A.length - 1] % 3 != 0) {
      return false;
    }
  
    System.out.println(Arrays.toString(A));
    int count = 1;
    System.out.printf("a[%d]: %d\n\n", A.length - 1, A[A.length - 1]);
    for (int i = 0; i < A.length; ++i) {
      if (A[i] * 3 / count == A[A.length - 1]) {
        System.out.printf("a[%d]: %d\n", i, A[i]);
        ++count;
      }
    }
    
    // consider the situation sum == 0, use >=
    // if the target sum is zero, we can reach it more than 3 times
    return count >= 4;
  }
  
  // two pointer
  public boolean sol2(int[] A) {
    int leftSum = A[0], rightSum = A[A.length - 1];
    int low = 1, high = A.length - 2;
    int sum = Arrays.stream(A).sum();
    if (sum % 3 != 0) {
      return false;
    }
    
    int average = sum / 3;
    
    while (low < high) {
      if (leftSum != average && low < high) {
//        System.out.println("A[low]: " + A[low]);
        leftSum += A[low];
        low += 1;
//        System.out.println("next low: " + low);
      }
      if (rightSum != average && low < high) {
//        System.out.println("A[high]: " + A[high]);
        rightSum += A[high];
        high -= 1;
//        System.out.println("next high: " + high);
      }
      if (leftSum == average && average == rightSum) {
        return true;
      }
      if (low >= high) {
        break;
      }
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    P1013_Partition_Array_Into_Three_Parts_With_Equal_Sum p = new P1013_Partition_Array_Into_Three_Parts_With_Equal_Sum();
//    int[] a1 = {0,2,1,-6,6,-7,9,1,2,0,1};
//    System.out.println(p.canThreePartsEqualSum(a1) == true);
//
//    int[] a2 = {10,-10,10,-10,10,-10,10,-10};
//    System.out.println(p.canThreePartsEqualSum(a2) == true);
//
//    int[] a3 = {1,0,1,0,1};
//    System.out.println(p.canThreePartsEqualSum(a3) == true);

    int[] a4 = {1,-1,1,-1};
    System.out.println(p.canThreePartsEqualSum(a4) == false);
    
    // low == high needs put at the end
//    int[] a5 = {3,3,6,5,-2,2,5,1,-9,4};
//    System.out.println(p.canThreePartsEqualSum(a5) == true);
  }
}
