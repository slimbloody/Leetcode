import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P1104_Path_In_Zigzag_Labelled_Binary_Tree {
  public List<Integer> pathInZigZagTree(int label) {
    return sol1(label);
  }
  
  public List<Integer> sol1(int label) {
    List<Integer> res= new ArrayList<>();
    int level = -1;
    // 10^6 ==> (10^3)^2 ==> (2^10)^2 ==> 2^20
    for (int i = 1; i < 21; ++i) {
      if (Math.pow(2, i) - 1 >= label) {
        level = i;
      }
    }
    
    int pos = -1;
    int val = (int) (Math.pow(2, level) - 1) - label;
    if ((level & 1) == 0) {
      pos = val;
    }
    else {
      pos  = (2 * level) - val;
    }
    while (level > 0) {
      res.add(pos);
      --level;
    }
  
    Collections.reverse(res);
    return res;
  }
}
