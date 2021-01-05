public class P509_Fibonacci_Number {
  public int fib(int N) {
    return sol1(N);
  }
  
  public int sol1(int N) {
    if (N == 0) {
      return 0;
    }
    if (N == 1) {
      return 1;
    }
    else {
      return sol1(N - 1) + sol1(N - 2);
    }
  }
}
