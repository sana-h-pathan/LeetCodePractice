class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class MyCircularQueue {

    private Node head;
    private Node tail;
    private int count;
    private int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.count = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean enQueue(int value) {
        if (count == capacity) {
            return false;
        }

        Node newNode = new Node(value);

        if (count == 0) {
            head = newNode;
            tail = newNode;
            tail.next = head;          // make it circular
        } else {
            tail.next = newNode;       // attach new at end
            tail = newNode;            // move tail
            tail.next = head;          // keep circle closed
        }

        count++;
        return true;
    }

    public boolean deQueue() {
        if (count == 0) {
            return false;
        }

        if (count == 1) {
            head = null;
            tail = null;
            count = 0;
            return true;
        }

        head = head.next;              // move head forward
        tail.next = head;              // keep circle closed
        count--;
        return true;
    }

    public int Front() {
        if (count == 0) {
            return -1;
        }
        return head.value;
    }

    public int Rear() {
        if (count == 0) {
            return -1;
        }
        return tail.value;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == capacity;
    }
}
