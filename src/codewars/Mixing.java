package codewars;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Difficulty: 4 Kyu
 * Given two strings s1 and s2, we want to visualize how different the two strings are. We will only take into account
 * the lowercase letters (a to z). First let us count the frequency of each lowercase letters in s1 and s2.
 * s1 = "A aaaa bb c"
 * <p>
 * s2 = "& aaa bbb c d"
 * <p>
 * s1 has 4 'a', 2 'b', 1 'c'
 * <p>
 * s2 has 3 'a', 3 'b', 1 'c', 1 'd'
 * <p>
 * So the maximum for 'a' in s1 and s2 is 4 from s1; the maximum for 'b' is 3 from s2. In the following we will not
 * consider letters when the maximum of their occurrences is less than or equal to 1.
 * We can resume the differences between s1 and s2 in the following string: "1:aaaa/2:bbb" where 1 in 1:aaaa stands
 * for string s1 and aaaa because the maximum for a is 4. In the same manner 2:bbb stands for string s2 and bbb because the maximum for b is 3.
 * The task is to produce a string in which each lowercase letters of s1 or s2 appears as many times as its maximum if
 * this maximum is strictly greater than 1; these letters will be prefixed by the number of the string where they appear
 * with their maximum value and :. If the maximum is in s1 as well as in s2 the prefix is =:.
 * In the result, substrings will be in decreasing order of their length and when they have the same length sorted
 * alphabetically (more precisely sorted by codepoint); the different groups will be separated by '/'.
 * Hopefully other examples can make this clearer.
 */

public class Mixing implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return Integer.compare(o2.length(), o1.length());
    }

    public static void main(String[] args) {
        String primary = "The lovely eagle scouted the terrain for it's child" +
                ", knowing all-too-well that her efforts were in vain";
        String secondary = "This string is my secondary string, which I use to" +
                "count the occurrences of letters.";

        System.out.print(mix(primary, secondary));
    }

    private static String mix(String string1, String string2) {
        int[] s1LetterCount = new int[26];
        int[] s2LetterCount = new int[26];
        Arrays.fill(s1LetterCount, 0);
        Arrays.fill(s2LetterCount, 0);

        /* Add occurences of ASCII lowercase character to letter counter array*/
        for (int i = 0; i < 26; i++) {
            s1LetterCount[i] = occurrences((char) (i + 97), string1);
            s2LetterCount[i] = occurrences((char) (i + 97), string2);
        }

        String[] putThisInOrder = printLetterPattern(s1LetterCount, s2LetterCount).split("/");
        Arrays.sort(putThisInOrder, new Mixing());
        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < putThisInOrder.length; i++) {
            int sameSize = i;
            while (sameSize < putThisInOrder.length && putThisInOrder[i].length() == putThisInOrder[sameSize].length()) {
                sameSize++;
            }
            Arrays.sort(putThisInOrder, i, sameSize);
        }
        for (String a : putThisInOrder) {
            finalString.append(finalString.length() > 0 ? "/" + a : a);
        }

        return finalString.toString();
    }

    /**
     * Finds the occurrences of a specified character and returns the amount of occurrences
     */
    private static int occurrences(char findMe, String lookAtMe) {
        int howMany = 0;
        for (int i = 0; i < lookAtMe.length(); i++) {
            if (lookAtMe.charAt(i) == findMe)
                howMany += 1;
        }
        return howMany;
    }

    private static String printLetterPattern(int[] primaryArrayString,
                                             int[] secondaryArrayString) {

        StringBuilder pattern = new StringBuilder();
        pattern = new StringBuilder(initializePattern(pattern.toString(), primaryArrayString, secondaryArrayString));

        for (int i = 0; i < primaryArrayString.length; i++) {
            if (!pattern.toString().contains(String.valueOf((char) (i + 97)))) {
                if (primaryArrayString[i] > secondaryArrayString[i] &&
                        primaryArrayString[i] > 1) {
                    pattern.append("/1:").append(characterPrinter(primaryArrayString[i], (char) (i + 97)));
                } else if (secondaryArrayString[i] > primaryArrayString[i] && secondaryArrayString[i] > 1) {
                    pattern.append("/2:").append(characterPrinter(secondaryArrayString[i], (char) (i + 97)));
                } else if (primaryArrayString[i] != 0 && secondaryArrayString[i] != 0 && secondaryArrayString[i] > 1) {
                    pattern.append("/=:").append(characterPrinter(primaryArrayString[i], (char) (i + 97)));

                }
            }
        }

        return pattern.toString();
    }

    /**
     * Sole purpose is add the first pattern to the string
     */
    private static String initializePattern(String pattern, int[] primaryArrayString, int[] secondaryArrayString) {

        StringBuilder clonePattern = new StringBuilder(pattern);

        for (int i = 0; clonePattern.length() < 1 && i < primaryArrayString.length; i++) {
            // Chunk of code that finds which letter first occurs more than once to add to the string
            clonePattern.append(primaryArrayString[i] > secondaryArrayString[i] &&
                    primaryArrayString[i] > 1 ?
                    "1:" + characterPrinter(primaryArrayString[i], (char) (i + 97)) :
                    primaryArrayString[i] < secondaryArrayString[i] &&
                            secondaryArrayString[i] > 1 ?
                            "2:" + characterPrinter(secondaryArrayString[i], (char) (i + 97)) :
                            primaryArrayString[i] > 1 && secondaryArrayString[i] > 1 ?
                                    "=:" + characterPrinter(primaryArrayString[i], (char) (i + 97)) : "");
        }
        return clonePattern.toString();
    }

    private static String characterPrinter(int times, char character) {
        StringBuilder pattern = new StringBuilder();
        for (int i = 0; i < times; i++) {
            pattern.append(String.valueOf(character));
        }
        return pattern.toString();
    }
}