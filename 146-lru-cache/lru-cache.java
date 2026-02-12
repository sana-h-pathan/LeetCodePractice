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
    int capacity;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
    }
    public void removeNode(Node curr){
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
    }
    public void addToHead(Node curr){
        Node temp = head.next;
        head.next = curr;
        curr.prev = head;
        curr.next = temp;
        temp.prev = curr;
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
            curr.value = value;
            addToHead(curr);
        } else {
            if(map.size()==capacity){
                Node toremove = tail.prev;
                removeNode(toremove);
                map.remove(toremove.key);
            }
            Node newNode = new Node(key, value);
            addToHead(newNode);
            map.put(key, newNode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */