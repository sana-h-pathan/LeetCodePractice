class LFUCache {
    class Node{
        int key;
        int value;
        int freq;
        Node prev;
        Node next;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLList{
        Node head;
        Node tail;
        int size;
        public DLList(){
            this.head = new Node(-1, -1);
            this.tail = new Node(-1,-1);
            this.head.next = tail;
            this.tail.prev = head;
        }
        private void addToHead(Node curr){
            Node temp = head.next;
            head.next = curr;
            curr.prev = head;
            curr.next = temp;
            curr.next.prev = curr;
            this.size++;
        }
        private void removeNode(Node curr){
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            this.size--;
        }
    }

    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, DLList> freqMap;
    int min;
    int capacity;

    public LFUCache(int capacity) {
        this.capacity=capacity;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        Node curr = nodeMap.get(key);
        update(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            Node curr = nodeMap.get(key);
            update(curr);
            curr.value = value;
        } else {
            if(nodeMap.size()==capacity){
                DLList removeList = freqMap.get(min);
                Node toRemove = removeList.tail.prev;
                removeList.removeNode(toRemove);
                nodeMap.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            min=1;
            DLList newList = freqMap.getOrDefault(min, new DLList());
            newList.addToHead(newNode);
            nodeMap.put(key, newNode);
            freqMap.put(min, newList);
        }
        
    }
    private void update(Node curr){
        int oldFreq = curr.freq;
        DLList oldFreqList = freqMap.get(oldFreq);
        oldFreqList.removeNode(curr);
        if(oldFreq == min && oldFreqList.size==0){
            min++;
        }
        curr.freq++;
        int newFreq = curr.freq;
        DLList newFreqList = freqMap.getOrDefault(newFreq, new DLList());
        newFreqList.addToHead(curr);
        freqMap.put(newFreq, newFreqList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */