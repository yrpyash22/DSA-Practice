/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if(head == null)
        {
            return null;
        }

        flattenList(head);
        return head;
    }

    public Node flattenList(Node curr)
    {
        Node tail = curr;

        while(curr != null)
        {
            Node next = curr.next;

            // Agar child nahi hai
            if(curr.child == null)
            {
                tail = curr;
                curr = next;
                continue;
            }

            // Child ko flatten karo
            Node childHead = curr.child;

            // Child list ka LAST NODE milega
            Node childTail = flattenList(childHead);

            // Child ko curr ke baad connect karo
            curr.next = childHead;
            childHead.prev = curr;

            // Child ke end ko original next se connect karo
            if(next != null)
            {
                childTail.next = next;
                next.prev = childTail;
            }

            // Child pointer remove karo
            curr.child = null;

            // Tail update
            tail = childTail;

            // Original next par continue karo
            curr = next;
        }
        return tail;
    }
}