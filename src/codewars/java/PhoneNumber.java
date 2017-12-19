package codewars;

import java.util.Arrays;

/**
 * Difficulty: 6 Kyu
 * <p>
 * Write a function that accepts an array of 10 integers (between 0 and 9),
 * that returns a string of those numbers in the form of a phone number.
 */

public class PhoneNumber {
    public static String createPhoneNumber(int[] numbers) {
        String num = Arrays.toString(numbers).replaceAll("[^0-9]", "");
        return "(" + num.substring(0, 3) + ") " + num.substring(3, 6) + "-" + num.substring(6, num.length());
    }
}