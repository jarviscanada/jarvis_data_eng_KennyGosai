package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Valid-Palindrome-1a0af17b6fdf4f899d481ab25795ab4a
 */
public class Palindrome {

    /**
     * Big-O: O(n)
     */
    public boolean isPalindromeTwoPointers(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while (leftPointer < rightPointer) {
            while(leftPointer <= rightPointer && !Character.isLetterOrDigit(s.charAt(leftPointer))){
                leftPointer++;
            }
            while(leftPointer <= rightPointer && !Character.isLetterOrDigit(s.charAt(rightPointer))){
                rightPointer--;
            }
            if(leftPointer < rightPointer && Character.toLowerCase(s.charAt(leftPointer)) != Character.toLowerCase(s.charAt(rightPointer))){
                return false;
            }

            leftPointer++;
            rightPointer--;
        }
        return true;
    }

    /**
     * Big-O: O(n)
     */
    public boolean isPalindromeRecursive(String s) {
        int leftPointer = 0;
        int rightPointer = s.length() - 1;

        while(leftPointer <= rightPointer && !Character.isLetterOrDigit(s.charAt(leftPointer))){
            leftPointer++;
        }
        while(leftPointer <= rightPointer && !Character.isLetterOrDigit(s.charAt(rightPointer))){
            rightPointer--;
        }
        if(leftPointer < rightPointer && Character.toLowerCase(s.charAt(leftPointer)) != Character.toLowerCase(s.charAt(rightPointer))){
            return false;
        } else if(leftPointer < rightPointer && !isPalindromeRecursive(s.substring(leftPointer+1, rightPointer)) ){
            return false;
        }

        return true;
    }
}
