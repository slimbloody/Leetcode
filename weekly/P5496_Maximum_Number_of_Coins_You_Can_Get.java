import java.lang.reflect.Array;
import java.util.Arrays;

public class P5496_Maximum_Number_of_Coins_You_Can_Get {
// 1,2,3,4,5,6,7,8,9
// 3 8 9
// 2 6 7
// 1 4 5
  
  public int maxCoins(int[] piles) {
    return sol1(piles);
  }
  
  public int sol1(int[] piles) {
    Arrays.sort(piles);
    int boundary = piles.length / 3;
    int count = 0;
    int res = 0;
    
    for (int i = piles.length - 2; i >= 0; i -= 2) {
      if (count == boundary) {
        break;
      }
      else {
        res += piles[i];
        ++count;
      }
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P5496_Maximum_Number_of_Coins_You_Can_Get p = new P5496_Maximum_Number_of_Coins_You_Can_Get();
    int[] a1 = new int[]{2,4,1,2,7,8};
    System.out.println(p.maxCoins(a1));
  
    int[] a2 = new int[]{2,4,5};
    System.out.println(p.maxCoins(a2));
  
    int[] a3 = new int[]{9,8,7,6,5,1,2,3,4};
    System.out.println(p.maxCoins(a3));
  }
}




