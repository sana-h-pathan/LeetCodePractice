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
        if(head==null)
            return null;
        HashMap<Node, Node> map=new HashMap<>();
        Node curr=head;
        Node copyCurr=new Node(curr.val);
        map.put(curr, copyCurr);
        while(curr!=null){
            copyCurr.next=clone(curr.next,map);
            copyCurr.random=clone(curr.random,map);
            curr=curr.next;
            copyCurr=copyCurr.next;
        }
        return map.get(head);
    }
    private Node clone(Node curr, HashMap<Node, Node> map){
        if(curr==null)
            return null;
        if(!map.containsKey(curr)){
            Node copyCurr=new Node(curr.val);
            map.put(curr,copyCurr);
        }
        return map.get(curr);
    }
}