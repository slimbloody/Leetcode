class P8_String_to_Integer_atoi {
    public int myAtoi(String str) {
        return sol_1(str);
    }

    // use str.trim() to accelerate
    public int sol_1(String str) {
        long ans = 0;
        int sign = 1;
        char[] c = str.toCharArray();
        int i = 0;

        // remove space
        while (i < c.length && c[i] == ' ') {
            ++i;
        }

        // judge the sign
        if (i < c.length) {
            if (c[i] == '+') {
                ++i;
            }
            else if (c[i] == '-') {
                ++i;
                sign *= -1;
            }
            else if (Character.isDigit(c[i])) {
            }
            else {
                return 0;
            }
        }
        // System.out.println("sign: " + sign);

        // calculate the nums
        while (i < c.length) {
            if (Character.isDigit(c[i])) {
                ans = ans * 10 + Character.getNumericValue(c[i]);
                ++i;
            }
            else {
                break;
            }

            if (ans * sign >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            else if (ans * sign <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return (int)ans * sign;
    }

    public static void main(String[] args) {
        P8_String_to_Integer_atoi p = new P8_String_to_Integer_atoi();
        /*
        int ans = p.myAtoi("-91283472332");
        System.out.println(ans);

        ans = p.myAtoi("+-2");
        System.out.println(ans);

        ans = p.myAtoi("");
        System.out.println(ans);

        ans = p.myAtoi(" ");
        System.out.println(ans);
        */

        int ans = p.myAtoi("9223372036854775808");
        //ans = p.myAtoi("9223372036854775808");
        System.out.println(ans);
    }
}

