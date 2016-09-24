/**
 * Difficulty: 4 Kyu
 * 
 * "7777...8?!??!", exclaimed Bob, "I missed it again! Argh!" Every time there's an interesting number coming up, 
 * he notices and then promptly forgets. Who doesn't like catching those one-off interesting mileage numbers?
 * 
 * Let's make it so Bob never misses another interesting number. We've hacked into his car's computer, 
 * and we have a box hooked up that reads mileage numbers. We've got a box glued to his dash that lights up yellow or green depending on whether it receives a 1 or a 2 (respectively).
 * It's up to you, intrepid warrior, to glue the parts together. Write the function that parses the mileage number input, and returns a 2 
 * if the number is "interesting" (see below), a 1 if an interesting number occurs within the next two miles, or a 0 if the number is not interesting.
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
 * @author Nick Pierre
 *
 */
public class CarMileage {

    public static int isInteresting(int number, int[] awesomePhrases) {
        
        /** Check conditions on a number less than 100 but greater than 97 */          
        if (number < 100) {
            if (number + 1 > 99) {
                if (isPalindrome(String.valueOf(number + 2)) || isPalindrome(String.valueOf(number + 1))) { return 1;}
                else if (digitToZeros(number + 1) || digitToZeros(number + 2)) return 1;
                else if (checkSame(number + 1) || checkSame(number + 2)) return 1;
                else if (checkSeq(String.valueOf(number + 1)) || checkSeq(String.valueOf(number + 2))) { return 1; }
                else if (awesomeCheck(number + 1, awesomePhrases) || awesomeCheck(number + 2, awesomePhrases)) { return 1; }
            }
            else if (number + 2 > 99) {
                if (isPalindrome(String.valueOf(number + 2))) { return 1;}
                else if (digitToZeros(number + 2)) { return 1; }
                else if (checkSame(number + 2)) { return 1;}
                else if (checkSeq(String.valueOf(number + 2))) { return 1; }
                else if (awesomeCheck(number + 2, awesomePhrases)) { return 1; }
            }
            return 0;
        }

        /** Check if interesting number occurs in next 2 miles */
        if (isPalindrome(String.valueOf(number))) { return 2; }
        else if (digitToZeros(number)) { return 2; }
        else if (checkSame(number)) { return 2; }
        else if (checkSeq(String.valueOf(number))) { return 2; }
        else if (awesomeCheck(number, awesomePhrases)) { return 2; }
        else if (isPalindrome(String.valueOf(number + 2)) || isPalindrome(String.valueOf(number + 1))) { return 1;}
        else if (digitToZeros(number + 1) || digitToZeros(number + 2)) { return 1; }
        else if (checkSame(number + 1) || checkSame(number + 2)) { return 1;}
        else if (checkSeq(String.valueOf(number + 1)) || checkSeq(String.valueOf(number + 2))) { return 1; }
        else if (awesomeCheck(number + 1, awesomePhrases) || awesomeCheck(number + 2, awesomePhrases)) { return 1; }


        return 0;
    }

    public static boolean checkSeq(String number) {
        boolean dec = true, inc = true;

        int numberCount = Integer.parseInt(String.valueOf(number.charAt(0)));

        // Increasing Check
        System.out.println("Increase check for: " + number);
        for (int i = 1; i < number.length(); i++) {
            if (Integer.parseInt(String.valueOf(number.charAt(i))) != numberCount + 1) {
                inc = false;
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
                dec = false;
                break;
            }
            numberCount--;
            if (numberCount < 0)
                numberCount = 0;
        }
        return (dec || inc) ? true : false;
    }

    public static boolean awesomeCheck(int number, int[] awesomePhrases) {
        boolean match = false;
        for (int i = 0; i < awesomePhrases.length; i++) {
            if (number == awesomePhrases[i]) {
                match = true;
                break;
            }
        }
        return match;
    }

    public static boolean checkSame(int number) {
        boolean allSame = true;
        String numberString = String.valueOf(number);

        for (int i = 1; i < numberString.length(); i++) {
            if (numberString.charAt(i) != numberString.charAt(0)) {
                allSame = false;
                break;
            }
        }
        return allSame;
    }
    public static boolean digitToZeros(int number) {
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

    public static boolean isPalindrome(String number) {
        for (int i = 0; i < number.length() / 2; i++) {
            if (number.charAt(i) != number.charAt(number.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}