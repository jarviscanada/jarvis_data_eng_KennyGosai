package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Fibonacci-Number-Climbing-Stairs-4dee8fb153bb43d89a413de3e56db956
 */
public class ClimbingStairs {

    /**
     * Big-O: O(2^n)
     */
    public int climbStairsRecursion(int n) {
        int total = 0;
        if(n == 0){
            return 0;
        }
        if(n - 2 >= 0){
            total += 1;
            int tempTotal = climbStairsRecursion(n-2);
            if(tempTotal > 1){
                total += tempTotal - 1;
            }
        }
        if(n - 1 >= 0){
            total += 1;
            int tempTotal = climbStairsRecursion(n-1);
            if(tempTotal > 1){
                total += tempTotal - 1;
            }
        }
        return total;
    }

    /**
     * Big-O: O(n)
     */
    public int climbStairsDynamicProg(int n) {
        if(n == 1){
            return 1;
        }
        int total = 0;
        int[] totalNumbers = new int[n];
        totalNumbers[0] = 1;
        totalNumbers[1] = 2;
        for(int i = 2; i < n; i++){
            total = totalNumbers[i-1] + totalNumbers[i-2];
            totalNumbers[i] = total;
        }
        return totalNumbers[totalNumbers.length-1];
    }
}
