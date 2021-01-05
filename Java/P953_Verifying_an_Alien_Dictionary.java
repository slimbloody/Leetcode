import java.util.Comparator;
import java.util.PriorityQueue;

public class P953_Verifying_an_Alien_Dictionary {
  public boolean isAlienSorted(String[] words, String order) {
    return sol2(words, order);
  }
  
  // radix sort
  public boolean sol1(String[] words, String order) {
    return true;
  }
  
  public boolean sol2(String[] words, String order) {
    if (words == null || words.length == 0
        || order == null || order.length() == 0) {
    }
  
    Comparator<String> comparator = new Comparator<String>() {
      @Override
      public int compare(String str1, String str2) {
        for (int i = 0; i < Math.min(str1.length(), str2.length()); ++i) {
          char a = str1.charAt(i);
          char b = str2.charAt(i);
  
          if (a != b) {
            if (order.indexOf(a) > order.indexOf(b)) {
              return 1;
            } else {
              return -1;
            }
          }
        }
  
        if (str1.length() > str2.length()) {
          return 1;
        } else if (str1.length() == str2.length()) {
          return 0;
        } else {
          return -1;
        }
      }
    };
  
    PriorityQueue<String> pq = new PriorityQueue<>(words.length, comparator);
    
    for (String s: words) {
      pq.offer(s);
    }
    
    int index = 0;
    while (!pq.isEmpty()) {
      if (!pq.poll().equals(words[index++])) {
        return false;
      }
    }
    
    return true;
  }
  
  // mapping alphabet to number
  int[] mapping = new int[26];
  public boolean sol3(String[] words, String order) {
    for (int i = 0; i < order.length(); i++)
      mapping[order.charAt(i) - 'a'] = i;
    for (int i = 1; i < words.length; i++) {
      if (bigger(words[i - 1], words[i])) {
        return false;
      }
    }
    return true;
  }
  
  boolean bigger(String s1, String s2) {
    int n = s1.length(), m = s2.length();
    for (int i = 0; i < n && i < m; ++i)
      if (s1.charAt(i) != s2.charAt(i))
        return mapping[s1.charAt(i) - 'a'] > mapping[s2.charAt(i) - 'a'];
    return n > m;
  }
}
