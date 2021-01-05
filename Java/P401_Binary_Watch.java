//import java.util.List;
//
//public class P401_Binary_Watch {
//  public List<String> readBinaryWatch(int num) {
//    return sol1(num);
//  }
//
//  public List<String> sol1(int num) {
//    int T8H = 8 * 60;
//    int T4H = 4 * 60;
//    int T2H = 2 * 60;
//    int T1H =     60;
//    int T32M = 32;
//    int T16M = 16;
//    int T8M = 8;
//    int T4M = 4;
//    int T2M = 2;
//    int T1M = 1;
//    int[] timeArr = {T8H, T4H, T2H, T1H, T32M, T16M, T8M, T4M, T2M, T1M};
//
//  }
//
//  public String convertMinToStandardTime(int m) {
//    int hour = m / 60;
//    int min = m % 60;
//    StringBuffer s = new StringBuffer();
//
//    if (hour <= 9) {
//      s.append("0");
//    }
//    s.append(hour);
//    s.append(":");
//
//    if (min <= 9) {
//      s.append("0");
//    }
//    s.append(min);
//
//    return s.toString();
//  }
//}
