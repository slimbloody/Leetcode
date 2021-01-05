public class P5513_Min_Cost_to_Connect_All_Points {
  public int minCostConnectPoints(int[][] points) {
    return sol1(points);
  }
  
  public int sol1(int[][] points) {
    int res = 0;
    
    int[][] checkTable = new int[points.length][points[0].length];
    for (int i = 0; i < points.length - 1; ++i) {
      checkTable[i][i] = 0;
      for (int j = i + 1; j < points.length; ++j) {
        int diff = Math.abs(points[i][0] - points[j][0])
            + Math.abs(points[i][1] - points[j][1]);
        checkTable[i][j] = diff;
        checkTable[j][i] = diff;
      }
    }
  
    int[][] viewTable = new int[points.length][points[0].length];
    
    return res;
  }
}
