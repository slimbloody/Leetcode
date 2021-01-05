public class P34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
  public int[] searchRange(int[] nums, int target) {
    return sol1(nums, target);
  }
  
  public int[] sol1(int[] nums, int target) {
    int[] res = new int[]{-1, -1};
    int low = 0, high = nums.length - 1, mid;
    int ret = -1;
  
    while (low < high) {
      mid = (low + high) / 2;
      
      if (target < nums[mid]) {
        high = mid - 1;
      }
      else if (nums[mid] < target) {
        low = mid;
      }
      else {
        ret = low;
      }
    }
    
    return res;
  }
}
