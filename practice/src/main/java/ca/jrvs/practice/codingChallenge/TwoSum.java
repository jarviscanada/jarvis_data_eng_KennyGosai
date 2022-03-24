package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;

/**
 * ticket: https://www.notion.so/jarvisdev/Two-Sum-68f9c9b8ce044704afb0aac5aff40c5b
 */
public class TwoSum {
    /**
     * Big-O: O(n^2)
     */
    public int[] twoSumBruteForce(int[] nums, int target) {
        int[] indices = new int[2];
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                if(i != j && nums[j] + nums[i] == target){
                    indices[0] = i;
                    indices[1] = j;
                    return indices;
                }
            }
        }
        return indices;
    }

    /**
     * Big-O: O(n)
     */
    public int[] twoSumEfficient(int[] nums, int target) {
        HashMap<Integer, Integer> differences = new HashMap<Integer, Integer>();
        int[] indices = new int[2];
        for(int i = 0; i < nums.length; i++){
            if(differences.get(nums[i]) != null){
                indices[0] = differences.get(nums[i]);
                indices[1] = i;
                return indices;
            }
            int difference = target - nums[i];
            differences.put(difference, i);
        }
        return indices;
    }
}
