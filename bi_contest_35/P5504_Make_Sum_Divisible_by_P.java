import java.util.Arrays;

public class P5504_Make_Sum_Divisible_by_P {
  public int minSubarray(int[] nums, int p) {
    return sol1(nums, p);
  }
  
  public int sol1(int[] nums, int p) {
    long[] tempArr = new long[nums.length + 1];
    tempArr[0] = 0;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < nums.length; ++i) {
      tempArr[i + 1] = (tempArr[i] + nums[i]) % p;
    }
    long reamin = tempArr[tempArr.length - 1];
    System.out.println(Arrays.toString(tempArr));
    System.out.println("reamin: " + reamin);
    
    if (reamin == 0) {
      return 0;
    }
  
    for (int i = 0; i < tempArr.length - 1; ++i) {
      for (int j = i + 1; j < tempArr.length; ++j) {
//        System.out.printf(
//            "tempArr[%d]: %d; tempArr[%d]: %d; res: %d\n",
//            j, tempArr[j], i, tempArr[i], tempArr[j] - tempArr[i]
//        );
//        System.out.printf("diff: %d again: %d\n",
//            tempArr[j] - tempArr[i] + p,
//            (tempArr[j] - tempArr[i] + p) % p
//        );
        if (j - i >= res) {
//          System.out.println("break");
          break;
        }
        if (!(i == 0 && j == tempArr.length - 1) &&
            (tempArr[j] - tempArr[i] + p) % p == reamin) {
//          System.out.println("get");
          res = j - i;
        }
      }
    }
    
    return res == Integer.MAX_VALUE ? -1 : res;
  }
  
  public static void main(String[] args) {
    P5504_Make_Sum_Divisible_by_P p = new P5504_Make_Sum_Divisible_by_P();
    int[] a1 = new int[]{3,1,4,2};
    System.out.println(p.minSubarray(a1, 6) == 1);

    int[] a2 = new int[]{6,3,5,2};
    System.out.println(p.minSubarray(a2, 9) == 2);

    int[] a3 = new int[]{1,2,3};
    System.out.println(p.minSubarray(a3, 3) == 0);

    int[] a4 = new int[]{1,2,3};
    System.out.println(p.minSubarray(a4, 7) == -1);

    int[] a5 = new int[]{1000000000,1000000000,1000000000};
    System.out.println(p.minSubarray(a5, 3) == 0);

    int[] a6 = new int[]{4,4,2};
    System.out.println(p.minSubarray(a6, 7) == -1);
  
    int[] a7 = new int[]{6,3,5,2};
    System.out.println(p.minSubarray(a7, 9) == 2);
  
  }
}
