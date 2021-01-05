import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class P17_Letter_Combinations_of_a_Phone_Number {
  public List<String> letterCombinations(String digits) {
    return sol1(digits);
  }
  
  public List<String> sol1(String digits) {
    char[][] lex = new char[][]{
      {},
      {'a', 'b', 'c'},
      {'d', 'e', 'f'},
      {'g', 'h', 'i'},
      {'j', 'k', 'l'},
      {'m', 'n', 'o'},
      {'p', 'q', 'r', 's'},
      {'t', 'u', 'v'},
      {'w', 'x', 'y', 'z'}
    };
    
    Queue<String> queue = new LinkedList<>();;
    
    for (int i = 0; i < digits.length(); ++i) {
      if (queue.isEmpty()) {
//        queue.addAll(
//        );
      }
      else {
      }
    }
    
    return new ArrayList<>(queue);
  }
}
