package crackingTheCodingInterview;

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
