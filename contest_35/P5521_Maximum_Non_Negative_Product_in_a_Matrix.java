public class P5521_Maximum_Non_Negative_Product_in_a_Matrix {
  public int maxProductPath(int[][] grid) {
    return sol1(grid);
  }
  
  public int sol1(int[][] grid) {
    return 1;
  }
  
  public static void main(String[] args) {
    P5521_Maximum_Non_Negative_Product_in_a_Matrix p = new P5521_Maximum_Non_Negative_Product_in_a_Matrix();
    int[][] g1 = new int[][]{{-1,-2,-3}, {-2,-3,-3}, {-3,-3,-2}};
    System.out.println(p.maxProductPath(g1));
    int[][] g2 = new int[][]{{1,-2,1}, {1,-2,1}, {3,-4,1}};
    System.out.println(p.maxProductPath(g2));
    int[][] g3 = new int[][]{{1, 3}, {0,-4}};
    System.out.println(p.maxProductPath(g3));
    int[][] g4 = new int[][]{{ 1, 4,4,0}, {-2, 0,0,1}, { 1,-1,1,1}};
    System.out.println(p.maxProductPath(g4));
  }
}
