public class P520_Detect_Capital {
  public boolean detectCapitalUse(String word) {
    return sol1(word);
  }
  
  public int sol1JudgeCase(Character c) {
    if (Character.isLowerCase(c)) {
      return 0;
    }
    else if (Character.isUpperCase(c)) {
      return 1;
    }
    
    return -1;
  }
  
  public boolean sol1(String word) {
    int res = 0, first = 0, temp = 0;
    first = sol1JudgeCase(word.charAt(0));
  
    for (int i = 1; i < word.length(); ++i) {
      temp = sol1JudgeCase(word.charAt(i));
  
      if (i == 1) {
        if (first == 0 && temp == 1) {
          return false;
        }
        res = temp;
      }
      else {
        if ((res ^ temp) == 1) {
          return false;
        }
      }
    }
    return true;
  }
  
  public boolean sol2(String word) {
    return word.matches("[A-Z]*|[A-Z]?[a-z]*");
    // return word.matches("[A-Z][a-z]*|[a-z]*|[A-Z]*");
  }
  
  // def detectCapitalUse(self, word):
  //   return word.isupper() or word.islower() or word.istitle()
  
  public static void main(String[] args) {
    P520_Detect_Capital p = new P520_Detect_Capital();
    System.out.println(p.detectCapitalUse("Leetcode"));
  }
}
