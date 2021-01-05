public class P14_Longest_Common_Prefix {
  public String longestCommonPrefix(String[] strs) {
    return sol1(strs);
  }
  
  public String sol1(String[] strs) {
    StringBuilder sb = new StringBuilder();
    int minLen = Integer.MAX_VALUE;
    for (int i = 0; i < strs.length; ++i) {
      if (strs[i].length() < minLen) {
        minLen = strs[i].length();
      }
    }
    minLen = minLen == Integer.MAX_VALUE ? 0 : minLen;
    
    for (int i = 0; i < minLen; ++i) {
      for (int j = 1; j < strs.length; ++j) {
        if (strs[j - 1].charAt(i) != strs[j].charAt(i)) {
          return sb.toString();
        }
      }
      sb.append(strs[0].charAt(i));
    }
    
    return sb.toString();
  }
  
  // divide and conquer. like mergesort
  // ============== start =====================
  public String sol2(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    
    return sol2(strs, 0, strs.length - 1);
  }
  
  private String sol2(String[] strs, int l, int r) {
    if (l == r) {
      return strs[l];
    }
    else {
      int mid = (l + r) / 2;
      String lcpLeft = sol2(strs, l, mid);
      String lcpRight = sol2(strs, mid + 1, r);
      
      return sol2CommonPrefix(lcpLeft, lcpRight);
    }
  }
  
  private String sol2CommonPrefix(String left, String right) {
    int min = Math.min(left.length(), right.length());
    for (int i = 0; i < min; ++i) {
      if (left.charAt(i) != right.charAt(i)) {
        return left.substring(0, i);
      }
    }
    
    return left.substring(0, min);
  }
  // ============== end =====================
  
  // binary search
  // ============== start =====================
  public String sol3(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }
    int minLen = Integer.MAX_VALUE;
    for (String str: strs) {
      minLen = Math.min(minLen, str.length());
    }
    int low = 1, high = minLen;
    
    while (low < high) {
      int middle = (low + high) / 2;
      if (sol3IsCommomPrefix(strs, middle)) {
        low = middle + 1;
      }
      else {
        high = middle - 1;
      }
    }
    
    return strs[0].substring(0, (low + high) / 2);
  }
  
  private boolean sol3IsCommomPrefix(String[] strs, int len) {
    String str1 = strs[0].substring(0, len);
    
    for (int i = 1; i < strs.length; ++i) {
      if (!strs[i].startsWith(str1)) {
        return false;
      }
    }
    
    return true;
  }
  // ============== end =====================
  
  public static void main(String[] args) {
    P14_Longest_Common_Prefix p = new P14_Longest_Common_Prefix();
    String[] s1 = new String[]{"flower","flow","flight"};
    System.out.println(p.longestCommonPrefix(s1).equals("fl"));
  
    String[] s2 = new String[]{"dog","racecar","car"};
    System.out.println(p.longestCommonPrefix(s2).equals(""));
  
    String[] s3 = new String[]{};
    System.out.println(p.longestCommonPrefix(s3).equals(""));
  }
}
