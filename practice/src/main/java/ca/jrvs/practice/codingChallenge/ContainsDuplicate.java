package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;
import java.util.Set;

/**
 * ticket: https://www.notion.so/jarvisdev/Fibonacci-Number-Climbing-Stairs-4dee8fb153bb43d89a413de3e56db956
 */
public class ContainsDuplicate {

    /**
     * Big-O: O(n)
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.add(num) == false){
                return true;
            }
        }
        return false;
    }
}
