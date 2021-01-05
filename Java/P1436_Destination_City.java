import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P1436_Destination_City {
  public String destCity(List<List<String>> paths) {
    return sol1(paths);
  }
  
  public String sol1(List<List<String>> paths) {
    if (paths == null || paths.size() == 0) {
      return "";
    }
    Map<String, String> map = new HashMap<>();
    for (List<String> path: paths) {
      map.put(path.get(0), path.get(1));
    }
    
    for (String city: map.values()) {
      if (!map.containsKey(city)) {
        return city;
      }
    }
    
    return "";
  }
  
  public String sol2(List<List<String>> paths) {
    Set<String> set= new HashSet<>();
    for (List<String> l: paths) set.add(l.get(1));
    for (List<String> l: paths) set.remove(l.get(0));
    return set.iterator().next();
  }
}
