public class P1539_Kth_Missing_Positive_Number {
  public int findKthPositive(int[] arr, int k) {
    return sol1(arr, k);
  }
  
  public int sol1(int[] arr, int k) {
    int res = 0;
    int index = 0;
    while (k > 0) {
      ++res;
      if (index < arr.length && arr[index] == res) {
        ++index;
      }
      else {
        --k;
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P1539_Kth_Missing_Positive_Number p = new P1539_Kth_Missing_Positive_Number();
    int[] arr1 = new int[]{2,3,4,7,11};
    System.out.println(p.findKthPositive(arr1, 5));
  
    int[] arr2 = new int[]{1,2,3,4};
    System.out.println(p.findKthPositive(arr2, 2));
    
    int[] arr3 = new int[]{2};
    System.out.println(p.findKthPositive(arr3, 1));
  }
}
