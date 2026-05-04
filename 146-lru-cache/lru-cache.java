class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node curr = map.get(key);
        removeNode(curr);
        addToHead(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr = map.get(key);
            removeNode(curr);
            curr.value= value;
            addToHead(curr);
        } else {
            if(map.size()==capacity){
                Node curr = tail.prev;
                removeNode(curr);
                map.remove(curr.key);
            }
            Node newNode = new Node(key, value);
            addToHead(newNode);
            map.put(key, newNode);
        }
        
    }
    private void removeNode(Node curr){
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
    }
    private void addToHead(Node curr){
        Node temp = head.next;
        head.next = curr;
        curr.prev = head;
        curr.next = temp;
        curr.next.prev = curr;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */