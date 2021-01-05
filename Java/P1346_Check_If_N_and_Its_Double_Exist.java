import java.util.Arrays;

public class P1346_Check_If_N_and_Its_Double_Exist {
  public boolean checkIfExist(int[] arr) {
    return sol2(arr);
  }
  
  // if (seen.contains(2 * i) || i % 2 == 0 && seen.contains(i / 2))
  // HashSet provides O(1) lookup
  public boolean sol1(int[] arr) {
    return true;
  }
  
  // -10^3 <= arr[i] <= 10^3
  // 2 <= arr.length <= 500
  // ==> 打表法: array做hash
  // 桶排序
  public boolean sol2(int[] arr) {
    return true;
  }
  
  public boolean sol3(int[] arr) {
    Arrays.sort(arr);
    for (int i = 0; i < arr.length - 1; ++i) {
      if (arr[i] < 0) {
        if (arr[i] % 2 != 0) {
          continue;
        }
        else {
          boolean ans1 = binarySearch(i, arr, arr[i] / 2);
          if (ans1) {
            return true;
          }
        }
      }
      else {
        boolean ans2 = binarySearch(i, arr, arr[i] * 2);
        if (ans2) {
          return true;
        }
      }
    }
    
    return false;
  }
  
  public boolean binarySearch(int i, int[] arr, double target) {
    int low = i + 1;
    int high = arr.length - 1;
    while(low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == target) {
        return true;
      }
      else if (arr[mid] > target) {
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    P1346_Check_If_N_and_Its_Double_Exist p = new P1346_Check_If_N_and_Its_Double_Exist();
    int[] a1 = {10, 2, 5, 3};
    System.out.println(p.checkIfExist(a1));
  
    int[] a2 = {-10,12,-20,-8,15};
    System.out.println(p.checkIfExist(a2));
  }
}
