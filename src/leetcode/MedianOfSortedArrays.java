package leetcode;

import java.util.InputMismatchException;

public class MedianOfSortedArrays {

    public static void main(String[] args) {
        System.out.println(1 % 2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 != null && nums2 != null) {
            int nums1ArraySize = nums1.length;
            int nums2ArraySize = nums2.length;

            int medianRange;

            if (nums2ArraySize > nums1ArraySize) {
                medianRange = nums2ArraySize - nums1ArraySize;

                return findMedianUsingRange(nums2, medianRange, false);
            } else if (nums1ArraySize > nums2ArraySize) {
                medianRange = nums1ArraySize - nums2ArraySize;

                return findMedianUsingRange(nums1, medianRange, true);
            }

            return (nums1[nums1ArraySize - 1] + nums2[0]) / 2.0;

        } else {
            throw new InputMismatchException();
        }
    }

    private static double findMedianUsingRange(int[] array, int medianRange, boolean leftSide) {
        System.out.println(medianRange);
        if (medianRange == 1) {
            return array[medianRange - 1]; // if median is only 1 item left return
        }

        if (medianRange % 2 != 0) {

            if (leftSide) {
                return array[medianRange + (medianRange / 2)];
            }
            return array[medianRange / 2];
        }

        System.out.println(medianRange);

        return (array[medianRange / 2] + array[(medianRange / 2) - 1]) / 2.0;
    }
}
