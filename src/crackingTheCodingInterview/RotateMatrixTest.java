package crackingTheCodingInterview;

import org.junit.jupiter.api.Test;

import static crackingTheCodingInterview.RotateMatrix.rotate90;
import static org.junit.jupiter.api.Assertions.*;

class RotateMatrixTest {
    @Test
    void rotates90_rotatesOddMatrix() {

        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        assertArrayEquals(rotate90(matrix),
                new int[][]{
                        {10, 7, 4, 1},
                        {11, 8, 5, 2},
                        {12, 9, 6, 3}
                });
    }

    @Test
    void rotate90_rotatesEvenMatrix() {
        int[][] matrix = new int[][]{
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18},
        };

        assertArrayEquals(rotate90(matrix),
                new int[][]{
                        {16, 13, 10},
                        {17, 14, 11},
                        {18, 15, 12}
                });
    }

    @Test
    void rotate90_rotatesReallySmallMatrix() {
        int[][] matrix = new int[][]{
                {10, 11},
                {13, 14}
        };

        assertArrayEquals(rotate90(matrix),
                new int[][]{
                        {13, 10},
                        {14, 11}
                });
    }
}