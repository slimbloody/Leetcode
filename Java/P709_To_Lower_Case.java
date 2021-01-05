public class P709_To_Lower_Case {
  public String toLowerCase(String str) {
    return sol1(str);
  }
  
  public String sol1(String str) {
    char[] arr = str.toCharArray();
    
    
    for (int i = 0; i < arr.length; ++i) {
      if ('A' <= arr[i] && arr[i] <= 'Z') {
        arr[i] = (char) ('a' + arr[i] - 'A');
      }
    }
    
    return new String(arr).toLowerCase();
  }
}
