package crackingTheCodingInterview;

/**
 *  Implement a method to perform basic string compression using the counts
 *  of repeated characters. For example, the string aabcccccaaa would become
 *  a2b1c5a3. if the "compressed" string would not become smaller than the
 *  original string, your method should return the original string. You can
 *  assume the string has only uppercase and lowercase letters (a- z).
 */
public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compression("aaaaaaaaaa"));
    }

    static String compression(String str) {

        int lengthOfOriginalString = str.length();

        if (lengthOfOriginalString <= 1) {
            return str;
        }

        int count = 1;
        char currentChar = str.charAt(0);

        StringBuilder word = new StringBuilder();

        for (int i = 1; i < lengthOfOriginalString; i++) {

            if (currentChar != str.charAt(i)) {
                word.append(currentChar).append(count);
                count = 1;
                currentChar = str.charAt(i);
                continue;
            }
            ++count;

        }

        word.append(currentChar).append(count);

        String compressedString = word.toString();

        return lengthOfOriginalString * 2 > compressedString.length() ? compressedString : str;
    }
}
