public class P58_Length_of_Last_Word {
  public int lengthOfLastWord(String s) {
    return sol1(s);
  }
  
  int sol1(String s) {
    char[] arr = s.toCharArray();
    int len = 0, tail = arr.length - 1;
    while (tail >= 0 && arr[tail] == ' ') {
      --tail;
    }
    while (tail >= 0 && arr[tail] != ' ') {
      ++len;
      --tail;
    }
    return len;
  }
}
