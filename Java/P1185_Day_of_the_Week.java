public class P1185_Day_of_the_Week {
  public String dayOfTheWeek(int day, int month, int year) {
    return sol1(day, month, year);
  }
  
//  The formula for this problem is Zelle formula
//  Another name: Zeller's congruence or Kim larsen calculation formula.
  public String sol1(int day, int month, int year) {
    String[] days = new String[]{
        "Sunday", "Monday", "Tuesday",
        "Wednesday", "Thursday", "Friday", "Saturday"
    };
    
    if (month < 3) {
      month += 12;
      year -= 1;
    }
    int c = year / 100;
    year = year % 100;
    int w = (c / 4 - 2 * c + year + year / 4 + 13 * (month + 1) / 5 + day - 1) % 7;
    return days[(w + 7) % 7];
  }
}
