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

    public ListNode reverseKGroup(ListNode head, int k) {

        if(head == null || k == 1)
        {
            return head;
        }

        // Dummy node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode groupPrev = dummy;

        while(true)
        {

            // Find kth node
            ListNode kth = groupPrev;

            for (int i = 0; i < k; i++)
            {
                kth = kth.next;

                if (kth == null)
                {
                    return dummy.next;
                }
            }

            ListNode groupNext = kth.next;

            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while(curr != groupNext)
            {
                ListNode next = curr.next;

                curr.next = prev;

                prev = curr;
                curr = next;
            }

            ListNode temp = groupPrev.next;

            groupPrev.next = kth;

            groupPrev = temp;
        }
    }
}