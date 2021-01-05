public class P26_Remove_Duplicates_from_Sorted_Array {
  public int removeDuplicates(int[] nums) {
    return sol1(nums);
  }
  
  public int sol1(int[] nums) {
    int i = 0;
    for (int n: nums) {
      if (i < 1 || n > nums[i - 1]) {
        nums[i++] = n;
      }
    }
    
    return i;
  }
  
  public int sol2(int[] nums) {
    int replace = -1;
    
    for (int i = 0; i < nums.length; ++i) {
      if (replace < 0 || nums[i] != nums[replace]) {
        nums[++replace] = nums[i];
      }
    }
    
    return replace + 1;
  }
  
  public int sol3(int[] A) {
    if (A.length==0) return 0;
    int j=0;
    for (int i=0; i<A.length; i++)
      if (A[i]!=A[j]) A[++j]=A[i];
    return ++j;
  }
}
