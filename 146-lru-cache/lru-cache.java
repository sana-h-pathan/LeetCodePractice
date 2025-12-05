class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map=new HashMap<>();
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=tail;
        this.tail.prev=head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node curr=map.get(key);
        removeNode(curr);
        addToHead(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr=map.get(key);
            removeNode(curr);
            curr.value=value;
            addToHead(curr);
        } else{
            if(map.size()==capacity){
                Node remove=tail.prev;
                removeNode(remove);
                map.remove(remove.key);
            }
            Node newNode=new Node(key,value);
            addToHead(newNode);
            map.put(key, newNode);
        }
        
    }

    private void removeNode(Node curr){
        curr.next.prev=curr.prev;
        curr.prev.next=curr.next;
    }
    private void addToHead(Node curr){
        //head->1->2->3->tail
        //head->3->1->2->tail
        Node temp=head.next;
        head.next=curr;
        curr.next=temp;
        curr.prev=head;
        curr.next.prev=curr;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */