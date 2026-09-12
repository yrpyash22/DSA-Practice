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

        // Check whether k nodes are available
        ListNode temp = head;

        for (int i = 0; i < k; i++) {

            if (temp == null) {
                return head;
            }

            temp = temp.next;
        }

        // Reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;

        for (int i = 0; i < k; i++) {

            ListNode next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // Recursively reverse remaining groups
        head.next = reverseKGroup(curr, k);

        // prev is the new head
        return prev;
    }
}