package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Rotate-String-5bc01e6a1e1b47b087bcd853e9ba6b24
 */
public class RotateString {
    /**
     * Big-O: O(n^2)
     */
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}