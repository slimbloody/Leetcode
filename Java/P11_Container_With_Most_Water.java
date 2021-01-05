public class P11_Container_With_Most_Water {
  public int maxArea(int[] height) {
    return sol1(height);
  }
  
  public int sol1(int[] height) {
    int res = 0;
    int temp;
    for (int i = 0; i < height.length - 1; ++i) {
      for (int j = i + 1; j < height.length; ++j) {
        temp = (j - i) * Math.min(height[i], height[j]);
        
        if (temp > res) {
          res = temp;
        }
      }
    }
    
    return res;
  }
}
