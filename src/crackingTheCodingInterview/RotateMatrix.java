package crackingTheCodingInterview;

/**
 * Given an image represented by an N*N matrix, where each pixel in the
 * image is 4 bytes, write a method to rotate the image by 90 degrees.
 */
public class RotateMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        System.out.println("Before Rotating");
        System.out.println("=====================");
        printMatrix(matrix);

        matrix = rotate90(matrix);

        System.out.println("\n\nAfter Rotating");
        System.out.println("=====================");
        printMatrix(matrix);

    }

    /*
     [ 1  | 2  | 3 ]       [ 10  | 7  |  4 | 1 ]
     [ 4  | 5  | 6 ]       [ 11  | 8  |  5 | 2 ]
     [ 7  | 8  | 9 ] ===>  [ 12  | 9  |  6 | 3 ]
     [ 10 | 11 | 12]
     */
    static int[][] rotate90(int[][] matrix) {
        int numRows = matrix.length;
        int numCol = matrix[0].length;

        int[][] newMatrix = new int[numCol][numRows];

        for (int col = 0; col < matrix[0].length; col++) {

            int newMatrixOffSet = 0;

            for (int row = matrix.length - 1 ; row > -1; row--) {
                newMatrix[col][newMatrixOffSet] = matrix[row][col];
                newMatrixOffSet++;
            }
        }

        return newMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(aMatrix[j] +
                        String.format("%4s", ""));
            }
            System.out.println();
        }
    }
}
