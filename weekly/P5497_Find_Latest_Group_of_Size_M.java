public class P5497_Find_Latest_Group_of_Size_M {
  public int findLatestStep(int[] arr, int m) {
    return sol1(arr, m);
  }
  
  public int sol1(int[] arr, int m) {
    int num = 0;
    for (int i = 0; i < arr.length; ++i) {
      i = (i << arr[i]) | 1;
    }
    return 1;
  }
  
  public static void main(String[] args) {
    P5497_Find_Latest_Group_of_Size_M p = new P5497_Find_Latest_Group_of_Size_M();
    int[] a1 = new int[]{3,5,1,2,4};
    System.out.println(p.findLatestStep(a1, 4));
  }
}

