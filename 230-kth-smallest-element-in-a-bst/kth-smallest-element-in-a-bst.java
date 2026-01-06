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
    int count=0;
    TreeNode result=null;
    public int kthSmallest(TreeNode root, int k) {
        if(root==null){
            return 0;
        }
        count=k;
        helper(root);
        return result.val;
    }
    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        count--;
        if(count==0){
            result=root;
            return;
        }
        helper(root.right);
    }
}