package leetcode;

import org.junit.jupiter.api.Test;

import static leetcode.MedianOfSortedArrays.*;
import static org.junit.jupiter.api.Assertions.*;

class MedianOfSortedArraysTest {
    @Test
    void findMedianSortedArrays_returnsMedian_whenSecondArrayLengthIsLarger() {

        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{5, 6, 7, 8, 9};

        assertEquals(5.0, findMedianSortedArrays(arr1, arr2));
    }

    @Test
    void findMedianSortedArrays_returnsMedian_whenArrayLengthsAreEqual() {
        int[] arr1 = new int[]{1, 2, 3, 4};
        int[] arr2 = new int[]{5, 6, 7, 8};

        assertEquals(4.5, findMedianSortedArrays(arr1, arr2));
    }

    @Test
    void findMedianSortedArrays_returnsMedian_whenFirstArrayLengthIsLarger() {
        int[] arr1 = new int[]{1, 2, 3, 4, 5, 6};
        int[] arr2 = new int[]{7, 8, 9};

        assertEquals(5.0, findMedianSortedArrays(arr1, arr2));
    }

    @Test
    void findMedianSortedArrays_returnsMedian_whenSecondArrayLengthIsDivided_WithOneItemLeft() {
        int[] arr1 = new int[]{1};
        int[] arr2 = new int[]{2, 3, 4, 5, 6};

        assertEquals(3.5, findMedianSortedArrays(arr1, arr2));
    }

    @Test
    void findMedianSortedArrays_returnsMedian_whenSecondArray1() {
        int[] arr1 = new int[] {1, 2, 3, 4};
        int[] arr2 = new int[] {5, 6, 7, 8, 9, 10, 11, 12};

        assertEquals(6.5 , findMedianSortedArrays(arr1, arr2));
    }
}
