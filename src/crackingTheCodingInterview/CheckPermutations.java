package crackingTheCodingInterview;

/**
 * Given two strings, write a method to decide if one is a permutation of another
 * <p>
 * Note: This particular solution assumes lower case alphabetic ASCII characters and spaces
 * considered only!
 */

public class CheckPermutations {

    public static void main(String[] args) throws InterruptedException {
        java.util.Scanner input = new java.util.Scanner(System.in);

        System.out.print("First String: ");
        String firstString = input.next();
        System.out.print("Second String: ");
        String secondString = input.next();

        System.out.print("Determining if permutation of another ");
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.print(". ");
        }

        System.out.println("Is permutation of Another: " + checkPermutation(firstString, secondString));

        input.close();
    }

    private static boolean checkPermutation(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        int[] occurrencesOfLetters = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            occurrencesOfLetters[s1.charAt(i) - 97]++;
        }

        for (int i = 0; i < s2.length(); i++) {
            occurrencesOfLetters[s2.charAt(i) - 97]--;
        }

        for (int occurrencesOfLetter : occurrencesOfLetters) {
            if (occurrencesOfLetter != 0) return false;
        }

        return true;
    }
}