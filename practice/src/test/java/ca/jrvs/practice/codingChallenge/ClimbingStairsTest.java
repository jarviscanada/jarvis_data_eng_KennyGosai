package ca.jrvs.practice.codingChallenge;
import static org.junit.Assert.*;
import org.junit.Test;

public class ClimbingStairsTest {
    @Test
    public void recursiveLargeNumber(){
        ClimbingStairs test = new ClimbingStairs();
        assertEquals(test.climbStairsRecursion(44), 1134903170);
    }

    @Test
    public void dynamicLargeNumber(){
        ClimbingStairs test = new ClimbingStairs();
        assertEquals(test.climbStairsDynamicProg(44), 1134903170);
    }
}
