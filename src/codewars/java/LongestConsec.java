package codewars;

/**
 * 	Difficulty: 6 Kyu
 *  You are given an array 'strarr' of strings and an integer 'k'. 
 *  Your task is to return the first longest string consisting of k consecutive strings taken in the array.
 */

public class LongestConsec {	    
	public static String longestConsec(String[] strarr, int k) {
        
        if (k < 1 || strarr.length < 1 || k > strarr.length)
            return "";
        
        String longestString = "";
        String tempLongest;
        int l;
        for (int i = 0; i < strarr.length; i++) {
            tempLongest = strarr[i];
            l = 1;
            for (int j = i + 1; j < strarr.length && l < k; j++) {
                    tempLongest += strarr[j];
                    l++;
            }
            if (tempLongest.length() > longestString.length()) {
                longestString = tempLongest;
            }
        }

        return longestString;
    }
}

