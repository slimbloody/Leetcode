import java.util.HashSet;
import java.util.Set;

public class P874_Walking_Robot_Simulation {
  public int robotSim(int[] commands, int[][] obstacles) {
    return sol1(commands, obstacles);
  }
  
  public int sol1(int[] commands, int[][] obstacles) {
    int[][] direction = new int[][]{{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    int direct = 3;
    int curX = 0, curY = 0;
    Set<String> set = new HashSet<>();
    int res = 0;
    
    for (int i = 0; i < obstacles.length; ++i) {
      set.add(obstacles[i][0] + " " + obstacles[i][1]);
    }
    
    for (int i = 0; i < commands.length; ++i) {
      if (commands[i] == -1) {
        direct = (direct + 1) % 4;
      }
      else if (commands[i] == -2) {
        direct = (direct - 1 + 4) % 4;
      }
      else {
        for (int j = 0; j < commands[i]; ++j) {
          int tempX = curX + direction[direct][0];
          int tempY = curY + direction[direct][1];
          if (set.contains(tempX + " " + tempY)) {
            break;
          }
          else {
            curX = tempX;
            curY = tempY;
            int tempRes = curX * curX + curY * curY;
            res = Math.max(res, tempRes);
          }
          
        }
      }
    }
    /*
      long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
     */
    
    return res;
  }
}
