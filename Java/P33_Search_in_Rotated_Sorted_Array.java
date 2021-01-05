public class P33_Search_in_Rotated_Sorted_Array {
  public int search(int[] nums, int target) {
    return sol1(nums, target);
  }
  
  public int sol1(int[] nums, int target) {
    int low = 0, high = nums.length - 1, mid, realMid;
    
    // find the index of the smallest value using binary search
    while (low < high) {
      mid = (low + high) / 2;
      if (nums[mid] > nums[high]) {
        low = mid + 1;
      }
      else {
        high = mid;
      }
    }
    int rotationPoint = low;
    low = 0;
    high = nums.length - 1;
    
    while (low <= high) {
      mid = (low + high) / 2;
      realMid = (mid + rotationPoint) % nums.length;
      if (nums[realMid] == target) {
        return realMid;
      }
      else if (nums[realMid] < target) {
        low = mid + 1;
      }
      else {
        high = mid - 1;
      }
    }
    
    return -1;
  }
  
  public int sol2(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    
    while (low <= high) {
      int mid = (low + high) / 2;
      if (nums[mid] == target) {
        return mid;
      }
      else if (nums[low] <= nums[mid]) {
        if (target < nums[mid] && target>= nums[low]) {
          high = mid - 1;
        }
        else {
          low = mid + 1;
        }
      }
      else if (nums[mid] <= nums[high]) {
        if (target > nums[mid] && target <= nums[high]) {
          low = mid + 1;
        }
        else {
          high = mid - 1;
        }
      }
    }
    
    return -1;
  }
  
  public int sol3(int[] nums, int target) {
    int low = 0, high = nums.length - 1, mid;
    
    while (low < high) {
      mid = (low + high) / 2;
      
      if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])) {
        low = mid + 1;
      }
      else {
        high = mid;
      }
    }
    
    return low == high && nums[low] == target ? low : -1;
  }
}
