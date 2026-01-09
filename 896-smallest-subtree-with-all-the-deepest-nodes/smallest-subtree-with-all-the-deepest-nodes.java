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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root == null)
            return null;
        
        if(checkHeight(root.left) == checkHeight(root.right))
            return root;
        else if(checkHeight(root.left) > checkHeight(root.right))
            return subtreeWithAllDeepest(root.left);
        else
            return subtreeWithAllDeepest(root.right);    
    }
    
    private int checkHeight(TreeNode root){
        if(root == null) 
            return 0;
        int left = checkHeight(root.left);
        int right = checkHeight(root.right);
        return 1+ Math.max(left, right);
    }
}