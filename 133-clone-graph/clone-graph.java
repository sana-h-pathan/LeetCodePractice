/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        this.map=new HashMap<>();
        Queue<Node> bfsQue=new LinkedList<>();
        bfsQue.add(node);
        cloneNode(node);
        while(!bfsQue.isEmpty()){
            Node curr=bfsQue.poll();
            Node duplicaNode=cloneNode(curr);
            for(Node ne: curr.neighbors){
                if(!map.containsKey(ne)){
                    bfsQue.add(ne);
                }
                Node cloneNe=cloneNode(ne);
                duplicaNode.neighbors.add(cloneNe);
            }
        }

        return map.get(node);
        
    }

    private Node cloneNode(Node node){
        if(!map.containsKey(node)){
            Node newNode=new Node(node.val);
            map.put(node, newNode);
        }
        return map.get(node);
    }
}