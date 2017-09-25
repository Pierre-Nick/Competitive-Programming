package leetcode;

import java.util.InputMismatchException;

/**
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves,
 * judge if this robot makes a circle, which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character.
 * The valid robot moves are R (Right), L (Left), U (Up) and D (down).
 * The output should be true or false representing whether the robot makes a circle.
 */

public class JudgeCircle {
    public static void main(String[] args) {
        System.out.println(judgeCircle("RLUURDDDLU"));
        System.out.println(judgeCircle("ULDLDRDRURUL"));
    }

    private static boolean judgeCircle(String moves) {
        int movementCount = 0;
        for (int i = 0; i < moves.length(); i++) {
            movementCount += correspondingValue(moves.charAt(i));
        }

        return movementCount == 0;
    }

    private static int correspondingValue(char a) {
        switch (a) {
            case 'U':
                return 1;
            case 'D':
                return -1;
            case 'R':
                return 1;
            case 'L':
                return -1;
            default:
                throw new InputMismatchException("The movement " + a + " is not supported");
        }
    }
}