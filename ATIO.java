class ATIO {
    public static int ATIO(String str) {

        str = str.trim();

        if (str.isEmpty())
            return 0;

        // Check if the number is positive or negative
        int sign = 1;
        int index = 0;
        if (str.charAt(0) == '+' || str.charAt(0) == '-') {
            sign = str.charAt(0) == '+' ? 1 : -1;
            index++;
        }

        int result = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))) {
            int digit = str.charAt(index) - '0';

            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}