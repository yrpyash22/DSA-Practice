/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if(head == null)
        {
            return null; 
        }

        // Original Node -> Copy Node
        HashMap<Node, Node> map = new HashMap<>();

        // Create all nodes
        Node curr = head;

        while(curr != null)
        {
            Node copy = new Node(curr.val);
            map.put(curr, copy);
            curr = curr.next;
        }

        // Set next & random
        curr = head;
        while(curr != null)
        {
            Node copy = map.get(curr);
            // Set next pointer
            copy.next = map.get(curr.next);
            // Set random pointer
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        // Return copied head
        return map.get(head);
    }
}