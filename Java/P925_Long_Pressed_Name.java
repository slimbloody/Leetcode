public class P925_Long_Pressed_Name {
  public boolean isLongPressedName(String name, String typed) {
    return sol1(name, typed);
  }
  
  public int getNum(String s, int index) {
    int count = 1;
    if (s.length() - 1 == index) {
      return count;
    }
    else {
      while ((index != s.length() - 1)
          && (s.charAt(index) == s.charAt(index + 1))) {
        ++count;
        ++index;
      }
    }
    
    return count;
  }
  
  public boolean sol1(String name, String typed) {
    int start1 = 0, start2 = 0;
    int c1, c2;
    while(start1 != name.length()) {
      c1 = name.charAt(start1);
      c2 = typed.charAt(start2);
      
      if (c1 != c2) {
        return false;
      }
      
      int count1 = getNum(name, start1);
      int count2 = getNum(typed, start2);
//      System.out.printf("c1: %c %d\n", c1, count1);
//      System.out.printf("c2: %c %d\n", c2, count2);
      if (count1 > count2) {
        return false;
      }
      
      start1 += count1;
      start2 += count2;
//      System.out.println("start1: " + start1);
//      System.out.println("start2: " + start2);
      
      if ((start1 == name.length()) && (start2 != typed.length())
          || (start1 != name.length()) && (start2 == typed.length())) {
        return false;
      }
    
    }
    return true;
  }
  
  public boolean sol2(String name, String typed) {
    int i = 0, j = 0, m = name.length(), n = typed.length();
    for (; j < n; ++j) {
      if (i < m && name.charAt(i) == typed.charAt(j)) {
        ++i;
      }
      else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
        return false;
      }
    }
    
    return i == m;
  }
  
  public static void main(String[] args) {
    P925_Long_Pressed_Name p = new P925_Long_Pressed_Name();
    System.out.println(p.isLongPressedName("alex", "aaleex") == true);
    System.out.println(p.isLongPressedName("saeed", "ssaaedd") == false);
    System.out.println(p.isLongPressedName("leelee", "lleeelee") == true);
    System.out.println(p.isLongPressedName("laiden", "laiden") == true);
    System.out.println(p.isLongPressedName("vtkgn", "vttkgnn") == true);
  }
  
}
