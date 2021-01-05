import java.util.Arrays;

public class P1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
  public int numPairsDivisibleBy60(int[] time) {
    return sol1(time);
  }
  
//  (t + x) % 60 = 0
//  x % 60 = 60 - t % 60
//  x % 60 = (600 - t) % 60
//  x = (600 - t) % 60
  public int sol1(int[] time) {
    int c[]  = new int[60], res = 0;
    for (int t : time) {
      res += c[(600 - t) % 60];
      c[t % 60] += 1;
    }
    return res;
  }
  
  public int sol2(int[] time) {
    int[] a = new int[60];
    Arrays.fill(a, 0);
    int count = 0;
    
    for (int e: time) {
      int temp = e % 60;
      ++a[temp];
    }
    
    
    for (int i = 1; i < 30; ++i) {
      if (a[i] != 0 && a[60 - i] != 0) {
        count = count + a[i] * a[60 - i];
      }
    }
  
    if (a[0] > 0) {
      count = count + a[0] * (a[0] - 1) / 2;
    }
    
    if (a[30] > 1) {
      count = count + a[30] * (a[30] - 1) / 2;
    }
    
    return count;
  }
  
  public static void main(String[] args) {
    P1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60 p =
        new P1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60();
    
    int[] a1 = {30,20,150,100,40};
    System.out.println(p.numPairsDivisibleBy60(a1));
  }
}
