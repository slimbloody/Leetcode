public class P436_Find_Right_Interval {
    public int[] findRightInterval(int[][] intervals) {
        return sol1(intervals);
    }

    public int[] sol1(int[][] intervals) {
    }

    public static void main(String[] args) {
        P436_Find_Right_Interval p = new P436_Find_Right_Interval();

        int[][] a1 = {{1, 2}};
        // [-1]
        System.out.println(p.sol1(a1));

        int[][] a2 = {{3, 4}, {2, 3}, {1, 2}};
        // [-1,0,1]
        System.out.println(p.sol1(a2));
    }
}
