public class P69_Sqrt_x {
  public int mySqrt(int x) {
    return sol1(x);
  }

  // 牛顿法求平方根
  // https://www.cnblogs.com/Allen-rg/p/13602550.html
  // https://blog.csdn.net/u014485485/article/details/77599953
  public int sol1(int x) {
      return newton(x);
  }

  public int newton(int x) {
      double error = 0.0001;
      double root = x;

      while (root * root - x > error) {
          root = (root + x / root) / 2;
      }

      return (int) root;
  }

  public static void main(String[] args) {
      P69_Sqrt_x p = new P69_Sqrt_x();
      System.out.println(p.mySqrt(4));
      System.out.println(p.mySqrt(8));
  }
}

