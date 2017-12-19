package epi;

public class ArrayReorder {
    public static void main(String[] args) {
        int[] arr = new int [] { 1, 5, 7, 2, 9, 11, 4, 3 };

        System.out.print("Unsorted array: ");
        printArray(arr);

        reorder(arr);

        System.out.print("Sorted array: ");
        printArray(arr);

    }

    public static void reorder(int[]  arr) {
        int evenIndex = 0;
        int oddIndex = arr.length - 1;

        while (evenIndex != oddIndex) {
            boolean evenIndexValueIsOdd = arr[evenIndex] % 2 != 0;
            boolean oddIndexValueIsEven = arr[oddIndex] % 2 == 0;

            if (evenIndexValueIsOdd && oddIndexValueIsEven) {
                int temp = arr[evenIndex];
                arr[evenIndex] = arr[oddIndex];
                arr[oddIndex] = temp;

                evenIndex++;
                oddIndex--;
            } else {
                if (!evenIndexValueIsOdd) {
                    evenIndex++;
                }
                if (!oddIndexValueIsEven) {
                    oddIndex--;
                }
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
