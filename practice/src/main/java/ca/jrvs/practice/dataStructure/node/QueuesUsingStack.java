package ca.jrvs.practice.dataStructure.node;

import java.util.Stack;

public class QueuesUsingStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public QueuesUsingStack() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        if(s1.isEmpty()){
            s1.add(x);
        } else {
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
            s1.add(x);
            while(!s2.isEmpty()){
                s1.add(s2.pop());
            }
        }
    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }
}
