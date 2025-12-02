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
    int count;
    TreeNode result=null;
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        helper(root);
        return result.val;
    }
    private void helper(TreeNode root){
        if(root==null)
            return;
        if(result==null)
            helper(root.left);
        count--;
        if(count==0)
            result=root;
        if(result==null)
            helper(root.right);
    }
}