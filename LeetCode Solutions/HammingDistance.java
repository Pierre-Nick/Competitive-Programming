/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 */
public class HammingDistance {

    /* This same code can be done in one line:  Integer.bitCount(x ^ y)  */
    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }

    private static int hammingDistance(int x, int y) {
        String binaryX = Integer.toBinaryString(x);
        String binaryY = Integer.toBinaryString(y);

        if (binaryX.length() > binaryY.length()) {
            binaryY = addLeadingZeroes(binaryY, getLengthDifference(binaryX, binaryY));
        } else if (binaryY.length() > binaryX.length()) {
            binaryX = addLeadingZeroes(binaryX, getLengthDifference(binaryY, binaryX));
        }

        int hammingCount = 0;

        for (int i = 0; i < binaryX.length(); i++) {
            if (binaryX.charAt(i) != binaryY.charAt(i)) {
                hammingCount++;
            }
        }

        return hammingCount;
    }

    /**
     * @return the difference in lengths between parameter one 'first' and parameter two 'second'
     */
    private static int getLengthDifference(String first, String second) {
        return first.length() - second.length();
    }

    /**
     *  Adds leading zeroes to an expected binary value
     * @param binaryVal a binary number of type String
     * @param leadingZeroes the amount of leading 0's to add to the first parameter of type String
     */
    private static String addLeadingZeroes(String binaryVal, int leadingZeroes) {
        StringBuilder binaryValBuilder = new StringBuilder(binaryVal);

        for (int i = 0; i < leadingZeroes; i++) {
            binaryValBuilder.insert(0, "0");
        }

        binaryVal = binaryValBuilder.toString();

        return binaryVal;
    }
}
