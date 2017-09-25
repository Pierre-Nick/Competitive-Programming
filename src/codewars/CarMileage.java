package codewars;

/**
 * Difficulty: 4 Kyu
 *
 * "7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up,
 * he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?
 *
 * Let's make it so Bob never misses another interesting number. We've hacked into his car's computer,
 * and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash that lights up yellow or 
 * green depending on whether it receives a 1 or a 2 (respectively).
 * It's up to you, intrepid warrior, to glue the parts together.
 * Write the function that parses the mileage number input, and returns a 2
 * if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two miles,
 * or a 0 if the number is not interesting.
 * Note: In Haskell, we use No, Almost and Yes instead of 0, 1 and 2.
 * "Interesting" Numbers
 * Interesting numbers are 3-or-more digit numbers that meet one or more of the following criteria:
 * Any digit followed by all zeros: 100, 90000
 * Every digit is the same number: 1111
 * The digits are sequential, incrementing†: 1234
 * The digits are sequential, decrementing‡: 4321
 * The digits are a palindrome: 1221 or 73837
 * The digits match one of the values in the awesomePhrases array
 * † For incrementing sequences, 0 should come after 9, and not before 1, as in 7890.
 * ‡ For decrementing sequences, 0 should come after 1, and not before 9, as in 3210.
 * So, you should expect these inputs and outputs:
 *
 */
public class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {

        /* Check conditions on a number less than 100 but greater than 97 */
        if (number + 2 < 100)
            return 0;

        String numberAsAString = String.valueOf(number);
        String numberAsAString1 = String.valueOf(number + 1);
        String numberAsAString2 = String.valueOf(number + 2);

        /* Check if interesting number occurs within next 2 miles */
        if ((isPalindrome(numberAsAString) || digitToZeros(number) || checkIfAllDigitsAreTheSame(number) ||
            checkIfIncreasingOrDecreasingSequence(numberAsAString) || awesomeCheck(number, awesomePhrases)) && number > 99) {
            return 2;
        } else if (isPalindrome(numberAsAString2) || digitToZeros(number + 2) ||
            checkIfAllDigitsAreTheSame(number + 2) || checkIfIncreasingOrDecreasingSequence(numberAsAString2)
            || awesomeCheck(number + 2, awesomePhrases)) {
            return 1;
        } else if (isPalindrome(numberAsAString1) || digitToZeros(number + 1) ||
            checkIfAllDigitsAreTheSame(number + 1) || checkIfIncreasingOrDecreasingSequence(numberAsAString1)
            || awesomeCheck(number + 1, awesomePhrases)) {
            return 1;
        }

        return 0;

    }

    private static boolean checkIfIncreasingOrDecreasingSequence(String number) {
        boolean isDecreasingSequence = true, isIncreasingSequence = true;

        int numberCount = Integer.parseInt(String.valueOf(number.charAt(0)));

        // Increasing Check
        for (int i = 1; i < number.length(); i++) {
            int currentNumber = Integer.parseInt(String.valueOf(number.charAt(i)));
            if (currentNumber != numberCount + 1) {
                isIncreasingSequence = false;
                break;
            }
            if (++numberCount >= 9)
                numberCount = -1;
        }

        System.out.println();
        numberCount = Integer.parseInt(String.valueOf(number.charAt(0)));

        // Decreasing Check
        for (int i = 1; i < number.length(); i++) {
            if (Integer.parseInt(String.valueOf(number.charAt(i))) != numberCount - 1) {
                isDecreasingSequence = false;
                break;
            }
            numberCount--;
            if (numberCount < 0)
                numberCount = 0;
        }
        return (isDecreasingSequence || isIncreasingSequence);
    }

    private static boolean awesomeCheck(int number, int[] awesomePhrases) {
        for (int awesomePhrase : awesomePhrases) {
            if (number == awesomePhrase) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkIfAllDigitsAreTheSame(int number) {
        String numberString = String.valueOf(number);

        for (int i = 1; i < numberString.length(); i++) {
            if (numberString.charAt(i) != numberString.charAt(0)) {
                return false;
            }
        }
        return true;
    }
    private static boolean digitToZeros(int number) {
        boolean allZerosAfterDigit = true;
        String numberString = String.valueOf(number);

        for (int i = 1; i < numberString.length(); i++) {
            if (numberString.charAt(i) != '0') {
                allZerosAfterDigit = false;
                break;
            }
        }
        return allZerosAfterDigit;
    }

    private static boolean isPalindrome(String number) {
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
