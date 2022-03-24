package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;

/**
 * ticket: https://www.notion.so/jarvisdev/Valid-Anagram-1fd434ef6bb04a6a89c04308ff7e8295
 */
public class ValidAnagram {
    /**
     * Big-O: O(nlogn)
     */
    public boolean isAnagramSorting(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        return Arrays.equals(sArr, tArr);
    }

    /**
     * Big-O: O(n)
     */
    public boolean isAnagramLinear(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


}
