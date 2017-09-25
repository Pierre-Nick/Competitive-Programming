package leetcode;

/**
 * Difficulty: Easy
 * Reverse digits of an integer.
 * <p>
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */

public class ReverseInt {
    public static void main(String[] args) {
        System.out.println(reverse(-41235125));
    }

    private static int reverse(int x) {
        try {
            String num = String.valueOf((int) Math.sqrt(Math.pow(x, 2)));
            StringBuilder reversed = new StringBuilder();
            for (int i = num.length() - 1; i >= 0; --i) {
                if (num.charAt(i) != '0' || reversed.length() > 0)
                    reversed.append(num.charAt(i));
            }
            if (x < 0)
                return Integer.valueOf(reversed.toString()) * -1;

            return Integer.valueOf(reversed.toString());
        } catch (NumberFormatException ex) {
            return 0;
        }
    }
}