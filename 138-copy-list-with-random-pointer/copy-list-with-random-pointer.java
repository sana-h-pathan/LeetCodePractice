/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node curr = head;
        Node copyCurr = clone(map, curr);
        while(curr!=null){
           copyCurr.next = clone(map, curr.next);
           copyCurr.random = clone(map, curr.random); 
           curr = curr.next;
           copyCurr = copyCurr.next;
        }
        return map.get(head);
    }
    private Node clone(HashMap<Node, Node> map, Node curr){
        if(curr==null)
            return null;
        if(!map.containsKey(curr)){
            Node copyCurr = new Node(curr.val);
            map.put(curr, copyCurr);
        }
        return map.get(curr);
    }
}