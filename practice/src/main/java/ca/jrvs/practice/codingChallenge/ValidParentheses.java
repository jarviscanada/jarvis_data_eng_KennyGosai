package ca.jrvs.practice.codingChallenge;

import java.util.HashMap;
import java.util.Stack;

/**
 * ticket: https://www.notion.so/jarvisdev/Valid-Parentheses-7f255cac606b470a90f7cc705a9d63fb
 */
public class ValidParentheses {

    /**
     * Big-O: O(n)
     */
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        for(int i = 0; i< s.length(); i++){
            if(mappings.containsValue(s.charAt(i))){
                stack.push(s.charAt(i));
            } else if(mappings.containsKey(s.charAt(i))) {
                if(stack.size() == 0 || stack.pop() != mappings.get(s.charAt(i))){
                    return false;
                }
            }
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }
}
