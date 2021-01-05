public class P5520_Split_a_String_Into_the_Max_Number_of_Unique_Substrings {
  public int maxUniqueSplit(String s) {
    return sol1(s);
  }
  
  public int sol1(String s) {
    return 1;
  }
  
  public static void main(String[] args) {
    P5520_Split_a_String_Into_the_Max_Number_of_Unique_Substrings p = new P5520_Split_a_String_Into_the_Max_Number_of_Unique_Substrings();
    System.out.println(p.maxUniqueSplit("ababccc") == 5);
    System.out.println(p.maxUniqueSplit("aba") == 4);
    System.out.println(p.maxUniqueSplit("aa") == 1);
  }
}
