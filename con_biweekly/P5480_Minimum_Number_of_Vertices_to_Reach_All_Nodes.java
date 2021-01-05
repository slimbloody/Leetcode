import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P5480_Minimum_Number_of_Vertices_to_Reach_All_Nodes {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    return sol1(n, edges);
  }
  
  public List<Integer> sol1(int n, List<List<Integer>> edges) {
    Set<Integer> head = new HashSet<>();
    Set<Integer> tail = new HashSet<>();
    
    for (List<Integer> l: edges) {
      Integer headEle = l.get(0);
      Integer tailEle = l.get(1);
      
      if (head.contains(tailEle)) {
        head.remove(tailEle);
      }
      tail.add(tailEle);
      if (!tail.contains(headEle)) {
        head.add(headEle);
      }
    }
    
    return new ArrayList<>(head);
  }
  
  public static void main(String[] args) {
    P5480_Minimum_Number_of_Vertices_to_Reach_All_Nodes p = new P5480_Minimum_Number_of_Vertices_to_Reach_All_Nodes();
    List l1 = new ArrayList();
    l1.add(Arrays.asList(0, 1));
    l1.add(Arrays.asList(0, 2));
    l1.add(Arrays.asList(2, 5));
    l1.add(Arrays.asList(3, 4));
    l1.add(Arrays.asList(4, 2));
    System.out.println(p.findSmallestSetOfVertices(6, l1));
  
    List l2 = new ArrayList();
    l2.add(Arrays.asList(0, 1));
    l2.add(Arrays.asList(2, 1));
    l2.add(Arrays.asList(3, 1));
    l2.add(Arrays.asList(1, 4));
    l2.add(Arrays.asList(2, 4));
    System.out.println(p.findSmallestSetOfVertices(5, l2));
  }
}
