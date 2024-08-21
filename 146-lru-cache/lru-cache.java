class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    Node head;
    Node tail;
    HashMap<Integer,Node> map;
    int capacity;

    public LRUCache(int capacity) {
       this.capacity=capacity;
       this.head=new Node(-1,-1);
       this.tail=new Node(-1,-1);
       this.map=new HashMap<>();
       head.next=tail;
       tail.prev=head; 
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
        }
        else {
            if(map.size()==capacity){
                Node remove=tail.prev;
                map.remove(remove.key);
                removeNode(remove);
            }
            Node newNode=new Node(key,value);
            map.put(key, newNode);
            addToHead(newNode);
        }
    }

    private void removeNode(Node curr){
        curr.prev.next=curr.next;
        curr.next.prev=curr.prev;
    }

    private void addToHead(Node curr){
        curr.next=head.next;
        head.next=curr;
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