package practice.medium;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Node>map;
    Node start;
    Node end;
    int capacity;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        start = new Node(-1,-1);
        end = new Node(-1,-1);
        start.next = end;
        end.prev = start;
        this.capacity = capacity;
    }

    public int get(int key) {

        //find if key is present in map,
        //find node and add it in the beginning

        if(map.containsKey(key)){

            Node node = map.get(key);
            moveToHead(node);
            return node.val;
        }

        return -1;

    }

    public void put(int key, int value) {

        if(!map.containsKey(key)){
            if(map.size() == capacity){

                Node last = end.prev;
                removeNode(last);
                map.remove(last.key);
            }
            Node newNode = new Node(key,value);
            map.put(key, newNode);
            //add to head
            addToHead(newNode);

        } else{

            Node node  = map.get(key);
            node.val = value;
            moveToHead(node);

        }
    }


    void moveToHead(Node node){
        removeNode(node);
        addToHead(node);
    }


    void removeNode(Node node){
        //grab reference to the prev and next of the node
        Node prev = node.prev;
        Node next = node.next;

        //cut the outgoing forwards and backwards
        prev.next = next;
        next.prev = prev;

    }

    //Insertions to the doubly linked list will always be right after the dummy head
    private void addToHead(Node node) {

        //connect the inserted node
        node.prev = start;
        node.next = start.next;

        //Re-wire the exiting nodes
        start.next.prev = node;
        start.next = node;
    }



    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key,int val){
            this.key=key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }

    }

    public static void main(String[] args) {

        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));    // return 3
        System.out.println(lRUCache.get(4));    // return 4

    }
}

