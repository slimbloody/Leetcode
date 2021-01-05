import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P762_Prime_Number_of_Set_Bits_in_Binary_Representation {
  public int countPrimeSetBits(int L, int R) {
    return sol1(L, R);
  }
  
  public int sol1(int L, int R) {
    int count = 0;
    int[] primes = {2, 3, 5, 7, 11, 13, 17, 19};
    Set<Integer> primeSet = Arrays
        .stream(primes)
        .boxed()
        .collect(Collectors.toSet());
    
    for (int i = L; i <= R; ++i) {
      count += primeSet.contains(Integer.bitCount(i)) ? 1 : 0;
    }
    
    return count;
  }
  
  // 打表法
  // 0b10100010100010101100 is the bit wise representation of 665772.
  public int sol2(int L, int R) {
    return IntStream
        .range(L, R+1)
        .map(i -> 665772 >> Integer.bitCount(i) & 1)
        .sum();
  }
}
