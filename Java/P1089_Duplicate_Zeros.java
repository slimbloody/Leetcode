import java.util.Arrays;

public class P1089_Duplicate_Zeros {
  public void duplicateZeros(int[] arr) {
    sol1(arr);
  }
  
  public void sol1(int[] arr) {
    int i = 0, j = 0;
    int len = arr.length;
    
    for (; j > arr.length - 1; ++i, ++j) {
      if (arr[i] == 0) {
        j += 1;
      }
    }
    
    System.out.println(j);
    
    for (int k = arr.length - 1; k >= 0; --k, --i) {
      if (k == arr.length - 1) {
        if (arr[i] == 0 && j == arr.length - 1) {
          arr[k--] = arr[i];
          arr[k] = arr[i];
        }
        else {
          arr[k] = arr[i];
        }
      }
      else {
        if (arr[i] == 0) {
          arr[k--] = arr[i];
          arr[k] = arr[i];
        }
        else {
          arr[k] = arr[i];
        }
      }
    }
  
    System.out.println(Arrays.toString(arr));
  }
  
  public static void main(String[] args) {
    P1089_Duplicate_Zeros p = new P1089_Duplicate_Zeros();
//    int[] a1 = {1,0,2,3,0,4,5,0};
//    p.duplicateZeros(a1);
//
//    int[] a2 = {1,2,3};
//    p.duplicateZeros(a2);
  
    int[] a3 = {1,2,0};
    p.duplicateZeros(a3);
  }
}
