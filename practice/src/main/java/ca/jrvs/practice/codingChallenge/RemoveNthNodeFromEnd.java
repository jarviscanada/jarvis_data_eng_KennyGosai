package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.dataStructure.node.ListNode;

/**
 * ticket: https://www.notion.so/jarvisdev/Nth-Node-From-End-of-LinkedList-e25764c833b0487c8c624b898712c712
 */
public class RemoveNthNodeFromEnd {

    /**
     * Big-O: O(n)
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next == null && n == 1){
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pointer1 = dummy;
        ListNode pointer2 = dummy;
        for(int i = 0; i < n; i++){
            pointer1 = pointer1.next;
        }
        if(pointer1 == null){
            dummy.next = head.next;
        } else {
            while(pointer1 != null && pointer1.next != null){
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }
            pointer2.next = pointer2.next.next;
        }
        return dummy.next;
    }
}
