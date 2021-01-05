import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P811_Subdomain_Visit_Count {
  public List<String> subdomainVisits(String[] cpdomains) {
    return sol1(cpdomains);
  }
  
  // todo: find . pos is faster than split
  public List<String> sol1(String[] cpdomains) {
    List<String> res = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    
    for (String s: cpdomains) {
      String[] sp = s.split("\\s+");
      String[] domains = sp[1].split("\\.");
      int val = Integer.valueOf(sp[0]);
      
      StringBuilder sb = new StringBuilder();
      for (int i = domains.length - 1; i >= 0; --i) {
        // better todo:
        // cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
        if (i == domains.length - 1) {
          sb.append(domains[i]);
        }
        else {
          sb.insert(0, ".");
          sb.insert(0, domains[i]);
        }
  
        String key = sb.toString();
        map.put(
          key,
          map.getOrDefault(key, 0) + val
        );
      }
    }
  
    for (Map.Entry<String, Integer> pair: map.entrySet()) {
      res.add(pair.getValue() + " " + pair.getKey());
    }
    
    
    return res;
  }
}
