public class P657_Robot_Return_to_Origin {
  public boolean judgeCircle(String moves) {
    return sol1(moves);
  }
  
  public boolean sol1(String moves) {
    int x = 0, y = 0;
    
    for (int i = 0; i < moves.length(); ++i) {
      char temp = moves.charAt(i);
      if (temp == 'U') {
        ++y;
      }
      else if (temp == 'D') {
        --y;
      }
      else if (temp == 'L') {
        --x;
      }
      else if (temp == 'R') {
        ++x;
      }
    }
    
    return x == 0 && y == 0;
  }
  
  // faster than sol1
  // sol2
  // return moves.count('L') == moves.count('R')
  // and moves.count('U') == moves.count('D')
}
