public class P1395_Count_Number_of_Teams {
  public int numTeams(int[] rating) {
    return sol1(rating);
  }
  
  // Trivial O(n ^ 2)
  public int sol1(int[] rating) {
    int n = rating.length;
    int res = 0;
    
    for (int i = 0; i < n; ++i) {
      int x1 = 0, x2 = 0, y1 = 0, y2 = 0;
      
      for (int j = 0; j < n; ++j) {
        if (i > j) {
          if (rating[i] > rating[j]) {
            ++x1;
          }
          else {
            ++x2;
          }
        }
        else if (i < j) {
          if (rating[i] > rating[j]) {
            ++y1;
          }
          else {
            ++y2;
          }
        }
      }
      
      int asc = x1 * y2;
      int dsc = x2 * y1;
      res = asc + dsc;
    }
    
    return res;
  }
  
  // sol: Trivial O(n ^ 3)
}
