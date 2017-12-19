package codewars;

/**
 * Difficulty: 6 Kyu
 * <p>
 * Takes in numbers num1 and num2 and returns 1 if there is a
 * straight triple of a number at any place in num1 and also a
 * straight double of the same number in num2.
 * returns 0 if this is not the case
 */

public class TripleTroub {
    public static int TripleDouble(long num1, long num2) {
        for (int i = 0; i < 10; i++) {
            String triple = String.valueOf(i) + String.valueOf(i) + String.valueOf(i);
            System.out.println(triple);
            if (String.valueOf(num1).contains(String.valueOf(triple))) {
                if (String.valueOf(num2).contains(String.valueOf(triple.substring(0, triple.length() - 1)))) {
                    return 1;
                }
            }
        }
        return 0;
    }
}