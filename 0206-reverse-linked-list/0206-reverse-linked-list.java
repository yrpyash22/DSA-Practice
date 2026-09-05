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
    public ListNode reverseList(ListNode head) { // 1, 2, 3, 4
        
        ListNode curr = head;        // 1
        ListNode prev = null;
        ListNode next;

        while(curr != null) //(1!=N), (2!=N), (3), (4), (N)!
        {
            next = curr.next;       //[2], [3], [4], [N]
            curr.next = prev;       //[N], [1], [2], [3]
            prev = curr;            // N<-[1]<-[2]<-[3]<-[4]
            curr = next;            //[2], [3], [4], [N]
        }
        return prev;
    }
}