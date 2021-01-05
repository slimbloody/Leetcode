import java.util.ArrayList;
import java.util.List;

public class P728_Self_Dividing_Numbers {
  public List<Integer> selfDividingNumbers(int left, int right) {
    return sol1(left, right);
  }
  
  public List<Integer> sol1(int left, int right) {
    List<Integer> res = new ArrayList<>();
    for (int i = left; i <= right; ++i) {
      int temp = i;
      boolean flag = true;
      
      while (temp > 0) {
        int div = temp % 10;
        temp /= 10;
        
        if (div == 0 || i % div != 0) {
          flag = false;
          break;
        }
      }
      
      if (flag) {
        res.add(i);
      }
    }
    return res;
  }
}
