public class P1422_Maximum_Score_After_Splitting_a_String {
  public int maxScore(String s) {
    return sol1(s);
  }
  
  // Result = Max of (ZerosOnLeft + OnesOnRight)
  //        = Max of (ZerosOnLeft + (TotalOnes - OnesOnLeft))
  //        = Max of (ZerosOnLeft - OnesOnLeft) + TotalOnes (as TotalOnes is constant)
  public int sol1(String s) {
    int zeros = 0, ones = 0, max = Integer.MIN_VALUE;
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '0') {
        ++zeros;
      }
      else {
        ++ones;
      }
      
      if (i != s.length() - 1) {
        max = Math.max(zeros - ones, max);
      }
    }
    
    return max + ones;
  }
}
