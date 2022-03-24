package ca.jrvs.practice.codingChallenge;

import ca.jrvs.practice.dataStructure.node.ListNode;

/**
 * ticket: https://www.notion.so/jarvisdev/Reverse-Linked-List-a47b8349dc6c4a18b7edb7adea3de6a2
 */
public class ReverseLinkedList {

    /**
     * Big-O: O(n)
     */
    public ListNode reverseListRecursive(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseListRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    /**
     * Big-O: O(n)
     */
    public ListNode reverseListIterative(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode prev = null;
        ListNode pointer = head;
        ListNode temp = pointer.next;
        pointer.next = prev;
        prev = temp;
        while(prev != null) {
            temp = prev.next;
            prev.next = pointer;
            pointer = prev;
            if(temp != null){
                prev = temp;
            } else {
                prev = null;
            }
        }
        return pointer;
    }
}
