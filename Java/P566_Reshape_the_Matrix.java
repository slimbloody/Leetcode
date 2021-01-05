public class P566_Reshape_the_Matrix {
  public int[][] matrixReshape(int[][] nums, int r, int c) {
    return sol1(nums, r, c);
  }
  
  public int[][] sol1(int[][] nums, int r, int c) {
    int a = nums.length;
    
    if (a == 0) {
      return nums;
    }
    
    int b = nums[0].length;
    
    if (a * b != r * c) {
      return nums;
    }
    else {
      int[][] res = new int[r][c];
  
      // java multi-dimension array doesn't store as one-dimension array
      for (int i = 0; i < r * c; ++i) {
        res[i / c][i % c] = nums[i / b][i % b];
      }
  
      return res;
    }
  }
}
