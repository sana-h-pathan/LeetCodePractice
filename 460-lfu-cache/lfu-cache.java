class LFUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;
        int freq;
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
            this.tail = new Node(-1, -1);
            this.head.next = this.tail;
            this.tail.prev = this.head;
            this.size = 0;
        }
        private void addToHead(Node curr){
            Node temp = head.next;
            head.next = curr;
            curr.prev = head;
            curr.next = temp;
            temp.prev = curr;
            this.size++;
        }
        private void removeNode(Node curr){
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
            this.size--;
        }
    }

    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, DLList> freqMap;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        Node curr = nodeMap.get(key);
        updateNode(curr);
        return curr.value;   
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            Node curr = nodeMap.get(key);
            curr.value = value;
            updateNode(curr); //removenode->updatefreq->addToHead
        } else {
            if(nodeMap.size() == capacity){
                DLList removeList = freqMap.get(min);
                Node toRemove = removeList.tail.prev;
                removeList.removeNode(toRemove);
                nodeMap.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            min=1;
            DLList newList = freqMap.getOrDefault(min, new DLList());
            newList.addToHead(newNode);
            freqMap.put(min, newList);

        }
    }

    private void updateNode(Node curr){
        int currFreq = curr.freq;
        DLList currList = freqMap.get(currFreq);
        currList.removeNode(curr);
        if(currFreq==min && currList.size==0){
            min++;
        }
        curr.freq++;
        int newFreq = curr.freq;
        DLList newList = freqMap.getOrDefault(newFreq, new DLList());
        newList.addToHead(curr);
        freqMap.put(newFreq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */