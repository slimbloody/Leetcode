import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class P1360_Number_of_Days_Between_Two_Dates {
  public int daysBetweenDates(String date1, String date2) {
    return sol1(date1, date2);
  }
  
  public int sol1(String date1, String date2) {
    if (date1.compareTo(date2) > 0) {
      String temp = date1;
      date1 = date2;
      date2 = temp;
    }
    
    Integer[] times1 = getTimes(date1);
    Integer[] times2 = getTimes(date2);
    Integer[] t1 = getYearDaysAndRestDays(times1);
    System.out.println(Arrays.toString(t1));
    Integer[] t2 = getYearDaysAndRestDays(times2);
    System.out.println(Arrays.toString(t2));
    
    if (times1[0].equals(times2[0])) {
      return t2[0] - t1[0];
    }
    else {
      int sum = 0;
      for (int i = times1[0] + 1; i < times2[0]; ++i) {
        if (isLeapYear(i)) {
          sum += 366;
        }
        else {
          sum += 365;
        }
      }
      return sum + t1[1] + t2[0];
    }
  }
  
  int[] monthDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
  
  public boolean isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0)
        || (year % 400 == 0 && year % 3200 != 0);
  }
  
  public Integer[] getTimes(String date) {
    return Arrays
        .stream(date.split("-"))
        .map(Integer::parseInt)
        .toArray(Integer[]::new);
  }
  
  public Integer[] getYearDaysAndRestDays(Integer[] times) {
    boolean isLeap = isLeapYear(times[0]);
    int sum = 0;
    int rest = isLeap ? 366 : 365;
    for (int i = 1; i < times[1]; ++i) {
      sum += monthDay[i];
      
      if (i == 2 && isLeap) {
        sum += 1;
      }
    }
    sum += times[2];
    
    return new Integer[]{sum, rest - sum};
  }
  
  public static void main(String[] args) {
    P1360_Number_of_Days_Between_Two_Dates p = new P1360_Number_of_Days_Between_Two_Dates();
    String s1 = "1983-01-08";
    String s2 = "1983-09-12";
//    String s2 = "2074-09-12";
    System.out.println("self: " + p.daysBetweenDates(s1, s2));
    LocalDate p1 = LocalDate.parse(s1, DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate p2 = LocalDate.parse(s2, DateTimeFormatter.ISO_LOCAL_DATE);
    System.out.println("elec: " + (p2.toEpochDay() - p1.toEpochDay()));
    // 612
    // 246 366
  }
}
