/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        

        if(head == null || head == head.next || k == 0)
        {
            return head;
        }


        // Find length and tail
        int length = 1;
        ListNode tail = head;

        while(tail.next != null)
        {
            tail = tail.next;
            length++;
        }

        // Remove extra rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Make circular list
        tail.next = head;

        // Find new tail
        int steps = length - k;

        ListNode newTail = head;

        for (int i = 1; i < steps; i++)
        {
            newTail = newTail.next;
        }

         // New head
        ListNode newHead = newTail.next;

        // Break circular list
        newTail.next = null;

        return newHead;
    }
}