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
    int maxSum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        calcualteWeight(root);
        return maxSum;
    }
    private int calcualteWeight(TreeNode root){
        if(root==null){
            return 0;
        }
        int left = Integer.max(0, calcualteWeight(root.left));
        int right = Integer.max(0, calcualteWeight(root.right));
        maxSum = Integer.max(maxSum, root.val+left+right);
        return root.val+Math.max(left, right);
    }
}