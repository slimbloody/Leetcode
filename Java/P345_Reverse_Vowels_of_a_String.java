import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class P345_Reverse_Vowels_of_a_String {
  public String reverseVowels(String s) {
    return sol1(s);
  }
  
  public String sol1(String s) {
    String vowels = "aeiouAEIOU";
//    List<Character> chars = Arrays.asList(vowels.toCharArray());
    char[] vArr = vowels.toCharArray();
    
    char[] arr = s.toCharArray();
    int start = 0, end = arr.length - 1;
    
    while (start < end) {
//      while (start < end && !vArr.contains(arr[start++])) {
//      }
//
//      while (start < end && !vArr.contains(arr[end--])) {
//      }
  
      char temp = vArr[start];
      vArr[start] = vArr[end];
      vArr[end] = temp;
  
      ++start;
      --end;
    }
    
    return new String(arr);
  }
}
