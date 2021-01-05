public class P1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {
  public double average(int[] salary) {
    return sol1(salary);
  }
  
  public double sol1(int[] salary) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    double sum = 0;
    for (int num: salary) {
      sum += num;
      max = Math.max(num, max);
      min = Math.min(num, min);
    }
    
    return (sum - max - min) / (salary.length - 2);
  }
}
