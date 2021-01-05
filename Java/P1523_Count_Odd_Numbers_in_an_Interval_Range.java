public class P1523_Count_Odd_Numbers_in_an_Interval_Range {
  public int countOdds(int low, int high) {
    return sol1(low, high);
  }
  
  public int sol1(int low, int high) {
    return (high % 2 == 0 && low % 2 == 0)
        ? (high - low) / 2 : (high - low) / 2 + 1;
  }
}
