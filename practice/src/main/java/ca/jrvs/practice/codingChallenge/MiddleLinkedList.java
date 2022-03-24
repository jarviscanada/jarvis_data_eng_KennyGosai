package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.dataStructure.node.ListNode;

/**
 * ticket: https://www.notion.so/jarvisdev/Middle-of-the-Linked-List-bdc51cac134144dd8328a897f8dda2c3
 */
public class MiddleLinkedList {

    /**
     * Big-O: O(n)
     */
    public ListNode middleNode(ListNode head) {
        if(head.next == null){
            return head;
        }
        ListNode pointer1 = head.next;
        ListNode pointer2 = head.next.next;
        while(pointer2 != null && pointer2.next != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }
        return pointer1;
    }
}
