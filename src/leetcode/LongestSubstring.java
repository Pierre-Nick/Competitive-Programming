package leetcode;

import java.util.HashSet;

class LongestSubstring {

    static int longestSequence(String s) {
        if (s.isEmpty()) { // case when the string is empty
            return 0;
        }

        HashSet<Character> fun = new HashSet<>();

        int lsSize = 1;

        for (int i = 0; i < s.length(); i++) {
            int count = 1;
            fun.add(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                if (fun.contains(s.charAt(j))) {
                    fun.clear();
                    break;
                }
                fun.add(s.charAt(j));
                count++;
            }
            if (count > lsSize) {
                lsSize = count;
            }
        }
        return lsSize;
    }
}
