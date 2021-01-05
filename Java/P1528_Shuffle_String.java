import java.util.Arrays;

public class P1528_Shuffle_String {
  public String restoreString(String s, int[] indices) {
    return sol1(s, indices);
  }
  
  public String sol1(String s, int[] indices) {
    char[] charArray = s.toCharArray();
    
    for (int i = 0; i < indices.length - 1; ++i) {
      for (int j = i; j < indices.length; ++j) {
        if (indices[j] == i && i != j) {
          char c = charArray[j];
          charArray[j] = charArray[i];
          charArray[i] = c;
          
          int temp = indices[j];
          indices[j] = indices[i];
          indices[i] = temp;
        }
      }
    }
    
    return new String(charArray);
  }
  
  public static void main(String[] args) {
    P1528_Shuffle_String p = new P1528_Shuffle_String();
    String s1 = "codeleet";
    int[] indices1 = {4,5,6,7,0,2,1,3};
    System.out.println(p.restoreString(s1, indices1));
  
    String s2 = "abc";
    int[] indices2 = {0,1,2};
    System.out.println(p.restoreString(s2, indices2));

    String s3 = "aiohn";
    int[] indices3 = {3,1,4,2,0};
    System.out.println(p.restoreString(s3, indices3));

    String s4 = "aaiougrt";
    int[] indices4 = {4,0,2,6,7,3,1,5};
    System.out.println(p.restoreString(s4, indices4));

    String s5 = "art";
    int[] indices5 = {1,0,2};
    System.out.println(p.restoreString(s5, indices5));
  }
}
