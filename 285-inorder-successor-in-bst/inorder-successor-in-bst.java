/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode result;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root, p);
        return result;
    }
    private void helper(TreeNode root, TreeNode p){
        if(root==null){
            return;
        }
        helper(root.left,p);
        if(result==null && root.val>p.val){
            result = root;
            return;
        }
        helper(root.right, p);
    }
}