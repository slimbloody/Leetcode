import java.util.Arrays;

public class P1154_Day_of_the_Year {
  public int dayOfYear(String date) {
    return sol1(date);
  }
  
  public int sol1(String date) {
    Integer[] time = Arrays
        .stream(date.split("-"))
        .map(Integer::valueOf)
        .toArray(Integer[]::new);
    int year = time[0];
    int month = time[1];
    int day = time[2];
    
    Integer isLeap = (time[0] % 4 == 0 && time[0] % 100 != 0)
        || ((time[0] % 400 == 0) && time[0] % 3200 != 0) ? 1 : 0;
    System.out.println(isLeap);
    int[] monthDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
    
    int res = 0;
    for (int i = 0; i < time[1]; ++i) {
      res += monthDay[i];
    }
    res += (month > 2) ? isLeap : 0;
    
    res += time[2];
    
    return res;
  }
  
  public static void main(String[] args) {
    P1154_Day_of_the_Year p = new P1154_Day_of_the_Year();
    System.out.println(p.dayOfYear("2003-03-01"));
    System.out.println(p.dayOfYear("1900-03-25"));
  }
}
