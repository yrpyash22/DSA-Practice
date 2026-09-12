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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dum = new ListNode(0);

        // Current pointer for answer ke liye
        ListNode curr = dum;

        int carry = 0;

        // Jab tak koi list ya carry available hai
        while(l1 != null || l2 != null || carry != 0)
        {
            int val1 = 0;
            int val2 = 0;

            if(l1 != null)
            {
                val1 = l1.val;
            }

            if(l2 != null)
            {
                val2 = l2.val;
            }

            // sum of both value
            int sum = val1 + val2 + carry;

            // Current Actual Value of LL find
            int actualVal = sum % 10;
            // find carry value
            carry = sum / 10;

            // assigned actual value in LL
            curr.next = new ListNode(actualVal);

            curr = curr.next;

            // l1 and l2 ko aage move karo
            if(l1 != null) { l1 = l1.next; }
            if(l2 != null) { l2 = l2.next; }
        }

        return dum.next;
    }
}