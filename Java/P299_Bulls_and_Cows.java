import java.util.Arrays;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class P299_Bulls_and_Cows {
  public String getHint(String secret, String guess) {
    return sol1(secret, guess);
  }
  
  public String sol1(String secret, String guess) {
    int[] digitA = new int[10];
    int[] digitB = new int[10];
    Arrays.fill(digitA, 0);
    Arrays.fill(digitB, 0);
    int aNum = 0, bNum = 0;
    
    for (int i = 0; i < secret.length(); ++i) {
      if (secret.charAt(i) == guess.charAt(i)) {
        ++aNum;
      }
      else  {
        int a = Character.getNumericValue(secret.charAt(i));
        int b = Character.getNumericValue(guess.charAt(i));
        ++digitA[a];
        ++digitB[b];
      }
    }
    
    for (int i = 0; i < digitA.length; ++i) {
      bNum = bNum + Math.min(digitA[i], digitB[i]);
    }
    
    return aNum + "A" + bNum + "B";
  }
  
  public static void main(String[] args) {
    P299_Bulls_and_Cows p = new P299_Bulls_and_Cows();
    System.out.println(p.getHint("1807", "7810"));
    System.out.println(p.getHint("1807", "7810").equals("1A3B"));
  }
}
