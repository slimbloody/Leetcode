import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class P1002_Find_Common_Characters {
  public List<String> commonChars(String[] A) {
    return sol1(A);
  }
  
  public List<String> sol1(String[] A) {
    int[] arr = new int[26];
    // key point
    Arrays.fill(arr, Integer.MAX_VALUE);
    
    for (String str : A) {
      int[] tempArr = new int[26];
      Arrays.fill(tempArr, 0);
      
      str
          .chars()
          .forEach(c -> ++tempArr[c - 'a']);
      
      IntStream
          .range(0, 26)
          .forEach(i ->  arr[i] = Math.min(tempArr[i], arr[i]));
    }
    
    List<String> ans = new ArrayList<>();
    System.out.println(Arrays.toString(arr));
    
    IntStream
        .range('a', 'z' + 1)
        .forEach(
            c ->  ans.addAll(
                Collections.nCopies(arr[c - 'a'], "" + (char)c)
            )
        );
    
    return ans;
  }
  
  // bitwise: char arr[] three string then 3 bit: 111
  // error! the character can't be repeat
  /*
  public List<String> sol2(String[] A) {
    List<String> res = new ArrayList<>();
    
    int[] arr = new int[26];
    Arrays.fill(arr, 0);
    for (int i = 0; i < 3; ++i) {
      char[] temp = A[i].toCharArray();
      for (int j = 0; j < temp.length; ++j) {
        arr[temp[j] - 'a'] = arr[temp[j] - 'a'] | (1 << i);
        System.out.println(arr[temp[j] - 'a']);
      }
      System.out.println(Arrays.toString(arr));
    }
    
    for (int i = 0; i < 26; ++i) {
      if (arr[i] == 7) {
        res.add(String.valueOf('a' + i));
      }
    }
    
    return res;
  }
   */
  
  // intersection of set
  public List<String> sol3(String[] A) {
    return null;
  }
  
  public static void main(String[] args) {
    P1002_Find_Common_Characters p = new P1002_Find_Common_Characters();
    String[] a = {"bella","label","roller"};
    System.out.println(p.commonChars(a).toString());
  }
}
