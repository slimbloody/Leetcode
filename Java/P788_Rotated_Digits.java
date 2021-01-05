import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P788_Rotated_Digits {
  public int rotatedDigits(int N) {
    return sol2(N);
  }
  
  public boolean isValid(int N) {
    boolean isValid = false;
    while (N > 0) {
      if (N % 10 == 2 || N % 10 == 5 || N % 10 == 6 || N % 10 == 9) {
        isValid = true;
      }
      else if (N % 10 == 3 || N % 10 == 4 || N % 10 == 7) {
        return false;
      }
    }
    
    return isValid;
  }
  
  public int sol1(int N) {
    int count = 0;
    for (int i = 1; i <= N; ++i) {
      if (isValid(i)) {
        ++count;
      }
    }
    
    return count;
  }
  
  Set<Integer> s1 = new HashSet<>(Arrays.asList(1, 8, 0));
  Set<Integer> s2 = new HashSet<>(Arrays.asList(1, 8, 0, 6, 9, 2, 5));
  public boolean isGood(int n) {
    Set<Integer> set = Integer
        .valueOf(n)
        .toString()
        .chars()
        .mapToObj(c -> (char) c)
        .map(Character::getNumericValue)
        .collect(Collectors.toSet());
    
    return (!s1.containsAll(set)) && s2.containsAll(set);
  }
  
  // O(NlogN)
  public int sol2(int N) {
    return (int) IntStream
        .rangeClosed(1, N)
        .boxed()
        .filter(this::isGood)
        .count();
  }
  
  // O(logN)
  // todo:
  public int sol3(int N) {
    Set<Integer> s = new HashSet<>();
    int res = 0;
    int[] numArray = Integer
        .valueOf(N)
        .toString()
        .chars()
        .map(Character::getNumericValue)
        .toArray();
    for (int i = 0; i < numArray.length; ++i) {
      for (int j = 0; j < numArray[i]; ++j) {
        if (s2.containsAll(s) && s2.contains(j)) {
        }
        if (s1.containsAll(s) && s1.contains(j)) {
        }
      }
      if (!s2.contains(numArray[i])) {
        return res;
      }
      s.add(numArray[i]);
    }
    
    return res + ((s2.containsAll(s) && !s1.containsAll(s)) ? 1 : 0);
  }
  
  // todo: dp
  // https://leetcode.com/problems/rotated-digits/discuss/117975/Java-dp-solution-9ms
  // dp[i] = 0, invalid number
  // dp[i] = 1, valid and same number
  // dp[i] = 2, valid and different number
  public int sol4(int N) {
    int[] dp = new int[N + 1];
    int count = 0;
    for (int i = 0; i <= N; ++i) {
      if (i == 0 || i == 1 || i == 8) {
        dp[i] = 1;
      }
      else if (i == 2 || i == 5 || i == 6 || i == 9) {
        dp[i] = 2;
        ++count;
      }
      else {
        int a = dp[i / 10], b = dp[i % 10];
        if (a == 1 && b == 1) {
          dp[i] = 1;
        }
        else if (a >= 1 && b >= 1) {
          dp[i] = 2;
          ++count;
        }
      }
    }
    
    return count;
  }
  
  public static void main(String[] args) {
    P788_Rotated_Digits p = new P788_Rotated_Digits();
    System.out.println(p.rotatedDigits(10));
  }
}
