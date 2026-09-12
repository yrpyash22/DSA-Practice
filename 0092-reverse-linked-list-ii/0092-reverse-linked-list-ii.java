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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        

        // head = [1,2,3,4,5], left = 2, right = 4
        // Dumpy node
        ListNode dum = new ListNode(0);
        dum.next = head;    // [0, 1..]

        ListNode prev = dum;    // [0..]

        for(int i=1; i<left; i++)       // 1
        {
            prev = prev.next;    // [1..]
        }

        ListNode curr = prev.next;  // [2..]

        // Reverse left to right
        for(int i = 0; i < right - left; i++)   // 0, 1
        {
            ListNode next = curr.next;   // [3..], [4..]

            curr.next = next.next;       // [4..], [5]
            next.next = prev.next;       // [2..], [3..]

            prev.next = next;           // [3..], [4..]
        }

        return dum.next;   // [1,4,3,2,5]

    }
}