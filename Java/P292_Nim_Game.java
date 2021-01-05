public class P292_Nim_Game {
  public boolean canWinNim(int n) {
    return sol1(n);
  }
  
  public boolean sol1(int n) {
    return (((n - 1) / 3) & 1) == 0;
  }
  
  public static void main(String[] args) {
    P292_Nim_Game p = new P292_Nim_Game();
    System.out.println(p.sol1(1) == true);
    System.out.println(p.sol1(2) == true);
    System.out.println(p.sol1(3) == true);
    System.out.println(p.sol1(4) == false);
    System.out.println(p.sol1(5) == false);
    System.out.println(p.sol1(6) == false);
    System.out.println(p.sol1(7) == true);
  }
}
