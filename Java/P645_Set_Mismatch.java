public class P645_Set_Mismatch {
  public int[] findErrorNums(int[] nums) {
    return sol1(nums);
  }
  
  // 异或运算具有结合律
  // A XOR B XOR B = A XOR (B XOR B) = A XOR 0 = A
  public int[] sol1(int[] nums) {
    int[] res = new int[2];
    int temp;
    for (int i = 0; i < nums.length; ++i) {
      temp = (i + 1) ^ nums[i];
      
      if (temp != 0) {
        res[0] = temp ^ (i + 1);
        res[1] = i + 1;
        break;
      }
    }
    
    return res;
  }
}
