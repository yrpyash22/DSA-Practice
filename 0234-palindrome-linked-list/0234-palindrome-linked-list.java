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
    public boolean isPalindrome(ListNode head) {
        

        if(head == null || head.next == null)
        {
            return true;
        }

        // Find mid
        ListNode midNode = findMid(head);

        // Reverse 2nd half
        ListNode curr = midNode;
        ListNode prev = null;

        while(curr != null)
        {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode right = prev;
        ListNode left = head;
        // Check it is equal
        while(right != null)
        {
            if(left.val != right.val)
            {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public ListNode findMid(ListNode head)
    {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}