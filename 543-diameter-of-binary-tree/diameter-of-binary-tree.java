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
    int maxDiameter;
    public int diameterOfBinaryTree(TreeNode root) {
        this.maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }
    private int calculateHeight(TreeNode root){
        if(root==null)
            return 0;
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);
        maxDiameter = Math.max(maxDiameter, left+right);
        return 1 + Math.max(left,right);
    }
}