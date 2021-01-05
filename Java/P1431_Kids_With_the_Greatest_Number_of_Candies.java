import java.util.ArrayList;
import java.util.List;

public class P1431_Kids_With_the_Greatest_Number_of_Candies {
  public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    return sol1(candies, extraCandies);
  }
  
  public List<Boolean> sol1(int[] candies, int extraCandies) {
    List<Boolean> l = new ArrayList<>();
    int max = -1;
    
    for (int i = 0; i < candies.length; ++i) {
      if (candies[i] > max) {
        max = candies[i];
      }
      
      candies[i] += extraCandies;
    }
  
    for (int i = 0; i < candies.length; ++i) {
      if (candies[i] >= max) {
        l.add(true);
      }
      else {
        l.add(false);
      }
    }
    
    return l;
  }
}
