public class P639_Decode_Ways_II {
  public int numDecodings(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    int[] dp = new int[s.length() + 1];
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '*') {
        dp[i] = dp[i - 1] + 8;
      }
      else {
        int singleNum = Integer.valueOf(s.substring(0, 1));
        if (1 <= singleNum && singleNum <= 9) {
          dp[i] = dp[i - 1];
        }
        if (singleNum == 1) {
          return 1;
        }
      }
    }
    
    return 1;
  }
}
