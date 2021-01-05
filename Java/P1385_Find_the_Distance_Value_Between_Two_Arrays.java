public class P1385_Find_the_Distance_Value_Between_Two_Arrays {
  public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
    return sol1(arr1, arr2, d);
  }
  
  public int sol1(int[] arr1, int[] arr2, int d) {
    int res = 0;
    for (int a1: arr1) {
      boolean flag = true;
      for (int a2 : arr2) {
        if (Math.abs(a1 - a2) <= d) {
          flag = false;
          break;
        }
      }
      
      res += flag ? 1 : 0;
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P1385_Find_the_Distance_Value_Between_Two_Arrays p = new P1385_Find_the_Distance_Value_Between_Two_Arrays();
    int[] a11 = new int[]{4,5,8};
    int[] a12 = new int[]{10,9,1,8};
    System.out.println(p.findTheDistanceValue(a11, a12, 2));
  
    int[] a21 = new int[]{2,1,100,3};
    int[] a22 = new int[]{-5,-2,10,-3,7};
    System.out.println(p.findTheDistanceValue(a21, a22, 6));
  }
}
