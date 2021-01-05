public class P796_Rotate_String {
  public boolean rotateString(String A, String B) {
    return sol1(A, B);
  }
  
  public boolean sol1(String A, String B) {
    return ((A + A).contains(B)) && (A.length() == B.length());
  }
}
