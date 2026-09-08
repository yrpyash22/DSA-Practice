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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // head = [1,2,3,4,5], n = 2
        ListNode dum = new ListNode(0);
        dum.next = head;

        ListNode slow = dum;
        ListNode fast = dum;

        for(int i =0; i<n; i++) // 0, 1
        {
            fast = fast.next;  // [1..], [2..]
        }

        while(fast.next != null) // (3!=N), (4!=N), (5!=N), (N!=N)!
        {
            slow = slow.next; // [1.], [2.], [3.]
            fast = fast.next; // [3.], [4.], [5.]
        }

        slow.next = slow.next.next;  // [4] = [5] 

        return dum.next;
    }
}