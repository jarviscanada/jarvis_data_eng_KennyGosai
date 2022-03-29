package ca.jrvs.practice.codingChallenge;

import java.util.HashSet;

public class MissingNumber {
//    Can cause Integer Overflow
    public int missingNumberSum(int[] nums) {
        int sum = 0;
        for(int i = 1; i <= nums.length; i++){
            sum = sum + i - nums[i-1];
        }
        return sum;
    }

    public int missingNumberSet(int[] nums) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        for(int num : nums){
            numbers.add(num);
        }
        for(int i = 0; i <= nums.length; i++){
            if(!numbers.contains(i)){
                return i;
            }
        }
        return 0;
    }

//    Can cause Integer Overflow
    public int missingNumberGaussFormula(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}
