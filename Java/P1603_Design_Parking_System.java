public class P1603_Design_Parking_System {
  public class ParkingSystem {
    private int[] count;
    
    public ParkingSystem(int big, int medium, int small) {
      count = new int[]{big, medium, small};
    }
  
    public boolean addCar(int carType) {
      return count[carType - 1]-- > 0;
    }
  }
}
