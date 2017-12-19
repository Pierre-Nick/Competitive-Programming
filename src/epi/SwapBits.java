package epi;

import java.util.Scanner;

public class SwapBits {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //  System.out.println(swapBits(1, 2, 18));

        do {
            System.out.println("Enter a value to swap bits");
            long userValue = input.nextLong();

            System.out.println("\nBinary value of " + userValue + " : " + Long.toBinaryString(userValue));
            System.out.print("\nWhich two bit indices would you like to swap: ");

            int i = input.nextInt();
            int j = input.nextInt();

            System.out.println("Swapping bits " + i + " and " + j);
            long value = swapBits(i, j, userValue);

            System.out.println("\n\nNew value is " + value);
            System.out.println("Binary Representation is: " + Long.toBinaryString(value));

            System.out.println("\nWould you like to continue? Y/N");

            if (Character.toUpperCase(input.next().charAt(0)) != 'Y') {
                break;
            }
        } while (true);

        input.close();
    }

    private static long swapBits(int i, int j, long value) {

        // Check if the two bits are the same
        if (((value >>> i) & 1) == ((value >>> j) & 1)) {
            return value;
        }
        
        long mask = 1L << i | 1L << j;

        return value ^ mask;
    }
}