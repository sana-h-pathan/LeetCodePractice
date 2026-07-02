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
    TreeNode result;
    int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        helper(root);
        return result.val;
    }
    private void helper(TreeNode root){
        if(root==null){
            return;
        }
        helper(root.left);
        k--;
        if(k==0 && result==null){
            result = root;
        }
        helper(root.right);
    }
}