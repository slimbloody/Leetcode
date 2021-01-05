import java.util.Arrays;

public class P5512_Count_Unhappy_Friends {
  public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
    return sol1(n, preferences, pairs);
  }
  
  public boolean sol1CheckOneType(
      int x, int y, int u, int v, int[][] preferences
  ) {
    int uIndex = -1, yIndex = -1, xIndex = -1, vIndex = -1;
    
    for (int c = 0; c < preferences[x].length; ++c) {
      if (preferences[x][c] == u) {
        uIndex = c;
      }
      else if (preferences[x][c] == y) {
        yIndex = c;
      }
      
      if (uIndex > 0 && yIndex > 0) {
        break;
      }
    }
  
    for (int c = 0; c < preferences[u].length; ++c) {
      if (preferences[u][c] == x) {
        xIndex = c;
      }
    
      if (preferences[u][c] == v) {
        vIndex = c;
      }
  
      if (xIndex > 0 && vIndex > 0) {
        break;
      }
    }
  
//    System.out.println("x: " + x + " y: " + y + " u: " + u + " v: " + v);
//    System.out.println("pref[x]: " + Arrays.toString(preferences[x]));
//    System.out.println("pref[u]: " + Arrays.toString(preferences[u]));
//    System.out.println(
//        "uIndex: " + uIndex + " yIndex: " + yIndex
//            + " xIndex: " + xIndex + " vIndex: " + vIndex
//    );
    
    return (uIndex < yIndex) && (xIndex < vIndex);
  }
  
  public int sol1CheckAll(int[] pairX, int[] pairU, int[][] preferences) {
    int x, y, u, v;
  
    // [x, y] [u, v]
    x = pairX[0];
    y = pairX[1];
    u = pairU[0];
    v = pairU[1];
    int ans1 = sol1CheckOneType(x, y, u, v, preferences) ? 1 : 0;
  
    // [y, x] [u, v]
    y = pairX[0];
    x = pairX[1];
    u = pairU[0];
    v = pairU[1];
    int ans2 = sol1CheckOneType(x, y, u, v, preferences) ? 1 : 0;
  
    // [x, y] [v, u]
    x = pairX[0];
    y = pairX[1];
    v = pairU[0];
    u = pairU[1];
    int ans3 = sol1CheckOneType(x, y, u, v, preferences) ? 1 : 0;
  
    // [y, x] [v, u]
    y = pairX[0];
    x = pairX[1];
    v = pairU[0];
    u = pairU[1];
    int ans4 = sol1CheckOneType(x, y, u, v, preferences) ? 1 : 0;
  
    return ans1 + ans2 + ans3 + ans4;
  }
  
  public int sol1(int n, int[][] preferences, int[][] pairs) {
    int res = 0;
    
    /*
      [x, y] [u, v]
      [y, x] [u, v]
      [x, y] [v, u]
      [y, x] [v, u]
    */
    for (int i = 0; i < pairs.length - 1; ++i) {
      for (int j = i + 1; j < pairs.length; ++j) {
        // System.out.println("ans: " + Arrays.toString(pairs[i]) + " " + Arrays.toString(pairs[j]));
        res += (sol1CheckAll(pairs[i], pairs[j], preferences));
      }
    }
    
    return res * 2;
  }
  
  public static void main(String[] args) {
    P5512_Count_Unhappy_Friends p = new P5512_Count_Unhappy_Friends();
    int[][] pre1 = {
        {1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}
    };
    int[][] pairs1 = {
        {0, 1}, {2, 3}
    };
    System.out.println(p.unhappyFriends(4, pre1, pairs1));
  
    int[][] pre2 = {
        {1},
        {0}
    };
    int[][] pairs2 = {
        {1, 0}
    };
    System.out.println(p.unhappyFriends(2, pre2, pairs2));

    int[][] pre3 = {
      {1, 3, 2},
      {2, 3, 0},
      {1, 3, 0},
      {0, 2, 1}
    };
    int[][] pairs3 = {
        {1, 3},
        {0, 2}
    };
    System.out.println(p.unhappyFriends(4, pre3, pairs3));
  }
}
