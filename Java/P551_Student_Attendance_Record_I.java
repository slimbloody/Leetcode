public class P551_Student_Attendance_Record_I {
  public boolean checkRecord(String s) {
    return sol1(s);
  }
  
  public boolean sol1(String s) {
    int aNum = 0;
    int lNum = 0;
    
    for(int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
  
      if(c == 'A') {
        ++aNum;
        lNum = 0;
      }
      else if(c == 'L') {
        ++lNum;
      }
      else {
        lNum = 0;
      }
      
      if(lNum > 2 || aNum > 1) {
        return false;
      }
    }
    
    return true;
  }
  
  public boolean sol2(String s) {
    if(s.indexOf("A") != s.lastIndexOf("A") || s.contains("LLL")) {
      return false;
    }
    
    return true;
  }
  
  public boolean sol3(String s) {
    return !s.matches(".*LLL.*|.*A.*A.*");
  }
}
