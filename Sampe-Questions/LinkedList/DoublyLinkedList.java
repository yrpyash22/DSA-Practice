package LinkedList;

public class DoublyLinkedList {

    // ========================================
    // Node
    // ========================================
    public static class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size = 0;




    // ========================================
    // Add
    // ========================================

    // Add First
    public static void addFirst(int data)
    {
        Node newNode = new Node(data);

        if (head == null)
        {
            head = tail = newNode;
            size++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        size++;
    }


    // Add Last
    public static void addLast(int data)
    {
        Node newNode = new Node(data);
        if (head == null)
        {
            head = tail = newNode;
            size++;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        size++;
    }


    // Add at nth Position
    public static void addnthPosition(int idx, int data)
    {
        if(idx == 0)
        {
            addFirst(data);
            return;
        }

        if(idx < 0 || idx > size)
        {
            System.out.println("Invalid Index");
            return;
        }
        if (idx == size)
        {
            addLast(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;

        int i = 0;
        while(i < idx - 1)
        {
            temp = temp.next;
            i++;
        }

        // New node ko next se connect
        newNode.next = temp.next;
        // New node ko previous se connect
        newNode.prev = temp;
        // Next node ka prev new node
        temp.next.prev = newNode;
        // Previous node ka next new node
        temp.next = newNode;
        size++;
    }






    // ========================================
    // Print
    // ========================================

    // Forward Print
    public static void printLL()
    {
        if (head == null)
        {
            System.out.println("LL is empty");
            return;
        }

        Node temp = head;
        while (temp != null)
        {
            System.out.print("[" + temp.data + "]<->");
            temp = temp.next;
        }
        System.out.println("[N]");
    }


    // Backward Print
    public static void printReverse()
    {
        if (tail == null)
        {
            System.out.println("LL is empty");
            return;
        }

        Node temp = tail;
        while(temp != null)
        {
            System.out.print("[" + temp.data + "]<->");
            temp = temp.prev;
        }
        System.out.println("[N]");
    }






    // ========================================
    // Remove
    // ========================================

    // Remove First
    public static int removeFirst()
    {
        if (size == 0) 
        {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }

        int val = head.data;
        if (size == 1)
        {
            head = tail = null;
            size--;
            return val;
        }

        head = head.next;
        head.prev = null;
        size--;
        return val;
    }


    // Remove Last
    public static int removeLast()
    {

        if (size == 0) 
        {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }

        int val = tail.data;

        if (size == 1) 
        {
            head = tail = null;
            size--;
            return val;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }


    // Remove nth Node from beginning
    public static int removeNthNode(int n)
    {
        if (size == 0) 
        {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }

        if (n < 1 || n > size)
        {
            System.out.println("Invalid Position");
            return -1;
        }

        if (n == 1)
        {
            return removeFirst();
        }

        if (n == size)
        {
            return removeLast();
        }

        Node temp = head;
        int i = 1;
        while (i < n)
        {
            temp = temp.next;
            i++;
        }
        int val = temp.data;
        // Previous node ka next
        temp.prev.next = temp.next;

        // Next node ka prev
        temp.next.prev = temp.prev;
        size--;
        return val;
    }


    // Remove nth Node from Back
    public static int removeNthBack(int n)
    {
        if (size == 0)
        {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }

        if (n < 1 || n > size)
        {
            System.out.println("Invalid Position");
            return -1;
        }

        if (n == size) 
        {
            return removeFirst();
        }

        if (n == 1) 
        {
            return removeLast();
        }

        // Doubly LL ka advantage:
        // Tail se direct backward ja sakte hain

        Node temp = tail;
        int i = 1;
        while (i < n) 
        {
            temp = temp.prev;
            i++;
        }

        int val = temp.data;
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
        return val;
    }







    // ========================================
    // Search
    // ========================================

    // Iterative Search
    public static int itrSearch(int key)
    {
        Node temp = head;
        int i = 0;
        while (temp != null)
        {
            if (temp.data == key)
            {
                return i;
            }

            temp = temp.next;
            i++;
        }
        return -1;
    }


    // Recursive Search
    public static int recSearch(Node head, int key) 
    {
        // Base case
        if (head == null) 
        {
            return -1;
        }

        // Element found
        if (head.data == key)
        {
            return 0;
        }

        // Search remaining list
        int idx = recSearch(head.next, key);

        // Element not found
        if (idx == -1)
        {
            return -1;
        }
        return idx + 1;
    }




    

    // ========================================
    // Main
    // ========================================

    public static void main(String[] args) {
    /* 
        DoublyLinkedList l1 = new DoublyLinkedList();

        // Add First
        l1.addFirst(5);
        l1.addFirst(4);
        l1.addFirst(3);

        // Add Last
        l1.addLast(15);

        // Add at index
        l1.addnthPosition(2, 100);

        System.out.println("Forward Linked List:");
        l1.printLL();

        System.out.println("Reverse Linked List:");
        l1.printReverse();

        System.out.println("Size of LL: " + size);


        // Remove
        System.out.println(
            "First remove: " + l1.removeFirst()
        );

        System.out.println(
            "Last remove: " + l1.removeLast()
        );

        System.out.println(
            "Nth remove: " + l1.removeNthNode(2)
        );

        System.out.println(
            "Nth from back remove: " + l1.removeNthBack(2)
        );


        System.out.println("\nAfter Removing:");

        l1.printLL();

        System.out.println("\nReverse:");

        l1.printReverse();


        // Search
        System.out.println(
            "\nSearch by Iterative: " + l1.itrSearch(5)
        );

        System.out.println(
            "Search by Recursion: " + l1.recSearch(head, 5)
        );
        */
    }
}