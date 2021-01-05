import java.util.Arrays;

class P561_Array_Partition_I {
    public int arrayPairSum(int[] nums) {
        return sol1(nums);
    }

    public int sol1(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }
}

