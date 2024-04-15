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
    public int sumNumbers(TreeNode root) {
        return helper(root,0,0);
    }
    
    private int helper(TreeNode root, int currSum, int sum){
        if(root==null)
            return 0;
        currSum=currSum*10+root.val;
        if(root.left==null && root.right==null){
            sum+=currSum;
            return sum;
        }
        int left= helper(root.left,currSum,sum);
        int right = helper(root.right,currSum,sum);

        return left+right;
    }
}