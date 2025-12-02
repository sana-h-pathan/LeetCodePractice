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
    boolean flag;
    TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {
        this.flag=true;
        inOrder(root);
        return flag;
    }

    private void inOrder(TreeNode root){
        if(root==null)
            return;
        if(flag)
            inOrder(root.left);
        if(prev!=null && prev.val>=root.val)
            flag=false;
        prev=root;
        if(flag)
            inOrder(root.right);
    }

    public boolean isValidBST1(TreeNode root) {
        helper(root, null,null);
        return flag;
    }
    private void helper(TreeNode root, Integer low, Integer high){
        if(root==null)
            return;
        if(low!=null && low>=root.val){
            flag=false;
            return;
        }
        if(high!=null && high<=root.val){
            flag=false;
            return;
        }
        helper(root.left, low, root.val);
        helper(root.right, root.val, high);
    }
}