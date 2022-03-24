package ca.jrvs.practice.codingChallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ticket: https://www.notion.so/jarvisdev/Find-the-Duplicate-Number-ee99a172c128401588b727e316b103b9
 */
public class FindDuplicate {

    /**
     * Big-O: O(nlog(n))
     */
    public int findDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        int prev;
        int curr;
        for(int i = 1; i < nums.length; i++){
            prev = nums[i-1];
            curr = nums[i];
            if(curr == prev){
                return curr;
            }
        }
        return 0;
    }

    /**
     * Big-O: O(n)
     */
    public int findDuplicateSet(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums){
            if(set.add(num) == false){
                return num;
            }
        }
        return 0;
    }
}
