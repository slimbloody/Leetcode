public class P704_Binary_Search {
  public int search(int[] nums, int target) {
    return sol1(nums, target);
  }
  
  public int sol1(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;
    
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      else if (nums[mid] > target) {
        high = mid - 1;
      }
      else {
        low = mid + 1;
      }
    }
    
    return -1;
  }
}

