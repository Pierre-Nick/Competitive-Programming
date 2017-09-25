package leetcode;

import java.util.Random;

/**
 * Difficulty: Easy
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution.
 */

public class TwoSum {
    public static void main(String[] args) {
        Random generator = new Random();
        int randomTarget = generator.nextInt(10) + 1;
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; ++i)
            numbers[i] = generator.nextInt(10);

        System.out.print("Given nums = [");

        StringBuilder givenArray = new StringBuilder();
        for (int x : numbers) {
            givenArray.append(x).append(" ");
        }

        System.out.print(givenArray.substring(0, givenArray.length() - 1).replace(' ', ','));

        System.out.println("]\ttarget = " + randomTarget);
        twoSum(numbers, randomTarget);
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.printf("Because nums[%d] + nums[%d] = %d + %d = %d", i, j, nums[i], nums[j], target);
                    return new int[]{i, j};
                }
            }
        }
        System.out.println("No two numbers sum to the target " + target);
        return new int[0];
    }
}