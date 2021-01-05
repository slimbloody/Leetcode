public class P1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer {
  public int subtractproductandsum(int n) {
    return sol1(n);
  }
  
  public int sol1(int n) {
    int sum = 0, product = 1;
    while (n > 0) {
      sum += n % 10;
      product *= n % 10;
      n /= 10;
    }
    return product - sum;
  }
  
  public static void main(String[] args) {
    P1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer p =
        new P1281_Subtract_the_Product_and_Sum_of_Digits_of_an_Integer();
    System.out.println(p.subtractproductandsum(234));
  }
}
