import javax.sound.midi.SoundbankResource;

public class P5490_Minimum_Number_of_Days_to_Eat_N_Oranges {
  public int minDays(int n) {
    return sol1(n);
  }
  
  public int sol1(int n) {
    if (n == 0) {
      return 0;
    }
    else if (n == 1) {
      return 1;
    }
    else if (n % 2 == 0) {
      return 1 + sol1(n / 2);
    }
    else if (n % 3 == 0) {
      return 1 + sol1(n / 3);
    }
    else {
      return 1 + sol1(n - 1);
    }
  }
  
  public static void main(String[] args) {
    P5490_Minimum_Number_of_Days_to_Eat_N_Oranges p = new P5490_Minimum_Number_of_Days_to_Eat_N_Oranges();
    System.out.println(p.minDays(10));
    System.out.println(p.minDays(6));
  }
}
