class LRUCache {
    
    // create a doubleLL
    class Node
    {
        int val;
        int key;

        Node next;
        Node prev;

        public Node(int key, int val)
        {
            this.key = key;
            this.val = val;
        }
    }

    // create hashmap
    HashMap<Integer, Node> map;

    // create 2 dump node
    Node head;
    Node tail;

    int capacity;

    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node list)
    {
        Node prevNode = list.prev;
        Node nextNode = list.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    // Add node just before tail. This means node becomes MRU
    private void addToMRU(Node list) 
    { 
        Node prevNode = tail.prev;
        prevNode.next = list;
        list.prev = prevNode;
        list.next = tail;
        tail.prev = list;
    }


    public int get(int key) {
        if (!map.containsKey(key))
        { 
            return -1; 
        }

        Node node = map.get(key);
        // This key was recently used, so move it to MRU
        remove(node);
        addToMRU(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        
        // if key already exist
        if(map.containsKey(key))
        {
            Node node = map.get(key);

            // Update value
            node.val = value;

            // Move to MRU
            remove(node);
            addToMRU(node);
            return;
        }


        Node newNode = new Node(key, value);
        map.put(key, newNode);
        addToMRU(newNode);

        // If capacity exceeded 
        if(map.size() > capacity)
        { 
            // LRU node is head.next 
            Node lru = head.next; 
            
            // Remove from linked list 
            remove(lru); 
            
            // Remove from HashMap 
            map.remove(lru.key); 
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */