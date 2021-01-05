public class P5488_Minimum_Operations_to_Make_Array_Equal {
  public int minOperations(int n) {
    return sol1(n);
  }
  
  public int sol1(int n) {
    int pairs = n / 2;
    if ((n & 1) == 1) {
      return 2 * pairs + pairs * (pairs - 1); // ans / 2 * 2
    }
    else {
      return 1 * pairs + pairs * (pairs - 1); // ans / 2 * 2
    }
  }
  
  public static void main(String[] args) {
    P5488_Minimum_Operations_to_Make_Array_Equal p = new P5488_Minimum_Operations_to_Make_Array_Equal();
    System.out.println(p.sol1(3) == 2);
  }
}
