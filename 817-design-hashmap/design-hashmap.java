class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key=key;
            this.val=val;
        }
    }
    private Node[] data;

    public MyHashMap() {
        data=new Node[10000];
    }
    
    public void put(int key, int value) {
        int hashVal=findHash(key);
        if(data[hashVal]==null){
            data[hashVal]=new Node(-1,-1);
        }
        Node node = find(data[hashVal],key);
        if(node.next==null){
            node.next=new Node(key,value);
        }
        else{
            node.next.val=value;
        }
    }
    
    public int get(int key) {
        int hashVal=findHash(key);
        if(data[hashVal]==null){
            return -1;
        }
        Node node = find(data[hashVal],key);
        if(node.next==null){
            return -1;
        }
        else{
           return node.next.val;
        }
    }
    
    public void remove(int key) {
        int hashVal=findHash(key);
        if(data[hashVal]==null){
            return;
        }
        Node node = find(data[hashVal],key);
        if(node.next==null){
            return;
        }
        else{
            node.next=node.next.next;
        }
        
    }
    private int findHash(int number){
        return number%10000;
    }
    private Node find(Node node, int key){
        Node prev=null;
        Node curr=node;
        while(curr!=null && curr.key!=key){
            prev=curr;
            curr=curr.next;
        }
        return prev;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */