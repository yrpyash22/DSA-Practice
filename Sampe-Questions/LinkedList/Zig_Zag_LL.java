package LinkedList;

public class Zig_Zag_LL {

    public static class Node
    {
        int data;
        Node next;
        public Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }


    public static Node head;
    public static Node tail;
    public static int size = 0;















    


    
    public static void zigZag()
    {
        if(head == null || head.next == null)
        {
            return;
        }

        // Find mid
        Node mid = findMid(head);

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;

        Node prev = null;
        Node next;
        while(curr != null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // Alternate mearge
        while(left != null && right != null)
        {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }

        //Update tail
        tail = head;
        while(tail.next != null)
        {
            tail = tail.next;
        }
    }


















    public static Node findMid(Node head)
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }




    public static void addLast(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = tail = newNode;
            size++;
            return ;
        }
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public static void printLL()
    {
        if(head == null)
        {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while(temp != null)
        {
            System.out.print("["+temp.data + "]"+ "->");
            temp = temp.next;
        }
        System.out.println("[N]");
    }


    public static void main(String[] args) {
        

        addLast(1);
        addLast(2);
        addLast(3);
        addLast(4);
        addLast(5);
        addLast(6);
        addLast(7);
        addLast(8);
        addLast(9);
        addLast(10);

        System.out.println("Original Linked List:");
        printLL();

        zigZag();

        System.out.println("Zig-Zag Linked List:");
        printLL();
    }
}
