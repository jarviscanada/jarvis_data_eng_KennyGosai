package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.dataStructure.node.ListNode;

/**
 * ticket: https://www.notion.so/jarvisdev/LinkedList-Cycle-acfb2f62dac2475c955a0be5b9127bc3
 */
public class LinkedListCycle {

    /**
     * Big-O: O(n)
     */
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null){
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
