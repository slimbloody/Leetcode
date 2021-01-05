public class P492_Construct_the_Rectangle {
  public int[] constructRectangle(int area) {
    return sol1(area);
  }
  
  public int[] sol1(int area) {
    int width = (int) Math.floor(Math.sqrt(area));
    for (; width >= 1; --width) {
      if (area % width == 0) {
        break;
      }
    }
  
    return new int[]{area / width, width};
  }
}
