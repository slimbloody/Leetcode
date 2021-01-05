//import java.lang.reflect.Array;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
//public class P989_Add_To_ArrayForm_of_Integer {
//  public List<Integer> addToArrayForm(int[] A, int K) {
//    return sol1(A, K);
//  }
//
//  public List<Integer> sol1(int[] A, int K) {
//    int len = A.length;
//    long sum = A[A.length - 1];
//
//    for (int i = 1; i < A.length; ++i) {
//      sum = sum * 10 + A[i];
//    }
//
//    sum = sum + K;
//
//    Queue<Integer> numQueue = new LinkedList<>();
//
//    while (sum > 0) {
//      numQueue.add((int) sum % 10);
//      sum /= 10;
//    }
//
//    Integer[] integerArr = Arrays.asList(numQueue.toArray()).toArray(new Integer[0]);
//  }
//}
