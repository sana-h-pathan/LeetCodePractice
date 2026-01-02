class LFUCache {

    class Node {
        int key;
        int value;
        int freq;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    // DLL per frequency
    class DLL {
        Node head;
        Node tail;

        DLL() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }
    }

    int capacity;
    int minFreq;
    HashMap<Integer, Node> lruMap;           // key -> node
    HashMap<Integer, DLL> freqMap;            // freq -> DLL

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.lruMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    public int get(int key) {
        if (!lruMap.containsKey(key)) {
            return -1;
        }
        Node curr = lruMap.get(key);
        updateFreq(curr);
        return curr.value;
    }

    public void put(int key, int value) {
        if (lruMap.containsKey(key)) {
            Node curr = lruMap.get(key);
            curr.value = value;
            updateFreq(curr);
            return;
        }

        if (lruMap.size() == capacity) {
            DLL minList = freqMap.get(minFreq);
            Node remove = minList.tail.prev;
            removeNode(remove);
            lruMap.remove(remove.key);
        }

        Node newNode = new Node(key, value);
        lruMap.put(key, newNode);

        if(!freqMap.containsKey(1)){
            freqMap.put(1, new DLL());
        }
        addToHead(freqMap.get(1), newNode);
        minFreq = 1;
    }

    private void updateFreq(Node curr) {
        int oldFreq = curr.freq;
        DLL oldList = freqMap.get(oldFreq);

        removeNode(curr);

        // if this was the last node of minFreq
        if (oldFreq == minFreq && oldList.head.next == oldList.tail) {
            minFreq++;
        }

        curr.freq++;
        if(!freqMap.containsKey(curr.freq)){
            freqMap.put(curr.freq, new DLL());
        }
        addToHead(freqMap.get(curr.freq), curr);
    }

    private void removeNode(Node curr) {
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
    }

    private void addToHead(DLL list, Node curr) {
        Node temp = list.head.next;
        list.head.next = curr;
        curr.prev = list.head;
        curr.next = temp;
        temp.prev = curr;
    }
}
