public class P1037_Valid_Boomerang {
  public boolean isBoomerang(int[][] points) {
    return sol1(points);
  }

//  The other idea is to calculate the slope of AB and AC.
//  K_AB = (p[0][0] - p[1][0]) / (p[0][1] - p[1][1])
//  K_AC = (p[0][0] - p[2][0]) / (p[0][1] - p[2][1])
//
//  We check if K_AB != K_AC, instead of calculate a fraction.
//  Stupid me didn't think of cross multiplying. Hence wasted 10 mins dealing with divide by zero exception. :|
  public boolean sol1(int[][] p) {
    return ( p[0][0] - p[1][0]) * (p[0][1] - p[2][1]) !=
        (p[0][0] - p[2][0]) * (p[0][1] - p[1][1]);
  }
  
  // cross product
//  public boolean sol2(int[][] p) {
//  }
}
