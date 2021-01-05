public class P1184_Distance_Between_Bus_Stops {
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    int len = distance.length;
    int clockwiseDis = 0;
    int antiClockwiseDis = 0;
  
    System.out.println(len);
    for (int i = start; i != destination; i = (i + 1) % len) {
      System.out.println(i);
      clockwiseDis += distance[i];
    }
    
    for (
        int i = ((start - 1 + len) % len);
        i != destination - 1;
        i = (i - 1 + len) % len) {
      antiClockwiseDis += distance[i];
    }
    
    return clockwiseDis > antiClockwiseDis ? antiClockwiseDis : clockwiseDis;
  }
  
  public static void main(String[] args) {
    P1184_Distance_Between_Bus_Stops p = new P1184_Distance_Between_Bus_Stops();
//    int[] a1 = new int[]{1,2,3,4};
//    System.out.println(p.distanceBetweenBusStops(a1, 0, 1));
//
//    int[] a2 = new int[]{1,2,3,4};
//    System.out.println(p.distanceBetweenBusStops(a2, 0, 2));
  
    int[] a3 = new int[]{6,47,48,31,10,27,46,33,52,33,38,25,32,45,36,3,0,33,22,53,8,13,18,1,44,41,14,5,38,25,48};
    System.out.println(p.distanceBetweenBusStops(a3, 22, 0));
  }
}
