import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sound.midi.SoundbankResource;

public class P5495_Most_Visited_Sector_in_a_Circular_Track {
  public List<Integer> mostVisited(int n, int[] rounds) {
    return sol1(n, rounds);
  }
  
  public List<Integer> sol1(int n, int[] rounds) {
    int[] map = new int[n + 1];
  
    for (int i = 1; i < rounds.length; ++i) {
      int start;
      if (i == 1) {
        start = rounds[0];
      }
      else {
        start = (rounds[i - 1] + 1) % n;
      }
      
      for (int j = start; j != rounds[i]; ++j) {
        if (j == n + 1) {
          j = 1;
        }
        System.out.println("j: " + j + " round[" + i + "]: " + rounds[i]);
        ++map[j];
      }
      ++map[rounds[i]];
    }
    
    int max = Arrays.stream(map).max().getAsInt();
    List<Integer> res = new ArrayList<>();
    for (int k = 1; k <= n; ++k) {
      if (map[k] == max) {
        res.add(k);
      }
    }
    return res;
  }
  
  public static void main(String[] args) {
    P5495_Most_Visited_Sector_in_a_Circular_Track p = new P5495_Most_Visited_Sector_in_a_Circular_Track();
    int[] a1 = new int[]{1,3,1,2};
    System.out.println(p.mostVisited(4, a1));
    System.out.println();
  
    int[] a2 = new int[]{2,1,2,1,2,1,2,1,2};
    System.out.println(p.mostVisited(2, a2));
    System.out.println();
  
    int[] a3 = new int[]{1,3,5,7};
    System.out.println(p.mostVisited(7, a3));
    System.out.println();
  }
}




