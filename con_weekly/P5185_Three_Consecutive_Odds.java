import javax.sound.midi.SoundbankResource;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;

class P5185_Three_Consecutive_Odds {
  public boolean threeConsecutiveOdds(int[] arr) {
    return sol1(arr);
  }
  
  public boolean sol1(int[] arr) {
    for (int i = 0; i < arr.length - 2; ++i) {
      if ((arr[i] & 1) == 1) {
        int counter = 0;
        for (int j = 0; j < 3; ++j) {
          if ((arr[i + 1] & 1) == 1) {
            ++i;
            ++counter;
          }
          else {
            ++i;
            break;
          }
          
          if (counter == 2) {
            return true;
          }
        }
      }
    }
    
    return false;
  }
  
  public static void main(String[] args) {
    P5185_Three_Consecutive_Odds p = new P5185_Three_Consecutive_Odds();
    int[] a1 = new int[]{2,6,4,1};
    System.out.println(p.sol1(a1) == false);

    int[] a2 = new int[]{1,2,34,3,4,5,7,23,12};
    System.out.println(p.sol1(a2) == true);

    int[] a3 = new int[]{1,3,2};
    System.out.println(p.sol1(a3) == false);

    int[] a4 = new int[]{1,1,1};
    System.out.println(p.sol1(a4) == true);
  
    int[] a5 = new int[]{102,780,919,897,901};
    System.out.println(p.sol1(a5) == true);
  }
}