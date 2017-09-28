package leetcode;

import org.junit.jupiter.api.Test;

import static leetcode.LongestSubstring.longestSequence;
import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringTest {

    @Test
    void longestSubsequence_returnsZero_whenStringIsEmpty() {
        assertEquals(0, longestSequence(""));
    }

    @Test
    void longestSequence_returnsLength_ofLargestSequence() {

        assertEquals(8, longestSequence("abcdefgh"));
        assertEquals(7, longestSequence("abahhkdsejlek"));
        assertEquals(2, longestSequence("aba"));
        assertEquals(4, longestSequence("abaera"));
    }
}
