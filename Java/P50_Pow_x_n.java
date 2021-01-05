public class P50_Pow_x_n {
  public double myPow(double x, int n) {
    return sol4(x, n);
  }
  
  public double sol1(double x, int n) {
    if (n < 0) {
      // return 1 / (sol1(x, -n));  // overflow
      return 1 / x * sol1(1 / x, -(n + 1));
      
    }
    else if (n == 0) {
      return 1;
    }
    else if (n == 1) {
      return x;
    }
    else if (n == 2) {
      return x * x;
    }
    else {
      if (n % 2 == 0) {
        return sol1(sol1(x, n / 2), 2);
      }
      else {
        return sol1(sol1(x, n / 2), 2) * x;
      }
    }
  }
  
  public double sol2(double x, int n) {
    if (n == 0) {
      return 1;
    }
    else if (n == 1) {
      return x;
    }
    else if (n == 2) {
      return x * x;
    }
    double t = sol2(x * x,n / 2);
    if(n % 2 == 0) {
      return t * t;
    }
    else {
      return n < 0 ? 1 / x * t * t : x * t * t;
    }
  }
  
  public double sol3(double x, int n) {
    if (n == 0) {
      return 1;
    }
    if (n < 0) {
      n = -n;
      x = 1 / x;
    }
    return n % 2 == 0 ?
      sol3(x * x, n / 2) : x * sol3(x * x, n / 2);
  }
  
  // iterative
  public double sol4(double x, int n) {
    if (n == 0) {
      return 1;
    }
    else if (n < 0) {
      n = -n;
      x = 1 / x;
    }
    double res = 1;
    while (n > 0) {
      if ((n & 1) == 1) {
        res *= x;
      }
      x *= x;
      n >>= 1;
    }
    
    return res;
  }
  
  public static void main(String[] args) {
    P50_Pow_x_n p = new P50_Pow_x_n();
    System.out.println(p.myPow(2.00000, 10));
    System.out.println(p.myPow(2.00000, 10) ==  1024.00000);
    System.out.println(p.myPow(2.10000, 3));
    System.out.println(p.myPow(2.10000, 3) == 9.26100);
    System.out.println(p.myPow(2.00000, -2));
    System.out.println(p.myPow(2.00000, -2) == 0.25000);
    System.out.println(p.myPow(1.00000, -2147483648));
    System.out.println(p.myPow(1.00000, -2147483648) == 1);
    System.out.println(p.myPow(2.00000, -2147483648));
    System.out.println(p.myPow(2.00000, -2147483648) == 0);
  }
}
