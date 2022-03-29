package ca.jrvs.practice.dataStructure.node;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    public StackUsingQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if(q1.isEmpty()){
            q1.add(x);
        } else{
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
            q1.add(x);
            while(!q2.isEmpty()){
                q1.add(q2.poll());
            }
        }
        System.out.println(q1.toString());
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
