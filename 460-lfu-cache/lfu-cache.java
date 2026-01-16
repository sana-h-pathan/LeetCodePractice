class LFUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        int freq;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }
    
    class NodeList{
        Node head;
        Node tail;
        int size;
        public NodeList(){
            this.head = new Node(-1, -1);
            this.tail = new Node(-1,-1);
            this.head.next = tail;
            this.tail.prev = head;
        }
        public void addToHead(Node curr){
            Node temp = head.next;
            head.next = curr;
            curr.prev = head;
            curr.next = temp;
            curr.next.prev = curr;
            this.size++;
        }
        private void removeNode(Node curr){
            curr.next.prev = curr.prev;
            curr.prev.next = curr.next;
            this.size--;
        }
    }
    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, NodeList> freqMap;
    int capacity;
    int min;

    public LFUCache(int capacity) {
        this.nodeMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        Node curr = nodeMap.get(key);
        update(curr);
        return curr.value;
        
    }
    
    private void update(Node curr){
        int oldFreq = curr.freq;
        NodeList nl = freqMap.get(curr.freq);
        nl.removeNode(curr);
        if(oldFreq==min && nl.size==0){
            min++;
        }
        curr.freq++;
        int newCount = curr.freq;
        NodeList newFreqList = freqMap.getOrDefault(newCount, new NodeList());
        newFreqList.addToHead(curr);
        freqMap.put(newCount, newFreqList);
    }
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            Node curr = nodeMap.get(key);
            update(curr);
            curr.value = value;
        } else {
            if(nodeMap.size()==capacity){
                //remove least freq node
                NodeList list = freqMap.get(min);
                Node toRemove = list.tail.prev;
                list.removeNode(toRemove);
                nodeMap.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            min=1;
            NodeList nodeList = freqMap.getOrDefault(min, new NodeList());
            nodeList.addToHead(newNode);
            freqMap.put(min, nodeList);
            nodeMap.put(key, newNode);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */