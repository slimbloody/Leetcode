import java.lang.reflect.Array;
import java.util.Arrays;

public class P91_Decode_Ways {
  public int numDecodings(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    
    return sol2(s);
  }
  
  public int sol1(String s) {
    int n = s.length();
    int[] dp = new int[n + 1];
    Arrays.fill(dp, 0);
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    
    for (int i = 2; i <= n; ++i) {
      int singleNum = Integer.valueOf(s.substring(i - 1, i));
      int doubleNum = Integer.valueOf(s.substring(i - 2, i));
      if (1 <= singleNum && singleNum <= 9) {
        dp[i] += dp[i - 1];
      }
      if (10 <= doubleNum && doubleNum <= 26) {
        dp[i] += dp[i - 2];
      }
    }
  
    return dp[n];
  }
  
  public int sol2(String s) {
    int p = 1, pp = 0, n = s.length();
    
    for (int i = n - 1; i >= 0; --i) {
      int cur = (s.charAt(i) == '0') ? 0 : p;
      
      if (i < n - 1 &&
          (s.charAt(i) == '1' ||
              s.charAt(i) == '2' && (s.charAt(i + 1) - '0' <= 6))) {
        cur += pp;
      }
      pp = p;
      p = cur;
    }
    
    return s.length() == 0 ? 0 : p;
  }
  
  public int sol3(String s) {
    int res = 0;
    if (s.length() == 0) {
      return 1;
    }
    if (s.length() >= 1 && Integer.valueOf(s.substring(0, 1)) != 0) {
      res = res + sol3(s.substring(1));
    }
    if (s.length() >= 2) {
      int temp = Integer.valueOf(s.substring(0, 2));
      if (temp >= 10 && temp <= 26) {
        res = res + sol3(s.substring(2));
      }
    }
    
    return res;
  }
  
  public int sol4(String s) {
    int res = 0;
    if (s.length() == 0) {
      return 1;
    }
    if (s.length() >= 1 && s.charAt(0) - '0' != 0) {
      res = res + sol4(s.substring(1));
    }
    if (s.length() >= 2) {
      if ((s.charAt(0) - '0' == 1 && s.charAt(1) - '0' >= 0
          && s.charAt(1) - '0' <= 9) ||
          (s.charAt(0) - '0' == 2 && s.charAt(1) - '0' >= 0
          && s.charAt(1) - '0' <= 6)) {
        res = res + sol4(s.substring(2));
      }
    }
  
    return res;
  }
  
  public static void main(String[] args) {
    P91_Decode_Ways p = new P91_Decode_Ways();
    System.out.println(p.numDecodings("12") == 2);
    System.out.println(p.numDecodings("226") == 3);
    System.out.println(p.numDecodings("0") == 0);
    System.out.println(p.numDecodings("10") == 1);
  }
}

