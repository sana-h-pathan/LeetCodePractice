/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> bfsQue = new LinkedList();
        bfsQue.add(root);
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            if(isSameTree(curr, subRoot)){
                return true;
            }
            if(curr.left!=null){
                bfsQue.add(curr.left);
            }
            if(curr.right!=null){
                bfsQue.add(curr.right);
            }
        }
        return false;
    }
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }
        if(p!=null && q==null){
            return false;
        }
        if(p==null && q!=null){
            return false;
        }
        if(p.val!=q.val){
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}