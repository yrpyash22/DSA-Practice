package LinkedList;

public class LinkedList {


    // ========================================
    // Node
    // ========================================
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





    // ----------------------------------------
    // Add
    // ----------------------------------------
    public static void addFirst(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = tail= newNode;
            size++;
            return ;
        }
        newNode.next = head;
        head = newNode;
        size++;
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

    public static void addnthPosition(int idx, int data)
    {
        if(idx == 0)
        {
            addFirst(data);
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while(i < idx - 1)
        {
            temp = temp.next;
            i++;   
        }
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }







    // ----------------------------------------
    // Print A Linked List
    // ----------------------------------------
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








    // ----------------------------------------
    // Remove
    // ----------------------------------------

    public static int removeFirst()
    {
        if(size == 0)
        {
            System.out.println("LL is Emmpty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int removeLast()
    {
        if(size == 0)
        {
            System.out.println("LL is Emmpty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1)
        {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        Node prev = head;
        for(int i = 0; i< size -2; i++)
        {
            prev = prev.next;
        }
        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public static int removeNthNode(int n)
    {
        if(size == 0)
        {
            System.out.println("LL is Emmpty");
            return Integer.MIN_VALUE;
        }
        if(n == 1)
        {
            int val = head.data;
            head = head.next;
            if(head == null)
            {
                tail = null;
            }
            size--;
            return val;
        }

        Node temp = head;
        for(int i = 1; i < n - 1; i++)
        {
            if(temp == null || temp.next == null)
            {
                return -1; // n is greater than list length
            }
            temp = temp.next;
        }
        int val = temp.next.data;
        temp.next = temp.next.next;
        if(temp.next == null)
        {
            tail = temp;
        }
        size--;
        return val;        
    }


    public static int removeNthBack(int n)
    {
        if(size == 0)
        {
            System.out.println("LL is Emmpty");
            return Integer.MIN_VALUE;
        }
        if(n == size)
        {
            return removeFirst();
        }
        int i = 1;
        int itoFind = size - n;
        Node prev = head;
        while(i < itoFind)
        {
            prev = prev.next;
            i++;
        }
        int val = prev.next.data;
        prev.next = prev.next.next;
        size--;
        return val;
    }












    // ----------------------------------------
    // Search in LL
    // ----------------------------------------

    // Iterative
    public static int itrSearch(int key)
    {
        Node temp = head;
        int i = 0;

        while(temp != null)
        {
            if(temp.data == key)
            {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    // Recursion
    public static int recSearch(Node head,int key)
    {
        // Base case
        if(head == null)
        {
            return -1;
        }
        if(head.data == key)
        {
            return 0;
        }

        // Search in remaining list
        int idx = recSearch(head.next, key);
        // Element not found
        if(idx == -1)
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
        LinkedList l1 = new LinkedList();

        l1.addFirst(5);
        l1.addFirst(4);
        l1.addFirst(3);
        l1.addLast(15);
        l1.addnthPosition(2, 100);
        l1.printLL();

        System.out.println("Size of LL :" + size);


        // System.out.println("nth remove in LL : " + l1.removeNthNode(2));
        // System.out.println("First remove in LL : " + l1.removeFirst());
        // System.out.println("Last remove in LL : " + l1.removeLast());
        // System.out.println("Remove nth from last: " + removeNthBack(2));
        l1.printLL();

        System.out.println("Search by Iterative: " + itrSearch(5));
        System.out.println("Search By Recursion : "+ recSearch(head, 100));

        */
    }
}
