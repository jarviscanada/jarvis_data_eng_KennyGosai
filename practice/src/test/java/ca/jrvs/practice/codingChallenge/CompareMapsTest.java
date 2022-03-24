package ca.jrvs.practice.codingChallenge;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CompareMapsTest {
    @Test
    public void approach1Test1(){
        ca.jrvs.practice.codingChallenge.CompareMaps test = new ca.jrvs.practice.codingChallenge.CompareMaps();
        Map<String, Integer> m1 = new HashMap<String, Integer>();
        Map<String, Integer> m2 = new HashMap<String, Integer>();
        m1.put("Name", 1);
        m1.put("Hi", 2);
        m1.put("Bye",3);
        m2.put("Bye",3);
        m2.put("Name", 1);
        m2.put("Hi",2);
        assertEquals(test.compareMapsJavaAPI(m1,m2), true);
    }

    @Test
    public void approach1Test2(){
        ca.jrvs.practice.codingChallenge.CompareMaps test = new ca.jrvs.practice.codingChallenge.CompareMaps();
        Map<String, Integer> m1 = new HashMap<String, Integer>();
        Map<String, Integer> m2 = new HashMap<String, Integer>();
        m1.put("Name", 1);
        m2.put("Name2", 1);
        assertEquals(test.compareMapsJavaAPI(m1,m2), false);
    }


}