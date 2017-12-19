package codewars;

/**
 * Difficulty: 6 Kyu
 * <p>
 * Your task is to sort a given string. Each word in the String will contain a single number. This number is the position the word should have in the result.
 * Note: Numbers can be from 1 to 9. So 1 will be the first word (not 0).
 * If the input String is empty, return an empty String. The words in the input String will only contain valid consecutive numbers.
 * For an input: "is2 Thi1s T4est 3a" the function should return "Thi1s is2 3a T4est"
 */

public class Order {
    public static String order(String words) {
        String[] wordArray = words.split(" ");
        String wordReturn = "";

        for (int i = 1; i < wordArray.length + 1; i++) {
            for (int j = 0; j < wordArray.length; j++) {
                if (wordArray[j].contains(String.valueOf(i))) {
                    wordReturn += (i + 1 > wordArray.length) ?
                            wordArray[j] : wordArray[j] + " ";
                }
            }
        }

        return wordReturn;
    }
}