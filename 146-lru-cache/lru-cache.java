class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }

    private void addToHead(Node curr){
        curr.prev=head;
        curr.next=head.next;
        head.next=curr;
        curr.next.prev=curr;
    }
    
    private void removeFromHead(Node curr){
        curr.next.prev=curr.prev;
        curr.prev.next=curr.next;
    }

    Node head;
    Node tail;
    HashMap<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.head=new Node(-1,-1);
        this.tail=new Node(-1,-1);
        this.head.next=this.tail;
        this.tail.prev=this.head;
        this.map=new HashMap<>();  
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        Node curr=map.get(key);
        removeFromHead(curr);
        addToHead(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node curr=map.get(key);
            curr.value=value;
            removeFromHead(curr);
            addToHead(curr);
        }
        else{
            if(map.size()==capacity){
                Node toRemove=tail.prev;
                removeFromHead(toRemove);
                map.remove(toRemove.key);
            }
            Node toAdd=new Node(key, value);
            addToHead(toAdd);
            map.put(key, toAdd);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */