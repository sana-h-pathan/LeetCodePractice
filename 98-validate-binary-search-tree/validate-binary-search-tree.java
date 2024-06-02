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
    TreeNode prev=null;
    boolean flag=true;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return flag;
    }
    private void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        if(prev!=null && root.val<=prev.val){
            flag=false;
            return;
        }
        prev=root;
        inOrder(root.right);
    }
}