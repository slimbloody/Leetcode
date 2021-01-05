import java.util.Arrays;

public class P1304_Find_N_Unique_Integers_Sum_up_to_Zero {
  public int[] sumZero(int n) {
    return sol1(n);
  }
  
  public int[] sol1(int n) {
    int[] res = new int[n];
    int index = 0;
    int pivot = n / 2;
    System.out.println("pivot: " + pivot);
    
    for (; index < pivot; ++index) {
      System.out.println("index: " + index);
      res[index * 2] = index + 1;
      res[index * 2 + 1] = -res[index * 2];
    }
    
    if ((n | 1) == 1) {
      res[index] = 0;
    }
    
    return res;
  }
  
  public int[] sol2(int n) {
    int[] res = new int[n];
    int left = 0, right = n - 1, start = 1;
    while (left < right) {
      res[left++] = start;
      res[right--] = -start;
      start++;
    }
    return res;
  }
  
  public static void main(String[] args) {
    P1304_Find_N_Unique_Integers_Sum_up_to_Zero p = new P1304_Find_N_Unique_Integers_Sum_up_to_Zero();
    System.out.println(Arrays.toString(p.sumZero(5)));
    System.out.println(Arrays.toString(p.sumZero(3)));
  }
}
