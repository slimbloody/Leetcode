import java.util.ArrayList;
import java.util.List;

public class P868_Binary_Gap {
  public int binaryGap(int N) {
    return sol1(N);
  }
  
  // 1: Store Indexes
  public int sol1(int N) {
    int[] A = new int[32];
    int t = 0;
    for (int i = 0; i < 32; ++i) {
      if (((N >> i) & 1) != 0) {
        A[t++] = i;
      }
    }
  
    int res = 0;
    for (int i = 0; i < t - 1; ++i) {
      res = Math.max(res, A[i+1] - A[i]);
    }
    
    return res;
  }
  
  // one pass
  public int sol2(int N) {
    int last = -1, res = 0;
    
    for (int i = 0; i < 32; ++i) {
      if (((N >> i) & 1) > 0) {
        if (last >= 0) {
          res = Math.max(res, i - last);
        }
      }
    }
    
    return res;
  }

  public int sol5(int N) {
    String s = Long.toBinaryString(N);
    List<Integer> tempList = new ArrayList<>();
    int res = 0;
    
    for (int i = 0; i < s.length(); ++i) {
      if (s.charAt(i) == '1') {
        tempList.add(i);
      }
    }
    
    int temp;
    for (int i = 1; i < tempList.size(); ++i) {
      temp = tempList.get(i) - tempList.get(i - 1);
      if (temp > res){
        res = temp;
      }
    }
    
    return res;
  }
}

