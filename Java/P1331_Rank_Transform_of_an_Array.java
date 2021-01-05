import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P1331_Rank_Transform_of_an_Array {
  public int[] arrayRankTransform(int[] arr) {
    return sol2(arr);
  }
  
  public int[] sol1(int[] arr) {
    List<Integer> list = Arrays
        .stream(arr)
        .boxed()
        .collect(Collectors.toSet())
        .stream()
        .sorted()
        .collect(Collectors.toList());
  
    Map<Integer, Integer> map = IntStream
        .range(0, list.size())
        .boxed()
        .collect(Collectors.toMap(list::get, Function.identity()));
    
    int[] res = new int[arr.length];
    for (int i = 0; i < arr.length; ++i) {
      res[i] = map.get(arr[i]) + 1;
    }
    
    return res;
  }
  
  public int[] sol2(int[] arr) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    
    for (int num: arr) {
      min = num < min ? num : min;
      max = num > max ? num : max;
    }
    
    int[] hash = new int[max - min + 1];
    for (int i = 0; i < arr.length; i++) hash[arr[i] - min] = 1;
    for (int i = 1; i < hash.length; i++) hash[i] += hash[i-1];
    
    int[] answer = new int[arr.length];
    for (int i = 0; i < answer.length; i++) answer[i] = hash[arr[i] - min];
    
    return answer;
  }
  
  
  // 常规思路是数组去重后进行排序，然后迭代arr数组中的元素，在排序的数组中利用二分查找寻找索引值。
  // 此处采用桶排序的思路，先遍历arr数组，找到数组中的最大值和最小值。
  // 然后建立桶数组，将arr数组中出现过的元素在桶中设置为1。
  // 接下来利用前缀和统计出每个元素前面出现过的次数，即该元素的序号。
  public int[] sol3(int[] arr) {
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int num : arr) {
      min = num < min ? num : min;
      max = num > max ? num : max;
    }
    
    // 建立max - min + 1多个桶
    int[] count = new int[max - min + 1];
    
    // 用1标记有这么个元素
    for (int num : arr) {
      count[num - min] = 1;
    }
    
    // 前面的和数组
    int[] preSum = new int[count.length + 1];
    
    // 记录和即rank值
    for (int i = 1; i < preSum.length; i++) {
      preSum[i] = preSum[i - 1] + count[i - 1];
    }
    int[] ans = new int[arr.length];
    int index = 0;
    for (int num : arr) {
      ans[index++] = preSum[num - min] + 1;
    }
    
    return ans;
  }
  
  
  public static void main(String[] args) {
    P1331_Rank_Transform_of_an_Array p = new P1331_Rank_Transform_of_an_Array();
    int[] a1 = {40,10,20,30};
    System.out.println(Arrays.toString(p.arrayRankTransform(a1)));

    int[] a2 = {100, 100, 100};
    System.out.println(Arrays.toString(p.arrayRankTransform(a2)));
  }
}
