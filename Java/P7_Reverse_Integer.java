class P7_Reverse_Integer {
    public int reverse(int x) {
        return sol_1(x);
    }

    public int sol_1(int x) {
        long sign = (x >= 0) ? 1 : -1;
        String s = new StringBuilder(Long.toString(x * sign)).reverse().toString();
        long num = Long.parseLong(s) * sign;

        if (num >= Integer.MIN_VALUE && num <= Integer.MAX_VALUE) {
            return (int)num;
        }

        return 0;
    }

    public int sol_2(int x) {
        long ans = 0;

        while (x > 0) {
            ans = ans * 10 + x % 10;
            x /= 10;
        }

        if (ans >= Integer.MIN_VALUE && ans <= Integer.MAX_VALUE) {
            return (int)ans;
        }

        return 0;
    }

    public P7_Reverse_Integer() {
    }

    public static void main(String[] args) {
        P7_Reverse_Integer a = new P7_Reverse_Integer();
        System.out.println(a.reverse(-2147483648));
    }
}

