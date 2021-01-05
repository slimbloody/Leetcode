import java.sql.Time;
import sun.jvm.hotspot.memory.Space;

public class P507_Perfect_Number {
  public boolean checkPerfectNumber(int num) {
    return sol1(num);
  }
  
  // Time complexity : O(\log{n})O(logn). Number of primes will be in order \log{num}lognum.
  // Space complexity : O(\log{n})O(logn). Space used to store primes.
  public boolean sol1(int num) {
    // 2,3,5,7,13,17,19,31) only, as for bigger
    // prime its perfect number will not fit in 64 bits
    // (2^(p-1))(2^p-1)
    int[] primes = new int[]{2, 3, 5, 7, 13, 17, 19, 31};
    for (int prime: primes) {
    // (2^(p - 1)) * (2^p - 1)
      if ((1 << (prime - 1)) * ((1 << prime) - 1) == num) {
        return true;
      }
    }
    
    return false;
  }
  
  // bad solution
  // for (int i = 2; i <= Math.sqrt(num); i++)
  public boolean sol2(int num) {
    if (num <= 0) {
      return false;
    }
    int sum = 0;
    for (int i = 1; i * i <= num; i++) {
      if (num % i == 0) {
        sum += i;
        if (i * i != num) {
          sum += num / i;
        }
      
      }
    }
    return sum - num == num;
  }
}


