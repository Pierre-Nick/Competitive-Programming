package crackingTheCodingInterview.interval;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Given two arrays/Lists with sorted and non intersecting intervals. Merge them to get a new sorted
 * non-intersecting array/list.
 */

public class IntervalTest {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 9}, {17, 25}, {58, 73}, {75, 96}};
        int[][] arr2 = {{8, 11}, {16, 47}, {94, 95}, {103, 104}};

        ArrayList<Interval> list = new ArrayList<>();
        ArrayList<Interval> intervals = new ArrayList<>();
        Stack<Interval> stack = new Stack<>();

        int sizeArr1 = arr1.length;
        int sizeArr2 = arr2.length;

        int i = 0, j = 0;
        while (i < sizeArr1 || j < sizeArr2) { // O(i + j)
            if (i < sizeArr1 && j < sizeArr2) {
                if (arr1[i][0] < arr2[j][0]) {
                    intervals.add(new Interval(arr1[i][0], arr1[i][1]));
                    i++;
                } else {
                    intervals.add(new Interval(arr2[j][0], arr2[j][1]));
                    j++;
                }
                continue;
            }

            if (i < sizeArr1) {
                intervals.add(new Interval(arr1[i][0], arr1[i][1]));
                i++;
            }
            if (j < sizeArr2) {
                intervals.add(new Interval(arr2[j][0], arr2[j][1]));
                j++;
            }
        }

        for (i = intervals.size() - 1; i >= 0; i--) {
            stack.push(intervals.remove(i));
        }

        while (!stack.isEmpty()) { // O(i + j) i.e O(n)
            Interval currentInterval = stack.pop();
            boolean solvedInterval = false;

            while (!solvedInterval && !stack.isEmpty()) { // O(n)
                Interval temp = stack.peek();

                if (temp.getStart() <= currentInterval.getEnd()) {
                    if (temp.getEnd() < currentInterval.getEnd()) {
                        stack.pop();
                        continue;
                    }
                    currentInterval.setEnd(temp.getEnd());
                    stack.pop();
                    continue;
                }

                list.add(currentInterval);

                solvedInterval = true;
            }
            if (stack.isEmpty()) list.add(currentInterval);
        }

        for (Interval x : list) // O(n)
            System.out.print(x);
    }
}

// Overall Time:O(n^2) Space:O(n) solution: Not good