class MyCircularQueue {
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
            this.next = null;
        }
    }
    Node head;
    Node tail;
    int capacity;
    int count;
    public MyCircularQueue(int k) {
        this.capacity=k;
        this.count=0;
        this.head = null;
        this.tail = null;
    }
    
    public boolean enQueue(int value) {
        if(count==capacity){
            return false;
        }
        Node newNode = new Node(value);
        if(count==0){
            head = newNode;
            tail = newNode;
            tail.next = head;
        } else {
            tail.next = newNode;
            tail = tail.next;
            tail.next = head;
        }
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(count==0){
            return false;
        }
        if(count==1){
            head=null;
            tail=null;
            count--;
            return true;
            
        }
        head = head.next;
        tail.next = head;
        count--;
        return true;
    }
    
    public int Front() {
        if(count==0){
            return -1;
        }
        return head.value;
    }
    
    public int Rear() {
        if(count==0){
            return -1;
        }
        return tail.value;
    }
    
    public boolean isEmpty() {
        if(count==0){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(count==capacity){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */