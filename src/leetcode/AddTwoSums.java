package leetcode;

import java.util.Stack;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order
 * and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * <p>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * 1559 / 1559 test cases passed.
 * 65ms Runtime
 */

public class AddTwoSums {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode num1 = l1;
        ListNode num2 = l2;

        Stack<Integer> carryStack = new Stack<>();
        Stack<Integer> finalListStack = new Stack<>();

        while (num1 != null || num2 != null) {
            int x = num1 != null ? num1.val : 0;
            int y = num2 != null ? num2.val : 0;
            int sum = x + y;

            if (!carryStack.isEmpty()) sum += carryStack.pop();
            if (sum > 9) carryStack.push(sum / 10);

            finalListStack.push(sum % 10);
            num1 = num1 != null ? num1.next : null;
            num2 = num2 != null ? num2.next : null;
        }

        // Pancakes
        while (!carryStack.isEmpty()) {
            finalListStack.push(carryStack.pop());
        }
        while (!finalListStack.isEmpty()) {
            carryStack.push(finalListStack.pop());
        }

        ListNode listSum = new ListNode(carryStack.pop());
        ListNode temp = listSum;
        while (!carryStack.isEmpty()) {
            temp.next = new ListNode(carryStack.pop());
            temp = temp.next;
        }
        return listSum;
    }

    class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }
    }
}
