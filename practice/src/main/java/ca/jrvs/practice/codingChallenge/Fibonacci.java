package ca.jrvs.practice.codingChallenge;

/**
 * ticket: https://www.notion.so/jarvisdev/Fibonacci-Number-Climbing-Stairs-4dee8fb153bb43d89a413de3e56db956
 */
public class Fibonacci {

    /**
     * Big-O: O(2^n)
     */
    public int fibRecursion(int n) {
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return fibRecursion(n-1) + fibRecursion(n-2);
    }

    /**
     * Big-O: O(n)
     */
    public int fibDynamicProgramming(int n) {
        int[] fibSeq = new int[n+1];
        for(int i = 0; i < fibSeq.length; i++){
            if(i == 0){
                fibSeq[i] =  0;
            } else if(i == 1) {
                fibSeq[i] = 1;
            }else {
                fibSeq[i] = fibSeq[i-1]+ fibSeq[i-2];
            }
        }
        return fibSeq[n];
    }
}
