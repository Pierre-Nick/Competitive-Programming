package crackingTheCodingInterview;

import org.junit.jupiter.api.Test;

import static crackingTheCodingInterview.StringCompression.*;
import static org.junit.jupiter.api.Assertions.*;

class StringCompressionTest {

    @Test
    void compressesString_When_String_ifCompressable() {
        assertEquals("a2b1c5a3", compression("aabcccccaaa"));
        assertEquals("a2b2", compression("aabb"));
        assertEquals("a10", compression("aaaaaaaaaa"));
    }

    @Test
    void returnsString_When_String_isNotCompressable() {
        assertEquals("abcdefg", "abcdefg");
        assertEquals("", "");
        assertEquals("a", "a");
    }
}