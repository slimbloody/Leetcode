import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P628_Maximum_Product_of_Three_Numbers {
  public int maximumProduct(int[] nums) {
    return sol2(nums);
  }
  
  // single scan get the max1 max2 min1 min2, same as sol2
  // public int sol1(int[] nums) {
  // }
  
  // positive
  // - - +    - - - - + +: 0 1 size -1
  // + + +    + + + + + +: size - 3 size - 2 size - 1
  // negative:
  // - - - (all) min   - - - - - - -  size - 3 size - 2 size - 1
  // - + +    - - - - + + + +       0 size - 2 size - 1
  public int sol2(int[] nums) {
    Arrays.sort(nums);
    return Math.max(
        nums[0] * nums[1] * nums[nums.length - 1],
        nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]
    );
  }
  
  // positive
  // - - +
  // + + +
  // negative:
  // - - - (all) min
  // - + +
  public int sol4(int[] nums) {
    List<Integer> posList = new ArrayList<>();
    List<Integer> negList = new ArrayList<>();
    boolean hasZero = false;
  
    for (int num :nums) {
      if (num == 0) {
        hasZero = true;
      }
      else if (num > 0) {
        posList.add(num);
      }
      else {
        negList.add(num);
      }
    }
    Collections.sort(posList);
    Collections.sort(negList);
    int ppp = Integer.MIN_VALUE;
    int ppn = Integer.MIN_VALUE;
    int pnn = Integer.MIN_VALUE;
    int nnn = Integer.MIN_VALUE;
    if (posList.size() >= 3) {
      ppp = posList.get(posList.size() - 1)
          * posList.get(posList.size() - 2)
          * posList.get(posList.size() - 3);
    }
  
    if (posList.size() >= 2 && negList.size() >= 1) {
      ppn = posList.get(0)
          * posList.get(1)
          * negList.get(negList.size() - 1);
    }
  
    if (posList.size() >= 1 && negList.size() >= 2) {
      pnn = posList.get(posList.size() - 1)
          * negList.get(0)
          * negList.get(1);
    }
  
    if (negList.size() >= 3) {
      nnn = negList.get(negList.size() - 1)
          * negList.get(negList.size() - 2)
          * negList.get(negList.size() - 3);
    }
  
//    System.out.println(ppp + " " + ppn + " " + pnn + " " + nnn + " " + 0);
    List<Integer> collection = Arrays.asList(ppp, ppn, pnn, nnn);
    if (hasZero) {
      collection = new ArrayList(collection);
      collection.add(0);
    }
//    System.out.println(Collections.max(collection));
    
    return Collections.max(collection);
  }
  
  public static void main(String[] args) {
    P628_Maximum_Product_of_Three_Numbers p = new P628_Maximum_Product_of_Three_Numbers();
    int[] a1 = new int[]{1,2,3};
    System.out.println(p.maximumProduct(a1) == 6);
  
    int[] a2 = new int[]{1,2,3,4};
    System.out.println(p.maximumProduct(a2) == 24);
  
    int[] a3 = new int[]{-3,2,3,4};
    System.out.println(p.maximumProduct(a3) == 24);
  
    int[] a4 = new int[]{-1,-2,-3};
    System.out.println(p.maximumProduct(a4) == -6);
  
    int[] a5 = new int[]{-1,-2,-3,0};
    System.out.println(p.maximumProduct(a5) == 0);
  }
}
