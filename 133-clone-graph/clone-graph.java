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
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        HashMap<Node, Node> map=new HashMap<>();
        Queue<Node> bfsQue=new LinkedList<>();
        bfsQue.add(node);
        while(!bfsQue.isEmpty()){
            Node curr=bfsQue.poll();
            Node copyCurr=clone(map,curr);
            for(Node ne: curr.neighbors){
                if(!map.containsKey(ne))
                    bfsQue.add(ne);
                clone(map,ne);
                copyCurr.neighbors.add(map.get(ne));
            }
        }
        return map.get(node);
    }
    private Node clone(HashMap<Node, Node> map, Node curr){
        if(curr==null)
            return null;
        if(!map.containsKey(curr)){
            Node copyCurr=new Node(curr.val);
            map.put(curr,copyCurr);
        }
        return map.get(curr);
    }
}