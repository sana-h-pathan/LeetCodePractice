class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(s);
        while(!que.isEmpty()) { // bfs
            TreeNode node = que.poll();
            if(sameTree(node, t)) 
                return true;
            if(node.left != null) 
                que.add(node.left);
            if(node.right != null) 
                que.add(node.right);
        }
        return false;
    }
    
    private boolean sameTree(TreeNode s, TreeNode t) {
        if(s == null && t == null) 
            return true;
        if((s == null && t != null) || (s != null && t == null)) 
            return false;
        if(s.val != t.val) 
            return false;
        
        return sameTree(s.left, t.left) && sameTree(s.right, t.right);  
    } 
}