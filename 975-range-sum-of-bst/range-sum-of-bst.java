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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Queue<TreeNode> bfsQue = new LinkedList<>();
        bfsQue.add(root);
        int sum=0;
        while(!bfsQue.isEmpty()){
            TreeNode curr = bfsQue.poll();
            if(curr.val>=low && curr.val<=high){
                sum+=curr.val;
            }
            if(curr.left!=null){
                bfsQue.add(curr.left);
            }
            if(curr.right!=null){
                bfsQue.add(curr.right);
            }
        }
        return sum;
    }
}