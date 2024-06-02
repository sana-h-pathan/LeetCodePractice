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
    boolean limit=true;
    public boolean isValidBST(TreeNode root) {
        //return inOrder1(root);
        //return flag;
        helper(root, null, null);
        return limit;
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

    private boolean inOrder1(TreeNode root){
        if(root==null)
            return true;
        boolean left=inOrder1(root.left);
        if(prev!=null && root.val<=prev.val){
            return false;
        }
        prev=root;
        boolean right=inOrder1(root.right);
        return left && right;
    }

    private void helper(TreeNode root, Integer low, Integer high){
        if(root==null)
            return;
        if(low!=null && root.val<=low){
            limit=false;
            return;
        }
        if(high!=null && root.val>=high){
            limit=false;
            return;
        }
        helper(root.left, low, root.val);
        helper(root.right, root.val, high);
    }
}