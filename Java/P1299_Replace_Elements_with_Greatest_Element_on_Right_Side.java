public class P1299_Replace_Elements_with_Greatest_Element_on_Right_Side {
  public int[] replaceElements(int[] arr) {
    return sol1(arr);
  }

  public int[] sol1(int[] arr) {
    int max = Integer.MIN_VALUE;
    
    for (int i = arr.length - 1; i >= 0; --i) {
      int prevMax = max;
      max = Math.max(arr[i], max);
      if (i == arr.length - 1) {
        arr[i] = -1;
      }
      else {
        arr[i] = prevMax;
      }
    }
    
    return arr;
  }
}
