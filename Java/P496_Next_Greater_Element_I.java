import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class P496_Next_Greater_Element_I {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    return sol1(nums1, nums2);
  }
  
  // 1.find the element of nums1 in nums2
  // 2.whether there is a bigger num at the right part of nums2
  public int[] sol1(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>();
    Stack<Integer> stack = new Stack<>();
    
    for (int num: nums2) {
      while (!stack.empty() && stack.peek() < num) {
        map.put(stack.pop(), num);
      }
      stack.push(num);
    }
    
    for (int i = 0; i < nums1.length; ++i) {
      nums1[i] = map.getOrDefault(nums1[i], -1);
    }
    
    return nums1;
  }
  
  public static void main(String[] args) {
    P496_Next_Greater_Element_I p = new P496_Next_Greater_Element_I();
    int[] a1 = new int[]{4,1,2};
    int[] b1 = new int[]{1,3,4,2};
    System.out.println(Arrays.toString(p.nextGreaterElement(a1, b1)));
  
    int[] a2 = new int[]{2,4};
    int[] b2 = new int[]{1,2,3,4};
    System.out.println(Arrays.toString(p.nextGreaterElement(a2, b2)));
  }
}
