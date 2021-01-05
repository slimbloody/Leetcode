public class P1266_Minimum_Time_Visiting_All_Points {
  public int minTimeToVisitAllPoints(int[][] points) {
    return sol1(points);
  }
  
  // evolve of sol2
  // Sum of Chebyshev distance between two consecutive points
  // todo: https://en.wikipedia.org/wiki/Chebyshev_distance
  public int sol1(int[][] points) {
    int res = 0;
    for (int i = 1; i < points.length; ++i) {
      int x1 = points[i - 1][0];
      int y1 = points[i - 1][1];
      int x2 = points[i][0];
      int y2 = points[i][1];
      int xdiff = Math.abs(x2 - x1);
      int ydiff = Math.abs(y2 - y1);
      
      res += Math.max(xdiff, ydiff);
    }
    
    return res;
  }
  
  public int sol2(int[][] points) {
    int res = 0;
    for (int i = 1; i < points.length; ++i) {
      int x1 = points[i - 1][0];
      int y1 = points[i - 1][1];
      int x2 = points[i][0];
      int y2 = points[i][1];
      int xdiff = Math.abs(x2 - x1);
      int ydiff = Math.abs(y2 - y1);
      
      int min = Math.min(xdiff, ydiff);
      res += xdiff + ydiff - min;
    }
    
    return res;
  }
  
  
  public static void main(String[] args) {
    P1266_Minimum_Time_Visiting_All_Points p = new P1266_Minimum_Time_Visiting_All_Points();
    int[][] p1 = {{1,1},{3,4},{-1,0}};
    int[][] p2 = {{3,2},{-2,2}};
    
    System.out.println(p.minTimeToVisitAllPoints(p1));
    System.out.println(p.minTimeToVisitAllPoints(p2));
  }
}
