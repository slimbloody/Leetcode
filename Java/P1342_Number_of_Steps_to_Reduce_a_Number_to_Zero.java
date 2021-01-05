public class P1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {
  public int numberOfSteps (int num) {
    return sol1(num);
  }
  
  public int sol1 (int num) {
    int res = 0;
    
    while(num > 0) {
      res += (num & 1) == 1 ? 2 : 1;
      num >>= 1;
    }
  
    // We subtract 1 from result because when we the get to the most significant 1,
    // we only need to subtract it and we no longer need to divide by 2, so
    // only 1 step needed instead of the 2 that we counted when using the above while loop
    return res - 1;
  }
}
