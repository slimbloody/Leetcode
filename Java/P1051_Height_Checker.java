import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1051_Height_Checker {
  public int heightChecker(int[] heights) {
    return sol1(heights);
  }
  
  // Counting sort
  public int sol1(int[] heights) {
    int[] heightToFreq = new int[101];
    
    for (int height: heights) {
      ++heightToFreq[height];
    }
    
    int res = 0;
    int curHeight = 0;
    
    for (int i = 0; i < heights.length; ++i) {
      while (heightToFreq[curHeight] == 0) {
        ++curHeight;
      }
      
      if (curHeight != heights[i]) {
        ++res;
      }
      
      --heightToFreq[curHeight];
    }
    
    return res;
  }
  
  // O(nlogn)
  // move diff - 1 pairs of student == move diff student
  public int sol2(int[] heights) {
    List<Integer> list1 = Arrays
        .stream(heights)
        .boxed()
        .collect(Collectors.toList());
    
    List<Integer> list2 = new ArrayList(list1);
    Collections.sort(list2);
  
    int res = (int) IntStream
        .range(0, heights.length)
        .boxed()
        .filter(i -> !list1.get(i).equals(list2.get(i)))
        .count();
    
    return res;
  }
  
  public static void main(String[] args) {
    P1051_Height_Checker p = new P1051_Height_Checker();
    int[] a1 = new int[]{1,1,4,2,1,3};
    System.out.println(p.heightChecker(a1));
  
    int[] a2 = new int[]{5,1,2,3,4};
    System.out.println(p.heightChecker(a2));
  
    int[] a3 = new int[]{1,2,3,4,5};
    System.out.println(p.heightChecker(a3));
  }
}

