// O(log n)
// non-decreasing
// If target is not found in the array, return [-1, -1]
public class P34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
  public int[] searchRange(int[] nums, int target) {
    return sol1(nums, target);
  }

  // divide and conquer
  // find the target - 1 element with largest index
  // find the target + 1 element with smallest index
  public int[] sol1(int[] nums, int target) {
      return new int[]{};
  }

  public static void main(String[] args) {
    P34_Find_First_and_Last_Position_of_Element_in_Sorted_Array p = new P34_Find_First_and_Last_Position_of_Element_in_Sorted_Array();
    int[] a1 = new int[]{5,7,7,8,8,10};
    int t1 = 8;
    System.out.println(p.searchRange(a1, t1));
    // [3,4]

    int[] a2 = new int[]{5,7,7,8,8,10};
    int t2 = 6;
    System.out.println(p.searchRange(a2, t2));
    // [-1,-1]

    int[] a3 = new int[]{};
    int t3 = 0;
    System.out.println(p.searchRange(a3, t3));
    // [-1,-1]
  }
}
